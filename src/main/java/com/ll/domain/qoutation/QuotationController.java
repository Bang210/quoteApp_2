package com.ll.domain.qoutation;

import static com.ll.domain.base.App.*;

public class QuotationController {
    private String content;
    private String author;
    public void register() {
        System.out.print("명언: ");
        content = scanner.nextLine();
        System.out.print("작가: ");
        author = scanner.nextLine();
        quotes.add(new Quotation(idCount, content, author));
        System.out.printf("%d번 명언이 등록되었습니다.\n", idCount);
        idCount++;
    }
}