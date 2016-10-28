package sw_group3;

public class Binary_Search_Tree extends NodeStructure {
   Node root;

   Binary_Search_Tree() {
      root = new Node();
   }

   void insert(String d) {
      if (root.data == "") {
         root.data = d;
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
            bp.right.parent = bp;
         } else {
            bp.left = new Node(d);
            bp.left.parent = bp;
         }

      }
   }

   void inorder(Node t) {
      if (t != null) {
         inorder(t.left);
         System.out.print(t.data + " ");
         inorder(t.right);
      }
   }

   void preorder(Node t) {
      if (t != null) {
         System.out.print(t.data + " ");
         preorder(t.left);
         preorder(t.right);
      }
   }

   void postorder(Node t) {
      if (t != null) {
         postorder(t.left);
         postorder(t.right);
         System.out.print(t.data + " ");
      }
   }

   boolean isLeaf(Node t) {
      if (t.left != null || t.right != null)
         return false;
      else
         return true;
   }

   boolean isTwoNode(Node t) {
      if (t.left == null || t.right == null)
         return false;
      else
         return true;
   }

   Node treeSearch(String key) {
      if (root == null) {
         return null;
      } else {
         Node p = root;
         while (p != null) {
            if (p.data.equals(key))
               return p;
            else if (p.data.compareTo(key) < 0)
               p = p.right;
            else
               p = p.left;
         }
         return null;
      }
   }

   protected void relink(Node parent, Node child, boolean makeLeft) {
      if (child != null)
         child.parent = parent; // child�� parent�� �ڽ�����
      if (makeLeft)
         parent.left = child; // ���� �ڽ�, �Ǵ�
      else
         parent.right = child; // ������ �ڽ�
   }

   protected Node min(Node t) {
      if (t == null) {
         return null;
      } else {
         while (t.left != null)
            t = t.left;
         return t;
      }
   }

   String delete(String key) {
      if (root.data == "")
         return "Tree is Empty";
      Node x, y, p;
      x = treeSearch(key);
      // key�� ���� ���.
      if (isLeaf(x) && !key.equals(x.data))
         return "Search Error";
      // ��Ʈ�̰ų� �ڽ��� �� ���� ���
      if (x == root || isTwoNode(x)) {
         if (isLeaf(x)) // ��Ʈ�� ����
         {
            root.data = "";
            return "Tree set Empty";
         } else if (!isTwoNode(x)) { // ��Ʈ
            root = (x.right == null) ? x.left : x.right; // �ڽ��� ��Ʈ��
            root.parent = null;

         } else { // �ڽ��� ���� ���(��Ʈ ����)
            y = min(x.right); // inorder successor
            x.data = y.data; // y�� x�� ����
            p = y.parent;
            // y�� �ڽ��� p�� �ڽ�����(y ����)
            relink(p, y.right, y == p.left);
            // y�� ���� ������ size�� ����
         }
      } else { // �ڽ��� �ϳ��̸�, ��Ʈ �ƴ�
         p = x.parent;
         if (x.right == null)
            relink(p, x.left, x == p.left);
         else if (x.left == null)
            relink(p, x.right, x == p.left);
      }
      return key + " Delete Success";
   }
}