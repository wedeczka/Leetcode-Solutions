
class PalindromeNumber_09 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(9999));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int length = (int) Math.log10(x) + 1;

        while (length > 1) {
            int power = (int) Math.pow(10, length - 1);
            int first = x / power;
            int last = x % 10;

            if (first != last) {
                return false;
            }

            x = x % power;
            x = x / 10;

            length -= 2;
        }

        return true;
    }

}
