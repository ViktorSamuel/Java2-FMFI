package workbalance;

public interface WorkUnit {
    String getName();
    int salary();
    String repr(int offset);
    int getCurrentWorkload();
    WorkUnit getWorkerWithLowestWorkload();
    void addCurrentWorkload(int workload);
}
