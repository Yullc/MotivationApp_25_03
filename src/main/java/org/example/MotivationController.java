package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotivationController {
    Scanner sc = new Scanner(System.in);
    int lastId = 0;
    List<Motivation> motivations = new ArrayList<Motivation>();
    String cmd = sc.nextLine();
    void add(){
        int id = lastId + 1;
        System.out.println("===글쓰기===");
        System.out.print("내용 입력: ");
        String body = sc.nextLine();
        System.out.print("소스 입력: ");
        String source = sc.nextLine();
        Motivation motivation = new Motivation(id, body, source);

        motivations.add(motivation);
        System.out.println(id + "번 글 쓰기 완료.");
        lastId++;
    }
    void delete(){
        int id = Integer.parseInt(cmd.split(" ")[1]);
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                motivations.remove(motivation);
                System.out.println(id + "번 글이 삭제되었습니다.");
                break;
            }
        }
    }
    void edit(){
        int id = Integer.parseInt(cmd.split(" ")[1]);
        System.out.print("새로운 내용 입력: ");
        String newbody = sc.nextLine();
        System.out.print("새로운 소스 입력: ");
        String newsource = sc.nextLine();
        for (int i = 0; i < motivations.size(); i++) {
            Motivation motivation = motivations.get(i);
            if (motivation.getId() == id) {
                System.out.println(id + "번 글이 수정 되었습니다.");
                motivations.set(i, new Motivation(id, newbody, newsource));
                break;
            }
        }
    }
    void list(){
        System.out.println("=== 글 목록 ===\n");
        for (int i = motivations.size() - 1; i >= 0; i--) {
            System.out.printf("   %d   /   %s   /   %s\n", motivations.get(i).getId(), motivations.get(i).getBody(), motivations.get(i).getSource());
        }
    }
}
