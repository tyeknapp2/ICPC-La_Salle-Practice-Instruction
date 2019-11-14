#include <iostream>
using namespace std;
int main(int argc, char const *argv[])
{
  int n, h, v;
  cin >> n >> h >> v;
  cout << (4 * (n - h > h ? n - h : h) * (n - v > v ? n - v : v)) << "\n";
  return 0;
}
