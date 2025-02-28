
public class Test {
    public static void main(String[] args) {
        Buffer b1= new Buffer(5);
        Producer p1= new Producer(001, b1);
        Producer p2= new Producer(002, b1);
        Consumer c1= new Consumer(123, b1);
        Consumer c2= new Consumer(234, b1);
        p1.start();
        p2.start();
        c1.start();;
        c2.start();
    }
}
