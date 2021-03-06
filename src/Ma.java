
public class Ma extends ChessPiece{
	
	public Ma(int a, int b, String n,int t) {
		super(a, b, n, t);
	}

	public boolean isLegal(int x,int y,int a,int b) {
		if(a==x+2){
			if(Board.isChe(x+1, y))return false;
			if(y==b+1||y==b-1)return true;
			return false;
		}
		if(a==x-2){
			if(Board.isChe(x-1, y))return false;
			if(y==b+1||y==b-1)return true;
			return false;
		}
		if(y==b+2){
			if(Board.isChe(x, b+1))return false;
			if(x==a+1||x==a-1)return true;
			return false;
		}
		if(y==b-2){
			if(Board.isChe(x, b-1))return false;
			if(x==a+1||x==a-1)return true;
			return false;
		}
		return false;
	}
}
