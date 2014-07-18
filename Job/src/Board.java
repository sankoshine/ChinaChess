public class Board {

	private static ChessPiece[][] boar;
	private static ChessPiece[] che = new ChessPiece[40];
	private static int c;
	
	static int JX() {
		return che[0].getX();
	}
	
	static int JY() {
		return che[0].getY();
	}
	
	static int SX() {
		return che[1].getX();
	}
	
	static int SY() {
		return che[1].getY();
	}	

	static void init() {
		boar = new ChessPiece[15][15];
		c = 0;
		che[c] = new Jiang(0, 4, "将", 0);
		boar[0][4] = che[c++];
		che[c] = new Jiang(9, 4, "帅", 1);
		boar[9][4] = che[c++];

		che[c] = new Shi(0, 3, "士", 0);
		boar[0][3] = che[c++];
		che[c] = new Shi(0, 5, "士", 0);
		boar[0][5] = che[c++];
		che[c] = new Shi(9, 3, "仕", 1);
		boar[9][3] = che[c++];
		che[c] = new Shi(9, 5, "仕", 1);
		boar[9][5] = che[c++];

		che[c] = new Xiang(0, 2, "象", 0);
		boar[0][2] = che[c++];
		che[c] = new Xiang(0, 6, "象", 0);
		boar[0][6] = che[c++];
		che[c] = new Xiang(9, 2, "相", 1);
		boar[9][2] = che[c++];
		che[c] = new Xiang(9, 6, "相", 1);
		boar[9][6] = che[c++];

		che[c] = new Ju(0, 0, "车", 0);
		boar[0][0] = che[c++];
		che[c] = new Ju(0, 8, "车", 0);
		boar[0][8] = che[c++];
		che[c] = new Ju(9, 0, "車", 1);
		boar[9][0] = che[c++];
		che[c] = new Ju(9, 8, "車", 1);
		boar[9][8] = che[c++];

		che[c] = new Ma(0, 1, "马", 0);
		boar[0][1] = che[c++];
		che[c] = new Ma(0, 7, "马", 0);
		boar[0][7] = che[c++];
		che[c] = new Ma(9, 1, "馬", 1);
		boar[9][1] = che[c++];
		che[c] = new Ma(9, 7, "馬", 1);
		boar[9][7] = che[c++];

		che[c] = new Pao(2, 1, "炮", 0);
		boar[2][1] = che[c++];
		che[c] = new Pao(2, 7, "炮", 0);
		boar[2][7] = che[c++];
		che[c] = new Pao(7, 1, "包", 1);
		boar[7][1] = che[c++];
		che[c] = new Pao(7, 7, "包", 1);
		boar[7][7] = che[c++];

		che[c] = new Bing(6, 0, "兵", 1);
		boar[6][0] = che[c++];
		che[c] = new Bing(6, 2, "兵", 1);
		boar[6][2] = che[c++];
		che[c] = new Bing(6, 4, "兵", 1);
		boar[6][4] = che[c++];
		che[c] = new Bing(6, 6, "兵", 1);
		boar[6][6] = che[c++];
		che[c] = new Bing(6, 8, "兵", 1);
		boar[6][8] = che[c++];

		che[c] = new Bing(3, 0, "卒", 0);
		boar[3][0] = che[c++];
		che[c] = new Bing(3, 2, "卒", 0);
		boar[3][2] = che[c++];
		che[c] = new Bing(3, 4, "卒", 0);
		boar[3][4] = che[c++];
		che[c] = new Bing(3, 6, "卒", 0);
		boar[3][6] = che[c++];
		che[c] = new Bing(3, 8, "卒", 0);
		boar[3][8] = che[c++];
	}

	static boolean isChe(int a, int b) {
		if (boar[a][b] == null)
			return false;
		return true;
	}

	static String getName(int a, int b) {
		return boar[a][b].getName();
	}

	static void setChe(int f1, int f2, int t1, int t2){
		hasMove = false;
		try{
			boar[f1][f2].setLocation(t1, t2);
		}
		catch (Exception ex){
			System.out.println("ERROR: "+ex);
		}
		if (boar[f1][f2].getX() != f1 || boar[f1][f2].getY() != f2)
			hasMove = true;
		if (hasMove) {
			boar[t1][t2] = boar[f1][f2];
			boar[f1][f2] = che[39];
			prit();
		}
	}

	static boolean hasMove = false;

	static void prit() {
		int i, j;
		for (i = 9; i >= 0; i--) {
			System.out.print(i + " ");
			for (j = 0; j < 9; j++) {
				if (boar[i][j] == null)
					System.out.print(" - ");
				else
					System.out.print(boar[i][j].getName() + " ");
			}
			System.out.println();
		}
		System.out.print("SA");
		for (j = 0; j < 9; j++) {
			System.out.print(" "+ j + " ");
		}
		System.out.println();
	}

	static int getTeam(int a, int b) {
		return boar[a][b].getTeam();
	}
	
	static boolean isJiang(int a,int b){
		if( boar[a][b].isLegal (a, b, JX(), JY() ) )return true;
		return false;
	}
	
	static boolean isShuai(int a,int b){
		if( boar[a][b].isLegal (a, b, SX(), SY() ) )return true;
		return false;
	}
	
	static boolean F2F(){
		if(SY()!=JY())return false;
		int i;
		for(i=JX()+1;i<SX();i++){
			if(isChe(i,SY()))return false;
		}
		return true;
	}

}
