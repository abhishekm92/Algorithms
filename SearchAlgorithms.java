class SearchAlgorithms{

  public static void main(String[] args) {
    int array[]={1,2,3,4,5,6,7,8};
    int result=linearSearch(array,8);
    int result2=binarySearchIterative(array,8);
    int result3=binarySearchRecursive(array,0,array.length,8);
    int result4=jumpSearch(array,8);
    int result5=interpolationSearch(array,8);
    print(Integer.toString(result));
    print(Integer.toString(result2));
    print(Integer.toString(result3));
    print(Integer.toString(result4));
    print(Integer.toString(result5));
  }

/*
*linearSearch
*Dec:search the element one by one in array
*timeComplexity:O(n)
*arr[]:array which needs to be searched
*searchKey:element to be searched
*returns postion of element in array
*/
  public static int linearSearch(int arr[],int searchKey)
  {
    int lengthOfArray=arr.length;
    if(lengthOfArray!=0)
    {
      for (int i=0;i<lengthOfArray ;i++ ) {

        if (arr[i]==searchKey)
        {
          return i;
        }
      }
    }

  return -1;
  }

  /*
  *linearSearch
  *Dec:search the element one by one in array
  *timeComplexity:O(n)
  *arr[]:array which needs to be searched
  *searchKey:element to be searched
  *returns postion of element in array
  */
    public static int linearSearchWithRange(int arr[],int rangeStart,int size,int searchKey)
    {
      int lengthOfArray=arr.length;
      int end=Math.min(rangeStart+size,lengthOfArray-1);
      if(lengthOfArray!=0)
      {
        for (int i=rangeStart;i<=end ;i++ ) {

          if (arr[i]==searchKey)
          {
            return i;
          }
        }
      }

    return -1;
    }

/*
*binarySearch
*Dec:take middle element and check the search element is present left or right ,repeat
*timeComplexity:O(Logn)
*sortedArr[]:sorted array which needs to be searched
*searchKey:element to be searched
*returns postion of element in array
*/
  public static int binarySearchIterative(int sortedArr[],int searchKey)
  {
   int lengthOfArray = sortedArr.length;
   int searchStartIndex = 0;
   int searchEndIndex = lengthOfArray - 1;
   if(lengthOfArray != 0)
   {
    while(searchStartIndex <= searchEndIndex)
    {
      int middle = (searchStartIndex + searchEndIndex)/2;
      print(Integer.toString(searchStartIndex));
      print(Integer.toString(searchEndIndex));
      print(Integer.toString(middle));
      print("---");
      if(sortedArr[middle] == searchKey)
      {
        return middle;
      }

      if(sortedArr[middle] < searchKey)
      {
        searchStartIndex=middle+1;
      }
      else
      {
        searchEndIndex=middle-1;
      }

    }

   }
  return -1;
  }


  /*
  *binarySearch
  *Dec:take middle element and check the search element is present left or right ,repeat and check if mid is the required element else change the start,end points and repeat
  *timeComplexity:O(Logn)
  *sortedArr[]:sorted array which needs to be searched
  *searchStartIndex:starting point to scan for element default:0
  *searchEndIndex:ending point to scan for element default:array length
  *searchKey:element to be searched
  *returns postion of element in array
  */
    public static int binarySearchRecursive(int sortedArr[],int searchStartIndex,int searchEndIndex,int searchKey)
    {
     if(searchEndIndex >= searchStartIndex)
     {
              int middle = (searchStartIndex + searchEndIndex)/2;

        if(sortedArr[middle] == searchKey)
        {
          return middle;
        }

        if(sortedArr[middle] < searchKey)
        {
          searchStartIndex=middle+1;
          return binarySearchRecursive(sortedArr,searchStartIndex,searchEndIndex,searchKey);
        }
        else
        {
          searchEndIndex=middle-1;
          return binarySearchRecursive(sortedArr,searchStartIndex,searchEndIndex,searchKey);
        }

     }
    return -1;
    }


  /*
  *jumpSearch
  *Dec:get element by range by jumping index and when right of element perform linearSearch from current to previous jump element
  *timeComplexity:O(√n)
  *jump size increment is square root of array size
  *sortedArr[]:sorted array which needs to be searched
  *searchKey:element to be searched
  *returns postion of element in array
  */
    public static int jumpSearch(int sortedArr[],int searchKey)
    {
      int lengthOfArray=sortedArr.length;
      int jumpSize= (int)Math.floor(Math.sqrt(lengthOfArray));
      int previousJumpIndex=0;

      if(lengthOfArray!=0)
      {
        while (sortedArr[Math.min(jumpSize,lengthOfArray)-1]<searchKey) {
          previousJumpIndex=jumpSize;
          jumpSize=jumpSize+(int)(Math.sqrt(jumpSize));
          if (previousJumpIndex >=lengthOfArray) {
            return -1;
          }
        }
        return linearSearchWithRange(sortedArr,previousJumpIndex,jumpSize,searchKey);
        //return binarySearchRecursive(sortedArr,previousJumpIndex,Math.min(previousJumpIndex+jumpSize,lengthOfArray),searchKey);
      }

    return -1;
    }


  /*
  *InterpolationSearch
  *Dec:same as binary search but interpolation search may go to different locations according the value of key being searched
  *timeComplexity:O(log log n)) worstcase: O(n)
  *sortedDistributedArr[]:sorted array which needs to be searched and is uniformly distributed
  *searchKey:element to be searched
  *returns postion of element in array
  +postion formula=searchStartIndex+(((searchEndIndex-searchStartIndex)/(sortedDistributedArr[searchEndIndex]-sortedDistributedArr[searchStartIndex]))*(searchKey-sortedDistributedArr[searchStartIndex]));
  */
    public static int interpolationSearch(int sortedDistributedArr[],int searchKey)
    {
     int lengthOfArray = sortedDistributedArr.length;
     int searchStartIndex = 0;
     int searchEndIndex = lengthOfArray - 1;
     if(lengthOfArray != 0)
     {
      while(searchStartIndex <= searchEndIndex && searchKey >= sortedDistributedArr[searchStartIndex] && searchKey <= sortedDistributedArr[searchEndIndex])
      {
        int postion = searchStartIndex+(((searchEndIndex-searchStartIndex)/(sortedDistributedArr[searchEndIndex]-sortedDistributedArr[searchStartIndex]))*(searchKey-sortedDistributedArr[searchStartIndex]));

        if(sortedDistributedArr[postion] == searchKey)
        {
          return postion;
        }

        if(sortedDistributedArr[postion] < searchKey)
        {
          searchStartIndex=postion+1;
        }
        else
        {
          searchEndIndex=postion-1;
        }

      }

     }
    return -1;
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
