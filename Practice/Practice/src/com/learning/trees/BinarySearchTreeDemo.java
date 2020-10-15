import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        BSTNode root = new BSTNode(1);
        root.left = new BSTNode(2);
        root.right = new BSTNode(3);
        root.left.left = new BSTNode(4);
        root.left.right = new BSTNode(5);
        root.right.left = new BSTNode(6);
        root.right.right = new BSTNode(7);

        bfs(root);
    }

    private static void bfs(BSTNode root) {
        Queue<BSTNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            BSTNode temp = queue.poll();
            if (temp != null) {
                System.out.println(temp.data);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
    }

}


class BSTNode {
    BSTNode(int data) {
        this.data = data;
    }

    int data;
    BSTNode left;
    BSTNode right;

}

class BST {


}
