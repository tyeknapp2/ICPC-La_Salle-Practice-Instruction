#include <iostream>
#include <vector>
using namespace std;
int main(int argc, char const *argv[])
{
  double b;
  double p;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++)
  {
    cin >> b;
    cin >> p;
    double bpm = 60 * b / p;
    cout << (bpm - bpm / b) << " " << bpm << " " << (bpm + bpm / b) << "\n";
  }
  return 0;
}
