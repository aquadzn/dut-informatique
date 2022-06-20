public class Query {
    private int code;
    private String filename;

    public Query(int code, String filename) {
        // 1 upload, 2 download
        this.code = code;
        this.filename = filename;
    }

    public Query(String query) {
        String[] args = query.split("-");
        this.code = Integer.parseInt(args[0].strip());
        this.filename = args[1].strip();
    }

    public int getCode() {
        return code;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return code + " - " + filename;
    }

}
