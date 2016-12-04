
public class AVLTree extends Binary_Search_Tree {
	AVLTree() {
		super();
	}

	void insert(String d) {
		Node temp = null;

		if (root.data == "") {
			root.data = d;
			temp = root;
		} else {
			Node bp = null;
			Node p = root;
			while (p != null) {
				bp = p;
				if (p.data.compareTo(d) < 0)
					p = p.right;
				else if (p.data.equals(d)) {
					System.out.println("Same Date Exists.");
					return;
				} else {
					p = p.left;
				}
			}

			if (bp.data.compareTo(d) < 0) {
				bp.right = new Node(d);
				temp = bp.right;
				bp.right.parent = bp;
			} else {
				bp.left = new Node(d);
				temp = bp.left;
				bp.left.parent = bp;
			}
			// AVL추�?
			for (Node x = temp; x != null; x = x.parent) {
				x.aux = 1 + Math.max(height(x.left), height(x.right));
			}
			rebalance(temp);
		}

	}

	protected void rotate(Node x) { // LL�? RR?�� ?��?��?�� ?��?���?. c ?�� x ?�� y�? 문제!
		Node y = x.parent;
		Node z = y.parent;
		if (z == null) {
			root = x;
			x.parent = null;
		} else
			relink(z, x, y == z.left); // x�? z?�� ?��?��?���?. �?, x�? c?? y?�� �?�?
		if (x == y.left) {
			relink(y, x.right, true);
			relink(x, y, false);
		} // LL
		else {
			relink(y, x.left, false);
			relink(x, y, true);
		} // RR
	}

	protected Node restructure(Node x) { // x ?�� y ?�� z�? 문제
		Node y = x.parent;
		Node z = y.parent;
		if ((x == y.left) == (y == z.left)) {
			rotate(y);
			return y;
		} // LL or RR : y�? 중간�?
		else {
			rotate(x);
			rotate(x);
			return x;
		} // 중간값이 x: LR/RL ?�� LL/RR�? ?��?�� �?�?
	}

	private int height(Node x) {
		return (x == null) ? 0 : x.getAux();
	}

	private void setHeight(Node x, int height) {
		x.setAux(height);
	}

	private void recomputeHeight(Node x) // ?��?��?�� ?��?�� ?��계산
	{
		setHeight(x, (1 + Math.max(height(x.left), height(x.right))));
	}

	private boolean isBalanced(Node x) // ?��?��?�� balanced ?���? �??��
	{
		return (Math.abs(height(x.left) - height(x.right)) <= 1);
	}

	private Node tallerChild(Node x) { // 깊이�? 깊�? ?��?�� ?��?�� 조사
		if (height(x.left) > height(x.right))
			return x.left;
		if (height(x.left) < height(x.right))
			return x.right;
		if (x == root)
			return x.left; // 같�? 경우?��?�� ?���? ?��?��
		if (x == x.parent.left)
			return x.left; // LL?��?��
		else
			return x.right; // RR?�� ?��?��
	}

	private void rebalance(Node x) {
		do {
			if (!isBalanced(x)) { // x�? balanced node�? ?��?�� 경우, ?��구성
				x = restructure(tallerChild(tallerChild(x)));
				recomputeHeight(x.left); // ?��구성 ?��, ?��?���? ?��?�� 조정
				recomputeHeight(x.right);
				for (Node p = x; p != null; p = p.parent)
					recomputeHeight(p);
			}
			// put()?�� 경우?��?�� ?��구성 ?��, �?�? ?��?���? 조사?�� ?��?���? ?��?��?��,
			// delete?�� 경우?��?�� �?�? ?��?��?��?�� balanced ?���?�? 조사?��?��?�� ?��.
			x = x.parent;
		} while (x != null);
	}

	String delete(String key) {
		if (root.data == "")
			return "Tree is Empty";
		Node x, y, p;
		x = treeSearch(key);
		// key�? ?��?�� 경우.
		if (x==null || !key.equals(x.data))
			return "Search Error";
		// 루트?��거나 ?��?��?�� ?�� 개인 ?��?��
		if (x == root || isTwoNode(x)) {
			if (isLeaf(x)) // 루트�? 리프
			{
				root.data = "";
				return "Tree set Empty";
			} else if (!isTwoNode(x)) { // 루트
				root = (x.right == null) ? x.left : x.right; // ?��?��?�� 루트�?
				root.parent = null;
				// AVL추�?
				root.setAux(1);
			} else { // ?��?��?�� ?��?�� ?��?��(루트 ?��?��)
				y = min(x.right); // inorder successor
				x.data = y.data; // y�? x?�� 복사
				p = y.parent;
				// y?�� ?��?��?�� p?�� ?��?��?���?(y ?��?��)
				relink(p, y.right, y == p.left);
				// y?�� 조상 ?��?��?��?�� size�? 감소
				// AVL추�?
				
				
				for (Node temp = x; temp != null; temp = temp.parent) {
					temp.aux = 1 + Math.max(height(temp.left), height(temp.right));
				}rebalance(x);
			}
		} else { // ?��?��?�� ?��?��?���?, 루트 ?��?��
			p = x.parent;
			if (x.right == null)
				relink(p, x.left, x == p.left);
			else if (x.left == null)
				relink(p, x.right, x == p.left);
			// AVL추�?
			
			for (Node temp = p; temp != null; temp = temp.parent) {
				temp.aux = 1 + Math.max(height(temp.left), height(temp.right));
			}rebalance(p);
		}
		return key + " Delete Success";
	}

}