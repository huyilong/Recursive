//we could use the down-to-top as recursion
//then we could use the top-to-down as 2d dynamic programming

class Foo{
public:
	int go(vector<vector <int> > &map){
		if(map.size() == 0) return 0;
		const int m = map.size();
		const int n = map[0].size();

		int state[m][n];

		state[0][0] = map[0][0];
		//initialize the first row and the first column in the initial state matrix
		//by just calculating the one dimension case
		for(int i=1; i<m; i++)
		{
			state[i][0] = state[i-1][0] + state[i][0];
		}

		for(int i=1; i<n; i++)
		{
			state[0][i] = state[0][i-1] + state[0][i];
		}

		for(int i =1; i<m; i++)
		{
			for(int j=1; j<n; j++)
			{
				//transaction function between different level of states
				state[i][j] = min(state[i-1][j], state[i][j-1]) + map[i][j];
			}
		}

		//the m-1 and n-1 actually will be equal to the final value of
		// i and j in the looping above
		//i.e. the final optimal result will be the value stored in the 
		//top right corner position of the state matrix after all rounds
		//of calculation based on the other positions and the transaction
		//function of the dynamic programming
		return state[m-1][n-1]
	}
}