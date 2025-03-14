import java.io.File;

public class Exercise5 {
public static void main(String[] args) {
	String path= "C:/Users/DELL/Documents/";
	File directory= new File(path);
	if(directory.isDirectory())
	{
		File []files= directory.listFiles();
		if(files!=null)
		{
			for(File file: files)
			{
				System.out.println(file.getName());
			}
		}
	}
}
}
