package algorithm;

public class Generic {
	/*
	제네릭 규칙
	1. 1개의 대문자 사용
	2. 컬렉션의 자료형은 element의 앞글자 E를 사용
	3. 맵(Map)의 key, value는 앞자리를 따와 K, V로 사용
	4. 일반적으로 T 사용. 
	  
	 */
	
	// T는 Type을 의미.
	static class GenericClass<T>{
		private T xyz;
		
		//생성자
		GenericClass(T type){
			this.xyz = type;
		}
		
		T getXyz() {
			return xyz;
		}
	}
	public static void main(String[] args) {
		// 다음가 같이 파라미터에 String을 넘길 수도 있고 Integer를 넘길 수도 있다. type에 제약을 벗어남.
		GenericClass<String> s = new GenericClass<String>("abc");
		GenericClass<Integer> n = new GenericClass<Integer>(1234);
		
		System.out.println(s.getXyz());
		System.out.println(n.getXyz());
	}
}
