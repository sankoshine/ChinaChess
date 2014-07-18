
public class Xiang extends ChessPiece{

	public Xiang(int a, int b, String n,int t) {
		super(a, b, n, t);
	}

	public boolean isLegal(int x,int y,int a,int b) {
		if(x<=4&&a>=5||x>=5&&a<=4)return false;
		if(Board.isChe((a+x)/2, (y+b)/2))return false;
		if((x==a+2||x==a-2)&&(y==b-2||y==b+2))return true;
		return false;
	}
		
}
