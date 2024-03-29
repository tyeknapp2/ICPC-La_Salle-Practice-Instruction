#include <iostream>
#include <string>
using namespace std;

string decode(string in)
{
  string out = "";
  
  /** 
   * This for loop increments by two because we are guaranteed an encoded string of even length due to the encoding method.
   * You can think of the it at encoding pairs a char followed by an int and that it loops through those pairs
   */
  for (int i = 0; i < in.length(); i += 2)
  {
    char c = (in.at(i));
    int d = in.at(i + 1) - '0';
    while (d != 0)
    {
      out.push_back(c);
      d--;
    }
  }
  return out;
}

string encode(string in)
{
  string out = "";
  char let = in.at(0);
  int letCount = 0;
  for (int i = 0; i < in.length(); i++)
  {
    if (in.at(i) == let)
    {
      letCount++;
    }
    else
    {
      // adds the let
      out.push_back(let);
      out.push_back(letCount + '0');
      let = in.at(i);
      letCount = 1;
    }
  }
  // after the for loop the last letter and its count will need to be added
  out.push_back(let);
  out.push_back(letCount + '0');
  return out;
}

int main(int argc, char const *argv[])
{
  // handle input
  char input;
  cin >> input;
  string toCode;
  cin >> toCode;
  // handle output
  cout << (input == 'E' ? encode(toCode) : decode(toCode)) << "\n";
  return 0;
}
