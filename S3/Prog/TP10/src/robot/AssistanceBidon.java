package robot;

public class AssistanceBidon {

    public static void main(String[] args) {
        SupportSystem supportSystem = new SupportSystem(new InputReaderSet(), new ResponderSynonyme());
        supportSystem.start();
    }
}
