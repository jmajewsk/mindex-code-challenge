package com.mindex.challenge.data.reporting_structure;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    public Node<T> parent;
    public List<Node<T>> children;
    public T item;

    public Node(T item) {
        this.children = new ArrayList<>();
        this.item = item;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    public void addChildren(Node<T> child) {
        this.children.add(child);
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
