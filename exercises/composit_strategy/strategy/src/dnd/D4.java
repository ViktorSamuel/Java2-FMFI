package dnd;

public class D4 implements NDie{
    private MyRandom random;

    public D4(MyRandom random){
        this.random = random;
    }
    @Override
    public int nextValue(){
        return (int)(Math.abs(random.nextLong()) % 4);
    }
    @Override
    public int getSidesCount(){
        return 4;
    }
}
