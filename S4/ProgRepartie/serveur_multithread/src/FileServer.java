import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileServer implements Runnable {

    private DataInputStream input;
    private DataOutputStream output;
    private Socket clientSocket;
    private final String uploadFolder;
    private final String[] filesAvailable;

    public FileServer(Socket clientSocket, String uploadFolder) {
        this.clientSocket = clientSocket;
        try {
            this.initInputStream(this.clientSocket.getInputStream());
            this.initOutputStream(this.clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println("problème initialisation des buffers");
        }

        this.uploadFolder = uploadFolder;
        this.filesAvailable = new File(this.uploadFolder).list();
    }

    @Override
    public void run() {
        sendMessage("[SERVEUR] Fichiers disponibles : " + Arrays.toString(this.filesAvailable));

        System.out.print("* demande de client" + this.clientSocket.getRemoteSocketAddress() + "-> ");
        Query q = new Query(getMessage());

        switch (q.getCode()) {
            case 1:
                uploadFile(this.input, q.getFilename());
                break;
            case 2:
                downloadFile(this.output, q.getFilename());
                break;
            default:
                System.out.println("mauvais choix");
                break;
        }

        try {
            this.clientSocket.close();
        } catch (IOException e) {
            System.out.println("erreur fermeture buffers et connection socket");
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

    private String getMessage() {
        try {
            String resp = this.input.readUTF();
            System.out.println(resp);
            return resp;
        } catch (IOException e) {
            System.out.println("problème réception message");
        }
        return null;
    }

    private void uploadFile(DataInputStream input, String fileToUpload) {
        try {
            int fileSize = Integer.parseInt(input.readUTF());
            byte[] fileContent = new byte[fileSize];
            input.readFully(fileContent, 0, fileContent.length);

            String path = this.uploadFolder + new File(fileToUpload).getName();
            File file = new File(path);

            if (!file.exists() && !file.isDirectory()) {
                Files.write(Paths.get(path), fileContent);
            } else {
                System.out.println("le fichier existe déjà sur le serveur");
            }

            sendMessage(new Response(0).toString());
        } catch (IOException e) {
            System.out.println("erreur upload sur serveur");
            sendMessage(new Response(1).toString());
        }
    }

    private void downloadFile(DataOutputStream output, String fileToSend) {
        try {
            String path = this.uploadFolder + fileToSend;
            byte[] fileContent = Files.readAllBytes(Paths.get(path));
            output.writeInt(fileContent.length);
            output.write(fileContent);
            output.flush();

            sendMessage(new Response(0).toString());
        } catch (IOException e) {
            System.out.println("le fichier" + fileToSend + "n'existe pas dans le dossier upload");
            sendMessage(new Response(1).toString());
        }
    }
}
