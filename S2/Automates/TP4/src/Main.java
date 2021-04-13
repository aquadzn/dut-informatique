import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Scanner saisie = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // ex1();
        ex2();
        ex3();

        saisie.close();
    }

    public static void ex1() {
        System.out.print("Saisir une expression rationnelle: ");
        String rgx = saisie.nextLine();

        System.out.print("Saisir un mot: ");
        String mot = saisie.nextLine();

        Pattern p = Pattern.compile(rgx);
        Matcher m = p.matcher(mot);

        System.out.println(m.matches());
    }

    public static void ex2() throws IOException {
        Pattern p = Pattern.compile("vrai");
        Pattern p2 = Pattern.compile("i");
        int vrais = 0;
        int i = 0;

        String fname = "src/french.txt";
        System.out.println(fname);
        FileReader fr = new FileReader(fname);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher m = p.matcher(line);
                Matcher m2 = p2.matcher(line);

                while (m.find()) {
                    vrais++;
                }

                int count = 0;
                while (m2.find()) {
                    count++;
                }
                if (count == 6) {
                    i++;
                }
            }
        }
        fr.close();

        System.out.println("Nombre de 'vrai': " + vrais);
        System.out.println("Mots contenant 6 'i': " + i);
        System.out.println();
    }

    public static void ex3() throws IOException {
        Pattern p = Pattern.compile("yeux");
        int yeux = 0;

        String fname = "src/poeme.txt";
        System.out.println(fname);
        FileReader fr = new FileReader(fname);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher m = p.matcher(line);
                while (m.find()) {
                    yeux++;
                }
            }
        }
        fr.close();

        System.out.println("Nombre de 'yeux': " + yeux);
        System.out.println();
    }
}
