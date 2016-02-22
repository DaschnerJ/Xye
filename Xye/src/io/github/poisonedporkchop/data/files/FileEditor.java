package io.github.poisonedporkchop.data.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author Damien Claessen
 */

public class FileEditor {
	
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
			
			new FileHandler().createFolder(newFilePath);
			
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
			
			new FileHandler().createFolder("C:\\Xye" + secondFilePath);
			
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
			
			new FileHandler().createFolder("C:\\Xye" + secondFilePath);
			
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
