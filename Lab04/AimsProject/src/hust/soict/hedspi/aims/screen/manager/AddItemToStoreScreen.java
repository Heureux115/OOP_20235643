package hust.soict.hedspi.aims.screen.manager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public abstract class AddItemToStoreScreen extends JFrame {
	JPanel createNorth(JFrame aFrame) {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar(aFrame));
		return north;
	}
	JMenuBar createMenuBar(JFrame aFrame) {
		JMenu menu = new JMenu("Options");
		JMenuItem viewStore = new JMenuItem("View Store");
		menu.add(viewStore);
		viewStore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					JFrame frame = new StoreManagerScreen(StoreManagerScreen.getStore());
					aFrame.setVisible(false);
					frame.setVisible(true);
			}
		});
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame addBookFrame = new AddBookToStoreScreen();
				addBookFrame.setVisible(true);
				AddItemToStoreScreen.this.setVisible(false);
			}
		});
		JMenuItem addCd = new JMenuItem("Add CD");
		addCd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame addCdFrame = new AddCompactDiscToStoreScreen();
				addCdFrame.setVisible(true);
				AddItemToStoreScreen.this.setVisible(false);
			}
			
		});
		JMenuItem addDvd = new JMenuItem("Add DVD");
		addDvd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame addDvdFrame = new AddDigitalVideoDiscToStoreScreen();
				addDvdFrame.setVisible(true);
				AddItemToStoreScreen.this.setVisible(false);
			}
		});
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCd);
		smUpdateStore.add(addDvd);
		menu.add(smUpdateStore);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
		JLabel label = new JLabel("enter the name of item");
		center.add(label);
		JTextField tf = new JTextField(1000);
		center.add(tf);
		return center;
	}
	public AddItemToStoreScreen() {
	
	}
}
