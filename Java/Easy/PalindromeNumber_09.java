
class PalindromeNumber_09 {

    public static void main(String[] args) {
        System.out.println(isPalindromeV1(10));
    }

    public static boolean isPalindrome(int x) {
        // Negative numbers aren't palindroms --> -123 - != 3 
        if (x < 0) {
            return false;
        }

        //In this solution we need to know what is the length of the int, without parsing to String we can use the log to find how long the int is.
        //Time complexity is O(1) - log10(x)
        //Space O(1) we don't use more memory than we have
        int length = (int) Math.log10(x) + 1;
        // Loop compares digits from both ends toward the center
        // Runs at most floor(length / 2) iterations
        // Time: O(log10(x)) => O(d), where d = number of digits in x
        // Space: O(1) – no extra memory used except primitive variables
        while (length > 1) {
            int power = (int) Math.pow(10, length - 1);
            int first = x / power;
            int last = x % 10;

            if (first != last) {
                return false;
            }

            //After we checked our number we have to remove the first digit
            //for example the number is 1221 we want to remove the first digit so we do modulo of 10^(4-1)
            // so it is 1221 % 1000 what gives us 221 
            x = x % power; //remove the first digit 
            //now we want to remove the last digit we can't do number % 10 because we will get only the last digit and we don't want it 
            //we want to REMOVE the last digit not only have the last digit
            //for example 221 % 10 would give us 1 but we dont want it ,
            //so 221 divide 10 equals 22,1 but it will only take integer so 22 
            //as we see, we get the digits that was in center of the number 
            x = x / 10; //remove the last digit

            length -= 2;
        }

        return true;
    }

    public static boolean isPalindromeV1(int x) {
        // Negative numbers aren't palindroms e.g 123 != -123
        //all numbers that last digit is 0 cannot be palindroms e.g 1111110
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversed = 0;
        //we do the loop till the original number is highers than reversed number 
        //(if there is even number of digits we will check all, if odd we will check everything beside the middle one)
        while (x > reversed) {
            //this is the proces of making the reverse number e.g
            //x = 1234554321
            //reverse = 0 * 10 + 1 = 1
            //next step x = 123455432
            //reverse = 1 * 10 + 2 =12
            //next step x = 12345543
            //reverse = 12 * 10 + 3 = 123 and we can clearly see that we "rotate" the number 
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10; //the second half is when there is a odd number of digits co we want to cut the middle one 
    }
}
