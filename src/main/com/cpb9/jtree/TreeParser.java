package com.cpb9.jtree;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import org.apache.commons.io.IOUtils;

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

public class TreeParser
{
    //InputStream input сделать
    //
    public List<Node> parse(InputStream input) throws IOException
    {
        /*
        String str = "access\n\ttime =2014-10-10\n\turl =labuda.com\n\tip =8.8.8.8\nerrorSys\n\tunknown\n\t\terror =fuck";
        //String str = "=Буря мглою\n=Небо кроет";
        */
        String encoding = "UTF-8";
        String str = IOUtils.toString(input, encoding);

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
        //for(Node node : lstNode)
          //  node.printNode();

        return lstNode;
    }
    /*
    public  static void main(String[] args) throws IOException
    {
        TreeParser trPr = new TreeParser();
        List<Node> answ;
        answ = trPr.parse(System.in);


        for(Node node : answ)
            node.printNode();
    }
    */
}
