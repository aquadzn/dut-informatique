import java.io.*;
import java.net.Socket;

public class Client {

    private PrintWriter writer;
    private BufferedReader reader;
    private Socket clientSocket;
    private final String downloadFolder;

    public Client(String downloadFolder) {
        this.downloadFolder = downloadFolder;
    }

    private void initWriter(OutputStream outputStream) {
        this.writer = new PrintWriter(outputStream);
    }

    private void initReader(InputStream inputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    private void sendMessage(String message) {
        this.writer.println(message);
        this.writer.flush();
    }

    private String getMessage() {
        try {
            String resp = this.reader.readLine();
            System.out.println(resp);
            return resp;
        } catch (IOException e) {
            System.out.println("problème réception message");
        }
        return null;
    }

    public void downloadFile(String outputFile) {
        InputStream is;
        OutputStream os;

        try {
            is = this.clientSocket.getInputStream();
            os = new FileOutputStream(this.downloadFolder + outputFile);
            byte[] buffer = new byte[8192];

            int len;
            while ((len = is.read(buffer, 0, buffer.length)) > 0) {
                os.write(buffer, 0, len);
                os.flush();
            }

            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void uploadFile(String fileToUpload) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileToUpload));
            BufferedOutputStream bos = new BufferedOutputStream(this.clientSocket.getOutputStream());

            byte[] buffer = new byte[8192];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                bos.flush();
            }

            bos.close();
            bis.close();
            System.out.println("* fichier uploadé");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect(String host, int port) {
        try {
            this.clientSocket = new Socket(host, port);
            this.initReader(clientSocket.getInputStream());
            this.initWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        getMessage();

//        Query q = new Query(2, "test.txt");
        Query q = new Query(1, "files/downloaded/hello.txt");
        sendMessage(q.toString());

        switch (q.getCode()) {
            case 1 -> uploadFile(q.getFilename());
            case 2 -> downloadFile(q.getFilename());
            default -> System.out.println("mauvais choix");
        }

        try {
            this.reader.close();
            this.writer.close();
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client("files/downloaded/");
        client.connect("127.0.0.1", 5555);
    }
}
