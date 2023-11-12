package memento;

import org.junit.Test;

public class TestMonitorConfiguration {
    @Test
    public void mementoTest(){
        MonitorConfiguration monitorConfiguration = new MonitorConfiguration(50, 50, 50);
        MonitorConfiguration.Memento memento = monitorConfiguration.saveToMemento();

        monitorConfiguration.setContrast(0);
        monitorConfiguration.setBrightness(0);
        monitorConfiguration.setFrequency(0);

        monitorConfiguration.restoreFromMemento(memento);

        assert monitorConfiguration.getContrast() == 50;
        assert monitorConfiguration.getBrightness() == 50;
        assert monitorConfiguration.getFrequency() == 50;
    }
}
