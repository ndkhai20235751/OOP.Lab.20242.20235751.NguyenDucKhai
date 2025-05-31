package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private TableColumn<Media, Integer> colMediaId;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private Label costLabel;

	@FXML
	private ToggleGroup filterCategory;

	@FXML
	private TableView<Media> tblMedia;

	// === FILTER COMPONENTS ===
	@FXML
	private TextField tfFilter;

	@FXML
	private RadioButton radioBtnFilterId;

	@FXML
	private RadioButton radioBtnFilterTitle;

	private Cart cart;
	private Store store;
	private FilteredList<Media> filteredMediaList;

	public CartController(Cart cart) {
		this.cart = cart;
	}

	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}

	public CartController() {

	}

	public void setData(Store store, Cart cart) {
		if (cart == null) {
			throw new IllegalArgumentException("Cart cannot be null!");
		}
		this.store = store;
		this.cart = cart;

		if (tblMedia != null) {
			tblMedia.setItems(cart.getItemsOrdered());
		}
		updateTotalCost();
	}

	private void updateTotalCost() {
		if (costLabel != null && cart != null) {
			float total = cart.totalCost();
			costLabel.setText(String.format("%.2f $", total));
		}
	}

	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();

		if (media instanceof Playable) {
			try {
				((Playable) media).play();
			} catch (PlayerException e) {
				System.err.println("Error while playing media: " + e.getMessage());
			}
		} else {
			System.out.println("This media is not playable.");
		}
	}

	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		cart.clear();

		tblMedia.setItems(cart.getItemsOrdered());
		tblMedia.refresh();

		costLabel.setText("0 $");

		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		if (media != null) {
			cart.removeMedia(media);
			tblMedia.setItems(cart.getItemsOrdered());
			updateTotalCost();
		}
	}

	@FXML
	void btnViewStorePressed(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));

			ViewStoreController viewStoreController = new ViewStoreController(store, cart);
			fxmlLoader.setController(viewStoreController);

			Parent root = fxmlLoader.load();

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.setTitle("Store");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void updateButtonBar(Media media) {
		if (media == null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		} else {
			btnRemove.setVisible(true);
			btnPlay.setVisible(media instanceof Playable);
		}
	}

	@FXML
	public void initialize() {
		colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			updateButtonBar(newSelection);
		});

	}

	private void showFilteredMedia(String filter) {
		if (filter == null)
			filter = "";

		final String lowerFilter = filter.toLowerCase();

		filteredMediaList.setPredicate(media -> {
			if (lowerFilter.isEmpty())
				return true;

			if (radioBtnFilterId.isSelected()) {
				return String.valueOf(media.getId()).contains(lowerFilter);
			} else if (radioBtnFilterTitle.isSelected()) {
				return media.getTitle().toLowerCase().contains(lowerFilter);
			}
			return true;
		});
	}
}
