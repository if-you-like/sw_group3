package sw_group3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVL_Tree tree = new AVL_Tree();
		String str = "";
		int n = 1;
		Scanner sc = new Scanner(System.in);
		while (n != 0) {
			n = sc.nextInt();
			switch (n) {
			case 1:
				str = sc.next();
				tree.insert(str);
				break;
			case 2:
				tree.inorder(tree.root);
				break;
			case 3:
				System.out.println(tree.TreeDepth(tree.root));
				break;
			case 4:
				str = sc.next();
				System.out.println(tree.delete(str));
				break;
			case 5:
				tree.TreeInput();
				tree.ShowTreeData();
				break;
			case 6:
				str=sc.next();
				System.out.println(tree.treeSearch(str).getAux());
				break;
			default:
				System.out.println("Somthing Wrong!");
			}
		}
	}

}
