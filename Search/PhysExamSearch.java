import java.util.Arrays;
import java.util.Comparator;

class PhyExamSearch{

	// 신체검사 데이터 정의
	static class PhyscData{
		private String name;
		private int height;
		private double vision;
	
	//생성자 
	public PhyscData(String name, int height, double vision){
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	// 문자열 반환하는 메서드 (정보 확인용)
	public String toString(){
		return name + " " + height + " " + vision;
 	}

 	// 오름 차순 정렬위한 comparator.  제넥릭
 	public static final Compoarator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

 	private static class HeightOrderComparator implements Comparator<PhyscData>{
 		public int compare(PhyscData d1, PhyscData d2){
 			return (d1.height > d2.height) ? 1 : 
 			(d1.height < d2.height) ? -1 : 0
  			}
 		}
	}	

	public static void main(String[] args){
		PhyscData[] db = {
			new PhyscData("장혁진", 179, 0.3),
			new PhyscData("이나영", 163, 0.5),
			new PhyscData("김도경", 180, 1.0),
			new PhyscData("최주영", 173, 1.2),
			new PhyscData("이나라", 165, 0.8),
		};

		int height = 173;
		int idx = Arrays.binarySearch(
			db,
			new PhyscData("", height, 0.0),
			PhyscData.HEIGHT_ORDER
		);

		if(idx<0)
			System.out.println("요소가 배열 내에 없습니다.");
		else
			System.out.println("db[" + idx + "]에 있습니다.");
			System.out.println("찾은 데이터 : " + db[idx]);
	}
}