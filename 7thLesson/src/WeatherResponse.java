import javax.json.JsonArray;
import javax.json.JsonObject;

class WeatherResponse {
    private final Daily[] dailyForecasts;

    public WeatherResponse(JsonObject jsonObject) {
        JsonArray jsonDailyForecastsArray = jsonObject.getJsonArray("DailyForecasts");
        dailyForecasts = new Daily[jsonDailyForecastsArray.size()];
        for (int forecast = 0; forecast < dailyForecasts.length; forecast++) {
            JsonObject jsonForecast = jsonDailyForecastsArray.getJsonObject(forecast);
            Daily dailyForecast = new Daily(jsonForecast);
            dailyForecasts[forecast] = dailyForecast;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Погода на 5 дней в СПБ: \n");

        for (Daily dailyForecast : dailyForecasts) {
            stringBuilder.append(dailyForecast.toString() + "\n");
        }

        return stringBuilder.toString();
    }
}