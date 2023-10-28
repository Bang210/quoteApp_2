package com.ll.domain.qoutation;

import static com.ll.domain.base.App.*;

public class QuotationController {
    private String content;
    private String author;
    public void register() {
        //등록 명령 실행
        System.out.print("명언: ");
        content = scanner.nextLine();
        System.out.print("작가: ");
        author = scanner.nextLine();
        quotes.add(new Quotation(idCount, content, author));
        System.out.printf("%d번 명언이 등록되었습니다.\n", idCount);
        idCount++;
    }

    public void listup() {
        //목록 명령 실행
        System.out.print("번호 / 작가 / 명언\n--------------------------\n");
        for (int i = 0; i < quotes.size(); i++) {
            System.out.printf("%d / %s / %s\n", quotes.get(i).getId(), quotes.get(i).getAuthor(), quotes.get(i).getContent());
        }
    }

    public void delete(int[] indexId) {
        if (indexId[1] == -1) {
            System.out.println("정확한 id를 입력해주세요.");
            return;
        }
        if (indexId[0] == -1) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", indexId[1]);
        }
        else {
            quotes.remove(indexId[0]);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", indexId[1]);
        }
    }
}