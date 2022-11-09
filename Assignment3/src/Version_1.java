import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Gruppe H7
 * Jasper Angl (108021103663)
 * Philipp Lehmann (108021228860)
 * Malte Janek Kottmann (108021220217)
 */

// A test commit
public class Version_1 {
    private static InputStreamReader isr;
    private static BufferedReader br;
    private static short max, factor, increment, start, actualrandom;

    public static void main(String[] args) throws IOException {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        max = 1000;
        factor = 623;
        increment = 525;
        start = 157;
        actualrandom = (short) (((factor * start) + increment) % max);

        System.out.println("Random seed the generator (y/n)");
        String x = br.readLine();
        if (x.equals("y")) {
            DateTimeFormatter t = DateTimeFormatter.ofPattern("A");
            String ms = t.format(LocalDateTime.now());
            int time = Integer.parseInt(ms);
            actualrandom = (short) ((time/10)%max);
            System.out.println(actualrandom);
        }

        System.out.println("Another random number (y/n)?");
        String eingabe = br.readLine();
        if (eingabe.equals("y")) {
            actualrandom = (short) (((factor * actualrandom) + increment) % max);
            System.out.println(actualrandom);
        }
        if (!eingabe.equals("y")) {
            return ;
        }

        /**
         * This is where the program starts to have its issues. We cannot infinitely loop through a command in Java
         * without using some form of loop-statement. In structured programming no such command is allowed and therefore
         * the task is impossible to solve. The command that is missing would be a GOTO command that would
         * place us at an earlier line (line 31) in the program, but even if it existed it wouldn't be permissible.
         */

    }
}




