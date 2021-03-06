import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;
    StringBuilder fileContent = new StringBuilder();
    String textLine = "";

    public FilePartReader() {
        // it sets the class' instance variables to some invalid default value
        this.filePath = "src/main/resources/file.txt";
        this.fromLine = 1;
        this.toLine = 4;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("toLine must be bigger than fromLine !!!");
        } else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    public String read() throws FileNotFoundException {
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

    public String readLines() throws FileNotFoundException {
//        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String textContent = read();
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println("from line: " + fromLine);
        System.out.println("to line: " + toLine + "\n");

        for (int i = fromLine - 1; i < toLine; i++) {
            stringBuilder.append(textContent.split("\n")[i]);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        FilePartReader filePartReader = new FilePartReader();

        try {
            System.out.println(filePartReader.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(filePartReader.readLines());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
