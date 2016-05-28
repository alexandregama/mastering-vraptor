package com.mastering.vraptor.filesaver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

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
			
			public File withName(String fileName) {
				try {
					File file = new File(imageOnPath + fileName);
					InputStream uploadedFileByUser = uloadedFile.getFile();
					
					FileUtils.copyInputStreamToFile(uploadedFileByUser, file);
					return file;
				} catch (IOException e) {
					throw new RuntimeException(String.format("Error while trying to upload a new image", uloadedFile.getFileName()), e);
				}			
			}
		}
	}

}
