
import java.util.Arrays;

public class LongestCommonPrefix_014 {

    public static void main(String[] args) {
        String[] table = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix1(table));
        System.out.println(longestCommonPrefix(table));
    }

    public static String longestCommonPrefix1(String[] strs) {
        Arrays.sort(strs);
        // Time Complexity of Arrays.sort is O(n log n)
        // Sorting alfabetically  places the most different strings at the beginning and end

        String answer = "";

        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                // If characters match, add to the answer
                answer += strs[0].charAt(i);
            } else {
                // Stop when characters differ -->the end of the common prefix
                return answer;
            }
        }

        // Overall time complexity: O(n log n) for sorting + O(m) for prefix check
        // Final complexity is O(n log n)
        return answer;
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        // Initialize the prefix as the first word

        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            // For each string, check whether it starts with the current prefix

            while (!current.startsWith(prefix)) {
                // If it doesn't, shorten the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Final time complexity: O(n * m)
        // n = number of strings, m = average/minimal length of strings
        return prefix;
    }

}
