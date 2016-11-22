
public class stack extends ArrayStructure {
	String node[];
	int level;

	public stack(int num){
		node=new String[num];
	}

	public void push(String num, int level) {
		node[level] = num;
		this.level = level;
	}

	public void pop(int level) {
		this.level = level;
		node[level] = null;
	}
}
