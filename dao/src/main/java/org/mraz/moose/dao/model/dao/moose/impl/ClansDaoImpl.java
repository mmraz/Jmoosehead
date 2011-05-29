package org.mraz.moose.dao.model.dao.moose.impl;

import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import org.mraz.moose.dao.model.obj.moose.Clans;
import org.springframework.stereotype.Repository;
import org.mraz.moose.dao.model.dao.moose.ClansDao;
 
 
/**
 * DAO for table: Clans.
 * @author autogenerated
 */
@Repository
public class ClansDaoImpl extends GenericHibernateDaoImpl<Clans, Long> implements ClansDao {
	
	/** Constructor method. */
		public ClansDaoImpl() {
			super(Clans.class);
		}
	}

