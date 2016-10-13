package analyzers.tokenizer.transitions;

import analyzers.tokenizer.TokenizerImpl;
import structures.Token;
import sun.misc.Launcher;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class Transition {

    public static List<Transition> getTransitions(char state, TokenizerImpl tokenizer){
        List<Transition> t = new ArrayList<>();

        String name = new String(Transition.class.getPackage().getName());
        if (!name.startsWith("/")) {
            name = "/" + name;
        }

        name = name.replace('.','/');
        name += "/" + state;

        // Get a File object for the package
        URL url = Launcher.class.getResource(name);
        File directory = null;
        try {
            directory = new File(java.net.URLDecoder.decode(url.getFile(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        name = name.replace("/", ".").substring(1);

        if (directory.exists()) {
            // Get the list of the files contained in the package
            String [] files = directory.list();
            for (int i=0;i<files.length;i++) {

                // we are only interested in .class files
                if (files[i].endsWith(".class")) {
                    // removes the .class extension
                    String classname = files[i].substring(0,files[i].length()-6);
                    try {
                        // Try to create an instance of the object
                        Constructor constructor = Class.forName(name+"."+classname).getDeclaredConstructor(new Class[] {TokenizerImpl.class});
                        Transition o = (Transition) constructor.newInstance(new Object[]{tokenizer});
                        t.add(o);
                    } catch (ClassNotFoundException cnfex) {
                        cnfex.printStackTrace();
                    } catch (InstantiationException iex) {
                        iex.printStackTrace();
                    } catch (IllegalAccessException iaex) {
                        iaex.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return t;
    }

    private TokenizerImpl tokenizer;

    public Transition(TokenizerImpl tokenizer){
        this.tokenizer = tokenizer;
    }

    public abstract String inputRule();
    public abstract Token semanticRules();

    public boolean isValid(){
        return Character.toString(tokenizer.getCurrentChar()).matches(inputRule());
    }

    protected TokenizerImpl getTokenizer(){
        return tokenizer;
    }

}
