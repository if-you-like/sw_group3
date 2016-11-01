package sw_group3;

public class AVL_Tree extends Binary_Search_Tree {
	AVL_Tree() {
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
			// AVL추가
			for (Node x = temp; x != null; x = x.parent) {
				x.aux = 1 + Math.max(height(x.left), height(x.right));
			}
			rebalance(temp);
		}

	}

	protected void rotate(Node x) { // LL과 RR을 하나의 함수로. c  x  y가 문제!
		Node y = x.parent;
		Node z = y.parent;
		if (z == null) {
			root = x;
			x.parent = null;
		} else
			relink(z, x, y == z.left); // x를 z의 자식으로. 즉, x가 c와 y의 부모
		if (x == y.left) {
			relink(y, x.right, true);
			relink(x, y, false);
		} // LL
		else {
			relink(y, x.left, false);
			relink(x, y, true);
		} // RR
	}

	protected Node restructure(Node x) { // x  y  z가 문제
		Node y = x.parent;
		Node z = y.parent;
		if ((x == y.left) == (y == z.left)) {
			rotate(y);
			return y;
		} // LL or RR : y가 중간값
		else {
			rotate(x);
			rotate(x);
			return x;
		} // 중간값이 x: LR/RL  LL/RR로 일단 변경
	}

	private int height(Node x) {
		return (x == null) ? 0 : x.getAux();
	}

	private void setHeight(Node x, int height) {
		x.setAux(height);
	}

	private void recomputeHeight(Node x) // 노드의 높이 재계산
	{
		setHeight(x, (1 + Math.max(height(x.left), height(x.right))));
	}

	private boolean isBalanced(Node x) // 노드의 balanced 여부 검사
	{
		return (Math.abs(height(x.left) - height(x.right)) <= 1);
	}

	private Node tallerChild(Node x) { // 깊이가 깊은 자식 노드 조사
		if (height(x.left) > height(x.right))
			return x.left;
		if (height(x.left) < height(x.right))
			return x.right;
		if (x == root)
			return x.left; // 같은 경우에는 왼쪽 자식
		if (x == x.parent.left)
			return x.left; // LL이나
		else
			return x.right; // RR을 선호
	}

	private void rebalance(Node x) {
		do {
			if (!isBalanced(x)) { // x가 balanced node가 아닐 경우, 재구성
				x = restructure(tallerChild(tallerChild(x)));
				recomputeHeight(x.left); // 재구성 후, 높이를 다시 조정
				recomputeHeight(x.right);
				for (Node p = x; p != null; p = p.parent)
					recomputeHeight(p);
			}
			// put()의 경우에는 재구성 후, 부모 노드를 조사할 필요가 없으나,
			// delete의 경우에는 부모 노드들의 balanced 여부를 조사하여야 함.
			x = x.parent;
		} while (x != null);
	}

	String delete(String key) {
		if (root.data == "")
			return "Tree is Empty";
		Node x, y, p;
		x = treeSearch(key);
		// key가 없는 경우.
		if (x==null || !key.equals(x.data))
			return "Search Error";
		// 루트이거나 자식이 두 개인 노드
		if (x == root || isTwoNode(x)) {
			if (isLeaf(x)) // 루트가 리프
			{
				root.data = "";
				return "Tree set Empty";
			} else if (!isTwoNode(x)) { // 루트
				root = (x.right == null) ? x.left : x.right; // 자식을 루트로
				root.parent = null;
				// AVL추가
				root.setAux(1);
			} else { // 자식이 둘인 노드(루트 포함)
				y = min(x.right); // inorder successor
				x.data = y.data; // y를 x에 복사
				p = y.parent;
				// y의 자식을 p의 자식으로(y 삭제)
				relink(p, y.right, y == p.left);
				// y의 조상 노드들의 size를 감소
				// AVL추가
				
				
				for (Node temp = x; temp != null; temp = temp.parent) {
					temp.aux = 1 + Math.max(height(temp.left), height(temp.right));
				}rebalance(x);
			}
		} else { // 자식이 하나이며, 루트 아님
			p = x.parent;
			if (x.right == null)
				relink(p, x.left, x == p.left);
			else if (x.left == null)
				relink(p, x.right, x == p.left);
			// AVL추가
			
			for (Node temp = p; temp != null; temp = temp.parent) {
				temp.aux = 1 + Math.max(height(temp.left), height(temp.right));
			}rebalance(p);
		}
		return key + " Delete Success";
	}

}
