
public class RadixSort {

	int getMax(int a[], int n) {
		int max = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

	void countingSort(int a[], int n, int place) {
		int output[] = new int[n + 1];
		int count[] = new int[10];
		
		//calculate the count of elements
		for (int i = 0; i < n; i++)
			count[(a[i] / place) % 10]++;
		
		//calculate the cumulative frequency
		for (int i = 1; i<10; i++)
			count[i] += count[i-1];
		
		//place the elements in sorted order
		for (int i = n - 1; i >= 0 ; i--) {
			output[count[(a[i] / place) % 10] - 1] = a[i];
			count[(a[i] / place) % 10]--;
		}
		
		for(int i = 0 ; i < n ; i++)
			a[i] = output[i];
		
	}
	
	void radixSort (int arr[]) {
		int n = arr.length;
		//get maximum element from array
		int max = getMax(arr, n);
		
		//apply counting sort to sort elements based on place value
		for (int place = 1; max / place > 0; place *=10)
			countingSort(arr, n, place);
	}

}






