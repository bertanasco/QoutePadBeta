package org.mobiletao.qoutepad.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.mobiletao.qoutepad.model.Qoute;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class QouteDaoImpl implements QouteDao, MongoDao {
	
	private MongoOperations mongoOperation;
	private static final Log log = LogFactory.getLog(QouteDaoImpl.class);
	
	public QouteDaoImpl(){
		ApplicationContext ctx = new GenericXmlApplicationContext("mongodb.xml");
		mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");	
	}

	public List<Qoute> findByAuthor(final String author) {
		//final List<Qoute> resultQoute = mongoOperation.find(query(where("author")), Qoute);
		return null;
	}

	public Qoute findByTitle(final String title) {
		final Qoute resultQoute = mongoOperation.findOne(query(where("title").is(title)) , Qoute.class);
		log.info( " findbyTitle() result : " + resultQoute.toString());
		return resultQoute;
	}

	public List<Qoute> findfromUploadDate(final Date uploadDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Qoute> findExpired(final Date expiryDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
