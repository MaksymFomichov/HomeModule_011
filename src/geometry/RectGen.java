package geometry;


import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

import static geometry.Main.HEIGHT_SCREEN;
import static geometry.Main.WIDTH_SCREEN;

public class RectangleGenerate {
    private static List<Rectangle> rectangleList = new ArrayList<>();

    public static List<Rectangle> generateListRectangle() {
        for (int i = 0; i < RandomUtils.randomRectangle(); i++) {
            int x, y, width, height;
            // делаем координаты такими, чтобы прямоугольники все помещалтсь на экран
            do {
                x = RandomUtils.randomX();
                y = RandomUtils.randomY();
                height = RandomUtils.randomHeightRectangle();
                width = RandomUtils.randomWidthRectangle();
            } while ((x + width) > WIDTH_SCREEN != (y + height) > HEIGHT_SCREEN);
                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Paint.valueOf(RandomUtils.randomColor()));
                rectangle.setX(x);
                rectangle.setY(y);
                rectangle.setHeight(height);
                rectangle.setWidth(width);
            rectangleList.add(rectangle);
        }
        return rectangleList;
    }

    public static List<Rectangle> getRectangleList() {
        return rectangleList;
    }
}
