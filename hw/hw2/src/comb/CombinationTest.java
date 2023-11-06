package comb;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationTest {
    @Test
    public void testCombination42(){
        List<Character> list = Arrays.asList('a','b','c','d');
        Combinations<Character> combinations = new Combinations<>(list, 2);
        List<List<Character>> result = new ArrayList<>();
        List<List<Character>> expected = Arrays.asList(
                Arrays.asList('a','b'),
                Arrays.asList('a','c'),
                Arrays.asList('a','d'),
                Arrays.asList('b','c'),
                Arrays.asList('b','d'),
                Arrays.asList('c','d')
        );
        while (combinations.hasNext()){
            result.add(combinations.next());
        }
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testCombination43(){
        List<Character> list = Arrays.asList('a','b','c','d');
        Combinations<Character> combinations = new Combinations<>(list, 3);
        List<List<Character>> result = new ArrayList<>();
        List<List<Character>> expected = Arrays.asList(
                Arrays.asList('a','b','c'),
                Arrays.asList('a','b','d'),
                Arrays.asList('a','c','d'),
                Arrays.asList('b','c','d')
        );
        while (combinations.hasNext()){
            result.add(combinations.next());
        }
        assertTrue(result.containsAll(expected));
    }
}
