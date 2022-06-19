import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TestFile {
    public static void readAndWrite(String input, String output) throws IOException {
        File file = new File(input);
        InputStream is = new FileInputStream(file);

        OutputStream os = new FileOutputStream(output);
        byte[] buffer = new byte[8192];

        int c;

        while ((c = is.read(buffer, 0, buffer.length)) > 0) {
            os.write(buffer, 0, c);
            os.flush();
        }

        os.close();
        is.close();
    }

    public static void main(String[] args) throws IOException {
        readAndWrite("files/projet.pdf", "files/out.pdf");
        readAndWrite("files/uploaded/test.txt", "files/out.txt");
    }
}
