package Test;


import controller.XMLController;
import model.XMLModel;
import view.XMLView;

public class Test {
public static void main(String[] args) {
	XMLView view= new XMLView();
	XMLModel model= new XMLModel();
	XMLController controller=new XMLController(model, view);
}
}
