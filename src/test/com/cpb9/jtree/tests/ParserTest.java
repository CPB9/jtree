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


public class ParserTest
{
    @Test
    public void testingRootNode() throws IOException
    {
        URL url = Resources.getResource("/src/main/resources/foo.txt");
        String text = Resources.toString(url, Charsets.UTF_8);
        InputStream inputStream;
        inputStream = IOUtils.toInputStream(text);
        Parser parser = new Parser();
        List<Node> lstNde = new ArrayList<Node>();
        lstNde = parser.parse(inputStream);

        Assert.assertEquals("Here is the test for first node(root node): ", lstNde.get(0).getName(), "home");

    }

   @Test
    public void testingSecondNode() throws IOException
   {
       URL url = Resources.getResource("/src/main/resources/foo.txt");
       String text = Resources.toString(url, Charsets.UTF_8);
       InputStream inputStream;
       inputStream = IOUtils.toInputStream(text);
       Parser parser = new Parser();
       List<Node> lstNde = new ArrayList<Node>();
       lstNde = parser.parse(inputStream);

       Assert.assertEquals("Here is the test for second node: ", lstNde.get(0).getChildren().get(0).getName(), "home");
   }

}
