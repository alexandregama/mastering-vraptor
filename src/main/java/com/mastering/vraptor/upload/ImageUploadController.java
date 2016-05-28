package com.mastering.vraptor.upload;

import static br.com.caelum.vraptor.view.Results.json;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.google.gson.Gson;
import com.mastering.vraptor.filesaver.FileUploadedSaver;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;

@Controller
public class ImageUploadController {
	
	private static final String UPLOADED_IMAGES_PATH = "/Users/developer/java/workspace/mastering-vraptor/src/main/webapp/uploaded-images/";
	private static final String IMAGES_PATH = "uploaded-images/";
	
	@Inject
	private Result result;
	
	ImageUploadController() {
	}

	public ImageUploadController(Result result, FileUploadedSaver imageSaver) {
		this.result = result;
	}

	@Get("/images")
	public void show() {
	}
	
	@Post("/images/upload")
	public void upload(UploadedFile image) {
		FileUploadedSaver.save(image).onPath(UPLOADED_IMAGES_PATH).withName(image.getFileName());
		
		result.include("uploadSuccess", "Upload Success");
		result.redirectTo(this).show();
	}
	
	@Post("/images/upload/ajax")
	public void uploadAjax(UploadedFile image) {
		FileUploadedSaver.save(image).onPath(UPLOADED_IMAGES_PATH).withName(image.getFileName());
		
		Map<String, String> sucessMessage = new HashMap<>();
		sucessMessage.put("filePath", IMAGES_PATH + image.getFileName());
		sucessMessage.put("message", "sucess");
		Gson gson = new Gson();
		String json = gson.toJson(sucessMessage);
		
		result.use(json()).withoutRoot().from(json).serialize();
	}
	
	@Post("/images/upload/ajax/s3")
	public void uploadAjaxToAmazonS3(UploadedFile image) {
		File savedFile = FileUploadedSaver.save(image).onPath(UPLOADED_IMAGES_PATH).withName(image.getFileName());
		
		AmazonS3 s3Client = new AmazonS3Client(new DefaultAWSCredentialsProviderChain());
		Region region = Region.getRegion(Regions.US_EAST_1);
		s3Client.setRegion(region);
		String bucketName = "procurando-ape/upload";
		s3Client.listBuckets().forEach(bucket -> System.out.println(bucket.getName()));
		PutObjectResult s3ObjectResult = s3Client.putObject(new PutObjectRequest(bucketName, image.getFileName(), savedFile));
		
		Map<String, String> sucessMessage = new HashMap<>();
		sucessMessage.put("filePath", IMAGES_PATH + image.getFileName());
		sucessMessage.put("message", "sucess");
		Gson gson = new Gson();
		String json = gson.toJson(sucessMessage);
		
		result.use(json()).withoutRoot().from(json).serialize();
	}
	
}
