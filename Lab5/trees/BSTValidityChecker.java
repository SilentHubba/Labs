package trees;

public class BSTValidityChecker {
	public boolean isValidBST(TreeNode root)
	{
		return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isValidBSTHelper(TreeNode root, int lower, int upper)
	{
		// Case for if the passed node is null
		// And base case
		if(root == null)
		{
			return true;
		}
		
		// Check to see if the left child node violates the rules of a BST
		if(root.left != null && (root.left.val > root.val || root.left.val < lower))
		{
			return false;
		}
		
		// Check to see if the right child node violates the rules of a BST
		if(root.right != null && (root.right.val < root.val || root.right.val > upper))
		{
			return false;
		}
		
		// Recursively check the left child node. If any node in the left subtree violates
		// the properties of BSTs, return false
		int maxNum = Math.min(upper, root.val);
		if(!isValidBSTHelper(root.left, lower, maxNum))
		{
			return false;
		}
		
		// Recursively check the right child node. If any node in the right subtree violates
		// the properties of BSTs, return false
		int minNum = Math.max(lower, root.val);
		if(!isValidBSTHelper(root.right, minNum, upper))
		{
			return false;
		}
		
		// Returns true if every node in the tree follows the properties of BSTs
		return true;
	}
	
	public static void main(String[] args)
	{
		// Testing without using JUnit
		/*
		 *    4
		 *  3   8
		 * 1   5 9
		 * 
		 * test 3,1 and 1,5
		 */
		BSTValidityChecker checker = new BSTValidityChecker();
		
		TreeNode root = new TreeNode(4);
		TreeNode threeNode = new TreeNode(3);
		root.left = threeNode;
		root.right = new TreeNode(8);
		TreeNode oneNode = new TreeNode(1);
		root.left.left = oneNode;
		TreeNode fiveNode = new TreeNode(5);
		root.right.left = fiveNode;
		root.right.right = new TreeNode(9);
		
		// Should be true
		System.out.println(checker.isValidBST(root));
		
		
		TreeNode nodeRoot = new TreeNode(1);
		TreeNode nodeTwo = new TreeNode(2);
		TreeNode nodeThree = new TreeNode(3);
		TreeNode nodeFour = new TreeNode(4);
		TreeNode nodeEight = new TreeNode(8);
		TreeNode nodeFive = new TreeNode(5);
		TreeNode nodeSix = new TreeNode(6);
		nodeRoot.left = nodeTwo;
		nodeRoot.right = nodeEight;
		nodeTwo.left = nodeThree;
		nodeTwo.right = nodeFour;
		nodeEight.left = nodeFive;
		nodeEight.right = nodeSix;
		System.out.println(checker.isValidBST(nodeRoot));
	}
}
