
public class CartTest {
	public static void main(String[] args){
		
		Cart anOrder = new Cart();
		DigitalVideoDisc [] dvdList = new DigitalVideoDisc[3];
		dvdList[0] = new DigitalVideoDisc("Doraemon", "Animation", "F.J.F", 100, 10f);
		dvdList[1] = new DigitalVideoDisc("Conan", "LiveAction", "abcd", 4, 17.5f);
		dvdList[2] = new DigitalVideoDisc("ABCD", "Fighting", "Minh", 16, 16.7f);
		anOrder.addDigitalVideoDisc(dvdList[0]);
		anOrder.addDigitalVideoDisc(dvdList[1], dvdList[2]);

		// print items in cart and total cost
		anOrder.printCart();
		anOrder.searchCart("CD");
		anOrder.searchCart(1);
	
    }
}