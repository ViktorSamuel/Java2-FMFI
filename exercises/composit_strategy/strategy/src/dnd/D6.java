package dnd;

public class D6 implements MyRandom, NDie {
    private MyRandom random;

    public D6(MyRandom random){
        this.random = random;
    }

    @Override
    public long nextLong(){
        return Math.abs(random.nextLong()) % 6;
    }

    public int nextValue(){
        return (int)nextLong();
    }

    public int getSidesCount(){
        return 6;
    }
}
