package main;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class GridPaneControler {
    
    private GridPane gridPane;
    
    public GridPaneControler(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void updateGrid(Board board) {
        Field[][] fields = board.getBoard();
        gridPane.getChildren().clear();
        for (int y = 0; y < fields.length; y++) {
            for (int x = 0; x < fields[y].length; x++) {
                Label label = new Label();
                label.setMinSize(40, 40);
                label.setTextAlignment(TextAlignment.CENTER);
                label.setAlignment(Pos.CENTER);
                label.setFont(new Font("arial", 20));
                label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
                if (fields[y][x].isNumberField()) {
                    int[] numbers = fields[y][x].getNumbers();
                    for (int i = 0; i < numbers.length - 1; i++) {
                        label.setText(label.getText().concat(numbers[i] + ", "));
                    }
                    label.setText(label.getText().concat(numbers[numbers.length - 1] + ""));
                    label.setStyle("-fx-background-color: lightgrey");
                } else {
                    if (fields[y][x].isFilled()) {
                        if (board.numberOfUnfullfilledFields() == 0) {
                            label.setStyle("-fx-background-color: green");
                        } else {
                            label.setStyle("-fx-background-color: black");
                        }
                    } else {
                        label.setStyle("-fx-background-color: white");
                    }
                }
                gridPane.add(label, x, y);
            }
        }

        gridPane.setAlignment(Pos.CENTER);
    }
}
