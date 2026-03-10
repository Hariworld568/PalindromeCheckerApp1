import java.util.*;

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
            System.out.println("UC2: " + word + " is a Palindrome");
        } else {
            System.out.println("UC2: " + word + " is Not a Palindrome");
        }

        Scanner scanner = new Scanner(System.in);

        // UC3: Palindrome Check Using String Reverse
        System.out.print("\nEnter a string for UC3: ");
        String input = scanner.nextLine();
        String reversed = "";

        for(int i = input.length() - 1; i >= 0; i--){
            reversed = reversed + input.charAt(i);
        }

        if(input.equals(reversed)){
            System.out.println("UC3: Palindrome");
        } else {
            System.out.println("UC3: Not Palindrome");
        }

        // UC4: Character Array Based Palindrome Check
        System.out.print("\nEnter a string for UC4: ");
        String str4 = scanner.nextLine();
        char[] arr = str4.toCharArray();

        int left = 0;
        int right = arr.length - 1;
        boolean isPalindrome4 = true;

        while(left < right){
            if(arr[left] != arr[right]){
                isPalindrome4 = false;
                break;
            }
            left++;
            right--;
        }

        if(isPalindrome4){
            System.out.println("UC4: Palindrome");
        } else {
            System.out.println("UC4: Not Palindrome");
        }

        // UC5: Stack-Based Palindrome Checker
        System.out.print("\nEnter a string for UC5: ");
        String str5 = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        for(char c : str5.toCharArray()){
            stack.push(c);
        }

        String revStack = "";

        while(!stack.isEmpty()){
            revStack = revStack + stack.pop();
        }

        if(str5.equals(revStack)){
            System.out.println("UC5: Palindrome");
        } else {
            System.out.println("UC5: Not Palindrome");
        }

        scanner.close();
    }
}