import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpClient {
    private final static String URL = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/294021";
    private final static String API_KEY = "16lTnztK85qCwYOpi2uTjOyX40qA91jA";

    public static void main(String[] args) {
        try {
            URL weatherUrl = new URL(URL+API_KEY);
            HttpURLConnection urlConnection = (HttpURLConnection) weatherUrl.openConnection();
            if (urlConnection.getResponseCode() == 200)
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                    StringBuilder responseContent = new StringBuilder();
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                    System.out.println(responseContent);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }