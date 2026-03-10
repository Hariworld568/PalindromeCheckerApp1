import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1: Welcome Message
        System.out.println("Welcome to Palindrome Checker App");

        // UC2: Hardcoded Palindrome Check
        String word = "madam";
        String reverse = "";

        for(int i = word.length() - 1; i >= 0; i--){
            reverse = reverse + word.charAt(i);
        }

        if(word.equals(reverse)){
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is Not a Palindrome");
        }

        // UC3: Palindrome Check Using String Reverse (User Input)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String reversed = "";

        for(int i = input.length() - 1; i >= 0; i--){
            reversed = reversed + input.charAt(i);
        }

        if(input.equals(reversed)){
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is Not a Palindrome");
        }

        scanner.close();
    }
}