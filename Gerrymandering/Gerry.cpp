#include <iostream>
#include <vector>
using namespace std;
int main(int argc, char const *argv[])
{
  int inputs, districts, totalVs = 0, wa = 0, wb = 0, d, a, b;
  cin >> inputs >> districts;
  vector< vector<int> > votes;
  for (int i = 0; i < districts; i++)
    votes.push_back(vector<int>());
  for (int i = 0; i < inputs; i++)
  {
    cin >> d >> a >> b;
    cout << d << " " << a << " " << b << "\n";
    votes.at(d - 1).push_back(a);
    votes.at(d - 1).push_back(b);
    totalVs += a + b;
  }
  int y;
  for (int i = 0; i < districts; i++)
  {
    if (votes.at(i).at(0) > votes.at(i).at(1))
    {
      cout << "A ";
      y = votes.at(i).at(0) - ((votes.at(i).at(0) + votes.at(i).at(1)) / 2 + 1);
      wa += y;
      cout << y << " " << votes.at(i).at(1) << "\n";
      wb += votes.at(i).at(1);
    }
    else
    {
      cout << "B " << votes.at(i).at(0) << " ";
      wa += votes.at(i).at(0);
      y = votes.at(i).at(1) - ((votes.at(i).at(0) + votes.at(i).at(1)) / 2 + 1);
      wb += y;
      cout << y << "\n";
    }
  }
  cout << ((double)(wa - wb >= 0 ? wa - wb : -(wa - wb)) / (double)totalVs) << "\n";
  return 0;
}
