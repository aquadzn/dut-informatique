import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class FileServer implements Runnable {

    private PrintWriter writer;
    private BufferedReader reader;
    private Socket clientSocket;
    private String uploadFolder;
    private String[] filesAvailable;

    public FileServer(Socket clientSocket, String uploadFolder) {
        this.clientSocket = clientSocket;
        try {
            this.initReader(this.clientSocket.getInputStream());
            this.initWriter(this.clientSocket.getOutputStream());
        } catch (IOException e) {
            System.out.println("problème initialisation des buffers");
        }

        this.uploadFolder = uploadFolder;
        this.filesAvailable = new File(this.uploadFolder).list();
    }

    @Override
    public void run() {
        sendMessage("[SERVEUR] Fichiers disponibles : " + Arrays.toString(this.filesAvailable));

        Query q = new Query(getMessage());

        try {
            switch (q.getCode()) {
                case 1 -> uploadFile(clientSocket.getInputStream(), q.getFilename());
                case 2 -> downloadFile(clientSocket.getOutputStream(), q.getFilename());
                default -> System.out.println("mauvais choix");
            }
        } catch (IOException e) {
            System.out.println("erreur opération run du thread");
        }

        try {
            this.clientSocket.close();
        } catch (IOException e) {
            System.out.println("erreur fermeture buffers et connection socket");
        }
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

    private void uploadFile(InputStream inputStream, String fileToUpload) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(this.uploadFolder + new File(fileToUpload).getName()));

        byte[] bytes = new byte[8192];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bos.close();
        bis.close();
        System.out.println("* fichier reçu");
    }

    private void downloadFile(OutputStream outputStream, String fileToSend) {

        FileInputStream fis;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        try {
            fis = new FileInputStream(this.uploadFolder + fileToSend);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(outputStream);

            byte[] bytes = new byte[8192];
            int len;

            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }

            bos.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
