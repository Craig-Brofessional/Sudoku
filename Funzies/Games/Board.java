package Funzies.Games;

public interface Board {
	
	public boolean isGameOver();
	public Object getTile(int x, int y);
	public int getRows();
	public int getCols();
	public void print();
}
