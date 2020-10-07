import java.util.Scanner;

public class CompteARebours {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int depart;
		
		System.out.print("Entier de départ : ");
		depart = Integer.parseInt(sc.nextLine());
		
        int alignement = 10 - (depart % 10);

        while (alignement > 1) {
            System.out.print("\t");
            alignement--;
        }

		for (int i = depart ; i >= 0 ; i--) {
		    

            if (i % 10 == 0) {
                System.out.print(i + "\t");
                System.out.println();
            }
            else {
                System.out.print(i + "\t");
            }
        }
		
		System.out.println();
		System.out.println("C'est fini !");
		
		sc.close();
	}
	
}
