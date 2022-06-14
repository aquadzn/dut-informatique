import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

    private BufferedWriter bw;
    private BufferedReader br;
    private ServerSocket serverSocket;

    public FileServer(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Impossible de créer un serveur sur le port " + port);
        }
    }

    public void run() throws IOException {
        while (true) {
            Socket clientSocket = null;
            if (serverSocket != null) {
                clientSocket = serverSocket.accept();
            }
        }


    }

    private void initBufferWriter() {

    }

    private void initBufferReader() {

    }

    private void uploadFile(BufferedWriter bw, String fileToUpload) {

    }

    private void downloadFile(BufferedReader br, String fileToDownload) throws IOException {
        File file = new File("src/test.txt");
        byte[] bytesArray = new byte[(int) file.length()];
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        bis.read(bytesArray, 0, bytesArray.length);

//        if (clientSocket != null) {
//            OutputStream os = clientSocket.getOutputStream();
//            os.write(bytesArray, 0, bytesArray.length);
//            os.flush();
//            clientSocket.close();
//        }
    }

    public static void main(String[] args) throws IOException {
        FileServer fileServer = new FileServer(5555);
        fileServer.run();
    }
}
