public class PasCoup extends Exception {
    public PasCoup(String error) {
        super(error + " n'est pas un coup accepté");
    }
}
