#include "bits/stdc++.h"
using namespace std;

double calcIncTax(int taxableIncome)
{
    double tax = 0;

    tax += min(40000, taxableIncome) * 0.15;
    taxableIncome -= 40000;
    if (taxableIncome > 0)
    {
        tax += min(35000, taxableIncome) * 0.18;
        taxableIncome -= 35000;
    }
    if (taxableIncome > 0)
        tax += taxableIncome * 0.21;

    return tax;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    // For Testing, add any other test cases here to see if the algorithm still works
    pair<int, double> cases[] = {
        make_pair(37180, 5577),
        make_pair(61550, 9879),
        make_pair(94800, 16458),
    };

    for (auto p : cases)
    {
        double res = calcIncTax(p.first); 
        cout << "The tax for $" << p.first << " is $" << res << "\n";
        if (abs(p.second - res) < 10e-2)
            cout << "This is correct."
                 << "\n";
        else
            cout << "This is incorrect."
                 << "\n";
    }

    return 0;
}