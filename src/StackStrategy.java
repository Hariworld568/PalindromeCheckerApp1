import java.util.Stack;

public class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String str) {

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        // Compare stack pop with original characters
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}