public class Client {
    public static void main(String[] args) {
        MonitorConfiguration monitorConfiguration = new MonitorConfiguration(50, 50, 50);
        monitorConfiguration.saveToMemento();

        monitorConfiguration.setContrast(0);
        monitorConfiguration.setBrightness(0);
        monitorConfiguration.setFrequency(0);



    }
}
