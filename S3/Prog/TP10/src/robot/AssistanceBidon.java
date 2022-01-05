package robot;

public class AssistanceBidon {

    public static void main(String[] args) {
        SupportSystem supportSystem;
        try {
            supportSystem = new SupportSystem(new InputReaderSet(), new ResponderSynonyme());
            supportSystem.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
