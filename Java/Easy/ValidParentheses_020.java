
import java.util.HashMap;
import java.util.Stack;

class ValidParentheses_020 {

    public static void main(String[] args) {
        String test = "]";
        System.out.println(isValid(test));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
    if (stack.isEmpty()) {
        return false;
    }
    if (hashMap.get(stack.pop()) != s.charAt(i)) {
        return false;
    }
}
        }
        return stack.isEmpty();
    }

    // The best possible way to solve this problem is by using a stack.
    // We have to know that a stack works on the LIFO principle (Last In, First Out).
    // Example: if we do stack.push(2); stack.push(3); stack.push(4);
    // Then stack.pop() will return 4, because it was the last pushed element.
}
