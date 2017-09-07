package threads;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Task_2 {
    private int peopleCount;
    private Semaphore semaphoreLibrary;
    private Semaphore semaphoreDoorIn;
    private Semaphore semaphoreDoorOut;
    private final int TIME_DOOR = 500;

    public void enterData() {
        System.out.println("Количество людей:");
        peopleCount = checkInt();
        System.out.println("Максимальная вместимость:");
        semaphoreLibrary = new Semaphore(checkInt());
        semaphoreDoorIn = new Semaphore(1);
        semaphoreDoorOut = new Semaphore(1);
        startProgram();
    }

    // создаем людей
    private void startProgram() {
        for (int i = 1; i <= peopleCount; i++) {
            people(i);
        }
    }

    private void people(int count) {
        new Thread(() -> {
            System.out.println("[" + count + "] человек пришел ко входу в библиотеку");
            try {
                semaphoreLibrary.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doorIn(count);
            System.out.println("[" + count + "] вошел в библиотеку");
            int milliseconds = randomMilliseconds();
            System.out.println("[" + count + "] читает книгу " + milliseconds + " милисекунд");
            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doorOut(count);
            System.out.println("[" + count + "] вышел из библиотеки");
            semaphoreLibrary.release();
        }).start();
    }

    private void doorIn(int count) {
        System.out.println("[" + count + "] подошел к двери с улицы");
        try {
            semaphoreDoorIn.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + count + "] проходит через дверь внутрь");
        try {
            Thread.sleep(TIME_DOOR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + count + "] прошел через дверь внутрь");
        semaphoreDoorIn.release();
    }

    private void doorOut(int count) {
        System.out.println("[" + count + "] подошел к двери с изнутри");
        try {
            semaphoreDoorOut.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + count + "] проходит через дверь наружу");
        try {
            Thread.sleep(TIME_DOOR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[" + count + "] прошел через дверь наружу");
        semaphoreDoorOut.release();
    }

    // проверяем на целое число и на больше 0
    private int checkInt() {
        Scanner sc = new Scanner(System.in);
        int value = 0;
        while (true) {
            try {
                int tempValue = sc.nextInt();
                if (tempValue > 0) {
                    value = tempValue;
                    sc.nextLine();
                } else {
                    System.out.println("Число должно быть больше 0!\nПовторите ввод:");
                    sc.nextLine();
                    checkInt();
                }
                break;
            } catch (Exception e) {
                System.out.println("Только целое число!\nПовторите ввод:");
                sc.nextLine();
            }
        }
        return value;
    }

    // получаем рандомное количество миллисекунд
    private int randomMilliseconds() {
        int minMillisecond = 1000;
        int maxMillisecond = 4000;
        return (int) (minMillisecond + (Math.random() * maxMillisecond));
    }
}