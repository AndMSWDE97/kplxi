import main.Board;
import main.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestBoard {
    private Board board;


    @Before
    public void testSetUp() {
        board = new Board(8);
    }

    @Test
    public void testNumberfieldCounting() {
        Configuration.setExampleBoard(board);
        int result = board.getNumberFields().size();
        assertEquals(10, result);
    }

    @Test
    public void testBlackRegionCounting() {
        Configuration.setTestCase1(board);
        ArrayList<Integer> blackFields = board.blackRegionsSurroundingField(1, 1);
        assertEquals(4, blackFields.size());
        assertEquals((Integer) 1, blackFields.get(0));
        board.reset();
        Configuration.setTestCase2(board);
        blackFields = board.blackRegionsSurroundingField(1, 1);
        assertEquals(2, blackFields.size());
        assertEquals((Integer) 3, blackFields.get(0));
    }


}
