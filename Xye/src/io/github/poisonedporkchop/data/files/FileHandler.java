package io.github.poisonedporkchop.data.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

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
							
							writer.write(currentLine);

							reader.mark(500);

							currentLine = reader.readLine();

							if (currentLine != null) {

								writer.newLine();

							}

							reader.reset();
						
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
	 * Processes a file of downloaded stocks and removes unnecessary data from it.
	 * 
	 * @param path - The folder where the file of stocks to convert is in.
	 * @param targetPath - The folder to put the converted stocks in.
	 * @param fileName - Name of the file to convert.
	 * @return Whether or not the conversion was successful.
	 */
	
	public boolean processTrade(String path, String targetPath, String fileName) {
		
		FileReader fileReader = null;
		
		FileWriter fileWriter = null;
		
		this.createFolder(path);
		
		File file = new File("C:\\Xye\\" + path + "\\" + fileName);
		
		if (file.isFile()) {
			
			this.createFolder(targetPath);
			
			File newFile = new File("C:\\Xye\\" + targetPath + "\\" + file.getName());
			
			try {
				
				fileReader = new FileReader(file);
				
				fileWriter = new FileWriter(newFile);
				
			} catch (IOException e1) {
				
				System.out.println("ERROR: A problem has occurred with the file edit!");
				
				return false;
				
			}
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			String currentLine;
			
			try {
				
				while ((currentLine = reader.readLine()) != null) {
					
					String trimmedLine = currentLine.trim();
					
					if (!trimmedLine.startsWith("Date,Open,High,Low,Close")) {
						
						writer.write(currentLine);

						reader.mark(500);

						currentLine = reader.readLine();

						if (currentLine != null) {

							writer.newLine();

						}

						reader.reset();
					
					}
					
				}
				
				writer.close();
				
				reader.close();
				
				if (newFile.length() == 0) {
					
					newFile.delete();
					
				}
				
			} catch (IOException e) {
				
				System.out.println("ERROR: A problem has occurred with the file edit!");
				
				return false;
				
			}
			
		}
		
		return false;
		
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
	
	/**
	 * A merge of two files, putting their contents into a new one.
	 * 
	 * @param firstFilePath - Path of the first file to merge.
	 * @param secondFilePath - Path of the second file to merge.
	 * @param newFilePath - Folder of the new combined file.
	 * @param newFileName - Name of the new combined file.
	 * @return Whether or not the merge was successful.
	 */
	
	public boolean mergeFiles(String firstFilePath, String secondFilePath, String newFilePath, String newFileName) {
		
		FileReader fileReader1 = null;
		
		FileReader fileReader2 = null;
		
		FileWriter fileWriter = null;
		
		File file1 = new File("C:\\Xye\\" + firstFilePath);
		
		File file2 = new File("C:\\Xye\\" + secondFilePath);
		
		if (file1.isFile() && file2.isFile()) {
			
			this.createFolder(newFilePath);
			
			File newFile = new File("C:\\Xye\\" + newFilePath + "\\" + "TEMP" + new Random().nextInt(9) + new Random().nextInt(9) + new Random().nextInt(9) + new Random().nextInt(9) + new Random().nextInt(9));
			
			try {
				
				fileReader1 = new FileReader(file1);
				
				fileReader2 = new FileReader(file2);
				
				fileWriter = new FileWriter(newFile);
				
			} catch (IOException e1) {
				
				System.out.println("ERROR: A problem has occurred with the file create!");
				
				return false;
				
			}
			
			BufferedReader reader1 = new BufferedReader(fileReader1);
			
			BufferedReader reader2 = new BufferedReader(fileReader2);
			
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			String currentLine;
			
			try {
				
				while ((currentLine = reader1.readLine()) != null) {

					writer.write(currentLine);

					reader1.mark(500);

					currentLine = reader1.readLine();

					if (currentLine != null) {

						writer.newLine();

					}

					reader1.reset();
					
				}
				
				reader1.close();
				
				writer.newLine();
				
				while ((currentLine = reader2.readLine()) != null) {

					writer.write(currentLine);

					reader2.mark(500);

					currentLine = reader2.readLine();

					if (currentLine != null) {

						writer.newLine();

					}

					reader2.reset();
					
				}
				
				reader2.close();
				
				writer.close();
				
				if (newFile.length() == 0) {
					
					newFile.delete();
					
				}
				
				newFile.renameTo(new File(("C:\\Xye\\" + newFilePath + "\\" + newFileName)));
				
			} catch (IOException e) {
				
				System.out.println("ERROR: A problem has occurred with the file create!");
				
				return false;
				
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * A merge of two files, putting their contents into a new one.
	 * 
	 * @param firstFilePath - Path of the first file to merge.
	 * @param secondFilePath - Folder of the second file to merge.
	 * @param secondFileName - Name of the second file to merge.
	 * @param firstFileFirst - Whether the first file is put in front of or after the second.
	 * @return Whether or not the merge was successful.
	 */
	
	public boolean mergeFiles(String firstFilePath, String secondFilePath, String secondFileName, boolean firstFileFirst) {
		
		FileReader fileReader1 = null;
		
		FileReader fileReader2 = null;
		
		FileWriter fileWriter = null;
		
		File file1 = new File("C:\\Xye\\" + firstFilePath);
		
		File file2 = new File("C:\\Xye\\" + secondFilePath);
		
		if (file1.isFile() && file2.isFile()) {
			
			this.createFolder("C:\\Xye" + secondFilePath);
			
			File newFile = new File("C:\\Xye\\" + secondFilePath + "\\" + "TEMP" + new Random().nextInt(9) + new Random().nextInt(9) + new Random().nextInt(9) + new Random().nextInt(9) + new Random().nextInt(9));
			
			try {
				
				fileReader1 = new FileReader(file1);
				
				fileReader2 = new FileReader(file2);
				
				fileWriter = new FileWriter(newFile);
				
			} catch (IOException e1) {
				
				System.out.println("ERROR: A problem has occurred with the file create!");
				
				return false;
				
			}
			
			BufferedReader reader1 = new BufferedReader(fileReader1);
			
			BufferedReader reader2 = new BufferedReader(fileReader2);
			
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			String currentLine;
			
			try {
				
				if(firstFileFirst) {
				
				while ((currentLine = reader1.readLine()) != null) {

					writer.write(currentLine);

					reader1.mark(500);

					currentLine = reader1.readLine();

					if (currentLine != null) {

						writer.newLine();

					}

					reader1.reset();
					
				}
				
				reader1.close();
				
				writer.newLine();
				
				while ((currentLine = reader2.readLine()) != null) {

					writer.write(currentLine);

					reader2.mark(500);

					currentLine = reader2.readLine();

					if (currentLine != null) {

						writer.newLine();

					}

					reader1.reset();
					
				}
				
				reader2.close();
				
				writer.close();
				
				}
				else
				{
					
					while ((currentLine = reader2.readLine()) != null) {

						writer.write(currentLine);

						reader2.mark(500);

						currentLine = reader2.readLine();

						if (currentLine != null) {

							writer.newLine();

						}

						reader2.reset();
						
					}
					
					reader2.close();
					
					writer.newLine();
					
					while ((currentLine = reader1.readLine()) != null) {

						writer.write(currentLine);

						reader1.mark(500);

						currentLine = reader1.readLine();

						if (currentLine != null) {

							writer.newLine();

						}

						reader1.reset();
						
					}
					
					reader1.close();
					
					writer.close();
					
				}
				
				if (newFile.length() == 0) {
					
					newFile.delete();
					
				}
				
				newFile.renameTo(new File(file2.getAbsolutePath()));
				
			} catch (IOException e) {
				
				System.out.println("ERROR: A problem has occurred with the file create!");
				
				return false;
				
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * A merge of two files, putting their contents into a new one.
	 * 
	 * @param firstFilePath - Path of the first file to merge.
	 * @param secondFilePath - Folder of the second file to merge.
	 * @param secondFileName - Name of the second file to merge.
	 * @return Whether or not the merge was successful.
	 */
	
	public boolean mergeFiles(String firstFilePath, String secondFilePath, String secondFileName) {
		
		FileReader fileReader1 = null;
		
		FileReader fileReader2 = null;
		
		FileWriter fileWriter = null;
		
		File file1 = new File("C:\\Xye\\" + firstFilePath);
		
		File file2 = new File("C:\\Xye\\" + secondFilePath);
		
		if (file1.isFile() && file2.isFile()) {
			
			this.createFolder("C:\\Xye" + secondFilePath);
			
			File newFile = new File("C:\\Xye\\" + secondFilePath + "\\" + "TEMP" + new Random().nextInt(9) + new Random().nextInt(9) + new Random().nextInt(9) + new Random().nextInt(9) + new Random().nextInt(9));
			
			try {
				
				fileReader1 = new FileReader(file1);
				
				fileReader2 = new FileReader(file2);
				
				fileWriter = new FileWriter(newFile);
				
			} catch (IOException e1) {
				
				System.out.println("ERROR: A problem has occurred with the file create!");
				
				return false;
				
			}
			
			BufferedReader reader1 = new BufferedReader(fileReader1);
			
			BufferedReader reader2 = new BufferedReader(fileReader2);
			
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			String currentLine;
			
			try {
				
				while ((currentLine = reader1.readLine()) != null) {

					writer.write(currentLine);

					reader1.mark(500);

					currentLine = reader1.readLine();

					if (currentLine != null) {

						writer.newLine();

					}

					reader1.reset();
					
				}
				
				reader1.close();
				
				writer.newLine();
				
				while ((currentLine = reader2.readLine()) != null) {

					writer.write(currentLine);

					reader2.mark(500);

					currentLine = reader2.readLine();

					if (currentLine != null) {

						writer.newLine();

					}

					reader1.reset();
					
				}
				
				reader2.close();
				
				writer.close();
				
				newFile.renameTo(new File(file2.getAbsolutePath()));
				
			} catch (IOException e) {
				
				System.out.println("ERROR: A problem has occurred with the file create!");
				
				return false;
				
			}
			
		}
		
		return false;
		
	}
	
}
