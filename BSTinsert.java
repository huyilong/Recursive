/* Insert a node to a binary search tree*/

//the following is wrong because it dose not update the pointer into the preceding level 
//of stack so the tree is actually not finished and returned to the main function
        public static void insertNodeBinarySearchTree(TreeNode root, TreeNode n){
                if(root == null){
                        root = n;
                }//base case:: i.e. the bottom line
                else if(n.data >= root.data){
                        insertNodeBinarySearchTree(root.left,n);
                }
                else if(n.data < root.data){
                        insertNodeBinarySearchTree(root.right,n);
                }
        }

//the following is correct because we use the return type and let it equal to 
//the root.left / root.right  actually each level has the different root value
//i.e. each node could be viewed as a individual tree until connected up to the total root
        public static TreeNode insertNodeBinarySearchTree(TreeNode root, TreeNode n){
        if(root == null){
            return n;
        }
        else if(n.data >= root.data){
            root.left = insertNodeBinarySearchTree(root.left, n);
        }
        else if(n.data < root.data){
            root.right = insertNodeBinarySearchTree(root.right, n);
        }

        //here we omit an important line to return to the final main function
        return root;
    }
//must connect each level of dreams to tell each other what happened 
//only one level knows would not work
//第一种写法只告诉root它的是值是多少，但没有告诉它的parent（也就是node 4)这个node的存在。
//第二种写法就明确告诉它的parent新插进去的值是什么了(via left/right.left = n;)