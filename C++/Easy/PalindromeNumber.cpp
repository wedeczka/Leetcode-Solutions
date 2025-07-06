#include <iostream>
#include <cmath>

using namespace std;

bool isPalindrome(int x)
{
    // Negative numbers aren't palindromes → e.g. -121 ≠ 121
    if (x < 0)
    {
        return false;
    }
    else if (x == 0)
    {
        return true;
    }

    // It has to be a second `if`, because otherwise an error occurs:
    // runtime error: -inf is outside the range of representable values of type 'int'
    // Explanation:
    // log10(0) is undefined (mathematically -∞), so truncating it and casting to int results in undefined behavior.
    // That's why x == 0 must be handled explicitly before log10 is called.

    // Calculate the number of digits in x
    // Time complexity: O(1) – log10(x) is constant time for primitive int
    // Space complexity: O(1)
    int size = trunc(log10(x)) + 1;

    // Loop compares digits from both ends toward the center
    // Runs at most floor(size / 2) times
    // Time complexity: O(log10(x)) = O(d), where d is number of digits
    // Space complexity: O(1) – no extra memory used beyond a few variables
    while (size > 1)
    {
        // Get the first digit by dividing by 10^(size - 1)
        int power = pow(10, size - 1);
        int first = x / power;

        // Get the last digit using modulo
        int last = x % 10;

        if (first != last)
        {
            return false;
        }

        // Remove first digit: x % power removes the most significant digit
        x %= power;

        // Remove last digit: integer division by 10 removes least significant digit
        x /= 10;

        size -= 2;
    }

    return true;
}

int main()
{
    cout << isPalindrome(2);
}
