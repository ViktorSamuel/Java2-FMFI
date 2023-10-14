package dnd;

import java.util.ArrayList;

public class Hand implements NDie{
    private ArrayList<NDie> dices;

    public Hand(ArrayList<NDie> dices){
        this.dices = dices;
    }

    @Override
    public int nextValue(){
        int sum = 0;
        for(NDie dice : dices){
            sum += dice.nextValue();
        }
        return sum;
    }

    @Override
    public int getSidesCount(){
        int sum = 0;
        for(NDie dice : dices){
            sum += dice.getSidesCount();
        }
        return sum;
    }

}
