public class Query {
    private int code;
    private String filename;

    public Query(int code, String filename) {
        this.code = code;
        this.filename = filename;
    }

    public int getCode() {
        return code;
    }

    public String getFilename() {
        return filename;
    }
}
