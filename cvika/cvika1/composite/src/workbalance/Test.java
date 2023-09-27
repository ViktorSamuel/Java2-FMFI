package workbalance;

public class Test {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Worker 1", 100);
        Worker worker2 = new Worker("Worker 2", 200);
        Worker worker3 = new Worker("Worker 3", 500);
        Worker worker4 = new Worker("Worker 4", 100);
        Worker worker5 = new Worker("Worker 5", 200);

        Team team1 = new Team("Team 1");
        team1.add(worker1);
        team1.add(worker2);

        Team team2 = new Team("Team 2");
        team2.add(worker4);
        team2.add(worker5);

        Team company = new Team("Company");
        company.add(team1);
        company.add(worker3);
        company.add(team2);

        System.out.println(company.repr(1));
    }
}
