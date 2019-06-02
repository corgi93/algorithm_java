class InsertionSort {

	public int[] sort(int[] arr) {
		int temp;
		for (int i = 1; i < arr.length; i++) {
			temp = arr[i];
			int k;
			// 삽입할 값 i의 바로 왼쪽요소부터 왼쪽으로 탐색.
			for (k = i - 1; k >= 0; k--) {
				// 삽입할 값이 요소보다 크면 shift 중단.
				if (temp >= arr[k]) {
					break;
				}
				// 오른쪽으로 shift
				arr[k + 1] = arr[k];
			}
			// 삽입!
			arr[k + 1] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		InsertionSort insertion = new InsertionSort();
		int[] arr = { 23, 11, 14, 5, 33, 1, 4 };
		int[] sortedArr = insertion.sort(arr);

		// System.out.println(sortedArr);
		for (int i = 0; i < sortedArr.length; i++) {
			System.out.println("insertionArr[" + i + "]" + "=" + sortedArr[i]);
		}

	}
}
