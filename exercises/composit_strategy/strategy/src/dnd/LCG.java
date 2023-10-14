package dnd;

public class LCG implements MyRandom{
    private long seed;
    private long a;
    private long c;
    private long m;

    public LCG(long seed, long a, long c, long m){
        this.seed = seed;
        this.a = a;
        this.c = c;
        this.m = m;
    }

    @Override
    public long nextLong(){
        seed = (a * seed + c) % m;
        return seed;
    }
}
