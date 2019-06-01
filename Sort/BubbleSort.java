package algorithm;

class BubbleSort {
	// 두 수를 교환하는 swap함수.
	public void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	// 버블 정렬
	public int[] sorting(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		BubbleSort bubble = new BubbleSort();
		int[] arr = { 23, 11, 14, 5, 33 };
		int[] sortedArr = bubble.sorting(arr);

		// System.out.println(sortedArr);
		for (int i = 0; i < sortedArr.length; i++) {
			System.out.println("sortedArr[" + i + "]" + "=" + sortedArr[i]);
		}
	}
}