package workbalance;

import java.util.ArrayList;

public class Team implements WorkUnit {

    private ArrayList<WorkUnit> team;
    private String name;

    public Team(String name) {
        this.team = new ArrayList<>();
        this.name = name;
    }

    public Team(ArrayList<WorkUnit> team, String name) {
        this.team = team;
        this.name = name;
    }

    public void add(WorkUnit workUnit) {
        this.team.add(workUnit);
    }

    public void remove(WorkUnit workUnit) {
        this.team.remove(workUnit);
    }

    @Override
    public String getName() {
       return this.name;
    }

    @Override
    public int salary() {
        int salary = 0;
        for (WorkUnit workUnit : this.team) {
            salary += workUnit.salary();
        }
        return salary;
    }

    @Override
    public String repr(int offset){
        String repr = "";
        repr += this.name + " (total salary: " + this.salary() + "):\n";
        for (WorkUnit workUnit : this.team) {
            for (int i = 0; i < 4*offset; i++){
                repr += " ";
            }
            repr += workUnit.repr(offset+1);
        }
        return repr;
    }

    @Override
    public int getCurrentWorkload() {
        int workload = 0;
        for (WorkUnit workUnit : this.team) {
            workload += workUnit.getCurrentWorkload();
        }
        return workload;
    }

    @Override
    public WorkUnit getWorkerWithLowestWorkload() {
        WorkUnit workerWithLowestWorkload = this.team.get(0);
        for (WorkUnit workUnit : this.team){
            if (workUnit.getWorkerWithLowestWorkload().getCurrentWorkload() < workerWithLowestWorkload.getCurrentWorkload()){
                workerWithLowestWorkload = workUnit.getWorkerWithLowestWorkload();
            }
        }
        return workerWithLowestWorkload;
    }

    @Override
    public void addCurrentWorkload(int workload) {
        this.getWorkerWithLowestWorkload().addCurrentWorkload(workload);
    }
}