
public class Bing extends ChessPiece{
	public Bing(int a, int b, String n,int t) {
		super(a, b, n, t);
	}
	
	public boolean isLegal(int x,int y,int a,int b) {
		if(getTeam()==0){
			if(x==4){
				if(y==b&&a==x+1)return true;
				return false;
			}
			if(y==b&&a==x+1)return true;
			if(x==a&&b==y+1)return true;
			if(x==a&&b==y-1)return true;
			return false;
		}
		else {
			if(x==5){
				if(y==b&&a==x-1)return true;
				return false;
			}
			if(y==b&&a==x-1)return true;
			if(x==a&&b==y+1)return true;
			if(x==a&&b==y-1)return true;
			return false;
		}
	}
}
