package sw_group3;

class Node{
	String data="";
	Node parent=null;
	Node right=null;
	Node left=null;
	Node(){
	}
	Node(String d){
		data=d;
	}
	void Right(Node r){
		right=r;
	}
	void Left(Node l){
		left=l;
	}
}