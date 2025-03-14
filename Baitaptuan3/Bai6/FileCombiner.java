import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileCombiner  {
	private final Object lock = new Object();
	 private final String outputFile;
	    private final BufferedWriter writer;
	public FileCombiner(String outputFile) {
        this.outputFile = outputFile;
        try {
            this.writer = new BufferedWriter(new FileWriter(outputFile, true)); // true for append
        } catch (IOException e) {
            throw new RuntimeException("Không thể tạo BufferedWriter: " + e.getMessage(), e); // Xử lý lỗi khởi tạo
        }
    }
	public void writeLine(String line) throws IOException {  // Thêm throws IOException
        synchronized (lock) {
            try {
                writer.write(line);
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Lỗi ghi file: " + e.getMessage());
                throw e; // Re-throw exception để báo cho thread biết đã có lỗi
            }
        }
    }

    public void close() throws IOException {
        writer.close();
    }

}
