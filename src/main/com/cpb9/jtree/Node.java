package com.cpb9.jtree;

import java.util.ArrayList;
import java.util.List;

/**
 * Node Class. Описывает сущность ноды, у которой есть имя, значение, родительская нода
 * и список потомков.
 */
public class Node
{
    String name;
    String content;
    Node parentNode;
    List<Node> chlds = new ArrayList<Node>();

    Node()
    {
        this.name = null;
        this.content = null;
    }

    Node(String values,String  name)
    {
        this.name = name;
        this.content = values;
    }
    void push(Node t)
    {
        chlds.add(t);
    }
    void printNode()
    {
        System.out.println("Name: " + name + ", Value: " + content + ", ParentNode: " + parentNode +  ", Childrens: " + chlds);
    }

    @Override
    public String toString()
    {
        return String.format("Node(name=%s, content=%s, children=%s)", name, content, chlds);
    }

}
