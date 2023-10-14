package dnd;

public class Dn implements NDie{
    private MyRandom random;
    private int sidesCount;

    public Dn(MyRandom random, int sidesCount){
        this.random = random;
        this.sidesCount = sidesCount;
    }
    @Override
    public int nextValue(){
        return (int)(Math.abs(random.nextLong()) % sidesCount);
    }
    @Override
    public int getSidesCount(){
        return sidesCount;
    }
}
