public class Response {

    private int code;

    public Response(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        if (this.code == 0) {
            return "[SERVEUR] - Requête OK";
        }
        else {
            return "[SERVEUR] - Erreur requête";
        }
    }
}
