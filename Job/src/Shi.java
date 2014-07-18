
public class Shi extends ChessPiece{

	public Shi(int a, int b, String n,int t) {
		super(a, b, n, t);
		// TODO Auto-generated constructor stub
	}

	public boolean isLegal(int x,int y,int a,int b) {
		if(b>5||b<3||a<7&&a>2)return false;
		if((x==a+1||x==a-1)&&(y==b-1||y==b+1))return true;
		return false;
	}
}
