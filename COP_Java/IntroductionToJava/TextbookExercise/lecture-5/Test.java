public class Test {

	public static void main(String[] args) {
		
		int arrOriginal[] = new int[10];
		
		for (int i=0; i<arrOriginal.length; i++) {
			int rnd = (int) (Math.random() * 100);
			arrOriginal[i] = rnd;
			System.out.print(arrOriginal[i]+ " ");
		}
		System.out.println();
		
		int arr[] = new int[arrOriginal.length];
		
		/*
		//INSERTION SORT
		//MERGESORT
		//QUICKSORT
		*/
		//COUNTING SORT
		System.arraycopy(arrOriginal, 0, arr, 0, arrOriginal.length);
		CountingSort cs = new CountingSort();
		cs.countingSort(arr);
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		
		/*
		//RADIXSORT
		System.arraycopy(arrOriginal, 0, arr, 0, arrOriginal.length);
		RadixSort rs = new RadixSort();
		rs.radixSort(arr);
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		*/
		
		
	}

}
