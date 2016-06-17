package com.snpData.dao;
import java.io.Serializable;

import com.snpData.model.*;

/*
 * DAO interface for SleepingData entity
 * 
 * */
public interface SnpDataDaoInterface {
	
	public void persist(SnpData entity);
	public void update(SnpData entity);
	public SnpData getSleepDataByProfileID(long profileID);
}
