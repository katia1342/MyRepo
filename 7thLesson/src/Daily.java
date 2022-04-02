import javax.json.JsonObject;

public class Daily {
    private final String date;
    private final double minimumTemperature;
    private final double maximumTemperature;
    private final String dayTextDescription;
    private final String nightTextDescription;

    public Daily(JsonObject jsonObject) {
        date = jsonObject.getString("Date");

        minimumTemperature = jsonObject
                .getJsonObject("Temperature")
                .getJsonObject("Minimum")
                .getJsonNumber("Value")
                .doubleValue();
        maximumTemperature = jsonObject
                .getJsonObject("Temperature")
                .getJsonObject("Maximum")
                .getJsonNumber("Value")
                .doubleValue();

        dayTextDescription = jsonObject
                .getJsonObject("Day")
                .getString("IconPhrase");

        nightTextDescription = jsonObject
                .getJsonObject("Night")
                .getString("IconPhrase");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("В городе СПБ ");
        stringBuilder.append("на дату " + date + "\n");
        stringBuilder.append("ОЖИДАЕТСЯ: \n");
        stringBuilder.append("днём: " + dayTextDescription + "\n");
        stringBuilder.append("ночью: " + nightTextDescription + "\n");
        stringBuilder.append("ТЕМПЕРАТУРА: \n");
        stringBuilder.append("минимальная: " + minimumTemperature + " C\n");
        stringBuilder.append("максимальная: " + maximumTemperature + " C\n");

        return stringBuilder.toString();
    }
}
