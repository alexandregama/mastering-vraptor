package com.mastering.vraptor.filesaver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import br.com.caelum.vraptor.observer.upload.UploadedFile;

public class FileUploadedSaver {

	public static ImageSaverOnPath save(UploadedFile image) {
		return new ImageSaverOnPath(image);
	}

	public static class ImageSaverOnPath {
		
		private static UploadedFile uloadedFile;
		
		public ImageSaverOnPath(UploadedFile image) {
			uloadedFile = image;
		}
		
		public ImageSaverWithName onPath(String imagePath) {
			return new ImageSaverWithName(imagePath);
		}
		
		public static class ImageSaverWithName {
			
			private static String imageOnPath;
			
			public ImageSaverWithName(String imagePath) {
				imageOnPath = imagePath;
			}
			
			public void withName(String fileName) {
				try {
					IOUtils.copy(uloadedFile.getFile(), new FileOutputStream(new File(imageOnPath + fileName)));
				} catch (IOException e) {
					throw new RuntimeException(String.format("Error while trying to upload a new image", uloadedFile.getFileName()), e);
				}			
			}
		}
	}
	

}
