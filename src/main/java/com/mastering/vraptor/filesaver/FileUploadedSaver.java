package com.mastering.vraptor.filesaver;

import static org.apache.commons.io.IOUtils.copy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
					FileOutputStream fileOnDesiredDirectory = new FileOutputStream(new File(imageOnPath + fileName));
					InputStream uploadedFileByUser = uloadedFile.getFile();
					
					copy(uploadedFileByUser, fileOnDesiredDirectory);
				} catch (IOException e) {
					throw new RuntimeException(String.format("Error while trying to upload a new image", uloadedFile.getFileName()), e);
				}			
			}
		}
	}

}
