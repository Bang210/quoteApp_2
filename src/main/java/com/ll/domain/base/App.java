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
            System.out.printf("입력된 명령: %s\n", rq.getAction());
            switch (rq.getAction()) {
                case "종료":
                    return;
                case "등록":
                    quotationController.register();
                    break;
                case "목록":
                    quotationController.listup();
                    break;
                case "수정":
                    break;
                case "삭제":
                    quotationController.delete(getIndexId(rq.getId()));
                    break;
                default:
                    System.out.println("잘못된 명령입니다.");
            }
        }
    }

    public int[] getIndexId(int id) {
        int[] indexId = new int[2];
        indexId[0] = -1;
        indexId[1] = id;
        for (int i = 0; i < quotes.size(); i++){
            if (quotes.get(i).getId() == id) {
                indexId[0] = i;
                break;
            }
        }
        return indexId;
    }
}