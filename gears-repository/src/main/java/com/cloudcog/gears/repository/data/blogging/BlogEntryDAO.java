package com.cloudcog.gears.repository.data.blogging;

import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

public class BlogEntryDAO {

	private void saveBlogEntryObject(Session session, BlogEntry blogEntry, Node parentNode) throws ItemExistsException, PathNotFoundException, VersionException, ConstraintViolationException, LockException, RepositoryException {
        Node blogNode = parentNode.addNode("blogEntry");
        blogNode.setProperty("title", blogEntry.getTitle());
        blogNode.setProperty("blogContent", blogEntry.getBlogContent());
        blogNode.setProperty("creationTime", blogEntry.getCreationTime());
        blogNode.setProperty("userName", blogEntry.getUserName());            
        session.save();
	}
}
