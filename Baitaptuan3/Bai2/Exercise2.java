import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2 {
public static void main(String[] args) throws IOException {
	BufferedReader bufferReader= new BufferedReader(new InputStreamReader(System.in));
	String line="";
	
	BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter("C:/Users/DELL/Documents/c.txt"));
		while(true)
		{    
			System.out.print("Nhap du lieu: ");
			line=bufferReader.readLine();
			if(line.compareToIgnoreCase("exit")==0)
			{
			    System.out.println("Khong ghi file nua");
				break;
			}
			
			bufferedWriter.write(line);
			bufferedWriter.newLine();//Để xuống dòng trong file
			
			
		
	}
		
		bufferedWriter.close();
		bufferReader.close();
	
}
}
