

public class Cylinder  {
	 private Circle base;
	 private double height;  
	   public Cylinder() {
		   base = new Circle(); 
		      height = 1.0;
	   }
	   public Cylinder(Circle c, double height) {
	      this.base=c;
	      this.height = height;
	   }
	   public double getHeight() {
	      return height; 
	   }
	   public double getVolume() {
	      return base.getArea()*height; 
	   }
	   @Override
	   public String toString() {      
	      return "Cylinder: " + base.toString()  
	             + " height=" + height;
	   }
}
