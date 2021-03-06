/*
A Bottom-up Approach (Worst case O(n) ):
Using a bottom-up approach, we can improve over the top-down approach by avoiding 
traversing the same nodes over and over again.

We traverse from the bottom, and once we reach a node which matches one of the two 
nodes, we pass it up to its parent. The parent would then test its left and right 
subtree if each contain one of the two nodes. 

If yes, then the parent must be the LCA and we pass its parent up to the root. 

If not, we pass the lower node which contains either one of the two nodes (if the 
left or right subtree contains either p or q), or NULL (if both the left and right 
subtree does not contain either p or q) up.

*/

Node *LCA(Node *root, Node *p, Node *q) {
  if (!root) return NULL;
  if (root == p || root == q) return root;
  Node *L = LCA(root->left, p, q);
  Node *R = LCA(root->right, p, q);

  /*
   The parent would then test its left and right subtree if each contain one of the two nodes. 
   If yes, then the parent must be the LCA and we pass its parent up to the root.
   */
  if (L && R) return root;  // if p and q are on both sides


  /*
  If not, we pass the lower node which contains either one of the two nodes (if the left or 
  right subtree contains either p or q), or NULL (if both the left and right subtree does not 
  contain either p or q) up.
  */
  //compare l with r and decide to return the pointer which is not null
  return L ? L : R;  // either one of p,q is on one side OR p,q is not in L&R subtrees
}


//A Bottom-up Approach (Worst case O(n) )