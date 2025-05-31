package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
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

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));

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
		store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
		store.addMedia(new CompactDisc("Festival Anthems", "Electro House", 16.25f));

		store.addMedia(new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 100, 18.50f));
		store.addMedia(new CompactDisc("Chill Vibes", "Lo-fi", 12.99f));
		store.addMedia(new CompactDisc("Rock Legends", "Rock", 17.45f));

		store.addMedia(new DigitalVideoDisc("Avengers: Endgame", "Action", "Russo Brothers", 181, 25.99f));
		store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 22.50f));
		store.addMedia(new CompactDisc("Classical Essentials", "Classical", 14.80f));

		launch(args);
	}
}
