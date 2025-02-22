
public class MyIntStack {
   private int[] contents;
   private int tos; 
   public MyIntStack(int capacity) {
      contents = new int[capacity];
      tos = -1;
   }
 
   public void push(int element) throws IllegalArgumentException {
	   if(tos==contents.length-1)
	   {
		   throw new IllegalArgumentException("Full Stack");
	   }
      contents[++tos] = element;
   }
 
   public int pop() {
      return contents[tos--];
   }
 
   public int peek() {
      return contents[tos];
   }
 
   public boolean isEmpty() {
      return tos < 0;
   }
 
   public boolean isFull() {
      return tos == contents.length - 1;
   }
   public boolean pushLogic(int element) {
	      if (tos==contents.length-1) {
	         return false;
	      }
	      contents[++tos] = element;
	      return true;
	   }
   public void pushWithResize(int element) {
	      if (tos==contents.length-1) {
	         int newCapacity = contents.length + 1;
	         int[] newContents = new int[newCapacity];
	         System.arraycopy(contents, 0, newContents, 0, contents.length);
	         contents = newContents;
	      }
	      contents[++tos] = element;
	   } 
}