/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aliases` (
  `PLAYER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  `VALUE` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`PLAYER_ID`),
  CONSTRAINT `FK_ALIASES_1` FOREIGN KEY (`PLAYER_ID`) REFERENCES `player` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attributes` (
  `OWNER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IS_MODIFIER` tinyint(1) NOT NULL DEFAULT '0',
  `STRENGTH` smallint(5) unsigned NOT NULL,
  `INTELLIGENCE` smallint(5) unsigned NOT NULL,
  `WISDOM` smallint(5) unsigned NOT NULL,
  `DEXTERITY` smallint(5) unsigned NOT NULL,
  `CONSTITUTION` smallint(5) unsigned NOT NULL,
  `AGILITY` smallint(5) unsigned NOT NULL,
  `ENDURANCE` smallint(5) unsigned NOT NULL,
  `SOCIAL` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`OWNER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clans` (
  `CLAN_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `WHO_NAME` varchar(20) NOT NULL,
  `HALL_VNUM` smallint(5) unsigned DEFAULT NULL,
  `HIDDEN` tinyint(1) NOT NULL DEFAULT '0',
  `INDEPENDENT` tinyint(1) NOT NULL DEFAULT '0',
  `PVP` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`CLAN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deity` (
  `DEITY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`DEITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_skills` (
  `GROUP_ID` int(10) unsigned NOT NULL,
  `SN` int(10) unsigned NOT NULL,
  PRIMARY KEY (`GROUP_ID`),
  KEY `FK_GROUP_SKILLS_2` (`SN`),
  CONSTRAINT `FK_GROUP_SKILLS_1` FOREIGN KEY (`GROUP_ID`) REFERENCES `group` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_GROUP_SKILLS_2` FOREIGN KEY (`SN`) REFERENCES `skill_spell` (`SN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `ID` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `NAME` varchar(20) NOT NULL,
  `SURNAME` varchar(45) DEFAULT NULL,
  `TITLE` varchar(80) DEFAULT NULL,
  `EMAIL` varchar(80) DEFAULT NULL,
  `SHORT_DESC` varchar(80) DEFAULT NULL,
  `LONG_DESC` varchar(4096) DEFAULT NULL,
  `DESCRIPTION` varchar(4096) DEFAULT NULL,
  `VERSION` int(10) unsigned NOT NULL DEFAULT '0',
  `RACE_ID` int(10) unsigned NOT NULL DEFAULT '0',
  `CLAN_ID` int(10) unsigned DEFAULT NULL,
  `GENDER` enum('male','femaile','none') NOT NULL DEFAULT 'none',
  `LEVEL` int(10) unsigned NOT NULL DEFAULT '1',
  `TRUST` int(10) unsigned DEFAULT NULL,
  `PLAYED` int(10) unsigned NOT NULL DEFAULT '0',
  `Password` varchar(45) NOT NULL DEFAULT 'password',
  `BAMF_IN` varchar(2048) DEFAULT NULL,
  `BAMF_OUT` varchar(2048) DEFAULT NULL,
  `WHONAME` varchar(20) DEFAULT NULL,
  `TRUE_GENDER` enum('male','female','none') DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_deity` (
  `PLAYER_ID` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DEITY_ID` int(10) unsigned NOT NULL,
  `SWITCHED_TO` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `SACRIFICE_CNT` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`PLAYER_ID`),
  KEY `FK_player_deity_2` (`DEITY_ID`),
  CONSTRAINT `FK_PLAYER_DEITY` FOREIGN KEY (`PLAYER_ID`) REFERENCES `player` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_player_deity_2` FOREIGN KEY (`DEITY_ID`) REFERENCES `deity` (`DEITY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_gladiator` (
  `PLAYER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `WINS` int(10) unsigned NOT NULL DEFAULT '0',
  `KILLS` int(10) unsigned NOT NULL DEFAULT '0',
  `TEAM_WINS` int(10) unsigned NOT NULL DEFAULT '0',
  `TEAM_KILLS` int(10) unsigned NOT NULL DEFAULT '0',
  `GAMES` int(10) unsigned NOT NULL DEFAULT '0',
  `TEAM_GAMES` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`PLAYER_ID`),
  CONSTRAINT `FK_player_gladiator_1` FOREIGN KEY (`PLAYER_ID`) REFERENCES `player` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_group` (
  `PLAYER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`PLAYER_ID`),
  CONSTRAINT `FK_PLAYER_GROUP_1` FOREIGN KEY (`PLAYER_ID`) REFERENCES `player` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_lasts` (
  `PLAYER_ID` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `KILLED_BY` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `KILLED` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ATTACKED` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ATTACKED_BY` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ATTACKED_BY_TIMER` int(10) unsigned NOT NULL DEFAULT '0',
  `COMBAT` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `KILLED_DT` datetime DEFAULT NULL,
  `DEATH_DT` datetime DEFAULT NULL,
  `LOGIN` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`PLAYER_ID`),
  CONSTRAINT `FK_PLAYER_LASTS` FOREIGN KEY (`PLAYER_ID`) REFERENCES `player` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_notes` (
  `PLAYER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOTE` int(10) unsigned NOT NULL DEFAULT '0',
  `IDEA` int(10) unsigned NOT NULL DEFAULT '0',
  `PENALTY` int(10) unsigned NOT NULL DEFAULT '0',
  `NEWS` int(10) unsigned NOT NULL DEFAULT '0',
  `CHANGE` int(10) unsigned NOT NULL DEFAULT '0',
  `OOC` int(10) unsigned NOT NULL DEFAULT '0',
  `BUG` int(10) unsigned NOT NULL DEFAULT '0',
  `CLAN` int(10) unsigned NOT NULL DEFAULT '0',
  `IMMORTAL` int(10) unsigned NOT NULL DEFAULT '0',
  `QUESTION` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`PLAYER_ID`),
  CONSTRAINT `FK_player_notes_1` FOREIGN KEY (`PLAYER_ID`) REFERENCES `player` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_skills` (
  `PLAYER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `SN` int(10) unsigned NOT NULL,
  `LEARNED_PERCENT` smallint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`PLAYER_ID`),
  KEY `FK_PLAYER_SKILLS_2` (`SN`),
  CONSTRAINT `FK_PLAYER_SKILLS_1` FOREIGN KEY (`PLAYER_ID`) REFERENCES `player` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_PLAYER_SKILLS_2` FOREIGN KEY (`SN`) REFERENCES `skill_spell` (`SN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_stats` (
  `PLAYER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `HP` smallint(5) unsigned NOT NULL,
  `MAX_HP` smallint(5) unsigned NOT NULL,
  `MANA` smallint(5) unsigned NOT NULL,
  `MAX_MANA` smallint(5) unsigned NOT NULL,
  `MOVE` smallint(5) unsigned NOT NULL,
  `MAX_MOVE` smallint(5) unsigned NOT NULL,
  `GOLD` int(10) unsigned NOT NULL,
  `SILVER` int(10) unsigned NOT NULL,
  `BANK` int(10) unsigned NOT NULL DEFAULT '0',
  `INCOGNITO` smallint(5) unsigned NOT NULL DEFAULT '0',
  `INVISIBLE` smallint(5) unsigned NOT NULL DEFAULT '0',
  `PRACTICE` smallint(5) unsigned NOT NULL,
  `TRAINING` smallint(5) unsigned NOT NULL,
  `SKILL` smallint(5) unsigned NOT NULL,
  `SAVING_THROW` smallint(5) unsigned NOT NULL,
  `ALIGNMENT` int(11) NOT NULL,
  `HITROLL` smallint(5) unsigned NOT NULL,
  `DAMROLL` smallint(5) unsigned NOT NULL,
  `SECOND_HITROLL` smallint(5) unsigned NOT NULL,
  `SECOND_DAMROLL` smallint(5) unsigned NOT NULL,
  `AC0` smallint(5) unsigned NOT NULL,
  `AC1` smallint(5) unsigned NOT NULL,
  `AC2` smallint(5) unsigned NOT NULL,
  `AC3` smallint(5) unsigned NOT NULL,
  `WIMPY` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`PLAYER_ID`),
  CONSTRAINT `FK_PLAYER_STATS_1` FOREIGN KEY (`PLAYER_ID`) REFERENCES `player` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `races` (
  `RACE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  `STAT_STR` smallint(5) unsigned NOT NULL,
  `STAT_INT` smallint(5) unsigned NOT NULL,
  `STAT_WIS` smallint(5) unsigned NOT NULL,
  `STAT_DEX` smallint(5) unsigned NOT NULL,
  `STAT_CON` smallint(5) unsigned NOT NULL,
  `STAT_AGT` smallint(5) unsigned NOT NULL,
  `STAT_END` smallint(5) unsigned NOT NULL,
  `STAT_SOC` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`RACE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill_spell` (
  `SN` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`SN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
