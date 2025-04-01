package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }
    static void run()
    {
        System.out.println("프로그램이 실행됩니다. ");
        MotivationController motivationController = new MotivationController();

        while (true) {
            System.out.print("명령어 입력: ");
            String cmd = sc.nextLine();
            if (cmd.equals("exit")) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            }
            if (cmd.equals("add")) {
                motivationController.add();
            } else if (cmd.equals("list")) {
                motivationController.list();
            } else if (cmd.startsWith("delete")) {
                motivationController.delete();
            } else if (cmd.startsWith("edit")) {
                motivationController.edit();
            }
            else{
                System.out.println("명령어를 다시 입력해주세요");
            }
        }
    }
}
