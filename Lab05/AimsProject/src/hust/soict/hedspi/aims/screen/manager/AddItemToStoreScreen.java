package hust.soict.hedspi.aims.screen.manager;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
	protected Store store;

	public AddItemToStoreScreen(Store store, String title, int rows, int cols) {
		this.store = store;

		setTitle(title);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(rows, cols));

		createForm();

		setVisible(true);
	}

	// Phương thức trừu tượng để các lớp con triển khai form nhập liệu đặc thù
	protected abstract void createForm();

	// Phương thức dùng chung để thêm media vào store
	protected void addMediaToStore(Media media) {
		store.addMedia(media);
		JOptionPane.showMessageDialog(this, "Item added successfully!");
	}
}
