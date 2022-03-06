import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Main {
    public static final String FILE_NAME = "table.csv";

    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
            byte[] csvData = newData().toString().getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(csvData);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME)) {
            byte[] csvData = new byte[fileInputStream.available()];
            fileInputStream.read(csvData);
            String table = new String(csvData);
            System.out.println(table);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static AppData newData() {
        AppData appData = new AppData();
        String[] headers = new String[] { "title 1", "title 2", "title 3" };
        appData.init(headers);
        return appData;
    }
}