import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class OnePossibleSolutionTest {
    @Test
    public void onepossibleSolutionSolve() throws IOException {
        SudokuSolver sudokuSolver = new SudokuSolver("OPSTestInput.txt",null);
        String board[][]=sudokuSolver.getSudokuBoard();
        OnePossibleSolution onePossibleSolution= new OnePossibleSolution(board);
        assertEquals(onePossibleSolution.getSize(),board[0].length);
        onePossibleSolution.solveSudoku();
        assertEquals(2,onePossibleSolution.getOnePossibleSolutionCount());
    }
}