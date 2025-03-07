
public class TestDeadLock {
public static void main(String[] args) {
	Object resource1= new Object();
	Object resource2= new Object();
	Thread t1= new Thread() {
		@Override
		public void run() {
			synchronized (resource1) {
				System.out.println("Thread1 locked resource1");
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (resource2) {
					System.out.println("Thread1 locked resource2");
				}
			}
		}
	};
	Thread t2= new Thread() {
		@Override
		public void run() {
			synchronized (resource2) {
				System.out.println("Thread2 locked resource2");
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (resource1) {
					System.out.println("Thread2 locked resource1");
				}
			}
		}
	};
	t1.start();
	t2.start();
}
}
