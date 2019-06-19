import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 Graph 검색
 1.dfs (depth-first-search) : 깊이 우선 탐색
 2.bfs (breadth-first-search) : 너비 우선 탐색

 
 */

// 사실 그래프는 tree구조처럼 부모-자식 관계는 없고 인접한 Node를 Linked-list로 연결
class Graph {
	class Node {
		int data;
		// 인접노드
		LinkedList<Node> adjacent;
		boolean marked;

		Node(int data) {
			this.data = data;
			// 마킹을 false로 초기화 후 연결리스트를 준비시킴.
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}

	Node[] nodes;

	Graph(int size) {
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}

	// 두 Node의 관계를 저장하는 함수
	void addEdge(int idx1, int idx2) {
		Node n1 = nodes[idx1];
		Node n2 = nodes[idx2];

		// 두 개의 Node에 인접한 노드를 저장하는 linked-list에 상대방이 없으면 추가
		if (!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}

	// dfs를 호출하면 0번부터 시작하게 하겠음.
	void dfs() {
		dfs(0);
	}

	void dfs(int idx) {
		Node root = nodes[idx];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		// stack에 push하면 true로 마크
		root.marked = true;
		while (!stack.isEmpty()) {
			// stack에서 데이터를 하나 가져와
			Node r = stack.pop();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}

	// bfs
	void bfs() {
		bfs(0);
	}

	void bfs(int idx) {
		Node root = nodes[idx];
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root); // offer(node) : enqueue
		root.marked = true;
		while (!q.isEmpty()) {
			Node r = q.poll(); // poll() : dequeue. 큐에서 data를 한 개 가져온다
			// q에서 꺼낸 자식들을 q에 추가. 한 번도 추가되지 않은 경우만!
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					q.offer(n);
				}
			}
			// q에서 빠진 데이터는 출력.
			visit(r);
		}
	}

	// 방문했을 때 출력.
	void visit(Node n) {
		System.out.print(n.data + " ");
	}

}

class Execute {
	public static void main(String[] args) {
		Graph g = new Graph(10);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		g.dfs();
	}
}
