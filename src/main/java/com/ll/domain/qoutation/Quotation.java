package com.ll.domain.qoutation;

public class Quotation {
    private int id;
    private String author;
    private String content;

    public Quotation(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        //id값 반환
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getContent() {
        //명언 반환
        return content;
    }

    public void setContent(String content) {
        //명언 수정
        this.content = content;
    }

    public String getAuthor() {
        //작가 반환
        return author;
    }

    public void setAuthor(String author) {
        //작가 수정
        this.author = author;
    }
}