package hust.soict.hedspi.aims.screen.manager;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

	public AddBookToStoreScreen(Store store) {
		super(store, "Add Book", 5, 2);
		setJMenuBar(createMenuBar()); // <-- Thêm dòng này để hiển thị menu
	}

	private JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");

		JMenuItem viewStore = new JMenuItem("View store");
		viewStore.addActionListener(e -> {
			new StoreManagerScreen(store);
			this.dispose();
		});
		menu.add(viewStore);

		JMenu smUpdateStore = new JMenu("Update Store");

		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(e -> {
			new AddBookToStoreScreen(store);
			this.dispose();
		});
		smUpdateStore.add(addBook);

		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(e -> {
			new AddCompactDiscToStoreScreen(store);
			this.dispose();
		});
		smUpdateStore.add(addCD);

		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(e -> {
			new AddDigitalVideoDiscToStoreScreen(store);
			this.dispose();
		});
		smUpdateStore.add(addDVD);

		menu.add(smUpdateStore);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

	@Override
	protected void createForm() {
		JTextField titleField = new JTextField();
		JTextField categoryField = new JTextField();
		JTextField costField = new JTextField();
		JTextField authorsField = new JTextField(); // Nhập: "Nguyễn Văn A, Trần B"

		add(new JLabel("Title:"));
		add(titleField);
		add(new JLabel("Category:"));
		add(categoryField);
		add(new JLabel("Cost ($):"));
		add(costField);
		add(new JLabel("Authors (comma-separated):"));
		add(authorsField);

		JButton addButton = new JButton("Add Book");
		addButton.addActionListener(e -> {
			try {
				String title = titleField.getText();
				String category = categoryField.getText();
				float cost = Float.parseFloat(costField.getText());

				List<String> authors = new ArrayList<>();
				for (String author : authorsField.getText().split(",")) {
					authors.add(author.trim());
				}

				Book book = new Book(title, category, cost, authors);
				addMediaToStore(book);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage());
			}
		});

		add(addButton);
	}
}
