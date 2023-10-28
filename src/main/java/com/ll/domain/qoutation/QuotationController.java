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
        } else {
            quotes.remove(indexId[0]);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", indexId[1]);
        }
    }

    public void correct(int[] indexId) {
        if (indexId[1] == -1) {
            System.out.println("정확한 id를 입력해주세요.");
            return;
        }
        if (indexId[0] == -1) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", indexId[1]);
        } else {
            System.out.printf("명언(기존): %s\n", quotes.get(indexId[0]).getContent());
            System.out.print("명언: ");
            content = scanner.next();
            quotes.get(indexId[0]).setContent(content);
            System.out.printf("작가(기존): %s\n", quotes.get(indexId[0]).getAuthor());
            System.out.print("작가: ");
            author = scanner.next();
            quotes.get(indexId[0]).setAuthor(author);
            System.out.printf("%d번 명언이 수정되었습니다.\n", indexId[1]);
            scanner.nextLine();
        }
    }

    public int[] getIndexId(int id) {
        int[] indexId = new int[2];
        indexId[0] = -1;
        indexId[1] = id;
        for (int i = 0; i < quotes.size(); i++) {
            if (quotes.get(i).getId() == id) {
                indexId[0] = i;
                break;
            }
        }
        return indexId;
    }

    public void idSort() {
        for (int i = 0; i < quotes.size(); i++) {
            quotes.get(i).setId(i + 1);
        }
        System.out.println("명언 번호가 정렬되었습니다.");
    }

    public void commandList() {
        System.out.print("명령어: 사용 가능한 명령어들을 보여줍니다.\n등록: 새로운 명언을 등록합니다.\n목록: 등록된 명언들을 보여줍니다.\n정렬: 명언 번호를 1부터 오름차순으로 정렬합니다.\n삭제?id=#: #번 명언을 삭제합니다.\n수정?id=#: #번 명언을 수정합니다.\n");
    }
}