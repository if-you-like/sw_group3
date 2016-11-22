
public class queue extends ArrayStructure {
	static int head;
	static int tail;
	static int Max = 11;// gui로 11개가 한개래서 11개로 설정 원래 15개

	queue() {
		head = 0;
		tail = 0;
	}

	void insert(String d) { // PUSH
		if (!isFull()) {
			data[head] = d;
			head = (head + 1) % Max;
		} else {
			System.out.println("Queue is Full");
		}
	}

	String delete() { // POP
		if (!isEmpty()) {
			/*
			 * 시각화에서 출력할때 값을 넘겨주어야 하기떄문에 원래는 tail의 위지만 옮기고 덮어쓰기형식이지만 없다고 표시를 하여야
			 * 하기때문에 data[tail]을 초기화해준다.
			 */
			String tmp = data[tail];
			data[tail] = "";
			tail = (tail + 1) % Max;
			return tmp;
		} else {
			return "Queue is Empty.";
		}
	}

	boolean isEmpty() {
		return tail == head ? true : false;
	}

	boolean isFull() {
		return ((head + 1) % Max) == tail ? true : false;
	}

	int infoHead() {
		return head;
	}

	int infoTail() {
		return tail;
	}
}
