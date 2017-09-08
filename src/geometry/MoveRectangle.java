package geometry;

import javafx.application.Platform;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class MoveRectangle {

    public static void startMove(int i, List<Rectangle> list) {
        new Thread(() -> {
            int direction = RandomUtils.rndMoveRect();
            while (true) {
                if (list.get(i).getX() + list.get(i).getWidth() >= Main.WIDTH_SCREEN && direction == 2) {
                    direction = 1;
                }

                if (list.get(i).getX() + list.get(i).getWidth() >= Main.WIDTH_SCREEN && direction == 4) {
                    direction = 3;
                }

                if (list.get(i).getX() <= 0 && direction == 1) {
                    direction = 2;
                }

                if (list.get(i).getX() <= 0 && direction == 3) {
                    direction = 4;
                }

                if (list.get(i).getY() + list.get(i).getHeight() >= Main.HEIGHT_SCREEN && direction == 3) {
                    direction = 1;
                }

                if (list.get(i).getY() + list.get(i).getHeight() >= Main.HEIGHT_SCREEN && direction == 4) {
                    direction = 2;
                }

                if (list.get(i).getY() <= 0 && direction == 1) {
                    direction = 3;
                }

                if (list.get(i).getY() <= 0 && direction == 2) {
                    direction = 4;
                }

                switch (direction) {
                    case 1:
                        Platform.runLater(() -> {
                            list.get(i).setX((list.get(i).getX() - 1));
                            list.get(i).setY((list.get(i).getY() - 1));
                        });
                        break;
                    case 2:
                        Platform.runLater(() -> {
                            list.get(i).setX((list.get(i).getX() + 1));
                            list.get(i).setY((list.get(i).getY() - 1));
                        });
                        break;
                    case 3:
                        Platform.runLater(() -> {
                            list.get(i).setX((list.get(i).getX() - 1));
                            list.get(i).setY((list.get(i).getY() + 1));
                        });
                        break;
                    case 4:
                        Platform.runLater(() -> {
                            list.get(i).setX((list.get(i).getX() + 1));
                            list.get(i).setY((list.get(i).getY() + 1));
                        });
                        break;
                }

                try {
                    Thread.sleep(RandomUtils.rndMoveSpeedRect());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
