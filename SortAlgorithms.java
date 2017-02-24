class SortAlgorithms{

  public static void main(String[] args) {
    int array[]={1,8,4,1,2,3,5,7,5,9,5,3,1};
    insertionSort(array);

  }

/*
*selectionSort
*Dec:find the minimum element and place it at the begining ,Reapeat
*timeComplexity:O(n2)
*arr[]:array to be sorted
*/
  public static void selectionSort(int arr[])
  {
    int lengthOfArray = arr.length;
    printArray(arr);
    for (int i=0;i<lengthOfArray-1;i++) {
      // print(Integer.toString(i));
      int minimumElement=i;

      for (int j=i;j<lengthOfArray;j++) {
        if(arr[j] < arr[minimumElement])
        {
          minimumElement = j;
        }
      }
      print(Integer.toString(arr[minimumElement]));
      int temp=arr[minimumElement];
      arr[minimumElement]=arr[i];
      arr[i]=temp;

      printArray(arr);
    }

  }

  /*
  *Bubble Sort
  *Dec:compare the correspoding element and swap if lower
  *timeComplexity:O(n2)
  *arr[]:array to be sorted
  */
    public static void bubbleSort(int arr[])
    {
      int lengthOfArray = arr.length;
      printArray(arr);
      for (int i=0;i<lengthOfArray-1;i++) {
        for (int j=0;j<lengthOfArray-i-1;j++) {
          if(arr[j] > arr[j+1])
          {
            int temp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = temp;
          }

        }
        printArray(arr);
    }




    }


    /*
    *Insertion Sort
    *Dec:works like the way we sort cards
    *timeComplexity:O(n2)
    *arr[]:array to be sorted
    */
      public static void insertionSort(int arr[])
      {
        int lengthOfArray = arr.length;
        printArray(arr);
        for (int i=1;i<lengthOfArray;i++) {
          int key=arr[i];
          int j=i-1;
          while (j>=0 && arr[j] > key)
             {
                 arr[j+1] = arr[j];
                 j = j-1;
             }
             arr[j+1] = key;
          printArray(arr);
      }
      }

  static void print(String toBePrinted)
  {
    System.out.println(toBePrinted);
  }

  static void printArray(int arr[])
  {
      int n = arr.length;
      for (int i=0; i<n; ++i)
          System.out.print(arr[i]+" ");
      System.out.println();
  }


}
