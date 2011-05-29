package org.mraz.moose.dao.model.obj.moose;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;
import org.mraz.moose.dao.enums.subtype.moose.PlayerSubclassType;
import org.mraz.moose.dao.model.obj.moose.iface.IPlayerGroup;


/** 
 * Object mapping for hibernate-handled table: player_group.
 * @author autogenerated
 */

@Entity
@PrimaryKeyJoinColumn(name = "player_id")
@Table(name = "player_group", catalog = "moose")
public class PlayerGroup extends Player implements Cloneable, Serializable, IPojoGenEntity, IPlayerGroup {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559033531L;

	

 

	/**
 	 * Return an enum of the type of this subclass. This is useful to be able to use switch/case in your code.
 	 *
 	 * @return PlayerSubclassType enum.
 	 */
 	@Transient
 	@Override
 	public PlayerSubclassType getPlayerSubclassType() {
		return PlayerSubclassType.PLAYER_GROUP;
 	}  

 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Override
	@Transient
	public Class<?> getClassType() {
		return PlayerGroup.class;
	}
 


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public PlayerGroup clone() throws CloneNotSupportedException {
		
        final PlayerGroup copy = (PlayerGroup)super.clone();

		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		if (this.getClass().getSuperclass() != this.getClass()) {
			sb.append("(super.toString=" + super.toString() + ")");
		}
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		return true;
	}
	
	

	
}
