package Composite;

import java.util.ArrayList;

public class Composite implements Component{
    private ArrayList<Component> children = new ArrayList<Component>();

    public void add(Component component){
        children.add(component);
    }

    public void remove(Component component){
        children.remove(component);
    }

    @Override
    public void operation() {
        for(Component component : children){
            component.operation();
        }
    }
}
