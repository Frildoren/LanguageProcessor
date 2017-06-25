package analyzers.syntactic.elements;

import analyzers.syntactic.elements.terminals.Lambda;

import java.util.ArrayList;
import java.util.List;

public abstract class NotTerminalElement extends BaseElement {

    public abstract List<List<Element>> getBranchesClasses();

    public abstract int getRuleIndex();

    public List<List<Element>> getBranches(){
        List<List<Element>> result = new ArrayList<>();
        getBranchesClasses().forEach(classes -> {
            List<Element> branch = new ArrayList<>();
            classes.forEach(element -> branch.add(element));
            result.add(branch);
        });

        return result;
    }

    @Override
    public List<Element> getFirst(){
        return getFirst(new ArrayList<>());
    }

    @Override
    public List<Element> getFirst(List<Class<? extends Element>> done){
        List<Element> result = new ArrayList<>();
        getBranchesClasses().forEach(elements -> {
            int i;
            for(i=0; i<elements.size(); i++) {
                if(elements.get(i) instanceof NotTerminalElement) {
                    if (done.contains(elements.get(i).getClass())) {
                        break;
                    }
                    done.add(elements.get(i).getClass());
                }

                result.addAll(elements.get(i).getFirst(done));
                if (result.contains(new Lambda()) && !done.isEmpty()) {
                    result.remove(new Lambda());
                } else {
                    break;
                }
            }

            if(i == elements.size()){
                //Follow?
            }
        });

        return result;
    }

    public List<List<Element>> getBranchFirsts(){
        List<List<Element>> result = new ArrayList<>();
        getBranchesClasses().forEach(elements -> {
            result.add(elements.get(0).getFirst());
        });
        return result;
    }

}
