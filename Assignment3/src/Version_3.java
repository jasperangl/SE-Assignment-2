import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Gruppe H7
 * Jasper Angl (108021103663)
 * Philipp Lehmann (108021228860)
 * Malte Janek Kottmann (108021220217)
 */
public class Version_3 {
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
        actualrandom = randomValue(factor, start, increment, max);

        System.out.println("Random seed the generator (y/n)");
        String x = br.readLine();
        if (x.equals("y")) {
            actualrandom = randomSeed(max);
            System.out.println(actualrandom);
        }

        while (true) {
            System.out.println("Another random number (y/n)?");
            String eingabe = br.readLine();
            if (eingabe.equals("y")) {
                actualrandom = randomValue(factor, actualrandom, increment, max);
                System.out.println(actualrandom);
            } else {
                break;
            }
        }
    }

    /**
     * Produces a pseudo random value using simple math with a size cap using modulo
     * @param factor The factor with which the seed gets multiplied
     * @param seed A seed value which will be continuously updated
     * @param increment The increment which gets added to the partial result
     * @param max The maximum number to be generated
     * @return A pseudo random generated value
     */
    private static short randomValue(int factor, int seed, int increment, int max) {
        return (short) (((factor * seed) + increment) % max);
    }

    /**
     * Generates a random seed using the current time.
     * @param max The maximum number to be generated
     * @return  A random seed between 0 and the given max value
     */
    private static short randomSeed(int max) {
        DateTimeFormatter t = DateTimeFormatter.ofPattern("A");
        String ms = t.format(LocalDateTime.now());
        int time = Integer.parseInt(ms);
        return (short) ((time / 10) % max);
    }
}
