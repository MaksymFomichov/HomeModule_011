package geometry;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH_SCREEN = 960;
    public static final int HEIGHT_SCREEN = 540;
    public static final int MAX_WIDTH_RECT = WIDTH_SCREEN / 4;
    public static final int MAX_HEIGHT_RECT = HEIGHT_SCREEN / 4;
    public static final int MIN_WIDTH_RECT = 10;
    public static final int MIN_HEIGHT_RECT = 10;
    private static Pane root;
    private int sizeCount = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_SCREEN);
        primaryStage.setHeight(HEIGHT_SCREEN);

        Button btnMultiThreads = new Button();
        btnMultiThreads.setTranslateX(10);
        btnMultiThreads.setTranslateY(10);
        btnMultiThreads.setText("Multi Threads");

        Button btnSingleThread = new Button();
        btnSingleThread.setTranslateX(10);
        btnSingleThread.setTranslateY(40);
        btnSingleThread.setText("Single Thread");

        Button btnOptimalThreads = new Button();
        btnOptimalThreads.setTranslateX(10);
        btnOptimalThreads.setTranslateY(70);
        btnOptimalThreads.setText("Optimal Threads");

        root = new Pane();
        root.getChildren().addAll(btnMultiThreads, btnSingleThread, btnOptimalThreads);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Геометрия в движении");
        primaryStage.show();

        btnMultiThreads.setOnMouseClicked((MouseEvent event) -> {
            root.getChildren().clear();
            root.getChildren().addAll(btnMultiThreads, btnSingleThread, btnOptimalThreads);
            root.getChildren().addAll(RectGen.generateListRectangle());
            for (int i = sizeCount; i < RectGen.getRectList().size(); i++) {
                MoveRectangle.startMove(i, RectGen.getRectList());
            }
            sizeCount = RectGen.getRectList().size();
        });

        btnSingleThread.setOnMouseClicked(event -> {

        });

        btnOptimalThreads.setOnMouseClicked(event -> {

        });
    }
}
