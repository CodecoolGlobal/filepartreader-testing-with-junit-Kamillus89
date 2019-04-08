import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileWordAnalyzerTest {

    FilePartReader filePartReader;
    FileWordAnalyzer fileWordAnalyzer;

    @BeforeEach
    void setup() {
        filePartReader = mock(FilePartReader.class);
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    @DisplayName("getWordsOrderedAlphabetically sort words")
    void testIfGetWordsOrderedAlphabeticallySortProperly() throws FileNotFoundException {
        //Arrange
        String sampleString = "123\nabc\nbanana bleble\nzzzz";
        when(filePartReader.readLines()).thenReturn(sampleString);

        List<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("abc");
        expected.add("banana");
        expected.add("bleble");
        expected.add("zzzz");

        //Act
        List<String> actual = fileWordAnalyzer.getWordsOrderedAlphabetically();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getWordsContainingSubstrings select proper words")
    void testIfGetWordsContainingSubstring() throws FileNotFoundException {
        //Arrange
        String sampleString = "123\n This is first line\n and this is second line.\n some ble ble ble\n";
        when(filePartReader.readLines()).thenReturn(sampleString);

        List<String> expected = new ArrayList<>();
        expected.add("This");
        expected.add("is");
        expected.add("this");
        expected.add("is");

        //Act
        List<String> actual = fileWordAnalyzer.getWordsContainingSubstring("is");

        //Assert
        assertEquals(expected, actual);
    }

    
}