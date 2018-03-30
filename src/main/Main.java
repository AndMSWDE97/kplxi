package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    GridPane grid;
    GridPaneControler gridPaneControler;
    Board board;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tapa solver");
        Button button = new Button("solve");
        button.setOnAction(e -> BoardSolver.solveBoard(board, gridPaneControler));


        grid = new GridPane();
        gridPaneControler = new GridPaneControler(grid);
        board = new Board(8);

        Configuration.setExampleBoard(board);

        gridPaneControler.updateGrid(board);

        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(20);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(grid, button);

        Scene scene = new Scene(layout, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
