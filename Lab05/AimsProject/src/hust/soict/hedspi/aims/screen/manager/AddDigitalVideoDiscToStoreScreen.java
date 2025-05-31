package hust.soict.hedspi.aims.screen.manager;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store, "Add DVD", 6, 2);
		setJMenuBar(createMenuBar());
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
		JTextField directorField = new JTextField();
		JTextField lengthField = new JTextField();
		JTextField costField = new JTextField();

		add(new JLabel("Title:"));
		add(titleField);
		add(new JLabel("Category:"));
		add(categoryField);
		add(new JLabel("Director:"));
		add(directorField);
		add(new JLabel("Length (min):"));
		add(lengthField);
		add(new JLabel("Cost ($):"));
		add(costField);

		JButton addButton = new JButton("Add DVD");
		addButton.addActionListener(e -> {
			try {
				String title = titleField.getText();
				String category = categoryField.getText();
				String director = directorField.getText();
				int length = Integer.parseInt(lengthField.getText());
				float cost = Float.parseFloat(costField.getText());

				DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
				addMediaToStore(dvd);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage());
			}
		});

		add(addButton);
	}
}
