class NodeStructure extends DataStructure {
	Node head = null;
	Node tail = null;
	String delete(String d){
		return "";
	}
	String print() {
		if(head.data=="")
			return "빈 리스트입니다.";
		Node tmp = head;
		if (tmp != null) {
			String str = "";
			while (tmp.right != null) {
				str = str+" "+tmp.data;
				tmp = tmp.right;
			}
			return str+" "+tmp.data;
		} else
			return "";
	}
}