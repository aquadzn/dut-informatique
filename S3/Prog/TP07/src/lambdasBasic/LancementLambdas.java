package lambdasBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LancementLambdas {

    public static ArrayList<Gens> appliquerAChacun(ArrayList<Gens> l, Function<Gens, Gens> f) {
        ArrayList<Gens> gens = new ArrayList<>();
        for(Gens g : l) {
            gens.add(f.apply(g));
        }

        return gens;
    }

    public static List<Integer> m1(List<Integer> l) {
        return l.stream()
                .map(i -> i * 2)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Gens a, b, c, d;
        a = new Gens("lulu", 18);
        b = new Gens("toto", 17);
        c = new Gens("lulu", 20);
        d = new Gens("bibi", 20);

        Produit p112et30 = new Produit(112, 30);
        Produit p150et15 = new Produit(150, 15);
        Produit p120et30 = new Produit(120, 30);
        Produit p112et40 = new Produit(112, 40);
        Produit p120et30Bis = new Produit(120, 30);

        // completez avec des lambdas expressions et eventuellement le type de
        // la variable.:
        // 1: p est une fonction qui prend un gens et teste s'il a plus de 18
        // ans.
         Predicate<Gens> p = gens -> gens.getAge() > 18;
         System.out.println(p.test(a));
         System.out.println(p.test(b));
         System.out.println(p.test(c));

        // 2 :p2 est une fonction qui prend un gens et teste s'il s'appelle
        // "lulu".
         Predicate<Gens> p2 = gens -> gens.getNom().equals("lulu");
         System.out.println(p2.test(a));
         System.out.println(p2.test(b));
         System.out.println(p2.test(c));

        // // 3 :p3 est une fonction qui prend un gens et teste si son nom
        // commence
        // // par l..
         Predicate<Gens> p3 = gens -> gens.getNom().startsWith("l");
         System.out.println(p3.test(a));
         System.out.println(p3.test(b));
         System.out.println(p3.test(c));

        // // 4 : p4 est une fonction prenant un produit et testant si son prix
        // est sup
        // a 35
         Predicate<Produit> p4 = (Produit x) -> x.getPrix() > 35;
         System.out.println(p4.test(p112et40));
         System.out.println(p4.test(p112et30));

        // // 5 : utiliser and or negate (cf javadoc Predicate) pour que p5
        // teste si un
        // // Gens s'appelle "lulu" et a plus de 18 ans.
         Predicate<Gens> p5 = p2.and(p);
         System.out.println(p5.test(a));
         System.out.println(p5.test(b));
         System.out.println(p5.test(c));

        // 6 : // sur qui p6 repondra t il true ?
        Predicate<Gens> p6 = p5.or(p3.negate());
        // B, C et D mais pas A
        System.out.println(p6.test(a));
        System.out.println(p6.test(b));
        System.out.println(p6.test(c));
        System.out.println(p6.test(d));

        // // f1 est une fonction prenant une String et retournant sa longueur.
        Function<String, Integer> f1 = (String::length);
        // // L'unique methode abstraite de l'interface fonctionnelle
        // Function<S,T>
        // // T apply(S x);
        // // appliquée à "bonjour" f1 retourne donc 7
        System.out.println(f1.apply("bonjour"));

        // // 7 : typer f11.
         Function<Integer, Integer> f11 = x-> x+2;
         System.out.println(f11.apply(2));
         System.out.println(f11.apply(4));

        // // 8 : f2 est une fonction qui prend un gens et retourne son age
         Function<Gens, Integer> f2 = Gens::getAge;
         System.out.println(f2.apply(a));
         System.out.println(f2.apply(b));

        // // 9 : f3 est une fonction qui prend un gens et retourne la premiere
        // lettre de son
        // // nom.
         Function<Gens, Character> f3 = gens -> gens.getNom().charAt(0);
         System.out.println(f3.apply(a));
         System.out.println(f3.apply(b));

        // // 10 : utiliser andThen pour que f4 prenne un gens et retourne le
        // double de
        // // son age.
         Function<Gens, Integer> f4 = f2.andThen(integer -> integer * 2);
        System.out.println(f4.apply(a));

        // // 11 typer :
        Function<Gens, Character> f5 = ((Function<Gens, String>) x -> x.getNom()).andThen(y -> y.charAt(0));
        System.out.println(f5.apply(d));

        ArrayList<Gens> lesGens = new ArrayList<>();
        lesGens.add(a);
        lesGens.add(b);
        lesGens.add(c);
        lesGens.add(d);

        Function<Gens, Gens> augAge = gens -> new Gens(gens.getNom(), f11.apply(gens.getAge()));
        System.out.println(appliquerAChacun(lesGens, augAge));

        Function<Gens, Gens> majNom = gens -> new Gens(gens.getNom().toUpperCase(), gens.getAge());
        System.out.println(appliquerAChacun(lesGens, majNom));

        // EX STREAM
        // 1.1
        System.out.println("\nSTREAM\n------\n");
        ArrayList<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(4);
        l.add(7);
        l.add(8);

        System.out.println(
                l.stream()
                        .filter(i -> i % 2 == 0)
                        .count()
        );

        // 2.1
        ArrayList<Integer> lpair = l.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(lpair);

        // 2.2
        Set<String> strings = Arrays.stream(new String[]{"toto", "bidule", "truc"})
                .filter(s -> s.length() == 4)
                .collect(Collectors.toSet());
        System.out.println(strings);

        // 3.1
        System.out.println(
                lesGens.stream()
                        .map(Gens::getAge)
                        .collect(Collectors.toCollection(ArrayList::new)).toString()
        );

        // 3.2
        System.out.println(
                lesGens.stream()
                        .map(gens -> gens.getNom().length())
                        .collect(Collectors.toCollection(ArrayList::new)).toString()
        );

        // 3.4
        System.out.println(
                m1(lpair)
        );

        // 4.1
        System.out.println(
                lesGens.stream()
                        .map(Gens::getNom)
                        .filter(s -> s.toLowerCase().charAt(0) == 'l')
                        .collect(Collectors.toList())
        );

        // 4.2
        System.out.println(
                lesGens.stream()
                        .filter(gens -> gens.getAge() == 20)
                        .map(Gens::getNom)
                        .collect(Collectors.toList())
        );

        // 4.3
        ArrayList<String> lesGens20Ans = new ArrayList<>();
        for(Gens g : lesGens) {
            if (g.getAge() == 20) {
                lesGens20Ans.add(g.getNom());
            }
        }
        System.out.println(lesGens20Ans);

        // 4.4
        System.out.println(
                lesGens.stream()
                        .map(gens -> gens.getNom().length())
                        .filter(longueurNom -> longueurNom > 3)
                        .collect(Collectors.toList())
        );
    }

}
