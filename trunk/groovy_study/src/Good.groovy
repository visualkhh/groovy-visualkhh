
def list = [1,2,3,4];
list.inject(10){ 
	sum, i ->
	println  sum +' '+i;
	sum+=i;
};