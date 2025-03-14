import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exercise6 {
	private static final String OUTPUT_FILE = "C:/Users/DELL/Documents/output.txt";

	

    public static void main(String[] args) {
        List<String> inputFiles = new ArrayList<>();
        inputFiles.add("C:/Users/DELL/Documents/a.txt");
        inputFiles.add("C:/Users/DELL/Documents/b.txt");
    

        FileCombiner fileCombiner = new FileCombiner(OUTPUT_FILE);
        List<Thread> threads = new ArrayList<>();

        for (String inputFile : inputFiles) {
            FileReaderTask task = new FileReaderTask(inputFile, fileCombiner);
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        }

        try {
            fileCombiner.close(); // Đóng BufferedWriter sau khi tất cả các thread hoàn thành
        } catch (IOException e) {
            System.err.println("Lỗi khi đóng FileCombiner: " + e.getMessage());
        }

        System.out.println("Gộp file hoàn thành.");
    }

}
