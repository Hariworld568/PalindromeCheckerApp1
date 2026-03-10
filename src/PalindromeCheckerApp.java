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

        // UC6: Queue + Stack Based Palindrome Check
        System.out.print("\nEnter a string for UC6: ");
        String str6 = scanner.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack6 = new Stack<>();

        for(char c : str6.toCharArray()){
            queue.add(c);
            stack6.push(c);
        }

        boolean isPalindrome6 = true;

        while(!queue.isEmpty()){
            if(queue.remove() != stack6.pop()){
                isPalindrome6 = false;
                break;
            }
        }

        if(isPalindrome6){
            System.out.println("UC6: Palindrome");
        } else {
            System.out.println("UC6: Not Palindrome");
        }

        // UC7: Deque-Based Optimized Palindrome Checker
        System.out.print("\nEnter a string for UC7: ");
        String str7 = scanner.nextLine();

        Deque<Character> deque = new ArrayDeque<>();

        for(char c : str7.toCharArray()){
            deque.add(c);
        }

        boolean isPalindrome7 = true;

        while(deque.size() > 1){
            if(deque.removeFirst() != deque.removeLast()){
                isPalindrome7 = false;
                break;
            }
        }

        if(isPalindrome7){
            System.out.println("UC7: Palindrome");
        } else {
            System.out.println("UC7: Not Palindrome");
        }

        scanner.close();
    }
}