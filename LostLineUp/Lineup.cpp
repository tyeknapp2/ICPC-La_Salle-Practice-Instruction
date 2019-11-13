#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;
int main(int argc, char const *argv[])
{
  vector<int> dists;
  map<int, int> distToOrder;
  int u, h;
  cin >> u;
  for (int i = 2; i <= u; i++)
  {
    cin >> h;
    distToOrder.insert(pair<int, int>(h, i));
    dists.push_back(h);
  }
  sort(dists.begin(), dists.end());
  cout << 1 << " ";
  for (int it = 0; it < dists.size(); it++)
  {
    cout << distToOrder.at(dists.at(it)) << (it == dists.size() - 1 ? "\n" : " ");
  }
  return 0;
}