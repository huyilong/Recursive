class Foo{
public:
	int findPath(int m, int n){
		//using this 2d matrix to record which row and column is used
		state = vector< vector<int> > (m+1, vector<int>(n+1, 0));
		//state = ArrayList< ArrayList<Integer> > ();
		return go(m,n);
	}

private:
	vector< vector<int> > state; //memorize the interim process
	int go(int x, int y){
		//illegal input , prunning
		if( x<1 || y<1 ) return 0;

		//base case, touchdown and then use this value for the preceding stacks
		if(x==1 && y==1) return 1;

		//other returns in following stacks
		//starting actually from the ending point rather than the x=1, y=1 starting point
		return run(x-1, y) + run(x, y-1);

	}

	int run(int x, int y)
	{
		//if this row/column is already visited before
		//which could save time 
		if(State[x][y] > 0)
			return State[x][y];
		else
			return State[x][y] = go(x,y);
		//remember to use the recursive call to update the State[x][y] value
		//which could connect different level of stacks in the recursive
		//similar as the insertion node in BST
	}
};
//top-down theory with extra space to save time