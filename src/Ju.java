
public class Ju extends ChessPiece{

	public Ju(int a, int b, String n,int t) {
		super(a, b, n, t);
	}
	
	public boolean isLegal(int x,int y,int a,int b) {
		if(x!=a&&y!=b)return false;
		int i;
		if(x==a){
			if(y>b){
				for(i=b+1;i<y;i++){
					if(Board.isChe(a, i))return false;
				}
			}
			else{
				for(i=y+1;i<b;i++){
					if(Board.isChe(a, i))return false;
				}
			}
		}
		else{
			if(x>a){
				for(i=a+1;i<x;i++){
					if(Board.isChe(i, b))return false;
				}
			}
			else{
				for(i=x+1;i<a;i++){
					if(Board.isChe(i, b))return false;
				}
			}
		}
		return true;
	}

}
