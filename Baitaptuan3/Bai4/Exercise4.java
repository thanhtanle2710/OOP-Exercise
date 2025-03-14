import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise4 {
public static void main(String[] args) throws IOException {
	FileOutputStream fileOutputStream= new FileOutputStream("C:/Users/DELL/Documents/e.txt");
	try (DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
		int [] integers= {11,12,13,14,15,16};
		for(int i: integers)
		{
			dataOutputStream.writeInt(i);
		}
	}
	FileInputStream fileInputStream= new FileInputStream("C:/Users/DELL/Documents/e.txt");
	try (DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
		
		while(dataInputStream.available()>0)
		{
			System.out.println(dataInputStream.readInt());
		}
	}
}
}
