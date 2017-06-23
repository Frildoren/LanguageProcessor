package analyzers.syntactic.elements;

import analyzers.syntactic.elements.terminals.Lambda;

import java.util.ArrayList;
import java.util.List;

public abstract class NotTerminalElement extends BaseElement {

    public abstract List<List<Element>> getBranchesClasses();

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
        List<Element> result = new ArrayList<>();
        getBranches().forEach(elements -> {
            int i;
            for(i=0; i<elements.size(); i++) {
                List<Element> first = elements.get(i).getFirst();
                if (first.contains(new Lambda())) {
                    first.remove(new Lambda());
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

}
