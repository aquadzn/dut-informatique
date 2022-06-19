import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class FileServer extends Thread {

    private int port;
    private PrintWriter writer;
    private BufferedReader reader;
    private ServerSocket serverSocket;
    private String uploadFolder;
    private String[] filesAvailable;

    public FileServer(int port, String uploadFolder) {
        this.port = port;
        this.uploadFolder = uploadFolder;
        this.filesAvailable = new File(this.uploadFolder).list();
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

    private void getFile(InputStream inputStream, String fileToUpload) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("files/uploaded/" + new File(fileToUpload).getName()));

        byte[] bytes = new byte[8192];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bos.close();
        bis.close();
        System.out.println("* fichier reçu");
    }

    private void sendFile(OutputStream outputStream, String fileToSend) {

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

    @Override
    public void run() {
        try {
            this.serverSocket = new ServerSocket(this.port);

            while (true) {
                Socket clientSocket = this.serverSocket.accept();
                this.initReader(clientSocket.getInputStream());
                this.initWriter(clientSocket.getOutputStream());

                sendMessage("[SERVEUR] Fichiers disponibles : " + Arrays.toString(this.filesAvailable));

                Query q = new Query(getMessage());

                switch (q.getCode()) {
                    case 1 -> getFile(clientSocket.getInputStream(), q.getFilename());
                    case 2 -> sendFile(clientSocket.getOutputStream(), q.getFilename());
                    default -> System.out.println("mauvais choix");
                }
            }
        } catch (IOException e) {
            System.out.println("Impossible de créer un serveur sur le port " + port);
        }
    }
}
