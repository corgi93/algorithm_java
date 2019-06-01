import java.util.*;

/*
 enqueue - 큐에 data push
 dequeue - 큐에서 data pop
 front - 큐의 가장 앞에 있는 정수 출력
 back - 큐의 가장 뒤에 있는 정수 출력
 getSize - 현재 큐의 데이터들의 사이즈
 empty - 큐가 비어있나 확인
 */
public class QueueExam {

	// Queue클래스
	static class Queue {
		// front, rear가 포인터라 크기 저장이 필요.
		private int queueSize;
		private NODE front = null;
		private NODE rear = null;

		// class
		class NODE {
			int data;
			NODE next; // pointer
		}

		public void enqueue(int n) {
			NODE node = new NODE();
			node.data = n;

			// front가 null이면 비어있는 큐.
			if (front == null) {
				front = node;
				rear = node;
			} else {
				rear.next = node;
				rear = node;
			}
			queueSize++;
		}

		public void dequeue() {
			// queue가 비었으면
			if (front == null) {
				System.out.println("queue is empyty!");
			} else {
				System.out.println("dequeued data :" + front.data);
				// 포인터 이동.
				front = front.next;
				queueSize--;
			}
		}

		public void front() {
			// queue의 앞이 빈 경우
			if (front == null) {
				System.out.println("큐는 비어있습니다.");
			} else {
				System.out.println("front data : " + front.data);
			}
		}

		// queue의 뒤가 빈 경우
		public void back() {
			if (rear == null) {
				System.out.println("큐는 비었습니다.");
			} else {
				System.out.println("rear data : " + rear.data);
			}
		}

		// 큐의 사이즈.
		public void getSize() {
			System.out.println("Queue's size : " + queueSize);
		}

		public void empty() {
			if (front == null)
				System.out.println("빈 큐입니다.");
			else
				System.out.println("큐 안에 데이터가 있습니다.");
		}

	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Queue q = new Queue();

		while (true) {
			System.out.println("1.enquene 2.dequeue 3.front 4.back 5.size 6.empty");

			int menu = stdIn.nextInt();
			int x;

			if (menu == 1) {
				System.out.println("큐에 넣을 데이터 :");
				x = stdIn.nextInt();
				q.enqueue(x);
			} else if (menu == 2) {
				q.dequeue();
			} else if (menu == 3) {
				q.front();
			} else if (menu == 4) {
				q.back();
			} else if (menu == 5) {
				q.getSize();
			} else if (menu == 6) {
				q.empty();
			} else {
				stdIn.close();
				break;
			}
		}

	}
}
