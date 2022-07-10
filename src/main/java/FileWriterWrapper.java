import java.io.FileWriter;
import java.io.IOException;

public class FileWriterWrapper {

    private FileWriter fileWriter;

    public FileWriterWrapper(String path) throws IOException {
        fileWriter = new FileWriter(path);
    }

    public void writeLine(String line) throws IOException {
        fileWriter.write(line);
        fileWriter.write(System.getProperty( "line.separator" ));
        fileWriter.flush();
    }
}
