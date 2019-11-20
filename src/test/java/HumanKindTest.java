import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class HumanKindTest {
    @Test
    public void humanKindTestSolve() throws IOException {
        SudokuSolver sudokuSolver = new SudokuSolver("HKTestInput.txt",null);
        String board[][]=sudokuSolver.getSudokuBoard();
        HumanKind humanKind= new HumanKind(board);
        assertEquals(humanKind.getSize(),board[0].length);
        humanKind.solveSudoku();
        assertEquals(humanKind.getHumanKindCount(),1);
    }
}