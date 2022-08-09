package com.yuzee.common.lib.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.CollectionUtils;
import com.yuzee.common.lib.constants.IConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AWSUtil {

	private AWSUtil() {}
	
	public static void writeAndDeleteFile(String accessKey, String bucketName, String s3Region, String secretKey,List<File> files) {
		log.info("In writeAndDeleteFile method Start in AWSUtil");
    	String s3Path = IConstant.FOLDER_NAME;
		
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withClientConfiguration(new ClientConfiguration().withMaxConnections(3000)
				.withConnectionTimeout(120 * 1000).withMaxErrorRetry(15))
				.withRegion(s3Region).build();

		if (!ObjectUtils.isEmpty(client)) {
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(0);
			InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, s3Path, emptyContent, metadata);
			client.putObject(putObjectRequest);
			List<String> results = new ArrayList<String>();

			if (!CollectionUtils.isNullOrEmpty(files)) {
				for (File file : files) {
					if (true) {
						results.add(file.getName());
						client.putObject(new PutObjectRequest(bucketName, s3Path + file.getName(),
								new File(file.getPath())).withCannedAcl(CannedAccessControlList.PublicRead));
						S3Object s3object = client.getObject(new GetObjectRequest(bucketName, s3Path + file.getName()));
						log.info("In writeAndDeleteFile method End in AWSUtil");
					}
				}
			}
		}
	}
}
