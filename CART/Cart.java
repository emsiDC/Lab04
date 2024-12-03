

public class Cart {
    // Attribute
    private DigitalVideoDisc []itemsOrdered =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered;

    public static final int MAX_NUMBERS_ORDERED = 20;

    // Constructor
    public Cart() {
        setQtyOrdered(0);
    }

    // Setter and Getter
    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(DigitalVideoDisc[] itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    // Method to add a new DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        // If cart is full
        if (getQtyOrdered() >= 20) {
            System.out.println("The cart is almost full");
            return;
        }

        // Increase the qtyOrdered
        setQtyOrdered(getQtyOrdered() + 1);

        // Add to cart
        DigitalVideoDisc []newItemsOrdered = getItemsOrdered();
        newItemsOrdered[getQtyOrdered() - 1] = disc;
        setItemsOrdered(newItemsOrdered);

        // Notify
        System.out.println("The disc has been added");
    }

    // Overloading version
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println(disc.getTitle() + " has been added!");
			} else System.out.println("Cannot add more DVDs! The cart is almost full.");
		}
	}

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED){
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			itemsOrdered[qtyOrdered] = dvd2;
			System.out.println(dvd1.getTitle() + " and " + dvd2.getTitle() + " has been added!");
			qtyOrdered++;
		} else System.out.println("Cannot add more DVDs! The cart is almost full.");
	}

    // Method to remove a DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        // Search for disc
        int indexOfRemoved = -1;
        DigitalVideoDisc []newItemsOrdered = getItemsOrdered();
        for (int i = 0; i < getQtyOrdered(); i++) {
            if (newItemsOrdered[i].equals(disc)) {
                indexOfRemoved = i;
                break;
            }
        }

        // If not found
        if (indexOfRemoved == -1) {
            System.out.println("The disc is not found");
            return;
        }

        // Remove
        for (int i = indexOfRemoved; i < getQtyOrdered() - 1; i++) {
            newItemsOrdered[i] = newItemsOrdered[i + 1];
        }
        setQtyOrdered(getQtyOrdered() - 1);
        newItemsOrdered[getQtyOrdered() - 1] = null;
        setItemsOrdered(newItemsOrdered);

        // Notify
        System.out.println("The disc has been removed");
    }

    // Method to calculate the total cost
    public double totalCost() {
        double cost = 0;
        DigitalVideoDisc []itemsOrdered = getItemsOrdered();
        for (DigitalVideoDisc disc: itemsOrdered) {
            if (disc != null) {
                cost += disc.getCost();
            }
        }

        return Math.round(cost * 100.0) / 100.0;
    }

    public String toString(){
    	String result = "";
        for (int i = 0; i < qtyOrdered; i++) {
            result += "\n"+itemsOrdered[i].toString();
        }
        return result;
    }

    public void printCart(){
		System.out.printf("\n***********************CART***********************\n");
		System.out.printf("Ordered Items:");
		System.out.println(toString());
		System.out.printf("Total cost: $%.2f\n", totalCost());
		System.out.printf("**************************************************\n");
    }

    public void searchCart(int id){ 
    	int check = 0;
    	for(int i = 0; i < qtyOrdered; i++) {
    		if(itemsOrdered[i].isMatch(id)) {
    			check = 1;
    			System.out.printf("Found item with ID %d!\n", id);
    			System.out.println(itemsOrdered[i].toString());
    			break;
    		}
    	}
    	if (check == 0) System.out.println("Not Found!\n");
    }
    public void searchCart(String title){ 
    	int check = 0;
    	for (int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrdered[i].isMatch(title)) {
    			check = 1;
    			System.out.printf("Found item with title included %s!\n", title);
    			System.out.println(itemsOrdered[i].toString());
    			break;
    		}
    	}
    	if (check == 0) System.out.println("Not Found!\n");
    }
}
