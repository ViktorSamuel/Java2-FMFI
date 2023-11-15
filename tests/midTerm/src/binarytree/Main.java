package binarytree;

import java.util.Arrays;
import java.util.List;

public class Main {
    static <T> void testPrettyPrint(List<BinaryTreeNode<T>> nodes, List<String> truth) {
        System.out.println("Testing Task A ...");

        int tests_total = nodes.size();
        int tests_passed = 0;
        for (int i = 0; i < tests_total; i++) {
            if (nodes.get(i).toString().equals(truth.get(i))) {
                tests_passed++;
            } else {
                System.out.println("Error for test " + i + "!");
            }
        }
        if (tests_passed == tests_total) {
            System.out.println("OK! All " + tests_total + "/" + tests_total + " tests passed!");
        } else {
            System.out.println("Only " + tests_passed + "/" + tests_total +  " tests passed :(");
        }
    }

    static <T> void testDepthVisitor(List<BinaryTreeNode<T>> nodes, List<Integer> truth) {
        System.out.println("Testing Task B ...");

        int tests_total = nodes.size();
        int tests_passed = 0;

        DepthVisitor<T> v = new DepthVisitor<T>();
        for (int i = 0; i < tests_total; i++) {
            if (nodes.get(i).accept(v).equals(truth.get(i))) {
                tests_passed++;
            } else {
                System.out.println("Error for test " + i + "!");
            }
        }
        if (tests_passed == tests_total) {
            System.out.println("OK! All " + tests_total + "/" + tests_total + " tests passed!");
        } else {
            System.out.println("Only " + tests_passed + "/" + tests_total +  " tests passed :(");
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> t1 = new InternalTreeNode<Integer>(7,
                new Leaf<Integer>(4),
                new Leaf<Integer>(6));
        BinaryTreeNode<Integer> t2 = new InternalTreeNode<>(8, t1, new Leaf<>(10));
        BinaryTreeNode<Integer> t3 = new InternalTreeNode<>(8, t2, new Leaf<>(-10));

//        testPrettyPrint(Arrays.asList(t1, t2, t3), Arrays.asList(
//                            "(val: 7 (val: 4) (val: 6))",
//                            "(val: 8 (val: 7 (val: 4) (val: 6)) (val: 10))",
//                            "(val: 8 (val: 8 (val: 7 (val: 4) (val: 6)) (val: 10)) (val: -10))"));

//        testDepthVisitor(Arrays.asList(t1, t2, t3), Arrays.asList(1, 2, 3));


    }
}
