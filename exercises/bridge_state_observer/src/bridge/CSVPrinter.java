package bridge;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.io.BufferedWriter;

public class CSVPrinter implements TablePrinter{
    private BufferedWriter writer;

    @Override
    public void openOutputFile(String filename) throws IOException {
        writer = new BufferedWriter(new FileWriter(filename));
    }

    @Override
    public void closeOutputFile() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }

    @Override
    public void printHeader(List<String> header) throws IOException {
        writer.write(String.join(",", header));
        writer.newLine();
    }

    @Override
    public void printRow(Map<String, Object> row) throws IOException {
        String[] values = row.values().stream()
                .map(Object::toString)
                .toArray(String[]::new);
        writer.write(String.join(",", values));
        writer.newLine();
    }
}
