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
    @Test
    public void testRootNode() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);

        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);
        System.out.println(lstNde);

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

        Assert.assertEquals("Second node must be root: ", lstNde.get(0).getChildren().get(0).getName(), "vovik");
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
    public void testFouthNode() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Fouth node must be private: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getName(), "private");
    }

    @Test
    public void testFouthNodeValue() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Fouth node value must be 1: ", lstNde.get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getContent(), "1");
    }

    @Test
    public void testFithNode() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Second node must be root: ", lstNde.get(0).getChildren().get(0).getChildren().get(1).getName(), "settings");
    }

    @Test
    public void testFithNodeValue() throws IOException
    {
        URL url = Resources.getResource("foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("Second node must be root: ", lstNde.get(0).getChildren().get(0).getChildren().get(1).getContent(), "2");
    }
}
