/* 
 * 
 */

class MergeSortArray {
	private static final int minMergeSortListSize = 4;

	public static void mergeSortArray(int[] a, int start, int end) {
		int[] temp = new int[end - start];
		int i1, i2, tempi, middle;

		if ((end - start) < minMergeSortListSize) {
			/* Use insertion sort for small datasets. */
			for (int i = start; i < end; i++) {
				int j, v = a[i];
				for (j = i - 1; j >= start && a[j] > v; j--)
					a[j + 1] = a[j];
				a[j + 1] = v;
			}
			return;
		}
		middle = start + (end - start) / 2;
		mergeSortArray(a, start, middle);
		mergeSortArray(a, middle, end);
		i1 = start;
		i2 = middle;
		tempi = 0;
		while (i1 < middle && i2 < end)
			if (a[i1] <= a[i2])
				temp[tempi++] = a[i1++];
			else
				temp[tempi++] = a[i2++];
		while (i1 < middle)
			temp[tempi++] = a[i1++];
		while (i2 < end)
			temp[tempi++] = a[i2++];
		System.arraycopy(temp, 0, a, start, end - start);
	}

	
    public static int binarySearch(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
	public static void main(String[] argv) {
		// int size = Integer.parseInt(argv[0]);
		int size = 1000;  //size of array
		int[] a = new int[size];
		
		java.util.Random rand = new java.util.Random(System.currentTimeMillis());  // get a new "random" thing
		for (int i = 0; i < size; i++) {
			a[i] = rand.nextInt() % size;  // FILL array with random integers but MODULE the # of ints
		}

		System.out.println("Original array");
		for (int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		mergeSortArray(a, 0, size);
		for (int i = 1; i < size; i++) {
			if (!(a[i - 1] <= a[i])) {
				System.out.println("ERROR");
				System.exit(-1);
			}
		}
		System.out.println("Sorted array");
		for (int i = 0; i < size; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		
		
		testIfInArray(a, 0);
		testIfInArray(a, 1);
		testIfInArray(a, 2);
		testIfInArray(a, 3);
		testIfInArray(a, 4);
		testIfInArray(a, 5);
		testIfInArray(a, 6);
		testIfInArray(a, 7);
		testIfInArray(a, 8);
		testIfInArray(a, 9);
		
		
		System.exit(0);
	}


	private static void testIfInArray(int[] a, int key) {
		int result=binarySearch(key,a);
		if (result == -1 ) 
			System.out.println("DID NOT FIND THE VALUE "+ key);
		else
			{
			System.out.println("DID  FIND THE VALUE "+ key + " and it has the rank of "+ result);
			}
	}
}
