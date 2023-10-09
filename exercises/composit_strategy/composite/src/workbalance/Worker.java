package workbalance;

public class Worker implements WorkUnit{

    private String name;
    private int salary;

    public Worker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int salary() {
        return this.salary;
    }

    @Override
    public String repr(int offset) {
        return this.name + ": (" + this.salary + ")\n";
    }
}
