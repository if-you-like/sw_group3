
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
			// AVLμΆκ?
			for (Node x = temp; x != null; x = x.parent) {
				x.aux = 1 + Math.max(height(x.left), height(x.right));
			}
			rebalance(temp);
		}

	}

	protected void rotate(Node x) { // LLκ³? RR? ??? ?¨?λ‘?. c ?  x ?  yκ°? λ¬Έμ !
		Node y = x.parent;
		Node z = y.parent;
		if (z == null) {
			root = x;
			x.parent = null;
		} else
			relink(z, x, y == z.left); // xλ₯? z? ???Όλ‘?. μ¦?, xκ°? c?? y? λΆ?λͺ?
		if (x == y.left) {
			relink(y, x.right, true);
			relink(x, y, false);
		} // LL
		else {
			relink(y, x.left, false);
			relink(x, y, true);
		} // RR
	}

	protected Node restructure(Node x) { // x ?  y ?  zκ°? λ¬Έμ 
		Node y = x.parent;
		Node z = y.parent;
		if ((x == y.left) == (y == z.left)) {
			rotate(y);
			return y;
		} // LL or RR : yκ°? μ€κ°κ°?
		else {
			rotate(x);
			rotate(x);
			return x;
		} // μ€κ°κ°μ΄ x: LR/RL ?  LL/RRλ‘? ?Ό?¨ λ³?κ²?
	}

	private int height(Node x) {
		return (x == null) ? 0 : x.getAux();
	}

	private void setHeight(Node x, int height) {
		x.setAux(height);
	}

	private void recomputeHeight(Node x) // ?Έ?? ??΄ ?¬κ³μ°
	{
		setHeight(x, (1 + Math.max(height(x.left), height(x.right))));
	}

	private boolean isBalanced(Node x) // ?Έ?? balanced ?¬λΆ? κ²??¬
	{
		return (Math.abs(height(x.left) - height(x.right)) <= 1);
	}

	private Node tallerChild(Node x) { // κΉμ΄κ°? κΉμ? ?? ?Έ? μ‘°μ¬
		if (height(x.left) > height(x.right))
			return x.left;
		if (height(x.left) < height(x.right))
			return x.right;
		if (x == root)
			return x.left; // κ°μ? κ²½μ°?? ?Όμͺ? ??
		if (x == x.parent.left)
			return x.left; // LL?΄?
		else
			return x.right; // RR? ? ?Έ
	}

	private void rebalance(Node x) {
		do {
			if (!isBalanced(x)) { // xκ°? balanced nodeκ°? ?? κ²½μ°, ?¬κ΅¬μ±
				x = restructure(tallerChild(tallerChild(x)));
				recomputeHeight(x.left); // ?¬κ΅¬μ± ?, ??΄λ₯? ?€? μ‘°μ 
				recomputeHeight(x.right);
				for (Node p = x; p != null; p = p.parent)
					recomputeHeight(p);
			}
			// put()? κ²½μ°?? ?¬κ΅¬μ± ?, λΆ?λͺ? ?Έ?λ₯? μ‘°μ¬?  ??κ°? ??Ό?,
			// delete? κ²½μ°?? λΆ?λͺ? ?Έ??€? balanced ?¬λΆ?λ₯? μ‘°μ¬??¬?Ό ?¨.
			x = x.parent;
		} while (x != null);
	}

	String delete(String key) {
		if (root.data == "")
			return "Tree is Empty";
		Node x, y, p;
		x = treeSearch(key);
		// keyκ°? ?? κ²½μ°.
		if (x==null || !key.equals(x.data))
			return "Search Error";
		// λ£¨νΈ?΄κ±°λ ???΄ ? κ°μΈ ?Έ?
		if (x == root || isTwoNode(x)) {
			if (isLeaf(x)) // λ£¨νΈκ°? λ¦¬ν
			{
				root.data = "";
				return "Tree set Empty";
			} else if (!isTwoNode(x)) { // λ£¨νΈ
				root = (x.right == null) ? x.left : x.right; // ??? λ£¨νΈλ‘?
				root.parent = null;
				// AVLμΆκ?
				root.setAux(1);
			} else { // ???΄ ??Έ ?Έ?(λ£¨νΈ ?¬?¨)
				y = min(x.right); // inorder successor
				x.data = y.data; // yλ₯? x? λ³΅μ¬
				p = y.parent;
				// y? ??? p? ???Όλ‘?(y ?­? )
				relink(p, y.right, y == p.left);
				// y? μ‘°μ ?Έ??€? sizeλ₯? κ°μ
				// AVLμΆκ?
				
				
				for (Node temp = x; temp != null; temp = temp.parent) {
					temp.aux = 1 + Math.max(height(temp.left), height(temp.right));
				}rebalance(x);
			}
		} else { // ???΄ ???΄λ©?, λ£¨νΈ ??
			p = x.parent;
			if (x.right == null)
				relink(p, x.left, x == p.left);
			else if (x.left == null)
				relink(p, x.right, x == p.left);
			// AVLμΆκ?
			
			for (Node temp = p; temp != null; temp = temp.parent) {
				temp.aux = 1 + Math.max(height(temp.left), height(temp.right));
			}rebalance(p);
		}
		return key + " Delete Success";
	}

}