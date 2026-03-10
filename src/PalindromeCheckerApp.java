import java.util.*;

public class PalindromeCheckerApp {
    // Node class for Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to check palindrome using Linked List
    public static boolean isPalindromeLinkedList(String input) {

        Node head = null;
        Node tail = null;

        // Convert string to linked list
        for (char c : input.toCharArray()) {
            Node newNode = new Node(c);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Find middle
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Compare both halves
        Node first = head;
        Node second = prev;

        while (second != null) {
            if (first.data != second.data) {
                return false;
            }
            first = first.next;
            second = second.next;
        }

        return true;
    }

    // UC9: Recursive Palindrome Checker
    public static boolean isPalindromeRecursive(String str, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // UC10: Case-insensitive and ignore spaces
    public static boolean isPalindromeIgnoreCase(String str) {

        str = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        // UC1: Welcome Message
        System.out.println("Welcome to Palindrome Checker App");

        // UC2: Hardcoded Palindrome Check
        String word = "madam";
        String reverse = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reverse = reverse + word.charAt(i);
        }

        if (word.equals(reverse)) {
            System.out.println("UC2: " + word + " is a Palindrome");
        } else {
            System.out.println("UC2: " + word + " is Not a Palindrome");
        }

        Scanner scanner = new Scanner(System.in);

        // UC3: Palindrome Check Using String Reverse
        System.out.print("\nEnter a string for UC3: ");
        String input = scanner.nextLine();
        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        if (input.equals(reversed)) {
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

        while (left < right) {
            if (arr[left] != arr[right]) {
                isPalindrome4 = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome4) {
            System.out.println("UC4: Palindrome");
        } else {
            System.out.println("UC4: Not Palindrome");
        }

        // UC5: Stack-Based Palindrome Checker
        System.out.print("\nEnter a string for UC5: ");
        String str5 = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        for (char c : str5.toCharArray()) {
            stack.push(c);
        }

        String revStack = "";

        while (!stack.isEmpty()) {
            revStack = revStack + stack.pop();
        }

        if (str5.equals(revStack)) {
            System.out.println("UC5: Palindrome");
        } else {
            System.out.println("UC5: Not Palindrome");
        }

        // UC6: Queue + Stack Based Palindrome Check
        System.out.print("\nEnter a string for UC6: ");
        String str6 = scanner.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack6 = new Stack<>();

        for (char c : str6.toCharArray()) {
            queue.add(c);
            stack6.push(c);
        }

        boolean isPalindrome6 = true;

        while (!queue.isEmpty()) {
            if (queue.remove() != stack6.pop()) {
                isPalindrome6 = false;
                break;
            }
        }

        if (isPalindrome6) {
            System.out.println("UC6: Palindrome");
        } else {
            System.out.println("UC6: Not Palindrome");
        }

        // UC7: Deque-Based Optimized Palindrome Checker
        System.out.print("\nEnter a string for UC7: ");
        String str7 = scanner.nextLine();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str7.toCharArray()) {
            deque.add(c);
        }

        boolean isPalindrome7 = true;

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome7 = false;
                break;
            }
        }

        if (isPalindrome7) {
            System.out.println("UC7: Palindrome");
        } else {
            System.out.println("UC7: Not Palindrome");
        }

        // UC8: Linked List Palindrome Check
        System.out.print("Enter string for Linked List Palindrome Check: ");
        String llInput = scanner.nextLine();

        if (isPalindromeLinkedList(llInput)) {
            System.out.println(llInput + " is a Palindrome");
        } else {
            System.out.println(llInput + " is Not a Palindrome");
        }

        // UC9: Recursive Palindrome Checker

        System.out.print("Enter string for Recursive Palindrome Check: ");
        String recInput = scanner.nextLine();

        if (isPalindromeRecursive(recInput, 0, recInput.length() - 1)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        // UC11 (Object Oriented Palindrome Service)
        PalindromeChecker checker = new PalindromeChecker();
        System.out.println(checker.checkPalindrome("madam"));


        //UC12
        PalindromeStrategy strategy = new StackStrategy();

        if (strategy.check("madam")) {
            System.out.println("Palindrome using Strategy Pattern");
        } else {
            System.out.println("Not Palindrome");
        }

        // UC13: Performance Comparison

        String test = "madam";

// Recursive Method Timing
        long start1 = System.nanoTime();

        boolean result1 = isPalindromeRecursive(test, 0, test.length() - 1);

        long end1 = System.nanoTime();

        System.out.println("Recursive Result: " + result1);
        System.out.println("Recursive Time: " + (end1 - start1) + " ns");


// Stack Strategy Timing
        PalindromeStrategy s = new StackStrategy();

        long start2 = System.nanoTime();

        boolean result2 = s.check(test);

        long end2 = System.nanoTime();

        System.out.println("Stack Result: " + result2);
        System.out.println("Stack Time: " + (end2 - start2) + " ns");
    }
}