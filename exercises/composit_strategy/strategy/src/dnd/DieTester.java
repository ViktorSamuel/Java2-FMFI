package dnd;

import java.util.Map;

public class DieTester {
    public static void testDistribution(NDie die, int tries){
        int[] counts = new int[die.getSidesCount()];
        for(int i = 0; i < tries; i++){
            counts[die.nextValue()]++;
        }
        for(int i = 0; i < counts.length; i++){
            System.out.println(i + ": " + counts[i]);
        }

        System.out.println("Entropy: " + evalEntropy(counts, tries));
    }

    public static double evalEntropy(int[] resultCounts, int totalThrows) {
        double entropy = 0.0;
        for (int count : resultCounts) {
            double probability = (double) count / totalThrows;
            if (count != 0) {
                entropy -= probability * (Math.log(probability) / Math.log(2));
            }
        }
        return entropy;
    }

    public static void testConsecutivePairs(NDie die, int tries){
        int[][][] pairsAndCount = new int[die.getSidesCount()][die.getSidesCount()][1];
        for(int i = 0; i < tries; i++){
            int first = die.nextValue();
            int second = die.nextValue();
            pairsAndCount[first][second][0]++;
        }
        for(int i = 0; i < pairsAndCount.length; i++){
            for(int j = 0; j < pairsAndCount[i].length; j++){
                System.out.println(i + ", " + j + ": " + pairsAndCount[i][j][0]);
            }
        }
    }
}
