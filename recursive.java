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

    //the following recursive calls do not need a return value
    //i.e. using return; in base case and just void to main
    public static void increaseNode(TreeNode root, TreeNode n)
    {

        //base case
        if(root.data == n)
        {
            ++root.data;
            return;
        }

        if(n.data <= root.data)
        {
            //because we do not need the connection between different levels here
            //we do not need to update and return like root.left = insertNodeBinarySearchTree(root.left, n);
            increaseNode(root.left, n);
        }

        else if(n.data > root.data)
        {
            increaseNode(root.right, n);
        }

    

/*
递归分为两部分 一开始进去之后先想 base case
然后base case里面一般为最基本的touchdown
有的时候如果不需要的话就可以直接     写一些语句  然后return; 即可
return后面什么都不用写

只有当需要最后返回到main中一些东西  而不是void的时候才需要return

base case后面就是分为不同的情况在if条件里面进行不同的 return + recursive calls
如果需要return的话往往还会把calls的结果赋值给新的节点 最后再return root
关键即在于更新和链接  以及if条件的把握
*/