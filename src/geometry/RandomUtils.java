package geometry;

import javafx.scene.paint.Color;

import java.util.Random;

import static geometry.Main.*;

public class RandomUtils {

    // получаем рандомное количество прямоугольников
    public static int rndCountRect() {
        return (int) (3 + (Math.random() * 7));
    }

    // получаем рандомную x координату
    public static int rndX() {
        return (int) (0 + (Math.random() * WIDTH_SCREEN));
    }

    // получаем рандомную x координату
    public static int rndY() {
        return (int) (0 + (Math.random() * HEIGHT_SCREEN));
    }

    // получаем рандомную ширину прямоугольника
    public static int rndWidthRect() {
        return (int) (MIN_WIDTH_RECT + (Math.random() * MAX_WIDTH_RECT));
    }

    // получаем рандомную сторону прмоугольника
    public static int getSide(int max) {
        return (int) (1 + (Math.random() * (max - 1)));
    }

    // получаем рандомную высоту прямоугольника
    public static int rndHeightRect() {
        return (int) (MIN_HEIGHT_RECT + (Math.random() * MAX_HEIGHT_RECT));
    }

    // получаем рандомный цвет
    public static String rndColor() {
        Random random = new Random();
        Color color = Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 0.5f);
        return color.toString();
    }

    // получаем рандомное напрвление
    public static int rndMoveRect() {
        return (int) (1 + (Math.random() * 3));
    }

    // получаем рандомное ускорение
    public static int rndMoveSpeedRect() {
        return (int) (1 + (Math.random() * 10));
    }
}
