// import a library that attempts to make up for some of Java's many failings
// see https://commons.apache.org/proper/commons-lang/ for overview
// full documentation here: https://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html
import org.apache.commons.lang3.StringUtils; 

public class App {

    /**
     * Show off how to left-, right-, or center-align Strings.
     */
    public static void alignStrings() {
        String s;
        System.out.println("\n\n## Strings\n");
        
        System.out.println("Basic alignment:");
        // right-aligned... the default
        s = String.format("%10s", "foo");
        System.out.println("|" + s + "|");

        // left-aligned
        s = String.format("%-10s", "foo");
        System.out.println("|" + s + "|");

        // centered... no easy way to do this with the standard API
        // here we use the StringUtils library, which we have downloaded and placed into the lib directory
        s = StringUtils.center("foo", 10); // you can use StringUtils to do .left() or .right() aligned text as well
        System.out.println("|" + s + "|");

        // left-aligned, with dashes - used to fill the extra space
        s = StringUtils.leftPad("foo", 10, "-");
        System.out.println("|" + s + "|");

        // right-aligned, with dashes - used to fill the extra space
        s = StringUtils.rightPad("foo", 10, "-");
        System.out.println("|" + s + "|");

        // mixed alignments
        System.out.println("\nTable-like alignment:");
        System.out.println(String.format("| %-20s | %20s | %20s |", "left-aligned", StringUtils.center("center-aligned", 20), "right-aligned"));
        System.out.println(String.format("| %-20s | %20s | %20s |", "foo", StringUtils.center("bar", 20), "baz"));

    }

    /**
     * Show off how to format floating-point numbers.
     */
    public static void alignFloatingPointNumbers() {
        String s;
        System.out.println("\n\n## Floating Point Numbers\n");

        System.out.println("Basic alignment:");
        // right-aligned... the default
        s = String.format("%20f", Math.PI);
        System.out.println("|" + s + "|");

        // right-aligned truncated to 2 decimal places
        s = String.format("%20.2f", Math.PI);
        System.out.println("|" + s + "|");

        // left-aligned, truncated to 2 decimal places
        s = String.format("%-20.2f", Math.PI);
        System.out.println("|" + s + "|");

        // centered, truncated to 2 decimal places... no easy way to do this with the standard API alone
        // we use the StringUtils library which we have placed into the lib directory: https://commons.apache.org/proper/commons-lang/
        s = StringUtils.center(String.format("%.2f", Math.PI), 20); // you can use StringUtils to do .left() or .right() aligned text as well
        System.out.println("|" + s + "|");

        // mixed alignments
        System.out.println("\nTable-like alignment:");
        System.out.println(String.format("| %-20s | %20s | %20s |", "left-aligned", StringUtils.center("center-aligned", 20), "right-aligned"));
        System.out.println(String.format("| %-20.2f | %20s | %20.2f |", Math.PI, StringUtils.center(String.format("%.2f", Math.PI), 20), Math.PI));

    }


    public static void main(String[] args) throws Exception {
        alignStrings();
        alignFloatingPointNumbers();
    }
}
