package com.learning.trees;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		
		BinaryTree tree1 = new BinaryTree(1);
		TreeNode root1 = tree1.root;
		tree1.levelOrderInsertArray(new int[] {2,3,4,5,6,7,8,9,10,11,12,13,14,15});
		/*
		 * 			 1
		 * 		2		   3
		 *   4	  5	    6  	   7
		 * 8  9 10 11 12 13 14 15
		 * 
		 * 
		 */
		BinaryTree tree2 = new BinaryTree(1);
		TreeNode root2 = tree2.root;
		tree2.levelOrderInsertArray(new int[] {2,3,4,5,6,7,8,9,10,11,12,13,14,15});
		
		System.out.println("\nInOrder");
		tree1.inorder(root1);
		System.out.println("\nPreOrder");
		tree1.preorder(root1);
		System.out.println("\nPostOrder");
		tree1.postorder(root1);
		System.out.println("\nLevelOrder");
		tree1.levelOrderTraversal(root1);
		System.out.println("\nZig Zag Level Order Traversal");
		tree1.zigZagLevelOrderTraversal(root1);
		System.out.println("\nCheck if tree1 and tree2 are identical : "+tree1.checkIdenticalTree(root1, root2));
	}

}
