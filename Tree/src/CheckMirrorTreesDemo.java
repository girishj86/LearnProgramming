public class CheckMirrorTreesDemo {

    public static void main(String[] args) {
        /*
                     50
                   /    \
                 25     75
                /  \    / \
              12    38 62  87

         */
        BT tree1 = new BT();
        tree1.setRoot(new BTNode(50));
        tree1.addBSTNodeRecursively(tree1.getRoot(),25);
        tree1.addBSTNodeRecursively(tree1.getRoot(),75);
        tree1.addBSTNodeRecursively(tree1.getRoot(),38);
        tree1.addBSTNodeRecursively(tree1.getRoot(),62);
        tree1.addBSTNodeRecursively(tree1.getRoot(),12);
        tree1.addBSTNodeRecursively(tree1.getRoot(),87);
        System.out.print("First Binary Search Tree (inorder) : ");
        tree1.inorder(tree1.getRoot());
         /*
                     50
                   /    \
                 75      25
                /  \    /  \
              87   62  38  12

         */
        BT tree2 = new BT();
        tree2.setRoot(new BTNode(50));
        tree2.addBTNodeIteratively(tree2.getRoot(),75);
        tree2.addBTNodeIteratively(tree2.getRoot(),25);
        tree2.addBTNodeIteratively(tree2.getRoot(),87);
        tree2.addBTNodeIteratively(tree2.getRoot(),62);
        tree2.addBTNodeIteratively(tree2.getRoot(),38);
        tree2.addBTNodeIteratively(tree2.getRoot(),12);
        System.out.print("\nSecond Binary Search Tree (inorder) : ");
        tree2.inorder(tree2.getRoot());
        System.out.println();
        tree1.levelOrderTraversal();
        System.out.println("\nMirror Trees : "+ checkMirrorTrees(tree1.getRoot(), tree2.getRoot()));

    }

    public static boolean checkMirrorTrees(BTNode root1, BTNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root1 != null && root2 == null) return false;
        if (root1.getData() != root2.getData()) return false;
        return checkMirrorTrees(root1.getLeft(), root2.getRight()) &&
                checkMirrorTrees(root1.getRight(), root2.getLeft());
    }
}
