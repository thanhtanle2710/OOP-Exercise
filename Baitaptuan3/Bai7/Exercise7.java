import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Exercise7 {
	private static final int kichthuoc1doan=1024*1024;
public static void main(String[] args) throws IOException, InterruptedException {
	
	RandomAccessFile randomAccessFile= new RandomAccessFile("C:/Users/DELL/Documents/f.txt","r");
	long kichthuocfile= randomAccessFile.length();
	int soDoanFile= (int) (kichthuocfile/kichthuoc1doan)+1;
	byte [][]buffer= new byte[soDoanFile][kichthuoc1doan];
	Thread []threads= new Thread[soDoanFile];
	for(int i=0;i<soDoanFile;i++)
	{
		int stt=i;
		threads[i]=new Thread() {
			@Override
			public void run() {
				try {
					RandomAccessFile raf = new RandomAccessFile("C:/Users/DELL/Documents/f.txt", "r");
					raf.seek(stt*kichthuoc1doan);
					raf.read(buffer[stt], 0, kichthuoc1doan);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		};
		threads[i].start();
	}
	for (Thread t : threads) {
        t.join();
    }
	FileOutputStream fileOutputStream= new FileOutputStream("C:/Users/DELL/Documents/g.txt");
	for(byte []motdoan: buffer)
	{
		fileOutputStream.write(motdoan);
	}
	System.out.println("Hoàn tất");
	
	
	
}
}
