
public class stack extends ArrayStructure {
	String node[]=new String[20];
	int level;
	
	public void push(String num, int level) {
		node[level] = num;
		this.level=level;
	}
	public void pop(int level) {
		this.level=level;
		node[level] = null;
	}
}
