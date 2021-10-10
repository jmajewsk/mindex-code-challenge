package com.mindex.challenge.data.reporting_structure;

import java.util.List;

public abstract class DirectReportingDirectedGraph<T> {

    public Node<T> root;
    public int size;

    public DirectReportingDirectedGraph() {

    }

    public Node<T> createFromParent(Node<T> parentNode) {
        this.root = buildTree(parentNode);
        return root;
    }

    private Node<T> buildTree(Node<T> parentNode) {
        List<Node<T>> childNodes = getChildrenOfNode(parentNode.getItem());
        size++;
        for (Node<T> tNode : childNodes) {
            tNode.setParent(parentNode);
            tNode.setParent(parentNode);
            Node<T> fromRoot = buildTree(tNode);
            tNode.addChildren(fromRoot);
        }
        return parentNode;
    }

    public abstract List<Node<T>> getChildrenOfNode(T item);


    public Node<T> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }
}
