package com.cpb9.jtree;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/**
 * Input
 *
 * access
 *   time =2014-10-10
 *   url =labuda.com
 *   ip =8.8.8.8
 * error
 *  unknown
 *    error =fuck
 *
 *
 * Output
 *
 *  [Node(access, [Node(time, 2014-10-10), Node(url, labuda.com), Node(ip, 8.8.8.8)]), Node(error, [Node(unknown, [Node(error, fuck)])])]
 */


class Node
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

public class TreeParser
{
    public static void main(String [] args)
    {
        String str = "access\n\ttime =2014-10-10\n\turl =labuda.com\n\tip =8.8.8.8\nerrorSys\n\tunknown\n\t\terror =fuck";
        //String str = "=Буря мглою\n=Небо кроет";
        String [] strArr = str.split("\n");

        Pattern p = Pattern.compile("^([ \\t]*)([^=]*)(?:=(.*))?$");
        Matcher m;

        List<Node> lstNode = new ArrayList<Node>();
        Node parentNode = null;
        int parentIndent = 0;
        for(int i = 0; i < strArr.length; i++)
        {
            String line = strArr[i];
            int indentLNode;
            m = p.matcher(line);
            if(!m.find())
                continue;

            String indent = m.group(1);   // отступы
            String key = m.group(2);     // узел
            String value = m.group(3);   //значение

            indentLNode = indent.length();
            Node nde = new Node(value, key);

            if (indentLNode == 0)
            {
                nde.parentNode = null;
                parentNode = nde;
                parentIndent = indentLNode;
                lstNode.add(parentNode);
            }
            else if (parentIndent < indentLNode && indentLNode > 0)
            {
                nde.parentNode = parentNode;
                parentNode.push(nde);
                parentNode = nde;
                parentIndent = indentLNode;
            }
            else if (parentIndent == indentLNode && indentLNode > 0)
            {
                //parentNode.parentNode.printNode();
                //parentNode = parentNode.parentNode;
                //nde.printNode();
                //parentNode.printNode();
                parentNode.parentNode.push(nde);
            }
        }
        for(Node node : lstNode)
            node.printNode();

    }
}
