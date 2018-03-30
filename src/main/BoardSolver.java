package main;

import javafx.application.Platform;

import java.util.ArrayList;

public class BoardSolver {

    private ArrayList<ArrayList<Boolean>> notWorking;

    public BoardSolver() {
        notWorking = new ArrayList<>();
    }

    public void setUpProbabilities(Board board) {
        Field[][] fields = board.getBoard();
        
        board.resetProbabilities();
        for (Field numberField : board.getNumberFields()) {
            int[] numbers = numberField.getNumbers();
            int y = numberField.getY();
            int x = numberField.getX();
            for (int i = y - 1; i <= y + 1; i++) {
                for (int j = x - 1; j <= x + 1; j++) {
                    //check for out of Bounds
                    if (!(i < 0 || j < 0 || i >= fields.length || j >= fields[i].length)) {
                        int currentProbability = fields[i][j].getProbability();
                        for (int k = 0; k < numbers.length; k++) {
                            currentProbability += numbers[k];
                        }
                        currentProbability -= (numbers.length - 1);
                        fields[i][j].setProbability(currentProbability);
                    }
                }
            }
        }
    }

    public void solveBoard(Board board, GridPaneControler gridPaneControler) {
        setUpProbabilities(board);
        
        Field[][] fields = board.getBoard();

        ArrayList<Field> allFields = new ArrayList<>();
        for (int y = 0; y < fields.length; y++) {
            for (int x = 0; x < fields[y].length; x++) {
                if (!fields[y][x].isNumberField()) {
                    allFields.add(fields[y][x]);
                }
            }
        }
        allFields.sort((a, b) -> b.getProbability() - a.getProbability());

        Thread thread = new Thread( () -> {
            for (Field field : allFields) {
                field.setFilled(true);

                boolean itWorked = solveStep(board, gridPaneControler);

                if (itWorked) {
                    Platform.runLater(() -> gridPaneControler.updateGrid(board));
                    return;
                } else {
                    field.setFilled(false);
                }
            }
        });
        thread.start();

    }

    private boolean solveStep(Board board, GridPaneControler gridPaneControler) {
        if (boardInNotWorking(board)) return false;
        Platform.runLater(() -> gridPaneControler.updateGrid(board));
        if (board.numberOfUnfullfilledFields() == 0) {
            return true;
        }
        ArrayList<Field> possibleFields = board.findPossibleFields();
        possibleFields.sort((a, b) -> b.getProbability() - a.getProbability());
        for (Field field : possibleFields) {
            field.setFilled(true);
            if (!errorInBoard(board)) {
                boolean result = solveStep(board, gridPaneControler);
                if (result) return true;
            }
            field.setFilled(false);
        }
        boardToNotWorking(board);
        return false;
    }

    private boolean errorInBoard(Board board) {
        Field[][] fields = board.getBoard();
        
        //check that no 2x2 area is all black
        for (int y = 0; y < fields.length - 1; y++) {
            for (int x = 0; x < fields[y].length - 1; x++) {
                if (fields[y][x].isFilled()
                        && fields[y + 1][x].isFilled()
                        && fields[y][x + 1].isFilled()
                        && fields[y + 1][x + 1].isFilled()) {
                    return true;
                }
            }
        }

        //test each number field
        for (Field numberField : board.getNumberFields()) {
            int[] numbers = numberField.getNumbers();
            int y = numberField.getY();
            int x = numberField.getX();
            if (numbers.length > 1) {
                ArrayList<Integer> blackRegions = board.blackRegionsSurroundingField(x, y);
                for (int i = 0; i < numbers.length; i++) {
                    Integer foundLargestRegion = null;
                    for (Integer region : blackRegions) {
                        if (region <= numbers[i]) {
                            if (foundLargestRegion == null || region > foundLargestRegion)
                                foundLargestRegion = region;
                        }
                    }
                    if (foundLargestRegion != null) {
                        blackRegions.remove(foundLargestRegion);
                    }
                }
                if (blackRegions.size() != 0) return true;
            } else {
                int countBlack = board.numberOfBlackFieldsSurrounding(x, y);
                if (countBlack > numbers[0]) {
                    return true;
                }
            }
        }

        return false;
    }

    private void boardToNotWorking(Board board) {
        notWorking.add(board.getCurrentBoardState());
    }

    private boolean boardInNotWorking(Board board) {
        for(ArrayList<Boolean> errorState : notWorking) {
            if (errorState.equals(board.getCurrentBoardState())) {
                return true;
            }
        }
        return false;
    }
}
