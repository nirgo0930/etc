package weather_pull;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
    }

    public void update() {
        tempSum += weatherData.getTemperature();
        numReadings++;

        if (weatherData.getTemperature() > maxTemp) {
            maxTemp = weatherData.getTemperature();
        }
        if (weatherData.getTemperature() < minTemp) {
            minTemp = weatherData.getTemperature();
        }

        display();
    }
}
