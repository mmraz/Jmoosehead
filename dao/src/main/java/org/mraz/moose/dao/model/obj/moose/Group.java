package org.mraz.moose.dao.model.obj.moose;

import com.felees.hbnpojogen.persistence.IPojoGenEntity;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;
import org.mraz.moose.dao.enums.subtype.moose.GroupSubclassType;
import org.mraz.moose.dao.model.obj.moose.iface.IGroup;


/** 
 * Object mapping for hibernate-handled table: group.
 * @author autogenerated
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "group", catalog = "moose")
public class Group implements Cloneable, Serializable, IPojoGenEntity, IGroup {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559033536L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private Long id = 0L; // init for hibernate bug workaround
	/** Field mapping. */
	private String name;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Group() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Group(Long id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param id Long object;
	 * @param name String object;
	 */
	public Group(Long id, String name) {

		this.id = id;
		this.name = name;
	}
	
 


 	/**
 	 * Return an enum of the type of this subclass. This is useful to be able to use switch/case in your code.
 	 *
 	 * @return GroupSubclassType enum.
 	 */
 	@Transient
 	public GroupSubclassType getGroupSubclassType() {
		return GroupSubclassType.NOT_A_CHILD;
 	}  
  
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Group.class;
	}
 

    /**
     * Return the value associated with the column: id.
	 * @return A Long object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id", nullable = false  )
	public Long getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Long id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null || this.id == 0L) &&
				(id != null) &&
				(this.hashCode != null) ) {
			SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

    /**
     * Return the value associated with the column: name.
	 * @return A String object (this.name)
	 */
	@Column( nullable = false, length = 45  )
	public String getName() {
		return this.name;
		
	}
	

  
    /**  
     * Set the value related to the column: name.
	 * @param name the name value you wish to set
	 */
	public void setName(final String name) {
		this.name = name;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Group clone() throws CloneNotSupportedException {
		
        final Group copy = (Group)super.clone();

		copy.setId(this.getId());
		copy.setName(this.getName());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("id: " + this.getId() + ", ");
		sb.append("name: " + this.getName());
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
		
		final Group that; 
		try {
			that = (Group) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getName() == null) && (that.getName() == null)) || (getName() != null && getName().equals(that.getName())));
		return result;
	}
	
	/** Calculate the hashcode.
	 * @see java.lang.Object#hashCode()
	 * @return a calculated number
	 */
	@Override
	public int hashCode() {
		if ( this.hashCode == null ) {
			synchronized ( this ) {
				if ( this.hashCode == null ) {
					Long newHashCode = null;

					if ( getId() != null ) {
						newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null && getId() != 0L) {
							newHashCode = getId();
						} else {
							newHashCode = (long) super.hashCode();

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
		return (int) (this.hashCode & 0xffffff);
	}
	

	
}
