public class Jiang extends ChessPiece {

	Jiang(int a, int b, String n,int t) {
		super(a, b, n, t);
	}

	public boolean isLegal(int x,int y,int a,int b) {
		if(b>5||b<3||a<7&&a>2)return false;
		if(x==a&&(y==b-1||y==b+1)||y==b&&(x==a+1||x==a-1))return true;
		return false;
	}
		
}