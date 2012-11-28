package org.mobiletao.qoutepad.test.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mobiletao.qoutepad.dao.QouteDaoImpl;
import org.mobiletao.qoutepad.dao.QouteDao;
import org.mobiletao.qoutepad.model.Author;
import org.mobiletao.qoutepad.model.Qoute;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class QouteDaoTest {
	final Qoute testQoute = new Qoute();
	final Author testAuthor = new Author();
	MongoOperations mongoOperation;
	
	private void loadConfig(){
		System.out.println("loading test configuration");
		ApplicationContext ctx = new GenericXmlApplicationContext("mongodb.xml");
		mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");	
	}
	private void insertTestData(){
		testAuthor.setName("testAuthor");
		testQoute.setAuthor(testAuthor);
		testQoute.setTitle("testTitle");
		mongoOperation.insert(testQoute);
		System.out.println();
	}
	@Before
	public void setUp(){
		loadConfig();
		insertTestData();
	}
	@After
	public void destroy(){
		mongoOperation.remove(testQoute);
	}
	
	@Test
	public void findByTitle(){	
		String testTitle = "testTitle";
		QouteDao qouteDao = new QouteDaoImpl();
		Qoute qoute = qouteDao.findByTitle(testTitle);
		System.out.println("findByTitle result : " + qoute.getTitle());
		assertTrue(qoute.getTitle().equals(testTitle));
	}
	
	@Test
	public void findByAuthor(){
		String testAuthor = "testAuthor";
		QouteDao qouteDao = new QouteDaoImpl();
		List<Qoute> qoute = qouteDao.findByAuthor(testAuthor);
		assertEquals(qoute.get(0).getAuthor().getName(), testAuthor, "Invalid qoute retrived");
	}
	
	/*@Test
	public void findById(){
		String testId = "testId";
		QouteDao qouteDao = new QouteDaoImpl();
		Qoute qoute = qouteDao.findById(testId);
		assertEquals(qoute.getId(),testId, "Invalid qoute retrived");
		//assertEquals
	}*/
	
	//TODO date
	
}
