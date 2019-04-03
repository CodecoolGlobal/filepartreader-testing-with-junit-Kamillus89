import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        // it sets the class' instance variables to some invalid default value
        this.filePath = "src/main/resources/file.txt";
        this.fromLine = 1;
        this.toLine = 1;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine && fromLine < 1) {
            throw new IllegalArgumentException("toLine must be bigger than fromLine !!!");
        }
    }

    public String read() throws FileNotFoundException {
        StringBuilder fileContent = new StringBuilder();
        String textLine = "";
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        try {
            while ((textLine = br.readLine()) != null) {
                fileContent.append(textLine);
                fileContent.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent.toString();
    }


    public static void main(String[] args) {
        FilePartReader filePartReader = new FilePartReader();

        try {
            System.out.println(filePartReader.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
