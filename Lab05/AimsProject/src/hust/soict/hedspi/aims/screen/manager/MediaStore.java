package hust.soict.hedspi.aims.screen.manager;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;

	public MediaStore(Media media) {
		if (media == null) {
			// Nếu media là null, chúng ta sẽ không làm gì cả
			throw new IllegalArgumentException("Media cannot be null");
		}
		this.media = media;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Tạo các label cho tên và giá của media
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);

		JLabel cost = new JLabel(String.format("%.2f $", media.getCost()));
		cost.setAlignmentX(CENTER_ALIGNMENT);

		// Thêm label vào panel
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalStrut(10));

		// Nếu media là đối tượng Playable, thêm button "Play"
		if (media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.setAlignmentX(CENTER_ALIGNMENT);
			playButton.addActionListener(e -> {
				JOptionPane.showMessageDialog(this, "Playing: " + media.getTitle());
			});
			this.add(playButton);
		}

		// Thêm các thành phần vào panel
		this.add(Box.createVerticalGlue());
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
