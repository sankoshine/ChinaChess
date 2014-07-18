
public class Pao extends ChessPiece{

	public Pao(int a, int b, String n,int t) {
		super(a, b, n, t);
	}
	
	public boolean isLegal(int x,int y,int a,int b) {
		if(x!=a&&y!=b)return false;
		int i, c=0;
		if(x==a){
			if(y>b){
				for(i=y;i>=b;i--){
					if(Board.isChe(a, i))c++;
				}
			}
			else{
				for(i=y;i<=b;i++){
					if(Board.isChe(a, i))c++;
				}
			}
		}
		else {
			if(x>a){
				for(i=x;i>=a;i--){
					if(Board.isChe(i, b))c++;
				}
			}
			else{
				for(i=x;i<=a;i++){
					if(Board.isChe(i, b))c++;
				}
			}
		}
		if(c==1||c==3&&Board.isChe(a, b))return true;
		return false;
	}
}
