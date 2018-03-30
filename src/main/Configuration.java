package main;

public class Configuration {

    public static void setExampleBoard(Board board) {
        try {
            board.setNumberField(2, 1, new int[]{3});
            board.setNumberField(7, 1, new int[]{2});
            board.setNumberField(4, 2, new int[]{1, 5});
            board.setNumberField(6, 2, new int[]{5});
            board.setNumberField(1, 3, new int[]{3});
            board.setNumberField(5, 4, new int[]{3, 3});
            board.setNumberField(2, 5, new int[]{4});
            board.setNumberField(7, 5, new int[]{3});
            board.setNumberField(4, 6, new int[]{2, 3});
            board.setNumberField(6, 7, new int[]{2});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setTenByTenBoard(Board board) {
        try {
            board.setNumberField(1, 1, new int[]{2});
            board.setNumberField(4, 1, new int[]{1});
            board.setNumberField(7, 1, new int[]{3});
            board.setNumberField(9, 2, new int[]{3});
            board.setNumberField(1, 3, new int[]{3});
            board.setNumberField(4, 3, new int[]{4});
            board.setNumberField(7, 3, new int[]{5});
            board.setNumberField(9, 4, new int[]{2, 2});
            board.setNumberField(0, 5, new int[]{3});
            board.setNumberField(2, 6, new int[]{4});
            board.setNumberField(5, 6, new int[]{5});
            board.setNumberField(8, 6, new int[]{6});
            board.setNumberField(0, 7, new int[]{5});
            board.setNumberField(2, 8, new int[]{6});
            board.setNumberField(5, 8, new int[]{8});
            board.setNumberField(8, 8, new int[]{7});
        } catch (IndexOutOfBoundsException e) {
            System.out.println("board not large enough");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setSolutionForExampleBoard(Board board) {
        board.getBoard()[0][2].setFilled(true);
        board.getBoard()[0][3].setFilled(true);
        board.getBoard()[0][4].setFilled(true);
        board.getBoard()[0][5].setFilled(true);
        board.getBoard()[0][6].setFilled(true);
        board.getBoard()[0][7].setFilled(true);
        board.getBoard()[1][3].setFilled(true);
        board.getBoard()[1][5].setFilled(true);
        board.getBoard()[2][5].setFilled(true);
        board.getBoard()[3][3].setFilled(true);
        board.getBoard()[3][4].setFilled(true);
        board.getBoard()[3][5].setFilled(true);
        board.getBoard()[3][6].setFilled(true);
        board.getBoard()[3][7].setFilled(true);
        board.getBoard()[4][0].setFilled(true);
        board.getBoard()[4][1].setFilled(true);
        board.getBoard()[4][2].setFilled(true);
        board.getBoard()[4][3].setFilled(true);
        board.getBoard()[5][0].setFilled(true);
        board.getBoard()[5][3].setFilled(true);
        board.getBoard()[5][4].setFilled(true);
        board.getBoard()[5][5].setFilled(true);
        board.getBoard()[5][6].setFilled(true);
        board.getBoard()[6][0].setFilled(true);
        board.getBoard()[6][6].setFilled(true);
        board.getBoard()[6][7].setFilled(true);
        board.getBoard()[7][0].setFilled(true);
        board.getBoard()[7][1].setFilled(true);
        board.getBoard()[7][2].setFilled(true);
        board.getBoard()[7][3].setFilled(true);
        board.getBoard()[7][4].setFilled(true);
    }

    public static void setTestCase1(Board board) {
        board.getBoard()[0][0].setFilled(true);
        board.getBoard()[2][0].setFilled(true);
        board.getBoard()[0][2].setFilled(true);
        board.getBoard()[2][2].setFilled(true);
    }

    public static void setTestCase2(Board board) {
        board.getBoard()[0][0].setFilled(true);
        board.getBoard()[0][1].setFilled(true);
        board.getBoard()[1][0].setFilled(true);
        board.getBoard()[2][1].setFilled(true);
        board.getBoard()[1][2].setFilled(true);
        board.getBoard()[2][2].setFilled(true);
    }
}
