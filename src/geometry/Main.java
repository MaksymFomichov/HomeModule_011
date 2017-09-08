package geometry;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
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
        btnOptimalThreads.setTranslateY(160);
        btnOptimalThreads.setText("Optimal Threads");

        Text textMinRect = new Text();
        textMinRect.setTranslateX(10);
        textMinRect.setTranslateY(200);
        textMinRect.setText("максимальная высота прямоугольника");
        TextField minRect = new TextField();
        minRect.setTranslateX(10);
        minRect.setTranslateY(205);
        minRect.setText("100");

        Text textMaxRect = new Text();
        textMaxRect.setTranslateX(10);
        textMaxRect.setTranslateY(240);
        textMaxRect.setText("максимальная ширина прямоугольнка");
        TextField maxWidth = new TextField();
        maxWidth.setTranslateX(10);
        maxWidth.setTranslateY(245);
        maxWidth.setText("100");

        Text texMaxHeight = new Text();
        texMaxHeight.setTranslateX(10);
        texMaxHeight.setTranslateY(200);
        texMaxHeight.setText("максимальная высота прямоугольника");
        TextField maxHeight = new TextField();
        maxHeight.setTranslateX(10);
        maxHeight.setTranslateY(205);
        maxHeight.setText("100");

        Text textMaxWidth = new Text();
        textMaxWidth.setTranslateX(10);
        textMaxWidth.setTranslateY(240);
        textMaxWidth.setText("максимальная ширина прямоугольнка");
        TextField maxWidth = new TextField();
        maxWidth.setTranslateX(10);
        maxWidth.setTranslateY(245);
        maxWidth.setText("100");


        root = new Pane();
        root.getChildren().addAll(btnMultiThreads, btnSingleThread, btnOptimalThreads, texMaxHeight, maxHeight, textMaxWidth, maxWidth);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Геометрия в движении");
        primaryStage.show();

        btnMultiThreads.setOnMouseClicked((MouseEvent event) -> {
            root.getChildren().clear();
            root.getChildren().addAll(btnMultiThreads, btnSingleThread, btnOptimalThreads, texMaxHeight, maxHeight, textMaxWidth, maxWidth);
            root.getChildren().addAll(RectGen.generateListRectangle());
            // передаем только созданные прямоугольники, старые отсекаем
            for (int i = sizeCount; i < RectGen.getRectList().size(); i++) {
                MoveRectangle_1_2.startMoveMulty(i, RectGen.getRectList());
            }
            sizeCount = RectGen.getRectList().size();
        });

        btnSingleThread.setOnMouseClicked(event -> {
            root.getChildren().clear();
            root.getChildren().addAll(btnMultiThreads, btnSingleThread, btnOptimalThreads, texMaxHeight, maxHeight, textMaxWidth, maxWidth);
            root.getChildren().addAll(RectGen.generateListRectangle());
            MoveRectangle_1_2.startMoveSingle(RectGen.getRectList());
        });

        btnOptimalThreads.setOnMouseClicked(event -> {
            root.getChildren().clear();
            root.getChildren().addAll(btnMultiThreads, btnSingleThread, btnOptimalThreads, texMaxHeight, maxHeight, textMaxWidth, maxWidth);
            root.getChildren().addAll(RectGen.generateListRectangle());
            int height = Integer.parseInt(maxHeight.getText());
            int width = Integer.parseInt(maxWidth.getText());
            int countCore = Runtime.getRuntime().availableProcessors();
        });
    }
}
