import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Exercise3 {
public static void main(String[] args) throws IOException {
	FileReader fileReader= new FileReader("C:/Users/DELL/Documents/d.txt");
	BufferedReader bufferedReader= new BufferedReader(fileReader);
	String line="";
	int count=0;
	while((line=bufferedReader.readLine())!=null)
	{  
		System.out.println("Noi dung dong thu "+(count+1)+" : "+line);
		count++;
	}
	System.out.println("So dong trong file la: "+count);
	
}
}
