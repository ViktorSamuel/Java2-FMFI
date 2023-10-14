package dnd;

public class StardardRandom implements MyRandom{

    private java.util.Random random;

    public StardardRandom(){
        random = new java.util.Random();
    }
    @Override
    public long nextLong(){
        return random.nextLong();
    }
}
