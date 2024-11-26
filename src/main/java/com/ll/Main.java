package com.ll;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // lab1();
        // lab2();
        // lab3();
        lab4();
    }

    // 사람이 직접 입력한 경우
    private static void lab1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("명령) ");
        String cmd = scanner.nextLine().trim();

        System.out.println("입력한 명령: " + cmd);
    }

    // 값을 미리 넣어놓고 출력하는 경우
    private static void lab2() {
        InputStream in = new ByteArrayInputStream("안녕\n잘가".getBytes());

        Scanner scanner = new Scanner(in);

        System.out.println("명령) ");
        String cmd = scanner.nextLine().trim();

        System.out.println("입력한 명령: " + cmd);

        System.out.println("명령) ");
        cmd = scanner.nextLine().trim();

        System.out.println("입력한 명령: " + cmd);
    }

    public static void lab3() {
        System.out.println("안녕하세요.");
    }

    public static void lab4() {
        // 출력이 콘솔로 안나오게 설정
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕하세요.");

        // 다시 콘솔로 나오게 설정
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        System.out.println("출력 : " + output.toString());

        try {
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}