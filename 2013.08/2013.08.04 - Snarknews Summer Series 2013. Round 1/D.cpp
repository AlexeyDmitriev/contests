pi e[1010101];
vi g[10101];
bool bad1[1010101];
bool bad2[1010101];
bool used[10101];

int starts[10101];

void dfs(int v) {
	if(used[v])
		return;
	used[v] = true;
	for(int to: g[v])
		dfs(to);
}

void solve() {
	int n,m, p;
	cin >> n >> m >> p;
	for(int i = 0; i < p; ++i){
		cin >> starts[i];
		--starts[i];
	}
	
	for(int i =0 ; i < m; ++i) {
		int& a = e[i].first;
		int& b = e[i].second;
		cin >> a >> b;
		--a, --b;
	}
	
	for(int i = 0; i < n; ++i) {
		int k;
		cin >> k;
		for(int j = 0; j < k; ++j) {
			int z;
			cin >> z;
			--z;
			if(e[z].first == i) 
				bad1[z] = true;
			if(e[z].second == i) 
				bad2[z] = true;
		}
	}
	
	for(int i = 0; i < m; ++i) {
		if(!bad1[i])
			g[e[i].second].pb(e[i].first);
		if(!bad2[i])
			g[e[i].first].pb(e[i].second);
	}
	
	for(int i = 0; i < p; ++i)
		dfs(starts[i]);
	
	for(int i = 0; i < n; ++i) {
		if(!used[i]) {
			cout << i + 1 << endl;
			return;
		}
	}
	
	cout << "Impossible";
}