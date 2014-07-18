public abstract class ChessPiece implements Movable {

	private int x, y, team;
	private String name;

	public ChessPiece(int a, int b, String n, int t) {
		x = a;
		y = b;
		name = n;
		team = t;
	}

	public void setLocation(int x1, int y1) throws IllExc{
		if (x1 < 0 || y1 < 0 || x1 > 9 || y1 > 8) {
			throw new IllExc("Out of Edge");
		}
		if (x1 == x && y1 == y) {
			throw new IllExc("Did not move");
		}
		if (isLegal(x, y, x1, y1)) {
			if(Board.isChe(x1, y1)&&Board.getTeam(x1, y1)==Board.getTeam(x, y)){
				throw new IllExc("Ate Yourself");
			}
			x = x1;
			y = y1;
			System.out.println("ok Move " + name + " to " + x + " " + y);
			return ;
		}
		throw new IllExc("Invalid Route");
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getTeam() {
		return team;
	}

	public String getName(){
		return name;
	}
	
	public abstract boolean isLegal(int x, int y, int x1, int y1);

}
