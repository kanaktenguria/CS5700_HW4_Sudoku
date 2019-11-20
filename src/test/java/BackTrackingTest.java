import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BackTrackingTest {
    @Test
    public void  testBackTracking() throws IOException {
        SudokuSolver sudokuSolver = new SudokuSolver("backtrackTestInput.txt",null);
        String board[][]=sudokuSolver.getSudokuBoard();
        BackTracking backTracking= new BackTracking(board);
        assertEquals(backTracking.getSize(),board[0].length);
        backTracking.solveSudoku();
        assertEquals(backTracking.getBackTrackingCount(),206);
    }
}