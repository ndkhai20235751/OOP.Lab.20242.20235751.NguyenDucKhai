package hust.soict.dsai.aims.screenmanager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;



public class StoreManagerScreen extends JFrame{
	private Store store;
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AIMS - Store Manager");
		setSize(1024, 768);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("Options");
		
		JMenuItem viewStore = new JMenuItem("View Store");
		viewStore.addActionListener(e -> refreshStoreDisplay());
		menu.add(viewStore);
		
		JMenu updateStoreMenu = new JMenu("Update Store");
		
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(e -> {
			new AddBookToStoreScreen(store);
			dispose();
		});
		updateStoreMenu.add(addBook);
		
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(e -> {
			new AddCompactDiscToStoreScreen(store);
		});
		updateStoreMenu.add(addCD);
		
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(e -> {
			new AddDigitalVideoDiscToStoreScreen(store);
		});
		updateStoreMenu.add(addDVD);
		
		menu.add(updateStoreMenu);
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS - Store Management");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(e -> refreshStoreDisplay());
		header.add(refreshButton);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (Media media : mediaInStore) {
			center.add(createMediaCell(media));
		}
		
		for (int i = mediaInStore.size(); i < 0; i++) {
			center.add(createEmptyCell());
		}
		
		return center;
	}
	
	JPanel createMediaCell(Media media) {
		JPanel cell = new JPanel();
		cell.setLayout(new BoxLayout(cell, BoxLayout.Y_AXIS));
        cell.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        JLabel titleLabel = new JLabel(media.getTitle());
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 14));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel detailsLabel = new JLabel(media.getClass().getSimpleName() + " - " + media.getCost() + " $");
        detailsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel buttonPanel = new JPanel();
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> playMedia(media));
            buttonPanel.add(playButton);
        }
        
        cell.add(Box.createVerticalGlue());
        cell.add(titleLabel);
        cell.add(detailsLabel);
        cell.add(Box.createVerticalGlue());
        cell.add(buttonPanel);
        
        return cell;
	}
	
	JPanel createEmptyCell() {
		JPanel cell = new JPanel();
        cell.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        cell.setBackground(new Color(240, 240, 240));
        return cell;
	}
	
	private void playMedia(Media media) {
        JDialog playDialog = new JDialog(this, "Now Playing", true);
        playDialog.setSize(300, 200);
        playDialog.setLocationRelativeTo(this);
        
        JTextArea playInfo = new JTextArea();
        playInfo.setEditable(false);
        playInfo.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        if (media instanceof Playable) {
            playInfo.setText("Now playing: " + media.getTitle() + "\n\n");
            
            if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                playInfo.append("Artist: " + cd.getArtist() + "\n");
                playInfo.append("Total length: " + cd.getLength() + " seconds\n");
            } else if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                playInfo.append("Director: " + dvd.getDirector() + "\n");
                playInfo.append("Length: " + dvd.getLength() + " minutes\n");
            }
            
            ((Playable) media).play();
        }
        
        playDialog.add(new JScrollPane(playInfo));
        playDialog.setVisible(true);
    }
	
	private void refreshStoreDisplay() {
        getContentPane().removeAll();
        getContentPane().add(createNorth(), BorderLayout.NORTH);
        getContentPane().add(createCenter(), BorderLayout.CENTER);
        revalidate();
        repaint();
    }
	
	public static void main(String[] args) {
	    Store store = new Store();
	    
	    CompactDisc cd1 = new CompactDisc("Hotel California", "Rock", "Eagles", 15.99f);
	    cd1.addTrack(new Track("New Kid in Town", 300));
	    cd1.addTrack(new Track("Life in the Fast Lane", 280));
	    cd1.addTrack(new Track("Wasted Time", 295));
	    store.addMedia(cd1);

	    CompactDisc cd2 = new CompactDisc("1989", "Pop", "Taylor Swift", 12.99f);
	    cd2.addTrack(new Track("Blank Space", 231));
	    cd2.addTrack(new Track("Style", 230));
	    store.addMedia(cd2);

	    DigitalVideoDisc dvd1 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 9.99f);
	    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 12.99f);
	    store.addMedia(dvd1);
	    store.addMedia(dvd2);

	    Book book1 = new Book("A Game of Thrones", "Fantasy", 21.99f);
	    book1.addAuthor("George R. R. Martin");
	    Book book2 = new Book("The Pragmatic Programmer", "Programming", 34.99f);
	    book2.addAuthor("Andrew Hunt");
	    book2.addAuthor("David Thomas");
	    store.addMedia(book1);
	    store.addMedia(book2);
	    
	    SwingUtilities.invokeLater(() -> {
	        StoreManagerScreen screen = new StoreManagerScreen(store);
	        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        screen.setVisible(true);
	    });
	}
}