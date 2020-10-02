import java.util.Scanner;


public class horairesBus {
    public static void main(String[] args) {
        Scanner saisie = new Scanner(System.in);

        System.out.print("Entrez une heure: ");
        int heure = saisie.nextInt();
        System.out.print("Entrez une minute: ");
        int minute = saisie.nextInt();
        boolean depart = false;

        if (heure >= 5 && heure < 8) {
            int[] heures_minutes = check_minute(heure, minute, 10);
            System.out.println(heures_minutes[0] + "h" + heures_minutes[1]);
        }
        else {
            System.out.println("Erreur");
        }

    }

    public static int[] check_minute(int heure, int minute, int intervalle) {

        int horaire_bus = 0;
        int[] heures_minutes = new int[2];
        heures_minutes[0] = heure;

        for (int i = 0; i <= 60; i += intervalle) {
            if ((i + 10) - minute > 10) {
                continue;
            }
            else {
                if (i >= 60 && minute >= 55 ) {
                    heures_minutes[0] += 1;
                    horaire_bus = 0;
                }
                else if ((i + 10) - minute <= 5) {
                    horaire_bus = i + 10;
                }
                else {
                    horaire_bus = i;
                }
            }
        }

        heures_minutes[1] = horaire_bus;

        return heures_minutes;
    }

}
