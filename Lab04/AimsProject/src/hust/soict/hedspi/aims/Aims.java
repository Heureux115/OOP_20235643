package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.*;

public class Aims {
	private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        // Init add media to the store
        initSetup();
        boolean exit = false;
        while (!exit) {
            showMenu();

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 0:
                    exit = true;
                    System.out.println("Good bye!");
                    break;
                case 1:
                    clearConsole();
                    storeMenu(sc);
                    break;
                case 2:
                    clearConsole();
                    updateStoreMenu(sc);
                    break;
                case 3:
                    clearConsole();
                    cartMenu(sc);
                    break;
                default:
                    clearConsole();
                    System.out.println("Invalid option, please choose again");
                    break;
            }

        }

    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // init store setup
    public static void initSetup() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        clearConsole();
    }

    // Print
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu(Scanner sc) {
        boolean back = false;
        while (!back) {
            store.print();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");

            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 0:
                    clearConsole();
                    back = true;
                    break;
                case 1:
                    boolean foundDetails = false;
                    while (!foundDetails) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = sc.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(title);
                        if (media != null) {
                            clearConsole();
                            System.out.println("Details: ");
                            System.out.println(media);
                            mediaDetailsMenu(sc, media);
                            foundDetails = true;
                        } else System.out.println("***MEDIA NOT FOUND***");
                    }
                    break;
                case 2:
                    boolean foundAdd = false;
                    while (!foundAdd) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = sc.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(title);
                        if (media != null) {
                            cart.addMedia(media);
                            foundAdd = true;
                        } else System.out.println("***MEDIA NOT FOUND***");
                    }
                    break;
                case 3:
                    boolean foundPlay = false;
                    while (!foundPlay) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = sc.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(title);
                        if (media != null) {
                            if (media instanceof Disc || media instanceof CompactDisc) media.play();
                            else System.out.println("This type of media is not supported");
                            foundPlay = true;
                        } else System.out.println("***MEDIA NOT FOUND***");
                    }
                    break;
                case 4:
                    clearConsole();
                    cartMenu(sc);
                    break;
                default:
                    clearConsole();
                    System.out.println("Invalid option, please choose again");
                    break;
            }
        }
    }

    public static void mediaDetailsMenu(Scanner sc, Media media) {
        boolean back = false;
        while (!back) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 0:
                    clearConsole();
                    back = true;
                    break;
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Disc || media instanceof CompactDisc) media.play();
                    else System.out.println("This type of media is not supported");
                    break;
                default:
                    clearConsole();
                    System.out.println("Invalid option, please choose again");
                    break;
            }
        }
    }

    public static void cartMenu(Scanner sc) {
        boolean back = false;
        while (!back) {
            cart.print();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");

            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 0:
                    clearConsole();
                    back = true;
                    break;
                case 1:
                    System.out.println("Filter medias in cart by (1) id or (2) title: ");
                    int filterOption = sc.nextInt();
                    sc.nextLine();
                    boolean found = false;
                    while (!found) {
                        if (filterOption == 1) {
                            System.out.println("Enter the id to filter (type 0 to stop): ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            if (id == 0) {
                                clearConsole();
                                break;
                            }
                            cart.searchByID(id);
                            found = true;
                        } else if (filterOption == 2) {
                            System.out.println("Enter the title to filter (type 0 to stop):");
                            String title = sc.nextLine();
                            if (title.equals("0")) {
                                clearConsole();
                                break;
                            }
                            cart.searchByTitle(title);
                            found = true;
                        } else if (filterOption == 0) {
                            clearConsole();
                            break;
                        } else System.out.println("Invalid option");
                    }
                    break;
                case 2:
                    System.out.println("Sort medias in cart by (1) title or (2) cost: ");
                    int sortOption = sc.nextInt();
                    sc.nextLine();
                    if (sortOption == 1) cart.sortMediaByTitle();
                    else if (sortOption == 2) cart.sortMediaByCost();
                    else System.out.println("Invalid option.");
                    break;
                case 3:
                    boolean foundRemove = false;
                    while (!foundRemove) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = sc.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = cart.searchToRemove(title);
                        if (media != null) {
                            clearConsole();
                            cart.removeMedia(media);
                            foundRemove = true;
                        } else System.out.println("***MEDIA NOT FOUND***");
                    }
                    break;
                case 4:
                    boolean foundPlay = false;
                    while (!foundPlay) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = sc.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(title);
                        if (media != null) {
                            if (media instanceof Disc || media instanceof CompactDisc) media.play();
                            else System.out.println("This type of media is not supported!");
                            foundPlay = true;
                        } else System.out.println("***MEDIA NOT FOUND***");
                    }
                    break;
                case 5:
                    clearConsole();
                    cart.empty();
                    break;
                default:
                    clearConsole();
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
    }

    public static void updateStoreMenu(Scanner sc) {
        boolean back = false;
        while (!back) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 0:
                    clearConsole();
                    back = true;
                    break;
                case 1:
                    System.out.println("Enter the category of the media (1) Book, (2) CD, (3) DVD or (0) exit: ");
                    int categoryChoice = sc.nextInt();
                    sc.nextLine();

                    if (categoryChoice == 1) {
                        System.out.println("Enter book title: ");
                        String bookTitle = sc.nextLine();
                        System.out.println("Enter book category: ");
                        String bookCategory = sc.nextLine();
                        System.out.println("Enter book cost: ");
                        Float bookCost = sc.nextFloat();
                        sc.nextLine();

                        Book newBook = new Book(bookTitle, bookCategory, bookCost);
                        store.addMedia(newBook);
                    } else if (categoryChoice == 2) {
                        System.out.println("Enter CD title: ");
                        String cdTitle = sc.nextLine();
                        System.out.println("Enter CD category: ");
                        String cdCategory = sc.nextLine();
                        System.out.println("Enter CD artist: ");
                        String cdArtist = sc.nextLine();
                        System.out.println("Enter CD cost: ");
                        Float cdCost = sc.nextFloat();
                        sc.nextLine();

                        CompactDisc newCD = new CompactDisc(cdTitle, cdCategory, cdArtist, cdCost);

                        System.out.println("Do you want to add tracks to your CD? (1) Yes (0) No: ");
                        int addTrack = sc.nextInt();
                        sc.nextLine();

                        if (addTrack == 1) {
                            System.out.println("How many tracks in your CD?");
                            int numTrack = sc.nextInt();
                            sc.nextLine();
                            for (int i = 0; i < numTrack; i++) {
                                System.out.println("Your " + (i+1) + " track: ");
                                System.out.println("Enter track title: ");
                                String trackTitle = sc.nextLine();
                                System.out.println("Enter track length: ");
                                int trackLength = sc.nextInt();
                                sc.nextLine();

                                Track newTrack = new Track(trackTitle, trackLength);
                                newCD.addTrack(newTrack);
                            }
                            store.addMedia(newCD);
                        } else if (addTrack == 0) store.addMedia(newCD);
                    } else if (categoryChoice == 3) {
                        System.out.println("Enter DVD title: ");
                        String dvdTitle = sc.nextLine();
                        System.out.println("Enter DVD category: ");
                        String dvdCategory = sc.nextLine();
                        System.out.println("Enter book cost: ");
                        Float dvdCost = sc.nextFloat();
                        sc.nextLine();

                        DigitalVideoDisc newDVD = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdCost);
                        store.addMedia(newDVD);
                    } else if (categoryChoice == 0) {
                        clearConsole();
                        break;
                    } else System.out.println("Invalid option.");
                    break;
                case 2:
                    boolean foundRemove = false;
                    while (!foundRemove) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String titleForRemove = sc.nextLine();
                        if (titleForRemove.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(titleForRemove);
                        if (media != null) {
                            clearConsole();
                            store.removeMedia(media);
                            foundRemove = true;
                        } else System.out.println("***MEDIA NOT FOUND***");
                    }
                    break;
                default:
                    clearConsole();
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
    }
}