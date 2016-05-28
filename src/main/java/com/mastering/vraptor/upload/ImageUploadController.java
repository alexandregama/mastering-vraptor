package com.mastering.vraptor.upload;

import javax.inject.Inject;

import com.mastering.vraptor.filesaver.FileUploadedSaver;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;

@Controller
public class ImageUploadController {
	
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
		FileUploadedSaver.save(image).onPath("/tmp/procurando-ape/").withName(image.getFileName());
		
		result.include("uploadSuccess", "Upload Success");
		result.redirectTo(this).show();
	}
	
}
