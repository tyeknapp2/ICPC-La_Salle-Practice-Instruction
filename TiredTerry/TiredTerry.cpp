#include <iostream>
#include <vector>
#include <string>
using namespace std;
int main(int argc, char const *argv[])
{
  int p, d;
  cin >> p;
  cin >> p;
  cin >> d;
  string s;
  cin >> s;
  vector<char> timer;
  int sleep = 0;
  for (int i = s.length() - p; i < s.length(); i++)
  {
    sleep += (s.at(i) == 'Z') ? 1 : 0;
    timer.push_back(s.at(i));
  }
  int tiredness = 0;
  for (int i = 0; i < s.length(); i++)
  {
    char c = timer.at(0);
    timer.erase(timer.begin());
    sleep -= c == 'Z' ? 1 : 0;
    sleep += s.at(i) == 'Z' ? 1 : 0;
    timer.push_back(s.at(i));
    tiredness += sleep < d ? 1 : 0;
  }
  cout << tiredness << "\n";
  return 0;
}
