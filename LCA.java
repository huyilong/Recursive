/*
Lowest Common Ancestor of a Binary Tree
第一次写最近公共祖先问题，用的邻接表指针。

对于一棵有根树，就会有父亲结点，祖先结点，当然最近公共祖先就是这两个点所有的祖先结点中深度最大的一个结点。

       0

       |

       1

     /   \

   2      3

比如说在这里，如果0为根的话，那么1是2和3的父亲结点，0是1的父亲结点，0和1都是2和3的公共祖先结点，
但是1才是最近的公共祖先结点，或者说1是2和3的所有祖先结点中距离根结点最远的祖先结点。

在求解最近公共祖先为问题上，用到的是Tarjan的思想，从根结点开始形成一棵深搜树，非常好的处理技巧就是在回溯到结点u的时候，
u的子树已经遍历，这时候才把u结点放入合并集合中，这样u结点和所有u的子树中的结点的最近公共祖先就是u了，

u和还未遍历的所有u的兄弟结点及子树中的最近公共祖先就是u的父亲结点。以此类推。。这样我们在对树深度遍历的时候就很自然的
将树中的结点分成若干的集合，两个集合中的所属不同集合的任意一对顶点的公共祖先都是相同的，也就是说这两个集合的最近公共
最先只有一个。对于每个集合而言可以用并查集来优化，时间复杂度就大大降低了，为O(n + q)，n为总结点数，q为询问结点对数。

另外Tarjan解法，是一个离线算法，就是说它必须将所有询问先记录下来，再一次性的求出每个点对的最近公共祖先，
只有这样才可以达到降低时间复杂度。

*/

//problem LCA (lowest common ancestor) : try to find the LCA of node p and q in tree with root
Node *LCA(Node *root, Node *p, Node *q) {
  //this is used as the initial screening and also used in 
  //if really does not find the required node then it is also used as base case
  if (!root) return NULL;

  //note: here we did not use else if
  //base case of recursive
  //touchdown  we find root could be either p and q because p and q does not have to 
  //have the same parent and that's why we need to find the p and q's ancester
  //rather than parent
  if (root == p || root == q) 
  	//think carefully for the logic, using  || instead of &&
  	return root;

  //recursion body
  //we need to update *L and *R here to return the value to the preceding stack
  //here is the operation of the recursive

  //it feels like Node *L = calling  = calling = calling, etc and then go back 
  Node *L = LCA(root->left, p, q);
  Node *R = LCA(root->right, p, q);

  //the following process will also go over for each stack to decide which value to 
  //return back to the preceding stack


  //THE following if else statements would be used in each recursion to return its value

  // if p and q are on both sides
  // i.e. here the current root is our current LCA
  if (L && R) return root;  

  //else if ( L != R)
  // either one of p,q is on one side OR p,q is not in L&R subtrees
  return L ? L : R;  

  //the if and else if return above will finally come back to the level1 and return to main function
}


