package ca.mbg.demo.devoxx2016;

/**
 * @author Marius Bogoevici
 */
public class ReceivedSensorData {

    private int sensorId;

    private double temperature;

    public ReceivedSensorData() {
    }

    public ReceivedSensorData(int id, int temperature) {
        this.sensorId = id;
        this.temperature = temperature;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int id) {
        this.sensorId = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "ReceivedSensorData{" +
                       "sensorId=" + sensorId +
                       ", temperature=" + temperature +
                       '}';
    }
}
