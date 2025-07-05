#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

vector<int> twoSum(const vector<int> &nums, int target)
{
    unordered_map<int, int> numbers;

    for (size_t i = 0; i < nums.size(); i++)
    {
        int help = target - nums[i];

        if (numbers.contains(help))
        {
            return {numbers[help], static_cast<int>(i)};
        }

        numbers[nums[i]] = static_cast<int>(i);
    }

    return {}; // no solution
}

int main()
{
    vector<int> result = twoSum(vector<int>{4, 5, 34, 5}, 9);

    if (!result.empty())
    {
        cout << "[" << result[0] << ", " << result[1] << "]" << endl;
    }
    else
    {
        cout << "[]" << endl;
    }

    return 0;
}
