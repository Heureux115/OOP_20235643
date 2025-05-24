package hust.soict.hedspi.aims.screen.customer.main;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        store.addMedia(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 4.5f));
        store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 4.8f));
        store.addMedia(new DigitalVideoDisc("Mad Max: Fury Road", "Action", "George Miller", 120, 4.3f));
        store.addMedia(new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 5.0f));
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 4.7f));
        store.addMedia(new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 3.9f));
        store.addMedia(new DigitalVideoDisc("The Shining", "Horror", "Stanley Kubrick", 144, 4.6f));
        store.addMedia(new DigitalVideoDisc("Hereditary", "Horror", "Ari Aster", 127, 4.2f));
        store.addMedia(new DigitalVideoDisc("Avengers: Endgame", "Superhero", "Anthony Russo", 181, 5.0f));
        store.addMedia(new DigitalVideoDisc("Joker", "Psychological", "Todd Phillips", 122, 4.7f));
        launch(args);
    }
}