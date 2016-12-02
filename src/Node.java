
class Node {
	String data = "";
	int N;
	int aux; 
	Node parent = null;
	Node right = null;
	Node left = null;

	Node() {
		this.N = 1;
		this.aux = 1;
	}

	Node(String d) {
		data = d;
	}

	void Right(Node r) {
		right = r;
	}


	void Left(Node l) {
		left = l;
	}
	

	public int getAux() {
		return aux;
	}


	public void setAux(int value) {
		aux = value;
	}
}