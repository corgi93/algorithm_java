import java.util.LinkedList;

class HashTable {
	// Node class
	class Node {
		String key;
		String value;

		Node(String key, String value) {
			this.key = key;
			this.value = value;
		}

		String value() {
			return value;
		}

		void value(String value) {
			this.value = value;
		}
	}

	LinkedList<Node>[] data;

	// HashTable initialization
	HashTable(int size) {
		// 크기를 미리 정해 array방을 정의해놓는다.
		this.data = new LinkedList[size];
	}

	int getHashCode(String key) {
		int hashCode = 0;
		for (char c : key.toCharArray()) {
			// 각 letter의 ASCII값을 가져와 hashCode에 더해준다.
			hashCode += c;
		}
		return hashCode;
	}

	int convertToIndex(int hashCode) {
		return hashCode % data.length;
	}

	Node searchKey(LinkedList<Node> list, String key) {
		if (list == null)
			return null;
		for (Node node : list) {
			if (node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}

	// array에 넣어보자.
	void put(String key, String value) {
		int hashcode = getHashCode(key);
		int idx = convertToIndex(hashcode);
		System.out.println("key: " + key + " ,hashcode: " + hashcode + " ,index: " + idx);
		
		// 배열방 번호로 기존 배열방 정보를 가져옴
		LinkedList<Node> list = data[idx];
		if (list == null) {
			list = new LinkedList<Node>();
			data[idx] = list;
		}
		Node node = searchKey(list, key);
		if (node == null) {
			list.addLast(new Node(key, value));
		} else {
			node.value(value);
		}
	}

	// key를 가지고 data를 가져오는 메서드
	String get(String key) {
		int hashCode = getHashCode(key);
		int idx = convertToIndex(hashCode);

		// index에서 linked-list 가져오기
		LinkedList<Node> list = data[idx];
		// linked-list에서 해당 key를 가지는 node를 가져온다.
		Node node = searchKey(list, key);
		return node == null ? "Not found" : node.value;
	}

	public static void main(String[] args) {
		HashTable h = new HashTable(3);
		h.put("sung", "she is pretty");
		h.put("jin", "she is a model");
		h.put("hee", "she is an angel");
		h.put("min", "she is so cute");
		// h.put("min", "she is so beautiful"); 똑같은 key값을 넣으면 뒤에 넣은 걸로 update
		System.out.println(h.get("min"));
		System.out.println(h.get("jin"));
		System.out.println(h.get("sung"));

	}

}