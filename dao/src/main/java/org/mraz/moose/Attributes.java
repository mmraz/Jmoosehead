package org.mraz.moose;

// Generated May 30, 2011 12:25:33 AM by Hibernate Tools 3.4.0.CR1

/**
 * Attributes generated by hbm2java
 */
public class Attributes implements java.io.Serializable {

	private Integer ownerId;
	private boolean isModifier;
	private short strength;
	private short intelligence;
	private short wisdom;
	private short dexterity;
	private short constitution;
	private short agility;
	private short endurance;
	private short social;

	public Attributes() {
	}

	public Attributes(boolean isModifier, short strength, short intelligence,
			short wisdom, short dexterity, short constitution, short agility,
			short endurance, short social) {
		this.isModifier = isModifier;
		this.strength = strength;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.agility = agility;
		this.endurance = endurance;
		this.social = social;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public boolean isIsModifier() {
		return this.isModifier;
	}

	public void setIsModifier(boolean isModifier) {
		this.isModifier = isModifier;
	}

	public short getStrength() {
		return this.strength;
	}

	public void setStrength(short strength) {
		this.strength = strength;
	}

	public short getIntelligence() {
		return this.intelligence;
	}

	public void setIntelligence(short intelligence) {
		this.intelligence = intelligence;
	}

	public short getWisdom() {
		return this.wisdom;
	}

	public void setWisdom(short wisdom) {
		this.wisdom = wisdom;
	}

	public short getDexterity() {
		return this.dexterity;
	}

	public void setDexterity(short dexterity) {
		this.dexterity = dexterity;
	}

	public short getConstitution() {
		return this.constitution;
	}

	public void setConstitution(short constitution) {
		this.constitution = constitution;
	}

	public short getAgility() {
		return this.agility;
	}

	public void setAgility(short agility) {
		this.agility = agility;
	}

	public short getEndurance() {
		return this.endurance;
	}

	public void setEndurance(short endurance) {
		this.endurance = endurance;
	}

	public short getSocial() {
		return this.social;
	}

	public void setSocial(short social) {
		this.social = social;
	}

}
