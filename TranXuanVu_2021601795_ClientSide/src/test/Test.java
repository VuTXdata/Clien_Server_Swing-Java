package test;
import model.ClientModel;

public class Test {
	public static void main(String[] args) {
		ClientModel c = new ClientModel();
		new Thread(c).start();
	}
}
