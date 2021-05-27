package Funzies.Sudoku;

import java.time.*;

public class Driver {

	public static void main(String[] args) {
		int[][] initialValues = {	{0,0,7,3,0,9,4,0,0},
									{8,0,0,1,0,5,0,0,2},
									{0,0,0,0,4,0,0,0,0},
									{0,8,0,0,6,0,0,5,0},
									{4,0,3,2,0,1,8,0,6},
									{0,1,0,0,5,0,0,9,0},
									{0,0,0,0,2,0,0,0,0},
									{2,0,0,5,0,4,0,0,7},
									{0,0,9,8,0,7,6,0,0}
		};
		
//		Duration tick = Duration.ofMillis(1);
		
//		myClock = Clock.tick(Clock.systemUTC(), tick);
//		Instant startInstant = myClock.instant();
		
		try {
			
			SudokuBoard board = new SudokuBoard(initialValues);
			board.print();
			
			Clock myClock = Clock.systemDefaultZone();
			long start = myClock.millis();
			System.out.println(start);
			
			int failSafe = 0;
			while (!board.isGameOver() && failSafe < 300) {
				int i, j;
				for (i = 0; i < 9; i++) {
					for (j = 0; j < 9; j++) {
						board.calculatePossibleValues(i, j);
					}
				}
				failSafe++;
			}
			//board.calculatePossibleValues(2, 0);
			
			System.out.println("ms taken = " + (myClock.millis() - start));
			System.out.println("Number of full cycles (failSafe) = " + failSafe);
			board.print();
			//board.print();
			
			
		
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		

	}

}
