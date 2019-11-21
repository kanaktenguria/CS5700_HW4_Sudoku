import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class HumanKindTest {
    @Test
    public void humanKindTestSolve() throws IOException {
        ValidityChecker validityChecker = new ValidityChecker("HKTestInput.txt",null);
        String board[][]= validityChecker.getSudokuBoard();
        HumanKind humanKind= new HumanKind(board);
        assertEquals(humanKind.getSize(),board[0].length);
        humanKind.solveSudoku();
        assertEquals(humanKind.getHumanKindCount(),1);
    }
}