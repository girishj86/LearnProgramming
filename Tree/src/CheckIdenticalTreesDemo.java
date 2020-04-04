public class CheckIdenticalTreesDemo {

    public static void main(String[] args) {
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
        BT tree2 = new BT();
        tree2.setRoot(new BTNode(50));
        tree2.addBSTNodeRecursively(tree2.getRoot(),25);
        tree2.addBSTNodeRecursively(tree2.getRoot(),75);
        tree2.addBSTNodeRecursively(tree2.getRoot(),38);
        tree2.addBSTNodeRecursively(tree2.getRoot(),62);
        tree2.addBSTNodeRecursively(tree2.getRoot(),12);
        tree2.addBSTNodeRecursively(tree2.getRoot(),87);
        System.out.print("\nSecond Binary Search Tree (inorder) : ");
        tree2.inorder(tree2.getRoot());
        System.out.println("\nTrees Identical : "+checkIdenticalTrees(tree1.getRoot(), tree2.getRoot()));
    }

    public static boolean checkIdenticalTrees(BTNode root1, BTNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root1 != null && root2 == null) return false;
        if (root1.getData() != root2.getData()) return false;
        return checkIdenticalTrees(root1.getLeft(), root2.getLeft()) &&
                checkIdenticalTrees(root1.getRight(), root2.getRight());
    }
}