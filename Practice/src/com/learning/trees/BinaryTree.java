package com.learning.trees;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	TreeNode root;

	public BinaryTree(int data) {
		this.root = new TreeNode(data);
	}

	void levelOrderInsertArray(int[] elements) {
		for (int el : elements) {
			levelOrderInsert(el);
		}
	}

	/* Function to insert data recursively */
	void levelOrderInsert(int data) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (true) {
			int size = queue.size();
			TreeNode node = queue.poll();
			for (int i = 0; i < size; i++) {
				if (node.left == null) {
					node.left = new TreeNode(data);
					return;
				}
				if (node.right == null) {
					node.right = new TreeNode(data);
					return;
				}
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
	}

	void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}

	void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (queue.stream().filter(Objects::nonNull).count() > 0) {
				System.out.print("\nLevel " + level++ + " :");
			}
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node != null) {
					System.out.print(node.data + " ");
					queue.offer(node.left);
					queue.offer(node.right);
				}
			}
		}
	}

	void zigZagLevelOrderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (queue.stream().filter(Objects::nonNull).count() > 0) {
				System.out.print("\nLevel " + level + " :");
			}
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (level % 2 == 1) {
					stack.add(node);
				}
				if (node != null) {
					if (level % 2 == 0) {
						System.out.print(node.data + " ");
					}
					queue.offer(node.left);
					queue.offer(node.right);
				}
			}
			if (level % 2 == 1) {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop()+" ");
				}
				stack.clear();
			}
			level++;
		}
	}

	/* Function to check if 2 trees are identical */
	boolean checkIdenticalTree(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 != null) {
			return false;
		}
		if (root2 == null && root1 != null) {
			return false;
		}
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1.data == root2.data) {
			return checkIdenticalTree(root1.left, root2.left) && checkIdenticalTree(root1.right, root2.right);
		}
		return false;
	}
	
	

}
