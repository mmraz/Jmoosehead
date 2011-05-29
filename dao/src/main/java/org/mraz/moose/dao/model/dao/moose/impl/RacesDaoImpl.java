package org.mraz.moose.dao.model.dao.moose.impl;

import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import org.mraz.moose.dao.model.obj.moose.Races;
import org.springframework.stereotype.Repository;
import org.mraz.moose.dao.model.dao.moose.RacesDao;
 
 
/**
 * DAO for table: Races.
 * @author autogenerated
 */
@Repository
public class RacesDaoImpl extends GenericHibernateDaoImpl<Races, Long> implements RacesDao {
	
	/** Constructor method. */
		public RacesDaoImpl() {
			super(Races.class);
		}
	}

