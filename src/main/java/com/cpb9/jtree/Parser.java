package com.cpb9.jtree;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс-парсер. Содержит метод для парсинга строки, представленной в формате Tree.
 */
public class Parser
{
    /**
     * Parse input stream with Tree format.
     * @param myInputStream Stream with data, which we would parse.
     * @return List of root nodes.
     * @throws java.io.IOException
     */
    public List<Node> parse(InputStream myInputStream) throws IOException
    {
        /**
         * Лист, содержащий корневые ноды, который мы вернем из метода.
         */
        List<Node> answList = new ArrayList<Node>();
        /**
         * ArrayList в качестве стека будем использовать.
         */
        Stack<Node> stackNode = new Stack<Node>();
        /**
         * Отступ, по нему определяем родительские ноды.
         */
        int parentIndent = 0;
        /**
         * Используется для того, чтобы праивльно работать со стеком тогда, когда отсутпы узлов равны
         */
        int depthEqualsNodeInStack = 0;
        /**
         * Эталонный отсутп, это будет первый прочитанный отступ, остальные должны быть того же типа.
         */
        Character indentModel = null;
        /**
         * Храним тут номер строки, которую мы считываем
         */
        int numOfString = 0;
        /**
         * Регулярное выражение для парсинга, учитываем отступы как пробелы и табы.
         */
        Pattern p = Pattern.compile("^([ \\t]*)([^=]*)(?:=(.*))?$");
        Matcher m;
        Scanner scanner = new Scanner(myInputStream);
        while (scanner.hasNext())
        {
            String str = scanner.nextLine();
            //String line = str;
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
            m = p.matcher(str);
            /**
             * Если не можем распарсить строку, то выкидываем исключение.
             */
            if (!m.find())
                throw new IOException("Can't parse string №" + numOfString);

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
             * Если модель отступов задана и текущий отступ не нулевой, то
             * проверяем каждый отступ в массиве отступов текущей ноды.
             * Если не совпадает с эталоном - кидаем исключение.
             */

            if (indentModel != null && indentLNode != 0)
            {
                for(int k = 0; k < indent.length(); k++)
                {
                    if (indentModel != indent.charAt(k))
                        throw new IOException("Wrong indent type in string №" + numOfString);
                }
            }

            /**
             * Если отступ нулевой, то это rootNode.
             * Ее кладем в стек. И также кладем еще и в лист с корневыми нодами.
             * Каждый раз, когда встречам корневую ноду мы чистим стек.
             * Обнуляем все переменные, связаныне с отступами.
             */
            if (indentLNode == 0)
            {
                stackNode.clear();
                stackNode.push(nde);
                parentIndent = indentLNode;
                answList.add(nde);
                depthEqualsNodeInStack = 0;
            }
            /**
             * Если отступ растет, т.е отступ текущей ноды больше, чем отступ родительской,
             * то значит перед нами - child-node.
             * Мы вытаскиваем из стека родительскую ноду и к ней крепим потомка.
             * Разумеется, обнуляя переменную depthEqualsNodeInStack.
             * Здесь же впервые мы инициализируем модель отступов.
             */
            else if (indentLNode > parentIndent)
            {
                Node tmp = stackNode.get(stackNode.size() - indentLNode + parentIndent);
                //Node tmp = stackNode.get(stackNode.size() - indentLNode + parentIndent);
                tmp.getChildren().add(nde);
                parentIndent = indentLNode;
                stackNode.push(nde);
                depthEqualsNodeInStack = 0;

                /**
                 * Инициализируем модель отступов.
                 * Первый отступ будет здесь.
                 */
                if (indentModel == null)
                    indentModel = indent.charAt(0);
            }
            /**
             * Если отступ текущей ноды не увеличился, то у нее будет тот же родитель, что и у предидущей.
             * Для отслеживания мы используем переменную, отслеживающую глубину одинаковых нод
             */
            else if (indentLNode == parentIndent && indentLNode > 0)
            {
                depthEqualsNodeInStack++;
                Node tmp = stackNode.get(stackNode.size() - indentLNode - depthEqualsNodeInStack + parentIndent - 1);
                stackNode.push(nde);
                tmp.getChildren().add(nde);
            }
            /**
             * Если отступ стал меньше, это значит, что родительсокй для такой ноды будет
             * нода, расположенная в стеке на столько позиций ниже, на сколько она меньше запомненной последней позиции
             * По сути родительской будет нода, отступ - 1.
             */
            else if (indentLNode < parentIndent)
            {
                Node tmp = stackNode.get(indentLNode - 1);

                tmp.getChildren().add(nde);
                stackNode.push(nde);
                parentIndent = indentLNode;
                depthEqualsNodeInStack = 0;
            }
            //Распарсили строку - увеличивем счетчик.
            numOfString++;
        }
        return answList;
    }
}
