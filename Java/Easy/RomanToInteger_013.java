
import java.util.HashMap;

public class RomanToInteger_013 {

    public static void main(String[] args) {
        System.out.println(romanToInt("MDCXCV"));
        System.out.println(romanToInt1("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int answer = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i + 1))) {
                answer -= hashMap.get(s.charAt(i));
            } else {
                answer += hashMap.get(s.charAt(i));
            }
        }

        answer += hashMap.get(s.charAt(s.length() - 1));
        return answer;
    }

    public static int romanToInt1(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i + 1))) {
                answer -= hashMap.get(s.charAt(i));
            } else {
                answer += hashMap.get(s.charAt(i));
            }
        }
        return answer;
    }

}
