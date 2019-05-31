// Arrays.sort() 사용을 위해.
import java.util.*;

class Searching{

	static void sequential(int[] arr, int key){
		int foundValue = 0; 
		int idx = 0;
      	boolean isfound = false;
		
		for(int i=0; i< arr.length; i++){
			if(arr[i] == key){
				foundValue = arr[i];
				idx = i;
				isfound = true;
                
                System.out.println(foundValue + "값은 " + idx + "번째 인덱스에 있습니다.");
				break;
            }
		}
      	if(isfound == false){
        	System.out.println("해당 값은 찾을 수 없습니다.");
      	}
	}
  
  public void binary(int[] arr, int key){
  	int left = 0;
    int right = arr.length-1;
    boolean isfound = false;
    
    while(left <= right){
      int mid = (left + right)/2;
      
      if(arr[mid] == key){
        isfound = true;
      	System.out.println(key +"값은" + mid +"번째 인덱스에 있습니다.");
        break;
      }
      else if(arr[mid]< key){
      	left = mid+1;
      }
      else{
        right = mid-1;
      }
    }
    if(isfound == false){
        System.out.println("해당 값은 찾을 수 없습니다.");
    }
  }
}


public class Search{
	public static void main(String[] args){
		int arr[] = {10,3,2,44,56,77,21,32,67};
		
		// sequential search(선형 검색)
		Searching s = new Searching();
		s.sequential(arr, 32);
		
		// binary search(이진탐색) - 정렬된 상태에서 탐색해야함
		// 오름차순 정렬 - [2,3,10,21,32,44,56,67,77]
		Arrays.sort(arr);
		s.binary(arr, 21);
		
	}
}

