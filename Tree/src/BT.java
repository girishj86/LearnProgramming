import java.util.LinkedList;
import java.util.Queue;

public class BT {

    private BTNode root;

    public BTNode getRoot() {
        return root;
    }

    public void setRoot(BTNode root) {
        this.root = root;
    }

    public void inorder(BTNode root) {
        if (root == null) return;
        inorder(root.getLeft());
        System.out.print(root.getData() + " ");
        inorder(root.getRight());
    }

    public BTNode addBSTNodeRecursively(BTNode root, int data) {
        if (root == null) {
            return new BTNode(data);
        }
        if (data > root.getData()) {
            root.setRight(addBSTNodeRecursively(root.getRight(), data));
        } else {
            root.setLeft(addBSTNodeRecursively(root.getLeft(), data));
        }
        return root;
    }

    public void addBSTNodeIteratively(BTNode root, int data) {
        BTNode cur = root;
        BTNode prev = null;
        while (cur != null) {
            prev = cur;
            if (data >= cur.getData()) {
                cur = cur.getRight();
            } else {
                cur = cur.getLeft();
            }
        }
        cur = new BTNode(data);
        if (data >= prev.getData()) {
            prev.setRight(cur);
        } else {
            prev.setLeft(cur);
        }
    }

    public void addBTNodeIteratively(BTNode root, int data) {
        BTNode cur = root;
        BTNode prev = null;
        while (cur != null) {
            prev = cur;
            if (cur.getLeft() == null){
                cur.setLeft(new BTNode(data));
                break;
            } else if (cur.getRight() == null){
                cur.setRight(new BTNode(data));
                break;
            }
            cur = cur.getLeft();
        }
        cur = new BTNode(data);
        if (data >= prev.getData()) {
            prev.setRight(cur);
        } else {
            prev.setLeft(cur);
        }
    }

    public void levelOrderTraversal(){
        BTNode prev = null;
        BTNode cur = root;
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while(!queue.isEmpty() && queue.size() > 0){
            System.out.print("Level "+level+++" : ");
            int size = queue.size();
            for(int i=0;i<size;i++) {
                BTNode node = queue.poll();
                if (node != null) {
                    System.out.print(" "+node.getData());
                    queue.offer(node.getLeft());
                    queue.offer(node.getRight());
                }
            }
            System.out.println();
        }
    }

}

class BTNode {

    private BTNode left;
    private BTNode right;
    private int data;

    public BTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
