
public class Philosopher implements Runnable{
    private Object duaTrai;
    private Object duaPhai;
    public Philosopher(Object duaTrai,Object duaPhai) {
		this.duaTrai=duaTrai;
		this.duaPhai=duaPhai;
	}
	@Override
	public void run() {
		while(true)
		{
			try {
				lamHanhDong("suy nghĩ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (duaTrai) {
              try {
				lamHanhDong("lấy đũa trái");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              synchronized (duaPhai) {
				try {
					lamHanhDong("lấy đũa phải và ăn");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					lamHanhDong("Bỏ đũa phải xuống");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
              try {
				lamHanhDong("Bỏ đũa trái xuống và trở lại suy nghĩ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
		
	}
	private void lamHanhDong(String hanhdong) throws InterruptedException
	{
		System.out.println(Thread.currentThread().getName()+" "+hanhdong);
		Thread.sleep(((int) (Math.random() * 100)));
		
	}

}
