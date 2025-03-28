package AimsProject;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private int qtyOrdered = 0;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered  < MAX_NUMBER_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered ++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }
	
/* 	public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
    	for (DigitalVideoDisc dvd : dvds) {
	          addDigitalVideoDisc(dvd);
	    }
	}
*/
 	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int check = 1;
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].equals(disc)) {
				qtyOrdered --;
				check = 0;
				for(int j = i; j < qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				System.out.println("The item has been removed");
			}
		}
		itemsOrdered[qtyOrdered + 1] = null;
		if(check == 1) {
			System.out.println("This item no in cart");
		}
	}
	public float totalCost() {
		float cost = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
	public void displayCart() {
		for(int i = 0; i < qtyOrdered; i++) {
			System.out.print(i + 1 + " ");
			System.out.print(itemsOrdered[i].getTitle() + " ");
			System.out.println(itemsOrdered[i].getCost());		
		}
	}
}
