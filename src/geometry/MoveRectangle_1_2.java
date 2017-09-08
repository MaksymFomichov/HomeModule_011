package geometry;

import javafx.application.Platform;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class MoveRectangle_1_2 {

    public static void startMoveMulty(int i, List<Rectangle> list) {
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

    public static void startMoveSingle(List<Rectangle> list) {
        final int[] temp = {0};
        final int[] direction = new int[list.size()];

        new Thread(() -> {
            while (true) {
                for (int i = 0; i < list.size(); i++) {
                    // задаем начальные направления
                    if (temp[0] < list.size()) {
                        direction[i] = RandomUtils.rndMoveRect();
                        System.out.println((i + 1) + " прямоугольник - направление " + direction[i]);
                        temp[0]++;
                    }

                    System.out.println(i + " " + list.get(i).getWidth() + " x=" + list.get(i).getX() + ", y=" + list.get(i).getY());

                    if (list.get(i).getX() + list.get(i).getWidth() >= Main.WIDTH_SCREEN && direction[i] == 2) {
                        direction[i] = 1;
                    }

                    if (list.get(i).getX() + list.get(i).getWidth() >= Main.WIDTH_SCREEN && direction[i] == 4) {
                        direction[i] = 3;
                    }

                    if (list.get(i).getX() <= 0 && direction[i] == 1) {
                        direction[i] = 2;
                    }

                    if (list.get(i).getX() <= 0 && direction[i] == 3) {
                        direction[i] = 4;
                    }

                    if (list.get(i).getY() + list.get(i).getHeight() >= Main.HEIGHT_SCREEN && direction[i] == 3) {
                        direction[i] = 1;
                    }

                    if (list.get(i).getY() + list.get(i).getHeight() >= Main.HEIGHT_SCREEN && direction[i] == 4) {
                        direction[i] = 2;
                    }

                    if (list.get(i).getY() <= 0 && direction[i] == 1) {
                        direction[i] = 3;
                    }

                    if (list.get(i).getY() <= 0 && direction[i] == 2) {
                        direction[i] = 4;
                    }

                    switch (direction[i]) {
                        case 1:
                            int final1 = i;
                            Platform.runLater(() -> {
                                list.get(final1).setX((list.get(final1).getX() - 1));
                                list.get(final1).setY((list.get(final1).getY() - 1));
                            });
                            break;
                        case 2:
                            int finalI2 = i;
                            Platform.runLater(() -> {
                                list.get(finalI2).setX((list.get(finalI2).getX() + 1));
                                list.get(finalI2).setY((list.get(finalI2).getY() - 1));
                            });
                            break;
                        case 3:
                            int finalI3 = i;
                            Platform.runLater(() -> {
                                list.get(finalI3).setX((list.get(finalI3).getX() - 1));
                                list.get(finalI3).setY((list.get(finalI3).getY() + 1));
                            });
                            break;
                        case 4:
                            int finalI4 = i;
                            Platform.runLater(() -> {
                                list.get(finalI4).setX((list.get(finalI4).getX() + 1));
                                list.get(finalI4).setY((list.get(finalI4).getY() + 1));
                            });
                            break;
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }
}
