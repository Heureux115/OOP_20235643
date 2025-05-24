package hust.soict.hedspi.aims.screen.manager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel{
	private Media media;
	
	public MediaStore() {
		
	}
	public MediaStore (Media media) {
		this.media=media;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JLabel title = new JLabel (media.getTitle());
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JDialog dialog = new JDialog( StoreManagerScreen.getFrame(),"Play");
					dialog.setLayout(new BoxLayout( dialog.getContentPane(), BoxLayout.Y_AXIS ));
					dialog.setSize(500, 500);
					if(media instanceof DigitalVideoDisc) {
						JLabel nhan = new JLabel();
						DigitalVideoDisc dvd = (DigitalVideoDisc)media;
						nhan.setText("<html>Playing DVD: " + dvd.getTitle() + "<br>DVD length: " + dvd.getLength() + "</html>");					
						dialog.add(nhan);
					}
					else if(media instanceof CompactDisc) {
						CompactDisc cd = (CompactDisc)media;
						JLabel[] label = new JLabel[cd.getTracks().size()];
						for(int i=0;i<cd.getTracks().size();i++) {
							label[i] = new JLabel();
							label[i].setText("<html>Playing Track: " + cd.getTracks().get(i).getTitle() + "<br>Track length: " + cd.getTracks().get(i).getLength() + "</html>");
							dialog.add(label[i]);
						}
					}
					dialog.setVisible(true);
				}
	        	
	        });
			container.add(playButton);
		}
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
