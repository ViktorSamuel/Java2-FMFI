package Visitor;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Element> elements = new ArrayList<>();
        elements.add(new ConcreteElementA());
        elements.add(new ConcreteElementB());

        Visitor visitor = new ConcreteVisitor();

        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
