#include <iostream>
#include <string>
using namespace std;
int main(int argc, char const *argv[])
{
  string s;
  cin >> s;
  cout << (s.find("ss") != -1 ? "hiss" : "no hiss") << "\n";
  return 0;
}
