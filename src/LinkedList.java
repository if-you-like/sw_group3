
public class LinkedList extends NodeStructure {

	static int Cnt = 0;
	static String[] str = new String[20];

	public LinkedList() {
		head = new Node();
		tail = head;
	}

	void display() {
		Node temp = head;
		for (int i = 0; i < Cnt; i++) {
			str[i] = temp.data;
			temp = temp.right;
		}
	}

	int Count_Node() {
		return Cnt;
	}

	String info_Head() {
		return head.data;
	}

	String info_Tail() {
		return tail.data;
	}

	void insert(String d) {
		if (head.data == "") {
			head.data = d;
		} else {
			Node tmp = new Node(d);
			tail.right = tmp;
			tail = tmp;
		}
		Cnt++;
	}

	void insert(String d, int k) {
		/*
		 * �� ��°�� �������� gui�� ���� �����Ҽ��ֵ��� ����. k���� ���� ��尹������ ū���� ������ ����ó����.
		 */
		int c = 1;
		Node before_pointer = null;
		Node pointer = head;
		Node tmp = new Node(d);
		while (c < k) {
			before_pointer = pointer;
			pointer = pointer.right;
			c++;
		}
		if (before_pointer == null) {
			tmp.right = head;
			head = tmp;
		} else {
			tmp.right = pointer;
			before_pointer.right = tmp;
		}
		if (tmp.right == null)
			tail = tmp;
		Cnt++;
	}

	String delete(String d) {
		if (head.data == null || head.data == "") {
			return "0";// "���� �����͸� ã�� �� �����ϴ�.";
		}
		Node before_pointer = null;
		Node pointer = head;
		Node delete_node = null;

		while (pointer.right != null) {
			if (pointer.data.equals(d))
				break;
			else {
				before_pointer = pointer;
				pointer = pointer.right;
			}
		}
		delete_node = new Node(pointer.data);

		if (!pointer.data.equals(d) || pointer.data == "") {
			return "0";// "���� �����͸� ã�� �� �����ϴ�.";
		}

		if (before_pointer == null) {
			if (pointer.right == null) {
				head.data = "";
				head.right = null;
			} else {
				head = pointer.right;
			}
		} else {
			if (tail.data.equals(delete_node.data)) {
				tail = before_pointer;
				tail.right = null;
			} else {
				before_pointer.right = pointer.right;
			}
		}
		Cnt--;
		return "1";// delete_node.data + "�� �����Ͽ����ϴ�.";
	}
}