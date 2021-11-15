import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] marques = new String[]{"Apple", "Samsung", "Google", "Sony", "Microsoft", "Amazon"};
        Arrays.stream(marques)
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println();
        Arrays.stream(marques)
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);
        System.out.println();
        System.out.println(Arrays.stream(new int[] {1, 2, 3, 4, 5}).reduce(0, Integer::sum));
    }
}
