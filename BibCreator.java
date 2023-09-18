package finalProjectSubmission;
import java.io.*;
import java.util.Scanner;

public class BibCreator {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		Scanner[] sc = new Scanner[10];
		int i = 1;
		String FileFinder = "";
		
		System.out.println("Welcome to BibCreator!");
		
		try {
			for(i = 1; i < 11; i++) {
				sc[i - 1] = new Scanner(new FileInputStream("Latex" + i + ".bib"));
			}
		}
		catch(FileNotFoundException e1) {
			System.out.println("Could not open input file Latex" + (i+1) + ".bib for reading. Please check if file exists.\nProgram will terminate after closing any opened files.");
			System.exit(0);
		}
		
		PrintWriter[] pw1 = new PrintWriter[10];
		PrintWriter[] pw2 = new PrintWriter[10];
		PrintWriter[] pw3 = new PrintWriter[10];
		
		try {
			for(i = 1; i < 11; i++) {
				FileFinder = "IEEE";
				pw1[i-1] = new PrintWriter(new FileOutputStream("IEEE" + i + ".json", true));
				FileFinder = "ACM";
				pw2[i-1] = new PrintWriter(new FileOutputStream("ACM" + i + ".json", true));
				FileFinder = "NJ";
				pw3[i-1] = new PrintWriter(new FileOutputStream("NJ" + i + ".json", true));
				pw1[i-1].close();
				pw2[i-1].close();
				pw3[i-1].close();
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Could not create output file " + FileFinder + i + ".json\nWill terminate program now");
			System.exit(0);
		}
		
		for(i = 1; i < 11; i++) {
			FileValidation.processFilesForValidation(i);
		}
		System.out.println("A total of " + FileValidation.count + " files were invalid. There are only " + (10 - FileValidation.count) + " valid files that have been processed");
		BufferedReader br = null;
		String line = null;
		
		try {
			FileValidation.reviewFile(br, line, kb);
		}	catch(FileNotFoundException e) {
			System.out.println("File could not be opened. File does not exist!");
			try {
				FileValidation.reviewFile(br, line, kb);
			}
			catch(FileNotFoundException ex) {
				System.out.println("Could not open input file. File does not exist!\nProgram will now terminate");
				System.exit(0);
			}
			catch(IOException ex) {
				System.out.println("IO Exception occured! Program will now terminate");
				System.exit(0);
			}	
		}
		catch(IOException e) {
			System.out.println("IO Exception occured! Program will now terminate!");
			System.exit(0);
		}

	}

}
