
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
			// AVLì¶”ê?
			for (Node x = temp; x != null; x = x.parent) {
				x.aux = 1 + Math.max(height(x.left), height(x.right));
			}
			rebalance(temp);
		}

	}

	protected void rotate(Node x) { // LLê³? RR?„ ?•˜?‚˜?˜ ?•¨?ˆ˜ë¡?. c ?ƒ  x ?ƒ  yê°? ë¬¸ì œ!
		Node y = x.parent;
		Node z = y.parent;
		if (z == null) {
			root = x;
			x.parent = null;
		} else
			relink(z, x, y == z.left); // xë¥? z?˜ ?ž?‹?œ¼ë¡?. ì¦?, xê°? c?? y?˜ ë¶?ëª?
		if (x == y.left) {
			relink(y, x.right, true);
			relink(x, y, false);
		} // LL
		else {
			relink(y, x.left, false);
			relink(x, y, true);
		} // RR
	}

	protected Node restructure(Node x) { // x ?ƒ  y ?ƒ  zê°? ë¬¸ì œ
		Node y = x.parent;
		Node z = y.parent;
		if ((x == y.left) == (y == z.left)) {
			rotate(y);
			return y;
		} // LL or RR : yê°? ì¤‘ê°„ê°?
		else {
			rotate(x);
			rotate(x);
			return x;
		} // ì¤‘ê°„ê°’ì´ x: LR/RL ?ƒ  LL/RRë¡? ?¼?‹¨ ë³?ê²?
	}

	private int height(Node x) {
		return (x == null) ? 0 : x.getAux();
	}

	private void setHeight(Node x, int height) {
		x.setAux(height);
	}

	private void recomputeHeight(Node x) // ?…¸?“œ?˜ ?†’?´ ?ž¬ê³„ì‚°
	{
		setHeight(x, (1 + Math.max(height(x.left), height(x.right))));
	}

	private boolean isBalanced(Node x) // ?…¸?“œ?˜ balanced ?—¬ë¶? ê²??‚¬
	{
		return (Math.abs(height(x.left) - height(x.right)) <= 1);
	}

	private Node tallerChild(Node x) { // ê¹Šì´ê°? ê¹Šì? ?ž?‹ ?…¸?“œ ì¡°ì‚¬
		if (height(x.left) > height(x.right))
			return x.left;
		if (height(x.left) < height(x.right))
			return x.right;
		if (x == root)
			return x.left; // ê°™ì? ê²½ìš°?—?Š” ?™¼ìª? ?ž?‹
		if (x == x.parent.left)
			return x.left; // LL?´?‚˜
		else
			return x.right; // RR?„ ?„ ?˜¸
	}

	private void rebalance(Node x) {
		do {
			if (!isBalanced(x)) { // xê°? balanced nodeê°? ?•„?‹ ê²½ìš°, ?ž¬êµ¬ì„±
				x = restructure(tallerChild(tallerChild(x)));
				recomputeHeight(x.left); // ?ž¬êµ¬ì„± ?›„, ?†’?´ë¥? ?‹¤?‹œ ì¡°ì •
				recomputeHeight(x.right);
				for (Node p = x; p != null; p = p.parent)
					recomputeHeight(p);
			}
			// put()?˜ ê²½ìš°?—?Š” ?ž¬êµ¬ì„± ?›„, ë¶?ëª? ?…¸?“œë¥? ì¡°ì‚¬?•  ?•„?š”ê°? ?—†?œ¼?‚˜,
			// delete?˜ ê²½ìš°?—?Š” ë¶?ëª? ?…¸?“œ?“¤?˜ balanced ?—¬ë¶?ë¥? ì¡°ì‚¬?•˜?—¬?•¼ ?•¨.
			x = x.parent;
		} while (x != null);
	}

	String delete(String key) {
		if (root.data == "")
			return "Tree is Empty";
		Node x, y, p;
		x = treeSearch(key);
		// keyê°? ?—†?Š” ê²½ìš°.
		if (x==null || !key.equals(x.data))
			return "Search Error";
		// ë£¨íŠ¸?´ê±°ë‚˜ ?ž?‹?´ ?‘ ê°œì¸ ?…¸?“œ
		if (x == root || isTwoNode(x)) {
			if (isLeaf(x)) // ë£¨íŠ¸ê°? ë¦¬í”„
			{
				root.data = "";
				return "Tree set Empty";
			} else if (!isTwoNode(x)) { // ë£¨íŠ¸
				root = (x.right == null) ? x.left : x.right; // ?ž?‹?„ ë£¨íŠ¸ë¡?
				root.parent = null;
				// AVLì¶”ê?
				root.setAux(1);
			} else { // ?ž?‹?´ ?‘˜?¸ ?…¸?“œ(ë£¨íŠ¸ ?¬?•¨)
				y = min(x.right); // inorder successor
				x.data = y.data; // yë¥? x?— ë³µì‚¬
				p = y.parent;
				// y?˜ ?ž?‹?„ p?˜ ?ž?‹?œ¼ë¡?(y ?‚­? œ)
				relink(p, y.right, y == p.left);
				// y?˜ ì¡°ìƒ ?…¸?“œ?“¤?˜ sizeë¥? ê°ì†Œ
				// AVLì¶”ê?
				
				
				for (Node temp = x; temp != null; temp = temp.parent) {
					temp.aux = 1 + Math.max(height(temp.left), height(temp.right));
				}rebalance(x);
			}
		} else { // ?ž?‹?´ ?•˜?‚˜?´ë©?, ë£¨íŠ¸ ?•„?‹˜
			p = x.parent;
			if (x.right == null)
				relink(p, x.left, x == p.left);
			else if (x.left == null)
				relink(p, x.right, x == p.left);
			// AVLì¶”ê?
			
			for (Node temp = p; temp != null; temp = temp.parent) {
				temp.aux = 1 + Math.max(height(temp.left), height(temp.right));
			}rebalance(p);
		}
		return key + " Delete Success";
	}

}