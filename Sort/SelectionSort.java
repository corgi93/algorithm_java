// 선택정렬 O(n^2)
class SelectionSort {
	public void swap(int[] arr, int idx1, int idx2) {
		int temp;
		temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;

	}

	public int[] sort(int[] arr) {
		// 맨 마지막에는 선택한 가장 큰 값을 넣으므로 arr.length-1까지만
		for (int i = 0; i < arr.length - 1; i++) {
			// 맨 왼쪽에서 부터 순서대로 i값 비교.
			int min = i;
			
			// i번째 인덱스에  값보다 작은 값이 있으면 인덱스 값을 교환 후 swap
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[k] < arr[min]) {
					min = k;
				}
			}
			swap(arr, i, min);
		}

		return arr;
	}

	public static void main(String[] args) {
		SelectionSort selection = new SelectionSort();
		int[] arr = { 23, 11, 14, 5, 27, 1, 55 };
		int[] sorted = selection.sort(arr);

		for (int i = 0; i < sorted.length; i++) {
			System.out.println("sorted[" + i + "]" + "=" + sorted[i]);
		}

		/*
		output : 

		sorted[0]=1
		sorted[1]=5
		sorted[2]=11
		sorted[3]=14
		sorted[4]=23
		sorted[5]=27
		sorted[6]=55
		*/
	}

}
