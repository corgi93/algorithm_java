package algorithm;

import java.util.Scanner;

public class Stack {
	private int max; // stack의 용량
	private int top; // stack의 포인터
	private int[] stack; // stack 본체

	// 실행 시 예외 : 스택이 비어있음
	public class EmptyStackException extends RuntimeException {
		public EmptyStackException() {

		}
	}

	// 실행 시 예외 : 스택이 가득참
	public class OverflowStackException extends RuntimeException {
		public OverflowStackException() {

		}
	}

	// 생성자
	public Stack(int capacity) {
		// stack이 비어있으면 포인터는 0, 가득 차 있으면 max값과 같다.
		top = 0;
		max = capacity;
		try {
			stack = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// stack에 push(넣을 값x)
	public int push(int x) throws OverflowStackException {
		if (top >= max) { // stack이 가득 참.
			throw new OverflowStackException();
		}
		// push할 데이터를 배열 stack[porinter]. top에 추가하고 포인터 값을 +1
		return stack[top++] = x;
	}

	// stack에서 데이터를 pop() - 정상(top)의 data를 꺼냄
	public int pop() throws EmptyStackException {
		if (top <= 0) {
			throw new EmptyStackException();
		}
		return stack[--top];
	}

	// stack에서 data를 peek() (top의 있는 데이터를 들여다봄)
	public int peek() {
		if (top <= 0) {
			throw new EmptyStackException();
		}
		return stack[top - 1];
	}

	// stack의 수용량을 반환. max 반환.
	public int capacity() {
		return max;
	}

	// stack 초기화 - top만 0을 주면 된다.
	public void clear() {
		top = 0;
	}

	// 현재 stack에 쌓여 있는 데이터 수(top의 수)를 반환.
	public int size() {
		return top;
	}

	public boolean isFull() {
		return top >= max;
	}

	public boolean isEmpty() {
		return top <= 0;
	}

	// stack안의 모든 데이터를 바닥->top 순서로 출력
	public void dump() {
		if (top <= 0) {
			System.out.println("stack is empty..");
		} else {
			for (int i = 0; i < top; i++) {
				System.out.println(stack[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Stack stack = new Stack(64);

		while (true) {
			System.out.println("현재 스택의 데이터 수 : " + stack.size() + "/" + stack.capacity());
			System.out.println("1.push(top에 쌓기) 2.pop(top을 빼기) 3.peek(top정보 보기) 4.dump(바닥서부터 모두 출력) 5.종료:");

			int menu = stdIn.nextInt();

			if (menu == 0) {
				break;
			}

			int x;
			if (menu == 1) {
				System.out.println("데이터 :");
				x = stdIn.nextInt();
				try {
					stack.push(x);
				} catch (Stack.OverflowStackException e) {
					System.out.println("stack is full!");
				}
			}

			if (menu == 2) {
				try {
					x = stack.pop();
					System.out.println("pop data : " + x);
				} catch (Stack.EmptyStackException e) {
					System.out.println("stack is empty!");
				}
			}

			if (menu == 3) {
				try {
					x = stack.peek();
					System.out.println("현재 top의 data : " + x);
				} catch (Stack.EmptyStackException e) {
					System.out.println("stack is empty!");
				}
			}

			if (menu == 4) {
				stack.dump();

			}
			if (menu == 5) {
				stdIn.close();
				break;
			}

		}

	}
}
