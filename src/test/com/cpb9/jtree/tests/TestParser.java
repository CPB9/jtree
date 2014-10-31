package com.cpb9.jtree.tests;

import com.cpb9.jtree.Node;
import com.cpb9.jtree.Parser;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class TestParser
{
    @Test
    public void testRootNode() throws IOException
    {
        URL url = Resources.getResource("/src/main/resources/foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream;
        inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = parser.parse(inputStream);

        Assert.assertEquals("RootNode must be home: ", lstNde.get(0).getName(), "home");
    }

   @Test
    public void testSecondNode() throws IOException
   {
       URL url = Resources.getResource("/src/main/resources/foo.txt");
       String text = Resources.toString(url, Charsets.UTF_8);
       InputStream inputStream = IOUtils.toInputStream(text);
       Parser parser = new Parser();
       List<Node> lstNde = parser.parse(inputStream);
       lstNde = parser.parse(inputStream);

       Assert.assertEquals("Second node must be root: ", lstNde.get(0).getChildren().get(0).getName(), "root");
   }

}
