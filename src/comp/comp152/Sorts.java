package comp.comp152;

public class Sorts {
    public static void main(String[] args) {
        //RUN THIS METHOD TO TEST YOUR SORTS!
        //Adjust the comments on lines 7-9 to try out each sort and verify that it outputs in the order 1-10.

        int[] nums = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        //bubbleSort(nums);
        //insertionSort(nums);
        mergeSort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void bubbleSort(int[] nums) {
        boolean swapped; //tracks whether a pair was swapped
        int n = nums.length - 1;

        for (int i = 0; i < n; ++i) {
            swapped = false; //assume false each time we begin a new pass over the array
            for (int j = 0; j < n - i; ++j) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true; //mark it true so we know a swap happened
                }
            }

            if (!swapped) //if this pass didn't have any swaps, the array is sorted. we can break out early now!
                break;
        }
    }

        public static void insertionSort ( int[] nums){
            int n = nums.length;
            for (int i = 1; i < n; ++i) {
                int current = nums[i];
                int j = i - 1;

                while (j >= 0 && nums[j] > current) {
                    nums[j + 1] = nums[j];
                    --j;
                }
                nums[j + 1] = current;
            }
        }

        public static void mergeSort ( int[] nums, int low, int high){
            if (low < high) {
                int mid = (low + high) / 2;
                mergeSort(nums, low, mid);
                mergeSort(nums, mid + 1, high);
                merge(nums, low, mid, high);
            }
        }

        public static void merge ( int[] nums, int low, int mid, int high){
           int[] left = new int[mid-low+1];
           int[] right = new int[high-mid];

           for(int i = 0; i < left.length; ++i) {
               left[i] = nums[low+i];
           }
           for(int i = 0; i < right.length; ++i) {
               right[i] = nums[mid+1+i];
           }
           int leftPoint = 0, rightPoint = 0;
           int numsPoint = low;

           while(leftPoint < left.length && rightPoint < right.length) {
               if(left[leftPoint] < right[rightPoint]) {
                   // when left[leftPoint] is less, copy value from left into nums
                   nums[numsPoint] = left[leftPoint];
                   ++leftPoint;
               } else {
                   nums[numsPoint] = right[rightPoint];
                   ++rightPoint;
               }
               ++numsPoint;
           }
            while (leftPoint < left.length) {
                nums[numsPoint] = left[leftPoint];
                ++leftPoint;
                ++numsPoint;
            }

            while (rightPoint < right.length) {
                nums[numsPoint] = right[rightPoint];
                ++rightPoint;
                ++numsPoint;
            }
        }
    }