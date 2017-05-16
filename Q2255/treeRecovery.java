/*Description
Little Valentine liked playing with binary trees very much. Her favorite game was constructing randomly looking binary trees with capital letters in the nodes.
This is an example of one of her creations:


                                               D

                                              / \

                                             /   \

                                            B     E

                                           / \     \

                                          /   \     \

                                         A     C     G

                                                    /

                                                   /

                                                  F


To record her trees for future generations, she wrote down two strings for each tree: a preorder traversal (root, left subtree, right subtree) and an inorder traversal (left subtree, root, right subtree). For the tree drawn above the preorder traversal is DBACEGF and the inorder traversal is ABCDEFG.
She thought that such a pair of strings would give enough information to reconstruct the tree later (but she never tried it).

Now, years later, looking again at the strings, she realized that reconstructing the trees was indeed possible, but only because she never had used the same letter twice in the same tree.
However, doing the reconstruction by hand, soon turned out to be tedious.
So now she asks you to write a program that does the job for her! 
 * Input
The input will contain one or more test cases.
Each test case consists of one line containing two strings preord and inord, representing the preorder traversal and inorder traversal of a binary tree. Both strings consist of unique capital letters. (Thus they are not longer than 26 characters.)
Input is terminated by end of file.

Output
For each test case, recover Valentine's binary tree and print one line containing the tree's postorder traversal (left subtree, right subtree, root).

Sample Input

DBACEGF ABCDEFG
BCAD CBAD

Sample Output

ACBFGED
CDAB

 */
/*
 * Solution:There's no need to recreate a tree.We can use the recurrsion and the property of postorder.
*we also know that the preorder and inorder can recreate the tree.So we can write the code.
*/
public class treeRecovery {
	public static void getPostOrder(String preOrder, String inOrder){
		if(preOrder.length() != inOrder.length() || preOrder.length() == 0) return;
		char root = preOrder.charAt(0);
		if(inOrder.indexOf(root) != -1){
			int end = inOrder.indexOf(root);
			if(1 <= end)
				getPostOrder(preOrder.substring(1, end+1), inOrder.substring(0, end));
			if(end+1 <= preOrder.length())
				getPostOrder(preOrder.substring(end+1, preOrder.length()), inOrder.substring(end+1, inOrder.length()));
			System.out.print(root);
		}
	}
	public static void main(String[] args){
		java.util.Scanner in = new java.util.Scanner(System.in);
		while(in.hasNext()){//To deal with cases
			String preOrder = in.next();
			String inOrder = in.next();
			
			getPostOrder(preOrder, inOrder);
			System.out.println();
		}
	}
}
