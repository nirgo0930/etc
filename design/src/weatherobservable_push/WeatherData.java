package weatherobservable_push;

import java.util.Observable;

public class WeatherData extends Observable {
    private WeatherInfo weatherInfo;

    public WeatherData() {
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers(weatherInfo);
    }

    public void setMeasurements(WeatherInfo weatherInfo) {
        this.weatherInfo = weatherInfo;

        measurementsChanged();
    }
}
