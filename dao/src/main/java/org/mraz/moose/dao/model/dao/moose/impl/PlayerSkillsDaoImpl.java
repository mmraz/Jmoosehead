package org.mraz.moose.dao.model.dao.moose.impl;

import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import org.mraz.moose.dao.model.obj.moose.PlayerSkills;
import org.springframework.stereotype.Repository;
import org.mraz.moose.dao.model.dao.moose.PlayerSkillsDao;
 
 
/**
 * DAO for table: PlayerSkills.
 * @author autogenerated
 */
@Repository
public class PlayerSkillsDaoImpl extends GenericHibernateDaoImpl<PlayerSkills, Date> implements PlayerSkillsDao {
	
	/** Constructor method. */
		public PlayerSkillsDaoImpl() {
			super(PlayerSkills.class);
		}
	}

