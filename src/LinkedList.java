
public class LinkedList extends NodeStructure {

	static int Cnt;
	static String[] str;

	public LinkedList() {
		head = new Node();
		tail = head;

		str = new String[20];
		Cnt = 0;

		str = new String[20];
		Cnt = 0;

	}

	void display() {
		Node temp = head;
		for (int i = 0; i < Cnt; i++) {
			str[i] = temp.data;
			temp = temp.right;
		}
		System.out.println();
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
		if (head.data.equals("")) {
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
		 * 몇 번째에 넣을지는 gui를 통해 조작할수있도록 하자. k값을 현재 노드갯수보다 큰수로 넣으면 예외처리뜸.
		 */
		int c = 0;
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
		if (head.data.equals(null) || head.data.equals("")) {
			return "0";// "지울 데이터를 찾을 수 없습니다.";
		}
		Node before_pointer = null;
		Node pointer = head;
		Node delete_node = null;
		Node find_node = null;

		while (pointer.right != null) {
			if (pointer.data.equals(d))
				break;
			else {
				before_pointer = pointer;
				pointer = pointer.right;
			}
		}
		delete_node = new Node(pointer.data);
		find_node = pointer;

		if (!pointer.data.equals(d) || pointer.data == "") {
			return "0";// "지울 데이터를 찾을 수 없습니다.";
		}

		if (before_pointer == null) {// 헤드일결우
			if (pointer.right == null) {
				head.data = "";
				head.right = null;
			} else {
				head = pointer.right;
			}
		} else {
			if (tail.data.equals(delete_node.data)) {
				if (find_node != tail) {
					before_pointer.right = pointer.right;
				} else {
					tail = before_pointer;
					tail.right = null;
				}
			} else {
				before_pointer.right = pointer.right;
			}
		}
		Cnt--;
		return "1";// delete_node.data + "를 삭제하엿습니다.";
	}
}