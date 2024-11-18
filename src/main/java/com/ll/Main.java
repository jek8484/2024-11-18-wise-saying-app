package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);
        String cmd = "";

        int id = 0; // 번호
        String mu = ""; // 명언
        String jk = ""; // 작가

        List<App> appList = new ArrayList<App>();

        try {
            while (true) {
                System.out.print("명령) ");
                cmd = scanner.nextLine().trim();

                if ("종료".equals(cmd)) break;
                else if ("등록".equals(cmd)) {
                    id++;
                    System.out.print("명언 : ");
                    mu = scanner.nextLine().trim();
                    System.out.print("작가 : ");
                    jk = scanner.nextLine().trim();

                    App app = new App(id, mu, jk);
                    appList.add(app);

                    System.out.println(id + "번 명언이 등록되었습니다.");
                }
                else if ("목록".equals(cmd)) {
                    if (isEmpty(appList)) continue;

                    System.out.println("번호  /   명언  /   작가");
                    System.out.println("------------------------");

                    for (App a : appList) {
                        System.out.printf("%d / %s / %s\n", a.getId(), a.getMu(), a.getJk());
                    }
                }
                else if (cmd.contains("삭제")) {
                    if (isEmpty(appList)) continue;

                    int dId = checkParams(cmd);
                    if (dId < 0) continue; // 숫자 파라미터 검증

                    // 삭제 처리
                    boolean isDel = false;
                    for (int i = 0; i < appList.size(); i++) {
                        App a = appList.get(i);

                        if (dId == a.getId()) {
                            appList.remove(i);
                            isDel = true;
                        }
                    }

                    if (isDel) {
                        System.out.println(dId + "번 명언이 삭제되었습니다.");
                    } else {
                        System.out.println(dId + "번 명언은 존재하지 않습니다.");
                    }
                }
                else if (cmd.contains("수정")) {
                    if (isEmpty(appList)) continue;

                    int dId = checkParams(cmd);
                    if (dId < 0) continue; // 숫자 파라미터 검증

                    // 수정 처리
                    boolean isMod = false;
                    for (int i = 0; i < appList.size(); i++) {
                        App a = appList.get(i);

                        if (dId == a.getId()) {
                            System.out.println("명언(기존) : " + a.getMu());
                            System.out.print("명언(신규) : ");
                            mu = scanner.nextLine().trim();

                            System.out.println("작가(기존) : " + a.getJk());
                            System.out.print("작가(신규) : ");
                            jk = scanner.nextLine().trim();

                            appList.set(i, new App(dId, mu, jk));

                            isMod = true;

                            break;
                        }
                    }

                    if (isMod) {
                        System.out.println(dId + "번 명언이 수정되었습니다.");
                    } else {
                        System.out.println(dId + "번 명언은 존재하지 않습니다.");
                    }
                }
            }
        } finally {
            scanner.close();
        }

        System.out.println("종료되었습니다");
    }

    // 빈 리스트인지 검증
    private static boolean isEmpty(List<App> list) {
        if (list.size() < 1) {
            System.out.println("등록된 명언이 없습니다.");
            return true;
        }
        else return false;
    }

    // 숫자 파라메타 검증
    private static int checkParams(String cmd) {
        String[] s = cmd.split("=");
        int id = 0;

        if (s.length < 2) {
            System.out.println("삭제?id=1 or 수정?id=1 형식으로 써주세요.");
            return -1;
        } else {
            try {
                id = Integer.parseInt(s[1]);
            } catch (NumberFormatException e) {
                System.out.println("유효하지 않은 숫자 형식입니다 : " + s[1]);
                return -1;
            }
        }

        return id;
    }
}