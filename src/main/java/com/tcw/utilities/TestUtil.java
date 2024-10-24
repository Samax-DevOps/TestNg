package com.tcw.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Set;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;

import com.tcw.base.BasePage;

public class TestUtil extends BasePage {

	public static String projectPath = System.getProperty("user.dir");
	public static Date d;
	public static String parentWindow;
	public static Set<String> allWindows;

	public static String sourceDirPath = projectPath + "\\target\\reports";
	public static String zipFilePath;

	static File fileToBeCleaned = new File(downloadPath);

	static File fileToBeChecked;

	public static void removeFilesFromFolder() {
		try {
			FileUtils.cleanDirectory(fileToBeCleaned);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isFileExists(String fName) {
		fileToBeChecked = new File(downloadPath + "\\" + fName);
		return fileToBeChecked.exists();
	}

	public static void pack() {
		d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_");

		if (!(new File(projectPath + "\\src\\test\\resources\\zipFolder").exists())) {
			try {
				Files.createDirectory(Path.of(projectPath + "\\src\\test\\resources\\zipFolder"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		zipFilePath = projectPath + "\\src\\test\\resources\\zipFolder\\" + fileName + ".zip";
		Path p = null;
		try {
			p = Files.createFile(Paths.get(zipFilePath));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Path pp = Paths.get(sourceDirPath);
		try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p)); Stream<Path> paths = Files.walk(pp)) {
			paths.filter(path -> !Files.isDirectory(path)).forEach(path -> {
				ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
				try {
					zs.putNextEntry(zipEntry);
					Files.copy(path, zs);
					zs.closeEntry();
				} catch (IOException e) {
					System.err.println(e);
				}
			});
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static String getParentWindowHandleString() {
		parentWindow = td.get().getWindowHandle();
		return parentWindow;
	}

	public static Set<String> getAllWindowHandleString() {
		allWindows = td.get().getWindowHandles();
		return allWindows;

	}

	public static boolean waitForDownloadCompleteByLoop(String fileNameSubString, int timeOutSeconds) {
		int count = 0;
		boolean b = false;
		OuterLoop: while (count < timeOutSeconds) {
			count++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			File[] files = new File(downloadPath).listFiles();

			for (File file : files) {
				System.out.println("Inside loop for: " + count);
				if (file.getName().contains(fileNameSubString)) {
					b = true;
					break OuterLoop;
				}
			}
		}

		return b;

	}

}
