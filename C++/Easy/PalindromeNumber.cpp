#include <iostream>
#include <cmath>

using namespace std;
bool isPalindrome(int x)
{
    //
    if (x < 0)
    {
        return false;
    }
    else if (x == 0)
    {
        return true;
    }
    //it has to be second if because otherwise the error occurs
    //runtime error: -inf is outside the range of representable values of type 'int'
    // meaning that when size is -inf it can't change the value into int  
    int size = trunc(log10(x)) + 1;
    while (size > 1)
    {
        int power = pow(10, size - 1);
        int first = x / power;
        int last = x % 10;

        if (first != last)
        {
            return false;
        }

        x %= power;
        x /= 10;
        size -= 2;
    }
    return true;
}

int main()
{
    cout << isPalindrome(2);
}
