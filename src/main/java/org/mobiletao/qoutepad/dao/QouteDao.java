package org.mobiletao.qoutepad.dao;
import java.util.List;
import java.util.Date;

import org.mobiletao.qoutepad.model.Qoute;

public interface QouteDao {
	public List <Qoute> findByAuthor(final String Author);
	public Qoute findByTitle(final String title);
	public List <Qoute> findfromUploadDate(final Date uploadDate);
	public List <Qoute> findExpired(final Date expiryDate);
}
