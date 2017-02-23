package ca.mbg.demo.devoxx2016;

/**
 * @author Marius Bogoevici
 */
public class AverageData {

    private int sensorId;

    private double average;

    public AverageData(int sensorId, double average) {
        this.sensorId = sensorId;
        this.average = average;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "AverageData{" +
                       "sensorId=" + sensorId +
                       ", average=" + average +
                       '}';
    }
}
