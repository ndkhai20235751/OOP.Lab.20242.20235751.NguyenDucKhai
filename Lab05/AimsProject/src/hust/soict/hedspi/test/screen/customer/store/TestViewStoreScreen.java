package hust.soict.hedspi.test.screen.customer.store;

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
		
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Philosopher's Stone", "Fantasy", "Chris Columbus", 152, 3.0f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Chamber of Secrets", "Fantasy", "Chris Columbus", 161, 3.5f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban", "Fantasy", "Alfonso Cuarón", 142, 5.0f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Goblet of Fire", "Fantasy", "Mike Newell", 157, 4.5f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Order of the Phoenix", "Fantasy", "David Yates", 138, 6.5f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Half-Blood Prince", "Fantasy", "David Yates", 153, 5.8f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Deathly Hallows - Part 1", "Fantasy", "David Yates", 146, 6.3f));
		store.addMedia(new DigitalVideoDisc("Harry Potter and the Deathly Hallows - Part 2", "Fantasy", "David Yates", 130, 7.0f));
		store.addMedia(new DigitalVideoDisc("Green Eggs and Ham", "Children", "Unknown", 90, 3.3f));
		launch(args);
	}
}
