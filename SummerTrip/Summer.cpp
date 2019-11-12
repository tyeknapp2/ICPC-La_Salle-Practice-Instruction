#include <iostream>
#include <string>
using namespace std;
int numDifferentLetters(string input)
{
  int differentLetters = 0;
  for (char l = 'a'; l <= 'z'; l++)
  {
    differentLetters += input.find(l) != -1 ? 1 : 0;
  }
  return differentLetters;
}

int main(int argc, char const *argv[])
{
  string calendar;
  cin >> calendar;
  int goodItineraries = 0;
  for (int i = 0; i < calendar.length() - 1; i++)
  {
    if (calendar.at(i) == calendar.at(i + 1))
    {
      continue;
    }
    string subSequence = calendar.substr(i + 1);
    subSequence = subSequence.find(calendar.at(i)) == -1 ? subSequence : subSequence.substr(0, subSequence.find_first_of(calendar.at(i)));

    goodItineraries += numDifferentLetters(subSequence);
  }
  cout << goodItineraries << "\n";
  return 0;
}
