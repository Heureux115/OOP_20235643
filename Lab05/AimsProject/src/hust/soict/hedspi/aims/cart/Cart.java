package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Collections;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private int qtyOrdered = 0;
	
	// Add and remove media from cart
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBER_ORDERED) {
            System.out.println("The cart is almost full");
        } else if (itemsOrdered.contains(media)) {
            System.out.println(media.getTitle() + " has already in the cart");
        } else {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added");
            qtyOrdered +=1;
        }
    }
    public void removeMedia(Media media) {
        if (itemsOrdered.size() == 0) System.out.println("Nothing to remove");
        else {
            if (itemsOrdered.remove(media)) {
                System.out.println(media.getTitle() + " has been removed from the cart");
                qtyOrdered -=1;
            } else System.out.println("Media is not found in cart");
        }
    }

    // Search to remove
    public Media searchToRemove(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) return media;
        }
        return null;
    }

    public float totalCost() {
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    // Search by title, category, price (max cost/ min-max cost) and ID
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found " + media);
                found = true;
            }
        }
        if (!found) System.out.println("Not found the media with the title " + title);
    }

    public void searchByCategory(String category) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getCategory().equalsIgnoreCase(category)) {
                System.out.println("Found " + media);
                found = true;
            }
        }
        if (!found) System.out.println("Not found the media with the category " + category);
    }

    public void searchByPrice(float maxCost) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getCost() <= maxCost) {
                System.out.println("Found " + media);
                found = true;
            }
        }
        if (!found) System.out.println("Not found the media with the maximum cost provided");
    }

    public void searchByPrice(float minCost, float maxCost) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getCost() >= minCost && media.getCost() <= maxCost) {
                System.out.println("Found " + media);
                found = true;
            }
        }
        if (!found) System.out.println("Not found the media with the cost range between your specified minimum and maximum");
    }

    public void searchByID(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found " + media);
                found = true;
            }
        }
        if (!found) System.out.println("Not found the media with the ID " + id);
    }

    // Print cart
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }

        System.out.println("Total items: " + qtyOrdered);
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void empty() {
        if (itemsOrdered.size() == 0) System.out.println("Nothing to remove");
        else {
            qtyOrdered = 0;
            itemsOrdered.clear();
            System.out.println("Order is created");
            System.out.println("Now your current cart will be empty");
            System.out.println();
        }
    }

    // Sort media in cart
    public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void sortMediaByCost() {
        Collections.sort((List<Media>) itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media) iterator.next()).toString());
        }
    }
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public Cart() {}

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public void clear() {
        itemsOrdered.clear();
    }
}
