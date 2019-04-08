import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    FilePartReader filePartReader;

    @BeforeEach
    void createNewFilePartReader() {
        filePartReader = new FilePartReader();
    }

    @Test
    @DisplayName("throws IllegalArgumentException when wrong arguments are passed")
    public void testIfSetupThrowsException() {
        int toLine = 5;
        int fromLine = -1;
        String filePath = "";

        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(filePath, fromLine, toLine));
    }

    @Test
    @DisplayName("throws FileNotFoundException when wrong path is provided")
    public void testIfReadThrowsException() {
        int toLine = 1;
        int fromLine = 1;
        String filePath = "";
        
        filePartReader.setup(filePath, fromLine, toLine);

        assertThrows(FileNotFoundException.class, () -> filePartReader.read());
    }

    @Test
    public void testIfReadLinesReadsFirstLine() throws FileNotFoundException {
        int toLine = 1;
        int fromLine = 1;
        String filePath = "src/main/resources/file.txt";
        filePartReader.setup(filePath, fromLine, toLine);
        String expected = "This is first line\n";

        String actual = filePartReader.readLines();

        assertEquals(expected, actual);
    }
}