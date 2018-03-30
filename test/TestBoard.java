import javafx.scene.layout.GridPane;
import main.Board;
import main.Configuration;
import org.junit.Before;
import org.junit.Test;

public class TestBoard{
    private GridPane gridPane;
    private Board board;


    @Before
    public void testSetUp() {
        gridPane = new GridPane();
        board = new Board(8, gridPane);
    }

    @Test
    public void testNumberfieldCounting() {
        Configuration.setTestCase(board);
    }
}
