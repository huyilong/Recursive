/*
when it's hard to figure out what your code is doing, 
logging it extensively is a very good solution, as it 
lets you output from within your code what the internal 
state is and pinpoint what the problem is.
*/

class Foo{
public:
	//in 2d matrix map 0 denotes could pass and 1 denotes there is an obstacle
	//User GUI interface engine only using one input which is user - friendly
	int go(vector < vector <int> > &map)
	{
		//initialize with const type, which would promise not alter the value of m and n
		const int m = map.size();
		const int n = map[0].size();
		//initialize a new 2d matrix to store the state to avoid repeated visiting in the recursion
		//using the extra space to get some advantage in time complexity
		this->state = vector < vector <int> > (m+1, vector<int> (n+1, 0 ));
		//using this to denote the state defined as private member afterwards
		return run(map, m, n);
	}

private:
	vector< vector <int> > state;

	//making the input const and using reference & is a good habit
	int run(const vector< vector <int> > &map, int x, int y)
	{
		if(x<1 || y<1)  return 0; //illegal input

		//in 2d matrix map 0 denotes could pass and 1 denotes there is an obstacle
		//prunning and return advancedly
		if(map[x-1][y-1] == 1)  return 0; // meet with obstacles

		//base case 
		//touchdown back to the starting point and return success
		if(x==1 && y==1)  return 1;

		return bar(map, x-1, y ) + bar(map, x, y-1);
	}

	int bar(const vector< vector< int > > &map, int x, int y)
	{
		//this row or column is already visited and checked
		//return the already known value and avoid extra recursion to save time
		//this->state = vector < vector <int> > (m+1, vector<int> (n+1, 0 )); is default state matrix
		if(state[x][y] > 0) 
			return state[x][y];
		else
			return state[x][y] = run(map, x, y);
		//otherwise we need to calling the recursive and update the state[x][y] value in the state matrix
		//for the following time saving 
	}
}