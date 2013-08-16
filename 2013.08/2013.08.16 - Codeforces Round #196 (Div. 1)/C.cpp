li a[101010];
li rest[101010];
map<li, int> memo;
int div(li x){
	if(memo.find(x) != memo.end()) {
		return memo[x];
	}
	int& res = memo[x];
	for(li i = 2; i  * i <= x; ++i) {
		while(x % i == 0) {
			x /= i;
			++res;
		}
	}
	if(x > 1) {
		++res;
	}

	return res;
}

int rec(int index, int currentRoots, int n) {

	if(index == n) {
		int sum = n;
		if(currentRoots > 1)
			++sum;
		for(int i = 0; i < n; ++i) {
			int divisors = div(rest[i]);
			sum += divisors == 1 ? (a[i] == rest[i] ? 0: 1) : divisors;
		}
		return sum;
	}
	int mn = rec(index + 1, currentRoots + 1, n);

	for(int i = index + 1; i < n; ++i) {
		if(rest[i] % a[index] == 0) {
			rest[i] /= a[index];
			mn = min(mn, rec(index + 1, currentRoots, n));
			rest[i] *= a[index];
		}
	}

	return mn;
}

void solve() {
	int n;
	cin >> n;
	for(int i = 0; i < n; ++i) {
		cin >> a[i];
		rest[i] = a[i];
	}

	sort(a, a + n);
	sort(rest, rest + n);
	cout << rec(0, 0, n);
}