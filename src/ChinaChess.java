import java.util.Scanner;

public class ChinaChess {

	private static int t1, t2;
	private static int f1, f2;
	private static Scanner in = new Scanner(System.in);
	private static boolean team = false;
	private static boolean jiang = false;

	public static void main(String[] args) {
		Board.init();
		Board.prit();
		while (true) {
			if(team) System.out.print("Hong: ");
			else System.out.print("Hei: ");
			f1 = in.nextInt();
			f2 = in.nextInt();
			if (!Board.isChe(f1, f2)) {
				System.out.println("No Chess Here");
				continue;
			}
			if(Board.getTeam(f1, f2)==1&&!team||Board.getTeam(f1, f2)==0&&team){
				System.out.println("Not Your Chess");
				continue;
			}
			System.out.println("To Move "+Board.getName(f1, f2));
			System.out.print("move to: ");
			t1 = in.nextInt();
			t2 = in.nextInt();
			if(Board.isChe(t1, t2)&&
					( t1==Board.JX()&&t2==Board.JY()
					||t1==Board.SX()&&t2==Board.SY() ))
				jiang=true;
			Board.setChe(f1, f2, t1, t2);
			if(Board.hasMove&&jiang){
				if(team)System.out.print("HONG ");
				else System.out.print("HEI ");
				System.out.println("WIN");
				break;
			}
			if(Board.F2F()){
				if(!team)System.out.print("HONG ");
				else System.out.print("HEI ");
				System.out.println("WIN");
				break;
			}
			if(!Board.hasMove)continue;
			if(!team&&Board.isShuai(t1, t2)||team&&Board.isJiang(t1, t2))
				System.out.println("JIANG!");
			team = !team;
		}

	}

}