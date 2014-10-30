package com.cpb9.jtree;

import com.google.common.base.MoreObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Node Class. Описывает сущность ноды, у которой есть имя, значение
 * и список потомков.
 */
public class Node
{
    private final String name;
    private final String content;
    private final List<Node> children = new ArrayList<Node>();

    /**
     *
     * @param name Имя ноды
     * @param values Значение ноды
     */
    public Node(String  name, String values)
    {
        this.name = name;
        this.content = values;
    }

    /**
     *
     * @param t Добавление ноды в список child-ов к текущей родительской
     */
    public void push(Node t)
    {
        children.add(t);
    }

    /**
     *
     * @return Форматированный вывод всех параметров ноды
     */
    @Override
    public String toString()
    {
        //return String.format("Node(name=%s, content=%s, children=%s)", name, content, children);

        return MoreObjects.toStringHelper(this).add("Name: ", name)
                .add("content: ", content).add("childrens: ", children).toString();

    }

    public String getName()
    {
        return this.name;
    }

    public String getContent()
    {
        return this.content;
    }

    public List<Node> getChildren()
    {
        return this.children;
    }

}
