import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FilePartReaderTest {

    FilePartReader filePartReader;

    @BeforeEach
    void createNewFilePartReader() {
        filePartReader = new FilePartReader();
    }

    @Test
    @DisplayName("throws IllegalArgumentException when wrong arguments")
    public void testIfSetupThrowsException() {
        int toLine = 5;
        int fromLine = -1;
        String filePath = "";

        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(filePath, fromLine, toLine));
    }


}