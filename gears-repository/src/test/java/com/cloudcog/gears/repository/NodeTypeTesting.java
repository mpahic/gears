package com.cloudcog.gears.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.jcr.ItemExistsException;
import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;

import org.apache.derby.tools.sysinfo;
import org.apache.jackrabbit.commons.cnd.CndImporter;
import org.apache.jackrabbit.commons.cnd.ParseException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeTypeTesting {

	private Session session;
	
	@Before
	public void before() throws LoginException, RepositoryException, FileNotFoundException, ParseException, IOException {
		session = RepositoryContext.login("admin", "admin");
		
		CndImporter.registerNodeTypes(new FileReader("src/main/java/com/cloudcog/gears/repository/data/nodeTypes.cnd"),session);
	}
	
	@Test
	public void testArticleNode() throws RepositoryException  {
		
		Node root = session.getRootNode();
		Node articles = root.addNode("articles");
		Node newNode = articles.addNode("article","cog:article");
		newNode.setProperty("cog:body","Hello World!");
		newNode.setProperty("cog:headline","New Hello World Article");
		
		session.save();
		Node checkNode = session.getNode("/articles/article");
		Assert.assertEquals("article", checkNode.getName());
		Assert.assertEquals("Hello World!", checkNode.getProperty("cog:body").getValue().getString());
		Assert.assertEquals("New Hello World Article", checkNode.getProperty("cog:headline").getValue().getString());

	}

	@Test
	public void testProjectNode() throws RepositoryException  {
		
		Node root = session.getRootNode();
		Node projects = root.addNode("projects");
		Node projectNode = projects.addNode("project 1","cog:project");
		projectNode.setProperty("cog:name", "project name");
		
		session.save();
		
		Node checkNode = session.getNode("/projects/project 1");
		Assert.assertEquals("project 1", checkNode.getName());
		Assert.assertEquals("project name", checkNode.getProperty("cog:name").getValue().getString());

	}
	
	@Test(expected = ItemExistsException.class)  
	public void testSameNameProjects() throws RepositoryException  {
		
		Node root = session.getRootNode();
		Node projects = root.addNode("projects", "cog:structured");
		Node projectNode = projects.addNode("project 1","cog:project");
		projectNode.setProperty("cog:name", "project name");
		session.save();

		Node projectNode2 = projects.addNode("project 1","cog:project");
		projectNode2.setProperty("cog:name", "project name");
		session.save();
		
		dumpToConsole(projects);

	}
	
	@After
	public void after() throws RepositoryException {
		Node root = session.getRootNode();
		NodeIterator iterator = root.getNodes();
		while (iterator.hasNext()) {
			Node childNode = (Node) iterator.next();
			if(!childNode.getName().equals("jcr:system") && !childNode.getName().equals("rep:policy")){
				childNode.remove();
			}
		}
		session.save();
		
	}
	
	private static void dumpToConsole(Node node) throws RepositoryException {
		if(node.getName().equals("jcr:system") || node.getName().equals("rep:policy")){
		    return;
		}
	    System.out.println(node.getPath());

	    if(node.hasProperties()){
	        PropertyIterator props = node.getProperties();
	        while(props.hasNext()){
	            Property property = (Property) props.next();

	            if(property.isMultiple()){
	                Value[] values = property.getValues();
	                System.out.print(property.getPath()+"="+"[");

	                for(Value value : values){
	                    System.out.print(value.getString()+",");
	                }
	                System.out.println("]");
	            } else {
	                System.out.println(property.getPath()+ "="+property.getString());
	            }
	        }
	        
	    }

	    NodeIterator iterator = node.getNodes();

	    while(iterator.hasNext()){
	        Node next = (Node) iterator.next();

	        dumpToConsole(next);
	    }
	}
}
