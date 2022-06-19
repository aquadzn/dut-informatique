public class Response {

    private int code;

    public Response() {

    }

    public Response(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        if (this.code == 0) {
            return "[SERVEUR] - OK";
        }
        else {
            return "[SERVEUR] - ERREUR";
        }
    }
}
