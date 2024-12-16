package org.example.models;

public class Snake {
    private Integer tail;
    private Integer head;

    public Snake(Integer tail, Integer head) {
        this.tail = tail;
        this.head = head;
    }

    public Integer getTail() {
        return tail;
    }

    public void setTail(Integer tail) {
        this.tail = tail;
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }
}
