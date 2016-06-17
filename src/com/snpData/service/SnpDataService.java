package com.snpData.service;

import com.snpData.dao.*;
import com.snpData.model.*;
import com.snpData.s3Access.*;

/*
 * Provides service to access data by profileID and download from S3 bucket accordingly
 * It provides an interface to use data download service as a package
 * 
 * */
public class SnpDataService {
	
	private static SnpDataDao snpDataDao;
	

	public SnpDataService(){
		snpDataDao = new SnpDataDao();
	}
	
	/*
	 * Get SnpData from MySQL db by profileID
	 * @param profileID the profileID of the client
	 * @return SnpData the SnpData from Mysql db
	 * */
	public SnpData getSleepDataByProfileID(long profileID) {
		snpDataDao.openCurrentSession();
		SnpData SnpData = snpDataDao.getSleepDataByProfileID(profileID);
		snpDataDao.closeCurrentSession();
		return SnpData;
	}
	
	/*
	 * A helper method that provides S3 address by combining bucket name and key name
	 * @param data the SnpData of the client
	 * @return addr the s3 address where the data file is stored
	 * */
	public String getS3Address(SnpData data){
		String bucketName= data.getS3bucket_name();
		String keyName= data.getS3key_name();
		String addr= bucketName+"/"+keyName;
		return addr;
	}
	
	
	/*
	 * Download S3 files based on given SnpData and stored in local
	 * @param data the SnpData of the client
	 * @param path the local path where the files is going to be stored
	 * @return void
	 * */
	
	public void getS3File(SnpData data, String path){
		String bucketName= data.getS3bucket_name();
		String keyName= data.getS3key_name();
		AWSS3DownloadUtil downloadUtil = new AWSS3DownloadUtil();
		downloadUtil.download(bucketName, keyName, path);
	}
	
}
