import main.Board;
import main.BoardSolver;
import main.Configuration;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBoardSolver {

    private BoardSolver boardSolver;
    private Board board;

    @Before
    public void testSetUp() {
        board = new Board(8);
        boardSolver = new BoardSolver();
    }

    @Test
    public void testUnfulfilledFieldCounting() {
        Configuration.setExampleBoard(board);
        Configuration.setSolutionForExampleBoard(board);
        int unfulfilledFields = boardSolver.numberOfUnfulfilledFields(board);
        assertEquals(0, unfulfilledFields);
    }
}
