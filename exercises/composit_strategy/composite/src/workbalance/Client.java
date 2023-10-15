package workbalance;

public class Client {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Worker 1", 100);
        Worker worker2 = new Worker("Worker 2", 200);
        Worker worker3 = new Worker("Worker 3", 500);
        Worker worker4 = new Worker("Worker 4", 100);
        Worker worker5 = new Worker("Worker 5", 200);
        Worker worker6 = new Worker("Worker 6", 500);

        worker1.addCurrentWorkload(10);
        worker2.addCurrentWorkload(20);
        worker3.addCurrentWorkload(30);
        worker4.addCurrentWorkload(1);
        worker5.addCurrentWorkload(50);

        Team team3 = new Team("Team 3");
        team3.add(worker6);

        Team team1 = new Team("Team 1");
        team1.add(worker1);
        team1.add(worker2);

        Team team2 = new Team("Team 2");
        team2.add(worker4);
        team2.add(worker5);
        team2.add(team3);

        Team company = new Team("Company");
        company.add(team1);
        company.add(worker3);
        company.add(team2);

        System.out.println(company.getWorkerWithLowestWorkload().getName());
    }
}
