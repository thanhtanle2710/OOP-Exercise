import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTask implements Runnable{
	 private final String inputFile;
	 private final FileCombiner fileCombiner;

	    public FileReaderTask(String inputFile, FileCombiner fileCombiner) {
	        this.inputFile = inputFile;
	        this.fileCombiner = fileCombiner;
	    }
	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line;
		try {
			while((line=bufferedReader.readLine())!=null)
			{
				fileCombiner.writeLine(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
