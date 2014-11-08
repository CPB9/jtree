package com.cpb9.jtree;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class TestParser
{
    /**
     *  Дерево номер 1.
     *  Отсутпы - пробелы.
     */
    @Test
    public void testRootNode() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("RootNode must be home: ", lstNde.get(0).getName(), "home");
    }

    @Test
    public void testSecondNode() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Second node must be vovik: ", lstNde.get(0).getChildren().get(0).getName(), "vovik");
    }

    @Test
    public void testThirdNode() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Third node must be docs: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getName(), "docs");
    }

    @Test
    public void testFourthNode() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Fourth node must be private: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getName(), "private");
    }

    @Test
    public void testFourthNodeValue() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Fourth node value must be 1: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getContent(), "1");
    }

    @Test
    public void testFifthNode() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Fifth node must be settings: ", lstNde.get(0).getChildren().get(0).getChildren().get(1).getName(), "settings");
    }

    @Test
    public void testFifthNodeValue() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Fifth node value must be 2: ", lstNde.get(0).getChildren().get(0).getChildren().get(1).getContent(), "2");
    }

    @Test
    public void testSecondRootNode() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second root node must be best: ", lstNde.get(1).getName(), "best");
    }
    @Test
    public void testSecondRootChildrenNode() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second root node have children web: ", lstNde.get(1).getChildren().get(0).getName(), "web");
    }

    @Test
    public void testSecondRootChildrenNodeValue() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second root node have children with value: ", lstNde.get(1).getChildren().get(0).getContent(), "1488");
    }

    /**
     * Второе дерево, большее, одна главная рутовая нода.
     * Отступы - табуляция.
     */


    @Test
    public void testAnotherTreeFirstNode() throws IOException
    {
        URL url = Resources.getResource("testFile.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Name of the root node must be a: ", lstNde.get(0).getName(), "a");
    }

    @Test
    public void testAnotherTreeSecondNode() throws IOException
    {
        URL url = Resources.getResource("testFile.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Name of the second node must be b: ", lstNde.get(0).getChildren().get(0).getName(), "b");
    }

    @Test
    public void testAnotherTreeThirdNode() throws IOException
    {
        URL url = Resources.getResource("testFile.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Name of the third node must be c: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getName(), "c");
    }

    @Test
    public void testAnotherTreeFourthNode() throws IOException
    {
        URL url = Resources.getResource("testFile.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Name of the fourth node must be d: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getName(), "d");
    }

    @Test
    public void testAnotherTreeFifthNode() throws IOException
    {
        URL url = Resources.getResource("testFile.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Name of the fifth node must be e: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getName(), "e");
    }

    @Test
    public void testAnotherTreeSixthNode() throws IOException
    {
        URL url = Resources.getResource("testFile.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Name of the sixth node must be f: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getName(), "f");
    }

    @Test
    public void testAnotherTreeSixthNodeValue() throws IOException
    {
        URL url = Resources.getResource("testFile.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Value of the sixth node must be 1: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getContent(), "1");
    }

    @Test
    public void testAnotherTreeFourthNode2() throws IOException
    {
        URL url = Resources.getResource("testFile.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Name of the second children of node c must be g: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(1).getName(), "g");
    }

    @Test
    public void testAnotherTreeFirstNode2() throws IOException
    {
        URL url = Resources.getResource("testFile.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Name of the second children of node a must be h: ", lstNde.get(0).getChildren().get(1).getName() , "h");
    }

    @Test
    public void testAnotherTreeFirstNode2Value() throws IOException
    {
        URL url = Resources.getResource("testFile.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Value of the second children of node a must be 3: ", lstNde.get(0).getChildren().get(1).getContent() , "3");
    }
    /**
     * Дерево номер 3. Две рутовые ноды.
     * Отступы - пробелы.
     */

    @Test
    public void testRootNodeTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("RootNode must be a: ", lstNde.get(0).getName(), "a");
    }

    @Test
    public void testSecondNodeTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second node must be b: ", lstNde.get(0).getChildren().get(0).getName(), "b");
    }
    @Test
    public void testThirdNodeTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third node must be c: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getName(), "c");
    }

    @Test
    public void testFourthNodeTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Fourth node must be d: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getName(), "d");
    }
    @Test
    public void testFifthNodeTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Fifth node must be e: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getName(), "e");
    }
    @Test
    public void testSixthNodeTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Sixth node must be f: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getName(), "f");
    }
    @Test
    public void testSixthNodeValueTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Sixth node value must be 1: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getContent(), "1");
    }
    @Test
    public void testThirdNode2Tree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third node must be g: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(1).getName(), "g");
    }

    @Test
    public void testThirdNode2ValueTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third node value must be 2: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(1).getContent(), "2");
    }
    @Test
    public void testThirdNode3Tree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third node must be j: ", lstNde.get(0).getChildren().get(1).getName(), "j");
    }

    @Test
    public void testThirdNode3ChildTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third childs node must be l: ", lstNde.get(0).getChildren().get(1).getChildren().get(0).getName(), "l");
    }

    @Test
    public void testThirdNode3ValueChildTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third childs node value must be 21: ", lstNde.get(0).getChildren().get(1).getChildren().get(0).getContent(), "21");
    }

    @Test
    public void testThirdNode4ChildTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third childs node must be o: ", lstNde.get(0).getChildren().get(1).getChildren().get(1).getName(), "o");
    }

    @Test
    public void testThirdNode4ValueChildTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third childs node value must be 11: ", lstNde.get(0).getChildren().get(1).getChildren().get(1).getContent(), "11");
    }

    @Test
    public void testThirdNode5ChildTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third childs node must be m: ", lstNde.get(0).getChildren().get(1).getChildren().get(2).getName(), "m");
    }

    @Test
    public void testThirdNode5ValueChildTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third childs node value must be 31: ", lstNde.get(0).getChildren().get(1).getChildren().get(2).getContent(), "31");
    }

    @Test
    public void testThirdNode6ChildTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third childs node must be s: ", lstNde.get(0).getChildren().get(1).getChildren().get(3).getName(), "s");
    }

    @Test
    public void testThirdNode6ValueChildTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third childs node value must be 2: ", lstNde.get(0).getChildren().get(1).getChildren().get(3).getContent(), "2");
    }


     @Test
     public void testRootNodeChildTree3() throws IOException
     {
     URL url = Resources.getResource("testFile2.txt");
     String text = Resources.toString(url, Charsets.UTF_8);
     InputStream inputStream = IOUtils.toInputStream(text);

     Parser parser = new Parser();
     List<Node> lstNde = parser.parse(inputStream);
     Assert.assertEquals("RootNode child must be h: ", lstNde.get(0).getChildren().get(2).getName(), "h");
     }

     @Test
     public void testRootNodeChildValueTree3() throws IOException
     {
     URL url = Resources.getResource("testFile2.txt");
     String text = Resources.toString(url, Charsets.UTF_8);
     InputStream inputStream = IOUtils.toInputStream(text);

     Parser parser = new Parser();
     List<Node> lstNde = parser.parse(inputStream);
     Assert.assertEquals("RootNode child value must be 3: ", lstNde.get(0).getChildren().get(2).getContent(), "3");
     }

    @Test
    public void testThirdNodeEndTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third node must be h: ", lstNde.get(0).getChildren().get(2).getName(), "h");
    }
    @Test
    public void testThirdNodeValueEndTree3() throws IOException
    {
        URL url = Resources.getResource("testFile2.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third node value must be 3: ", lstNde.get(0).getChildren().get(2).getContent(), "3");
    }

    /**
     * Дерево 4
     */

    @Test
    public void testFirstRootNodeTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First root node must be access: ", lstNde.get(0).getName(), "access");
    }
    @Test
    public void testFirstRootChildrenNodeOneTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First root child node must be time: ", lstNde.get(0).getChildren().get(0).getName(), "time");
    }
    @Test
    public void testFirstRootChildrenNodeOneValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First root child node value must be 2014-28-07 13:08:24: ", lstNde.get(0).getChildren().get(0).getContent(), "2014-28-07 13:08:24");
    }

    @Test
    public void testFirstRootChildrenNodeTwoTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second root child node must be url: ", lstNde.get(0).getChildren().get(1).getName(), "url");
    }

    @Test
    public void testFirstRootChildrenNodeTwoValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second root child node value must be hello.png: ", lstNde.get(0).getChildren().get(1).getContent(), "hello.png");
    }
    @Test
    public void testFirstRootChildrenNodeThreeTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third root child node must be ip: ", lstNde.get(0).getChildren().get(2).getName(), "ip");
    }
    @Test
    public void testFirstRootChildrenNodeThreeValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third root child node value must be ip: ", lstNde.get(0).getChildren().get(2).getContent(), "8.8.8.8");
    }

    @Test
    public void testSecondRootNodeTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First root node must be error: ", lstNde.get(1).getName(), "error");
    }

    @Test
    public void testSecondRootChildrenNodeOneTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second root child node must be time: ", lstNde.get(1).getChildren().get(0).getName(), "time");
    }
    @Test
    public void testSecondRootChildrenNodeOneValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First root child node value must be 2014-11-17 14:88:24: ", lstNde.get(1).getChildren().get(0).getContent(), "2014-11-17 14:88:24");
    }

    @Test
    public void testSecondRootChildrenNodeTwoTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second root child node must be url: ", lstNde.get(1).getChildren().get(1).getName(), "url");
    }

    @Test
    public void testSecondRootChildrenNodeTwoValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second root child node value must be hello.png: ", lstNde.get(1).getChildren().get(1).getContent(), "hello.png");
    }
    @Test
    public void testSecondRootChildrenNodeThreeTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third root child node must be ip: ", lstNde.get(1).getChildren().get(2).getName(), "ip");
    }
    @Test
    public void testSecondRootChildrenNodeThreeValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third root child node value must be ip: ", lstNde.get(1).getChildren().get(2).getContent(), "8.8.8.8");
    }
    @Test
    public void testSecondRootChildrenNodeFourTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Fourth root child node must be ip: ", lstNde.get(1).getChildren().get(3).getName(), "stack");
    }
    @Test
    public void testSecondRootChildrenNodeFourChildrenTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First child node of fourth node must be file: ", lstNde.get(1).getChildren().get(3).getChildren().get(0).getName(), "file");
    }
    @Test
    public void testSecondRootChildrenNodeFourChildrenValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First child node of fourth node value must be file.txt: ", lstNde.get(1).getChildren().get(3).getChildren().get(0).getContent(), "file.txt");
    }
    @Test
    public void testSecondRootChildrenNodeFourChildrenTwoTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second child node of fourth node must be file: ", lstNde.get(1).getChildren().get(3).getChildren().get(1).getName(), "line");
    }

    @Test
    public void testSecondRootChildrenNodeFourChildrenTwoValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First child node of fourth node value must be 30: ", lstNde.get(1).getChildren().get(3).getChildren().get(1).getContent(), "30");
    }

    @Test
    public void testSecondRootChildrenNodeFourChildrenThreeTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second child node of fourth node must be type: ", lstNde.get(1).getChildren().get(3).getChildren().get(2).getName(), "type");
    }

    @Test
    public void testSecondRootChildrenNodeFourChildrenThreeValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First child node of fourth node value must be unknown: ", lstNde.get(1).getChildren().get(3).getChildren().get(2).getContent(), "unknown");
    }


    @Test
    public void testSecondRootChildrenNodeFifthTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Fifith root child node must be ip: ", lstNde.get(1).getChildren().get(4).getName(), "stack");
    }
    @Test
    public void testSecondRootChildrenNodeFifthChildrenTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First child node of fourth node must be file: ", lstNde.get(1).getChildren().get(4).getChildren().get(0).getName(), "file");
    }
    @Test
    public void testSecondRootChildrenNodeFifthChildrenValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First child node of fourth node value must be file.txt: ", lstNde.get(1).getChildren().get(4).getChildren().get(0).getContent(), "applmech.txt");
    }
    @Test
    public void testSecondRootChildrenNodeFifthChildrenTwoTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second child node of fourth node must be file: ", lstNde.get(1).getChildren().get(4).getChildren().get(1).getName(), "line");
    }

    @Test
    public void testSecondRootChildrenNodeFifthChildrenTwoValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First child node of fourth node value must be 30: ", lstNde.get(1).getChildren().get(4).getChildren().get(1).getContent(), "1488");
    }

    @Test
    public void testSecondRootChildrenNodeFifthChildrenThreeTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third child node of fourth node must be file: ", lstNde.get(1).getChildren().get(4).getChildren().get(2).getName(), "typeError");
    }
    @Test
    public void testSecondRootChildrenNodeFifthChildrenThreeChildrenTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third child node of fourth node must be file: ", lstNde.get(1).getChildren().get(4).getChildren().get(2).getChildren().get(0).getName(), "type");
    }
    @Test
    public void testSecondRootChildrenNodeFifthChildrenThreeChildrenValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third child node value of fourth node must be file: ", lstNde.get(1).getChildren().get(4).getChildren().get(2).getChildren().get(0).getContent(), "unknown");
    }

    @Test
    public void testThirdRootNodeTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First root node must be access: ", lstNde.get(2).getName(), "access");
    }
    @Test
    public void testThirdRootChildrenNodeOneTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First root child node must be time: ", lstNde.get(2).getChildren().get(0).getName(), "time");
    }
    @Test
    public void testThirdRootChildrenNodeOneValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("First root child node value must be 2014-28-07 13:08:24: ", lstNde.get(2).getChildren().get(0).getContent(), "2022-11-07 12:18:34");
    }

    @Test
    public void testThirdRootChildrenNodeTwoTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second root child node must be url: ", lstNde.get(2).getChildren().get(1).getName(), "url");
    }

    @Test
    public void testThirdRootChildrenNodeTwoValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Second root child node value must be hello.png: ", lstNde.get(2).getChildren().get(1).getContent(), "good.png");
    }
    @Test
    public void testThirdRootChildrenNodeThreeTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third root child node must be ip: ", lstNde.get(2).getChildren().get(2).getName(), "ip");
    }
    @Test
    public void testThirdRootChildrenNodeThreeValueTree4() throws IOException
    {
        URL url = Resources.getResource("testFile3.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        Assert.assertEquals("Third root child node value must be ip: ", lstNde.get(2).getChildren().get(2).getContent(), "8.8.8.8");
    }

}
