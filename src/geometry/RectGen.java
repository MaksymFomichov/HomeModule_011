package geometry;


import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

import static geometry.Main.HEIGHT_SCREEN;
import static geometry.Main.WIDTH_SCREEN;

public class RectGen {
    private static List<Rectangle> rectangleList = new ArrayList<>();

    public static List<Rectangle> generateListRectangle() {
        for (int i = 0; i < RandomUtils.rndCountRect(); i++) {
            int x, y, width, height;
            // делаем координаты такими, чтобы прямоугольники все помещалтсь на экран
            do {
                x = RandomUtils.rndX();
                y = RandomUtils.rndY();
                height = RandomUtils.rndHeightRect();
                width = RandomUtils.rndWidthRect();
            } while ((x + width) > WIDTH_SCREEN != (y + height) > HEIGHT_SCREEN);
            Rectangle rectangle = new Rectangle();
            rectangle.setFill(Paint.valueOf(RandomUtils.rndColor()));
            rectangle.setX(x);
            rectangle.setY(y);
            rectangle.setHeight(height);
            rectangle.setWidth(width);
            rectangleList.add(rectangle);
        }
        System.out.println(rectangleList.size());


        return rectangleList;
    }

    public static List<Rectangle> getRectList() {
        return rectangleList;
    }
}
