
class ArrayStructure extends DataStructure {
	static final int Max = 15;
	String data[] = new String[Max];
	boolean isEmpty(){
		return true;
	}
	boolean isFull(){
		return true;
	}
	String print() {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < Max; i++) {
			if (data[i] != null)
				str.append(data[i] + " ");
			else	//null�� ��� ���̻� �ڸ� �˻��� �ʿ䰡 ����.
				break;
		}
		return str.toString();
	}
}