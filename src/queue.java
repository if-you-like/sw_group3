
public class queue extends ArrayStructure {
	static int head;
	static int tail;
	static int Max = 11;// gui�� 11���� �Ѱ����� 11���� ���� ���� 15��

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
			 * �ð�ȭ���� ����Ҷ� ���� �Ѱ��־�� �ϱ⋚���� ������ tail�� ������ �ű�� ��������������� ���ٰ� ǥ�ø� �Ͽ���
			 * �ϱ⶧���� data[tail]�� �ʱ�ȭ���ش�.
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
