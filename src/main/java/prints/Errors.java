package main.java.prints;

public class Errors {
    public static void PrintExceptionError(Exception e) {
        System.out.println();
        System.out.println("EXCEPTION ERROR: " + e.getClass());
        System.out.println("[i] ———— Uh-oh... looks like you found a bug in my code. Feel free to report, or suggest a fix!");
        System.out.print("> ");
    }

    public static void PrintInputError() {
        System.out.println();
        System.out.println("INPUT ERROR: Your input is invalid!");
        System.out.println("[i] ———— Make sure to type within the right type and scope.");
        System.out.print("> ");
    }4
}
