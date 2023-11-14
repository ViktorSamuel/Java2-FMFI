package bridge;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface TablePrinter {
    void openOutputFile(String filename) throws IOException;
    void closeOutputFile() throws IOException;
    void printHeader(List<String> header) throws IOException;
    void printRow(Map<String, Object> row) throws IOException;
}
