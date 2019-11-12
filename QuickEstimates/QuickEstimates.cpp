#include <iostream>
#include <string>
using namespace std;
int main(int argc, char const *argv[])
{
  int n;
  cin >> n;
  string s;
  for (int i = 0; i < n; i++)
  {
    cin >> s;
    cout << s.length() << "\n";
  }
  return 0;
}
