

public class Customer {
private String name;
private boolean member;
private String type;
public Customer(String name) {
	super();
	this.name = name;
	this.member=false;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public boolean isMember() {
	return member;
}
public void setMember(boolean member) {
	this.member = member;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}


}
