package org.mraz.moose.model.dao.moose.impl;

import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import org.mraz.moose.model.obj.moose.Player;
import org.springframework.stereotype.Repository;
import org.mraz.moose.model.dao.moose.PlayerDao;
 
 
/**
 * DAO for table: Player.
 * @author autogenerated
 */
@Repository
public class PlayerDaoImpl extends GenericHibernateDaoImpl<Player, String> implements PlayerDao {
	
	/** Constructor method. */
		public PlayerDaoImpl() {
			super(Player.class);
		}
	}

