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

}
