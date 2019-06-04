/*
 '분할 정복법'이라고도 부름.
 pivot : 두 그룹으로 쪼개는 기준.
 pivot으로 두 그룹으로 계속 쪼개고 1개씩 남았을 때 병합.
 
 */
public class QuickSort {
	public void swap(int[] arr, int idx1, int idx2) {
		int temp;
		temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	public int[] quickSort(int[] arr, int left, int right) {
		// 맨 왼쪽에서 출발한 왼쪽 커서
		int pl = left;
		// 맨 오른쪽에서 출발한 오른쪽 커서
		int pr = right;
		int pivot = arr[(pl + pr) / 2];

		// arr을 분할
		while (pl <= pr) {
			while (arr[pl] < pivot) {
				// 왼쪽에서 오른쪽으로 이동. pivot 앞 까지
				pl++;
			}
			while (arr[pr] > pivot) {
				// 오른쪽에서 왼쪽으로 이동. pivot 뒤 까지
				pr--;
			}

			// 돌던 시작점과 끝점이 서로 만나거나 지나치지 않았으면 swap
			if (pl <= pr) {
				swap(arr, pl, pr);
				// swap후 한 칸씩 이동을 다시 시작.
				pl++;
				pr--;
			}
		}

		// 분할된 array들을 sort.
		if (left < pl) {
			quickSort(arr, left, pr);
		}
		if (pr < right) {
			quickSort(arr, pl, right);
		}
		return arr;
	}

	public static void main(String[] args) {
		QuickSort quick = new QuickSort();

		int[] arr = { 23, 1, 63, 7, 45, 234, 12, 32, 11, 15 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "]" + "=" + arr[i]);
		}
		System.out.println("----정렬 후----");

		// 0번째 부터 n-1까지(주의: 인덱스값이므로 마지막 인덱스는 배열 길이에서 -1)
		int[] sortedArr = quick.quickSort(arr, 0, arr.length - 1);

		for (int i = 0; i < sortedArr.length; i++) {
			System.out.println("quick[" + i + "]" + "=" + sortedArr[i]);
		}
	}

}
