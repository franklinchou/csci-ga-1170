#include < iostream > 
#include < string >
using namespace std;

void selectionsort(string[], int);
void displayarray(const string[], int);

int main() {
  const int NUM_NAMES = 20;
  string names[NUM_NAMES] = {
    "Collins, Bill",
    "Smith, Bart",
    "Allen, Jim",
    "Griffin, Jim",
    "Stamey, Marty",
    "Rose, Geri",
    "Taylor, Terri",
    "Johnson, Jill",
    "Allison, Jeff",
    "Looney, Joe",
    "Wolfe, Bill",
    "James, Jean",
    "Weaver, Jim",
    "Pore, Bob",
    "Rutherford, Greg",
    "Javens, Renee",
    "Harrison, Rose",
    "Setzer, Cathy",
    "Pike, Gordon",
    "Holland, Beth"
  };

  cout << " The original order of names are: \n";
  displayarray(names, NUM_NAMES);

  selectionsort(names, NUM_NAMES);

  cout << " The alphabetized names are: \n";
  displayarray(names, NUM_NAMES);

  return 0;
}

void selectionsort(string array[], int NUM_NAMES) {
  int scan;
  int minIndex;
  string minValue;

  for (scan = 0; scan < (NUM_NAMES - 1); scan++) {
    minIndex = scan;
    minValue = array[scan]; // this is replacing the start of the array with the minimum value found 
    for (int index = scan + 1; index < NUM_NAMES; index++) // this is telling the array to start back at index 0 + 1, basically the next value in line
    {
      if (array[index] < minValue) //if there is a value found that is less than the minimum value 
      {
        minValue = array[index]; //then replace the min value with that index found in the array 
        minIndex = index; // after that assign the minimum value to that index  
      }
    }
    array[minIndex] = array[scan];
    array[scan] = minValue;
  }

}

void displayarray(const string array[], int NUM_NAMES) {
  for (int count = 0; count < NUM_NAMES; count++) {
    cout << array[count] << endl;
  }
}
