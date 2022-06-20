import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Client {

    private DataInputStream input;
    private DataOutputStream output;
    private Socket clientSocket;
    private final String downloadFolder;

    public Client(String downloadFolder) {
        this.downloadFolder = downloadFolder;
    }

    public void connect(String host, int port) {
        try {
            this.clientSocket = new Socket(host, port);
            this.initInputStream(clientSocket.getInputStream());
            this.initOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        getMessage();
    }

    public void sendQueryToServer(Query q) {
        sendMessage(q.toString());

        switch (q.getCode()) {
            case 1:
                uploadFile(this.output, q.getFilename());
                break;
            case 2:
                downloadFile(this.input, q.getFilename());
                break;
            default:
                System.out.println("mauvais choix");
                break;
        }

        try {
            this.input.close();
            this.output.close();
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initInputStream(InputStream inputStream) {
        this.input = new DataInputStream(inputStream);
    }

    private void initOutputStream(OutputStream outputStream) {
        this.output = new DataOutputStream(outputStream);
    }

    private void sendMessage(String message) {
        try {
            this.output.writeUTF(message);
            this.output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getMessage() {
        try {
            String resp = this.input.readUTF();
            System.out.println(resp);
        } catch (IOException e) {
            System.out.println("problème réception message");
        }
    }

    public void downloadFile(DataInputStream input, String outputFile) {
        try {
            int fileSize = input.readInt();
            byte[] fileContent = new byte[fileSize];
            input.readFully(fileContent, 0, fileContent.length);

            String path = this.downloadFolder + outputFile;
            Files.write(Paths.get(path), fileContent);
            System.out.println("* fichier sauvegardé");
        } catch (IOException e) {
            System.out.println("! probleme telechargement du fichier");
        } finally {
            getMessage();
        }
    }

    private void uploadFile(DataOutputStream output, String fileToUpload) {
        byte[] fileContent;
        try {
            fileContent = Files.readAllBytes(Paths.get(fileToUpload));
            output.writeUTF(String.valueOf(fileContent.length));
            output.write(fileContent);
            output.flush();
            System.out.println("* fichier envoyé au serveur");
        } catch (IOException e) {
            System.out.println("! le fichier n'existe pas");
        } finally {
            getMessage();
        }
    }
}
