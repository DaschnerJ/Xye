package io.github.poisonedporkchop.data.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	
	/**
	 * Processes a folder of downloaded stocks and removes unnecessary data from it.
	 * 
	 * @param path - The folder full of stocks to convert.
	 * @param targetPath - The folder to put the converted stocks in.
	 * @return Whether or not the conversion was successful.
	 */
	
	public boolean processTrade(String path, String targetPath) {

		FileReader fileReader = null;

		FileWriter fileWriter = null;

		File[] children;

		this.createFolder(path);

		File f = new File("C:\\Xye\\" + path);

		if (f.isDirectory()) {

			children = f.listFiles();

			if (children == null) {

				return false;

			}

		} else {

			System.out.println("ERROR: Invalid path at '" + path
					+ "' was found!");

			return false;

		}

		for (int x = 0; x < children.length; x++) {

			if (children[x].isFile()) {

				this.createFolder(targetPath);

				File newFile = new File("C:\\Xye\\" + targetPath + "\\" + children[x].getName());

				try {

					fileReader = new FileReader(children[x]);

					fileWriter = new FileWriter(newFile);

				} catch (IOException e1) {

					e1.printStackTrace();

					System.out.println("ERROR: Problem has occurred!");

				}

				BufferedReader reader = new BufferedReader(fileReader);

				BufferedWriter writer = new BufferedWriter(fileWriter);

				String currentLine;

				try {

					while ((currentLine = reader.readLine()) != null) {

						String trimmedLine = currentLine.trim();

						if (!trimmedLine.startsWith("Date,Open,High,Low,Close")) {

							writer.write(currentLine + System.getProperty("line.separator"));

						}

					}

					writer.close();

					reader.close();
					
					if(newFile.length() == 0) {
						
						newFile.delete();
						
					}

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

		}

		return true;

	}

	/**
	 * Creates a folder at the specified path.
	 * 
	 * @param path - The path at which to create the folder.
	 * @return True if folder was created or exists, false otherwise.
	 */

	public boolean createFolder(String path) {
	
		File f = new File("C:\\Xye\\" + path);
		
		try {
			
			f.mkdirs();
			
			return true;
			
		} catch (Exception e) {
			
			System.out.println("ERROR: Folder could not be created!");
			
			return false;
			
		}
		
	}
	
}
