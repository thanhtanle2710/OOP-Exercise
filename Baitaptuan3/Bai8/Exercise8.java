import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Exercise8 {
public static void main(String[] args) throws InterruptedException {
	
	Scanner sc= new Scanner(System.in);
	String []files= {"C:/Users/DELL/Documents/a.txt","C:/Users/DELL/Documents/b.txt","C:/Users/DELL/Documents/c.txt"};
	System.out.print("Nhap tu khoa can tim kiem trong danh sach cac file: ");
    String keyword= sc.nextLine();
    Thread []threads= new Thread[files.length];
    int []counts= new int[files.length];
    for(int i=0;i<files.length;i++)
    {   
    	
    	int stt=i;
    	threads[i]=new Thread() {
    		@Override
    		public void run() {
    			try {
    				
					FileReader file=new FileReader(files[stt]);
					BufferedReader bufferedReader= new BufferedReader(file);
					String line;
					while((line=bufferedReader.readLine())!=null)
					{
						if(line.contains(keyword))
						{
							counts[stt]++;
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
    			
    			
    			
    			
    		}
    		
    	};
    	threads[i].start();
    	
    	
    }
    for (Thread t : threads) {
        t.join();
    }
    int total=0;
    for(int i=0;i<files.length;i++)
    {
    	System.out.println("Số lần từ khoá "+keyword+" xuất hiện trong file thứ "+i+" la "+counts[i]);
    	total+=counts[i];
    }
    System.out.println("Tổng số lần từ khoá xuất hiện trong tất cả các file là "+total);
	}
}
