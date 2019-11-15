#include <iostream>
#include <vector>
#include <map>
using namespace std;
int main(int argc, char const *argv[])
{
  int numInputs;
  cin >> numInputs;
  map<char, bool> vars;
  char x;
  for (char i = 'A'; i < 'A' + numInputs; i++)
  {
    cin >> x;
    vars.insert(pair<char, bool>(i, (x == 'T')));
  }
  vector<bool> stackCalculator;
  bool left, right;
  while (cin >> x)
  {
    if (x == '*')
    {
      left = stackCalculator.at(stackCalculator.size() - 1);
      stackCalculator.pop_back();
      right = stackCalculator.at(stackCalculator.size() - 1);
      stackCalculator.pop_back();
      stackCalculator.push_back(right && left);
    }
    else if (x == '+')
    {
      left = stackCalculator.at(stackCalculator.size() - 1);
      stackCalculator.pop_back();
      right = stackCalculator.at(stackCalculator.size() - 1);
      stackCalculator.pop_back();
      stackCalculator.push_back(right || left);
    }
    else if (x == '-')
    {
      left = stackCalculator.at(stackCalculator.size() - 1);
      stackCalculator.pop_back();
      stackCalculator.push_back(!left);
    }
    else
    {
      stackCalculator.push_back(vars.at(x));
    }
  }
  cout << (stackCalculator.at(0) ? "T" : "F") << "\n";
  return 0;
}
