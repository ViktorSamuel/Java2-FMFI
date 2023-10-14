package workbalance;

public class Worker implements WorkUnit{

    private String name;
    private int salary;
    private int currentWorkload;

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

    @Override
    public int getCurrentWorkload() {
        return this.currentWorkload;
    }

    @Override
    public WorkUnit getWorkerWithLowestWorkload() {
        return this;
    }

    @Override
    public void addCurrentWorkload(int workload) {
        this.currentWorkload += workload;
    }
}
