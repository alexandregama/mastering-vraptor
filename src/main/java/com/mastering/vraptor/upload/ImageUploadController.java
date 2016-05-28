package com.mastering.vraptor.upload;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

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
		FileUploadedSaver.save(image).onPath(UPLOADED_IMAGES_PATH).withName(image.getFileName());
		
		Map<String, String> sucessMessage = new HashMap<>();
		sucessMessage.put("filePath", UPLOADED_IMAGES_PATH + image.getFileName());
		sucessMessage.put("message", "sucess");
		Gson gson = new Gson();
		String json = gson.toJson(sucessMessage);
		
		result.use(json()).withoutRoot().from(json).serialize();
	}
	
}
