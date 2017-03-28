package com.snpData.s3Access;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;


/*
 * AWS S3 bucket download utility, which downloads a file accoring to given
 * bucket/folder name and key name(file name)
 * 
 * */
public class AWSS3DownloadUtil {
	
	
	private AmazonS3 s3client;
	
	//constructor
	//The credentials are invalid, change those to your s3 credentials
	public AWSS3DownloadUtil(){
		AWSCredentials credentials = new BasicAWSCredentials(
				"updateme", 
				"updateme");
		
		this.s3client = new AmazonS3Client(credentials);
	}
	
	/*
	 * Downloading utility method
	 * @param bucketName this is the S3 bucket and folder name
	 * @param keyName this is the s3 key 
	 * @param path the local path where the files is going to be stored
	 * @return void
	 * */
	public void download(String bucketName, String keyName, String path){
		s3client.getObject(
		        new GetObjectRequest(bucketName, keyName),
		        new File(path+ ""+ keyName)
		);
	}
	
}
