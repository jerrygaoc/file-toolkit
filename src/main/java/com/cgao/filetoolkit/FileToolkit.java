package com.cgao.filetoolkit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileToolkit {

	public FileToolkit() {

	}

	/*
	 * getFileList fetch all files under the folder
	 */
	public static List<String> getFileList(String filePath) throws FileNotFoundException {
		File rootFolder = new File(filePath);

		if (rootFolder.isDirectory()) {

			List<String> fileList = new ArrayList<String>();
			File[] files = rootFolder.listFiles();
			for (File file : files) {
				if (!file.isDirectory()) {
					fileList.add(file.getName());
				}
			}
			return fileList;
		} else {
			throw new FileNotFoundException();
		}
	}

	/*
	 * getFileList fetch all files under the folder with exceptions
	 */
	public List<String> getFileList(String filePath, List<String> exceptionList) throws FileNotFoundException {
		File rootFolder = new File(filePath);

		if (rootFolder.isDirectory()) {
			List<String> fileList = new ArrayList<String>();
			File[] files = rootFolder.listFiles();
			for (File file : files) {
				if (!file.isDirectory()) {
					if (exceptionList == null) {
						fileList.add(file.getName());
					} else {
						boolean isException = false;
						for (String exception : exceptionList) {
							if (file.getName().equals(exception)) {
								isException = true;
							}
						}
						if (!isException) {
							fileList.add(file.getName());
						}
					}
				}
			}
			return fileList;

		} else {
			throw new FileNotFoundException();
		}

	}

	public static String getfileName(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		if (file.isFile()) {
			String fileName = file.getName();
			String[] names = fileName.split("\\.");
			return fileName.replace("." + names[names.length - 1], "");
		} else {
			throw new FileNotFoundException();
		}

	}

	public static String getFileExtension(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		if (file.isFile()) {
			String fileName = file.getName();
			String[] names = fileName.split("\\.");
			if (names.length > 0) {
				return names[names.length - 1];
			} else {
				return "";
			}
		} else {
			throw new FileNotFoundException();
		}
	}
}
