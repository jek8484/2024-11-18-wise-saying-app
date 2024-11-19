package com.ll;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        App2 app = new App2();
        app.run();
    }
}

class App2 {
    public void run() {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
        }

        scanner.close();
    }
}