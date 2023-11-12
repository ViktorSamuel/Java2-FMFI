public class MonitorConfiguration {
    private int contrast;
    private int brightness;
    private int frequency;

    public MonitorConfiguration(int contrast, int brightness, int frequency) {
        this.contrast = contrast;
        this.brightness = brightness;
        this.frequency = frequency;
    }

    public int getContrast() {
        return contrast;
    }

    public int getBrightness() {
        return brightness;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setContrast(int contrast) {
        this.contrast = contrast;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Memento saveToMemento() {
        return new Memento(this);
    }

    public void restoreFromMemento(Memento memento) {
        this.contrast = memento.contrast;
        this.brightness = memento.brightness;
        this.frequency = memento.frequency;
    }

    public static class Memento {
        private final int contrast;
        private final int brightness;
        private final int frequency;

        private Memento(MonitorConfiguration monitorConfiguration) {
            this.contrast = monitorConfiguration.getContrast();
            this.brightness = monitorConfiguration.getBrightness();
            this.frequency = monitorConfiguration.getFrequency();
        }
    }
}
