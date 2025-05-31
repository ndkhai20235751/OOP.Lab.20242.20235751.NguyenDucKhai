package hust.soict.hedspi.aims.screen.manager;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	public AddCompactDiscToStoreScreen(Store store) {
		super(store, "Add CD", 6, 2);
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
		JTextField artistField = new JTextField();
		JTextField costField = new JTextField();
		JTextField tracksField = new JTextField(); // Format: "Song A-3, Song B-4"

		add(new JLabel("Title:"));
		add(titleField);
		add(new JLabel("Category:"));
		add(categoryField);
		add(new JLabel("Artist:"));
		add(artistField);
		add(new JLabel("Cost ($):"));
		add(costField);
		add(new JLabel("Tracks (format: name-length,...):"));
		add(tracksField);

		JButton addButton = new JButton("Add CD");
		addButton.addActionListener(e -> {
			try {
				String title = titleField.getText();
				String category = categoryField.getText();
				String artist = artistField.getText();
				float cost = Float.parseFloat(costField.getText());

				ArrayList<Track> trackList = new ArrayList<>();
				String[] tracks = tracksField.getText().split(",");
				for (String t : tracks) {
					String[] parts = t.trim().split("-");
					if (parts.length == 2) {
						String name = parts[0].trim();
						int length = Integer.parseInt(parts[1].trim());
						trackList.add(new Track(name, length));
					}
				}

				CompactDisc cd = new CompactDisc(title, category, cost, artist, trackList);
				addMediaToStore(cd);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage());
			}
		});

		add(addButton);
	}
}
