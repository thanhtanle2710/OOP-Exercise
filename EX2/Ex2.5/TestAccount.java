

public class TestAccount {
public static void main(String[] args) {
	Customer customer= new Customer(123,"Nguyễn Văn A",'m');
	System.out.println(customer);
	System.out.println("id:"+customer.getId());
	System.out.println("name:"+customer.getName());
	System.out.println("gender:"+customer.getGender());
	Account account= new Account(102, customer, 200000);
	System.out.println(account);
	
	account.withdraw(150000);//Rút 150000
	System.out.println("Balance="+account.getBalance());//Số dư sau khi rút
	account.deposit(50000);//Nạp 50000
	System.out.println("Balance="+account.getBalance());//Số dư sau khi nạp
	account.withdraw(200000);//Rút 200000 sẽ không được vì vượt quá số dư
	System.out.println("Balance="+account.getBalance());
	
}
}
