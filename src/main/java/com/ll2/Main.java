package com.ll2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {
    private Scanner scanner;
    private int lastId;
    private WiseSaying[] wiseSayings;
    private int wiseSayingsSize;

    public App() {
        scanner = new Scanner(System.in);
        lastId = 0;
        wiseSayings = new WiseSaying[3];
        wiseSayingsSize = 0;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        addWiseSaying("이순신 명언", "이순신 작가");
        addWiseSaying("키케로 명언", "키케로 작가");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd();
            } else if (cmd.equals("목록")) {
                actionList();
            }
        }

        scanner.close();
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = 0; i < wiseSayingsSize; i++) {
            WiseSaying wiseSaying = wiseSayings[i];
            System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.author, wiseSaying.content));
        }
    }

    private void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying wiseSaying = addWiseSaying(content, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.id));
    }

    private WiseSaying addWiseSaying(String content, String author) {
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings[wiseSayingsSize] = wiseSaying;
        wiseSayingsSize++;

        return wiseSaying;
    }
}

class WiseSaying extends Object {
    public int id;
    public String content;
    public String author;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "WiseSaying (id=%d, content=\"%s\", author=\"%s\")".formatted(id, content, author);
    }
}