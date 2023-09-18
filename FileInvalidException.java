package finalProjectSubmission;

public class FileInvalidException extends Exception{
	
	public FileInvalidException() {
		super("Error: Input file cannot be parsed due to missing information\n(i.e. month={}, title={}, etc.)");
	}
	
	
	public String getMessage() {
		return super.getMessage();
	}
	
}
