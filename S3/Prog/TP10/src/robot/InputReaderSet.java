package robot;

import java.util.*;

public class InputReaderSet implements InputReader {
    private final Set<String> strings = new HashSet<>();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Collection<String> getInput() {
        System.out.print("> ");
        String r = scanner.nextLine().trim();
        for (String s : r.split(" ")) {
            this.strings.add(s);
        }

        return this.strings;
    }
}
