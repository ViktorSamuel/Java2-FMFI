package dnd;

import static dnd.DieTester.testConsecutivePairs;

public class Client {
    public static void main(String[] args) {
        MyRandom random = new StardardRandom();
        Dn dn = new Dn(random, 8);

        testConsecutivePairs(dn, 10);
    }
}
