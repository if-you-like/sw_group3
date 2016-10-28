package sw_group3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Binary_Search_Tree tree= new Binary_Search_Tree();
		String str=" ";
		while(true){
			str=sc.nextLine();
			if(str.equals("Done"))
				break;
			tree.insert(str);
		}
		tree.TreeInput(tree.root, 7, 4);
		tree.ShowTreeData();
	}

}
