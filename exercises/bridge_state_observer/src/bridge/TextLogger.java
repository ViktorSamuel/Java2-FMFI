package bridge;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TextLogger {
    private TablePrinter tablePrinter;

    public TextLogger(TablePrinter tablePrinter) {
        this.tablePrinter = tablePrinter;
    }

    public void logText(List<String> header, List<Map<String, Object>> rows, String outputFileName) {
        try {
            tablePrinter.openOutputFile(outputFileName);
            tablePrinter.printHeader(header);
            for (Map<String, Object> row : rows) {
                tablePrinter.printRow(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                tablePrinter.closeOutputFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
