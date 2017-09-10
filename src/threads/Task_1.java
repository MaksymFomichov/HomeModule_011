package threads;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Task_1 {
    private int peopleCount;
    private int capacity;
    private static Semaphore semaphore;
    private int countThread;


    public void enterData() {
        System.out.println("Количество людей:");
        peopleCount = checkInt();
        System.out.println("Максимальная вместимость:");
        capacity = checkInt();
        semaphore = new Semaphore(capacity);
        startProgram();
    }

    // создаем потоки
    private void startProgram() {
        for (int i = 1; i <= peopleCount; i++) {
            people(i);
        }
    }

    private void people(int count) {
        new Thread(() -> {
            System.out.println("[" + count + "] человек пришел ко входу в библиотеку");
            try {
                semaphore.acquire();
                countThread++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (countThread > capacity) {
                System.out.println("[" + count + "] человек ждёт входа в библиотеку");
            }
            System.out.println("[" + count + "] вошел в библиотеку");

            int milliseconds = randomMilliseconds();
            System.out.println("[" + count + "] читает книгу " + milliseconds + " милисекунд");
            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[" + count + "] вышел из библиотеки");
            semaphore.release();
            countThread--;
        }).start();
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