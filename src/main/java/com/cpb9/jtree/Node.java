package com.cpb9.jtree;

import com.google.common.base.MoreObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Node Class. Describe node, every node have name, value
 * and list of childrens.
 */
public class Node
{
    private final String name;
    private final String content;
    private final List<Node> children = new ArrayList<Node>();

    /**
     * Constructor
     * @param name Node name
     * @param values Node value
     */
    public Node(String  name, String values)
    {
        this.name = name;
        this.content = values;
    }

    /**
     * Add node to the list
     * @param t Adding node to the child list
     */
    public void push(Node t)
    {
        children.add(t);
    }

    /**
     * Output object method.
     * @return Format output for node
     */
    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("name", name)
                .add("content", content).add("children", children).toString();
    }

    /**
     * Simple get-method
     * @return Node name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Simple get-method
     * @return Node value
     */
    public String getContent()
    {
        return this.content;
    }

    /**
     * Simple get-method
     * @return List of node childrens
     */
    public List<Node> getChildren()
    {
        return this.children;
    }

}
