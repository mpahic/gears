/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cloudcog.gears;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.servlet.annotation.WebServlet;

import org.cloudcog.gears.sdk.RepositoryContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WebdavServlet provides webdav support (level 1 and 2 complient) for repository
 * resources.
 */
@WebServlet(urlPatterns = "/webdav/*", name = "SimpleWebdavServlet", asyncSupported = true)
public class SimpleWebdavServlet extends org.apache.jackrabbit.webdav.simple.SimpleWebdavServlet {
	private static final long serialVersionUID = -2361007635504358797L;
	
	private static final Logger log = LoggerFactory.getLogger(SimpleWebdavServlet.class);
	

    public Repository getRepository() {
        try {
			return RepositoryContext.getRepository();
		} catch (RepositoryException e) {
			log.error(e.getMessage(), e);
			return null;
		}
    }

    public void setRepository(Repository repository) {
        //It does not set anything
    }
}
