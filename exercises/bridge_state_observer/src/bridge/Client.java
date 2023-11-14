package bridge;

import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        List<String> header = List.of("Name", "Age", "City");

        List<Map<String, Object>> data = List.of(
                Map.of("Name", "John", "Age", 25, "City", "New York"),
                Map.of("Name", "Alice", "Age", 30, "City", "London")
        );

        TextLogger csvLogger = new TextLogger(new CSVPrinter());
        csvLogger.logText(header, data, "output.csv");

        TextLogger tsvLogger = new TextLogger(new TSVPrinter());
        tsvLogger.logText(header, data, "output.tsv");


    }
}
