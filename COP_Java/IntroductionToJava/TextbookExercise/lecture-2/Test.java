public class Test {
    public static void main(String[] args) {
		int arrOriginal[] = new int[10];

		for (int i = 0; i < arrOriginal.length; i++) {
			int rnd = (int) (Math.random() * 100);
			arrOriginal[i] = rnd;
			System.out.print(arrOriginal[i] + " ");	
		}

		System.out.println();

		int arr[] = new int[arrOriginal.length];
		System.arraycopy(arrOriginal, 0, arr, 0, arrOriginal.length);	
		InsertionSort is = new InsertionSort();
		is.insertionSort(arr);
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i] + " ");
		System.out.println();
		System.out.println("-------------------------------");
		
		for (int i = 0; i < arrOriginal.length; i++) 
			System.out.print(arrOriginal[i] + " ");
		System.out.println();
		
		System.arraycopy(arrOriginal, 0, arr, 0, arrOriginal.length);
		MergeSort mg = new MergeSort();
		mg.sort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i] + " ");

	}
}
