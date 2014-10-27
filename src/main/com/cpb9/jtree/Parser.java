package com.cpb9.jtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс-парсер. Содержит метод для парсинга строки, представленной в формате tree.
 */
public class Parser
{

    public void parse(String str)
    {
        /**
         * Делим строку на подстроки, по разделителю перевода строки.
         */
        String [] strArr = str.split("\n");

        /**
         * Регулярное выражение для парсинга, учитываем отступы как пробелы и табы.
         */
        Pattern p = Pattern.compile("^([ \\t]*)([^=]*)(?:=(.*))?$");
        Matcher m;

        /**
         * ArrayList в качестве стека будем использовать.
         */
        Stack<Node> stackNode = new Stack<Node>();
        /**
         * Отступ, по нему определяем родительские ноды.
         */
        int parentIndent = 0;

        /**
         * Идем по строчно.
         */
        for(int i = 0; i < strArr.length; i++)
        {
            String line = strArr[i];
            /**
             * Отступ ноды будем временно хранить тут
             */
            int indentLNode;
            /**
             * Разобьем то, что распарсили на блоки
             * отступы (1)
             * узел (2)
             * значение (3)
             */
            m = p.matcher(line);
            if(!m.find())
                continue;

            String indent = m.group(1);
            String key = m.group(2);
            String value = m.group(3);
            /**
             * Посчитаем отступы текущей ноды.
             * Создадим экземпляр класса Node.
             */
            indentLNode = indent.length();
            Node nde = new Node(key, value);

            /**
             * Если отступ нулевой, то это rootNode.
             * Ее кладем в стек.
             */
            if (indentLNode == 0)
            {
                stackNode.push(nde);
                parentIndent = indentLNode;
            }
            /**
             * Если отступ растет, т.е отступ больше, чем отступ родительской, то значит перед нами - child-node.
             * Мы вытаскиваем из стека родительскую ноду и к ней крепим потомка.
             * Если же отступ не растет, но больше 0, то эта нода на том же уровне, что и предидущая.
             */
            else if (indentLNode >= parentIndent && indentLNode > 0)
            {
                Node tmp = stackNode.pop();
                tmp.children.add(nde);
                stackNode.push(tmp);
                parentIndent = indentLNode;
            }
            /**
             * Если отступ стал меньше, это значит, что родительсокй для такой ноды будет
             * нода, расположенная в стеке на столько позиций ниже, на сколько она меньше запомненной последней позиции
             */
            else if (indentLNode < parentIndent)
            {
                Node tmp = stackNode.get(stackNode.size() - indentLNode);
                tmp.children.add(nde);
                parentIndent = indentLNode;
            }
        }

        for(Node node : stackNode)
        {
            System.out.println(node);
        }
    }

    public static void main(String [] args)
    {
        String str = "access\n\ttime =2014-10-10\n\turl =labuda.com\n\tip =8.8.8.8\nerrorSys\n\tunknown\n\t\terror =fuck";
        String str1 = "home\n\troot\n\t\tdocs\n\t\t\tphotos\n\t\t\t\tprivate =1\n\tvovik\n\t\tdocs =2";

        System.out.println("Строка 1:");
        System.out.println(str);

        System.out.println();

        System.out.println("Строка 2:");
        System.out.println(str1);


        Parser parser = new Parser();
        parser.parse(str);
        parser.parse(str1);

    }
}
