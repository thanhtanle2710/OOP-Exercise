import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise1 {
public static void main(String[] args) throws IOException {
	FileInputStream fileInputStream= new FileInputStream("C:/Users/DELL/Documents/a.txt");
	//Cách1
//	while(fileInputStream.available()>0)
//	{
//		char ch=(char) fileInputStream.read();
//		System.out.print(ch);
//	}
	//Cách2
    int size=fileInputStream.available();
    byte []buff= new byte[size];
    fileInputStream.read(buff, 0, size);
    String s=new String(buff);
    System.out.println(s);
    FileOutputStream fileOutputStream= new FileOutputStream("C:/Users/DELL/Documents/b.txt");
    fileOutputStream.write(buff);
    fileInputStream.close();
    
}
}
