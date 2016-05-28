package com.mastering.vraptor.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;

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

	public ImageUploadController(Result result) {
		this.result = result;
	}

	@Get("/images")
	public void show() {
	}
	
	@Post("/images/upload")
	public void upload(UploadedFile image) {
		System.out.println("Image to be uploaded: " + image.getFileName());
		try {
			IOUtils.copy(image.getFile(), new FileOutputStream(new File("/tmp/procurando-ape/" + image.getFileName())));
			
			result.include("uploadSuccess", "Upload Success");
			result.redirectTo(this).show();
		} catch (IOException e) {
			throw new RuntimeException(String.format("Error while trying to upload a new image", image.getFileName()), e);
		}
	}
	
}
