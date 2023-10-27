package com.ll.domain.base;

import com.ll.domain.qoutation.Quotation;
import com.ll.domain.qoutation.QuotationController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static List<Quotation> quotes = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    private static QuotationController quotationController = new QuotationController();
    public static int idCount = 1;
    public void run() {
        //초기 출력
        System.out.println("==명언 앱==");
        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            Rq rq = new Rq(cmd);
            switch (rq.getAction()) {
                case "종료":
                    return;
                case "등록":
                    quotationController.register();
                    break;
                case "목록":
                    break;
                case "수정":
                    break;
                case "삭제":
                    break;
            }
        }
    }
}