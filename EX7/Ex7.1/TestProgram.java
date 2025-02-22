
import java.util.Date;

public class TestProgram {
 public static void main(String[] args) {
     // Create customers
     Customer customer1 = new Customer("Winter");
     customer1.setMember(true);
     customer1.setType("Premium");
     Customer customer2 = new Customer("Summer");
     customer2.setMember(false);

     Visit visit1 = new Visit(customer1.getName(), new Date());
     visit1.setServiceExpense(400);
     visit1.setProductExpense(40);

     Visit visit2 = new Visit(customer2.getName(), new Date());
     visit2.setServiceExpense(84);
     visit2.setProductExpense(30);

     System.out.println("Total expense for Winter " + calculateTotal(visit1, customer1));
     System.out.println("Total expense for Summer: " + calculateTotal(visit2, customer2));
 }

 public static double calculateTotal(Visit visit, Customer customer) {
	 double serviceDiscount = 0.0;
	    double productDiscount = 0.0;

	    if (customer.isMember()) { // Kiểm tra nếu khách hàng là thành viên
	        serviceDiscount = DiscountRate.getServiceDiscountRate(customer.getType());
	        productDiscount = DiscountRate.getProductDiscountRate(customer.getType());
	    }
     
     
     double serviceTotal = visit.getServiceExpense() * (1 - serviceDiscount);
     double productTotal = visit.getProductExpense() * (1 - productDiscount);
     
     return serviceTotal + productTotal;
 }
}

