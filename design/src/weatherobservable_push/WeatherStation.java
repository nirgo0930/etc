package weatherobservable_push;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		weatherData.setMeasurements(new WeatherInfo(80, 65, 30.4f));
		weatherData.setMeasurements(new WeatherInfo(82, 70, 29.2f));
		weatherData.setMeasurements(new WeatherInfo(78, 90, 29.2f));
	}
}
