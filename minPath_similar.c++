//must identify the different functions of two 2d matrixs used here

// one is named map which is passed by user and in map every corner has a value > = 0
// actually the value means the cost -> we are trying to find the min sum of the path
// from top left to the bottom right 

// another is named state which is has one more row and column compared to map
// and its default value will be initialized with -1 and will update as recursive
// because the player could only go right or down therefore every column/row
// could only possibly be visited once and therefore whenever we find this way is 
// used we just directly return the value we calculated before (in preceding recursive)

//i.e. if the element stored in state matrix is not -1 anymore, it is actually the result
//we calculated before and we could use this value directly, i.e. return advancedly
class Foo{
public:
	int go(vector<vector <int> > &map)
	{
		const int m = map.size();
		const int n = map[0].size();
		this->state = vector <vector <int> > (m, vector<int> (n, -1));
		return run(map, m-1, n-1);
	}

private:
	vector <vector <int> > state;

	int run(const vector <vector <int> > &map, int x, int y)
	{
		if(x<0 || y<0) return INT_MAX; // run into the off-limit areas

		//successfully go to the base case 
		//and return the cost of the starting point to the preceding recursions
		//to add up the sum of the one possible path
		if(x==0 && y ==0) return map[0][0];

		//connect different level of stacks 
		//need to update the sum which is returned to the preceding sum calculation
		return min(bar(map,x-1,y),bar(map,x,y-1)) + map[x][y];
	}

	//the following function is just an assistant function
	//which will take advantage of map to reduce the times of useless recursion
	//and thus save time at the cost of extra space state
	int bar(const vector <vector <int> > &map, int x, int y)
	{
		//the first statement here should be as same as the main recursive body above

		if(x<0 || y<0)  return INT_MAX; // run into the off-limit areas
		//the state is used before and thus not -1 anymore
		//then return the preceding calculated sum stored in this position 
		//instead of calling the recursion
		if(state[x][y] >= 0 ) 
			return state[x][y];
		//otherwise, we cannot take advantage of the state for this round
		//we must call the recursion anyway
		//but when we call we must remember to update the state for the 
		//following use ->  that is how it works
		else
			return state[x][y] = run(map, x, y);
	}
};