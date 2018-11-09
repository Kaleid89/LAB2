
public class User {
	private long x,y;
	public long generate(long p){
		while(x<=0||x>p-1) {
			x=(long) (Math.random()*100);
		}
		return x;
	}
	public long count(long p, long a){
		y = (long) ((Math.pow(a, x))%p);
		return y;
	}
	public long key(long y2, long p){
		long k = (long) ((Math.pow(y2, x))%p);
		return k;
	}
	
}
