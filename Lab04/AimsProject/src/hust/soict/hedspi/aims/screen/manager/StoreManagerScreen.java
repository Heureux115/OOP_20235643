package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame{
	private static Store store;
	private static StoreManagerScreen frame;
	public static JFrame getFrame() {
		return frame;
	}
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		menu.add(new JMenuItem("View Store"));
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame addBookFrame = new AddBookToStoreScreen();
				addBookFrame.setVisible(true);
				StoreManagerScreen.this.setVisible(false);
			}
		});
		JMenuItem addCd = new JMenuItem("Add CD");
		addCd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame addCdFrame = new AddCompactDiscToStoreScreen();
				addCdFrame.setVisible(true);
				StoreManagerScreen.this.setVisible(false);
			}
			
		});
		JMenuItem addDvd = new JMenuItem("Add DVD");
		addDvd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame addDvdFrame = new AddDigitalVideoDiscToStoreScreen();
				addDvdFrame.setVisible(true);
				StoreManagerScreen.this.setVisible(false);
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
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10,10)));
		return header;
	}
	JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemInStore();
        for (int i = 0; i < store.getItemInStore().size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

	public StoreManagerScreen(Store store) {
		this.store = store;
		Container cp =  getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024,768);
		setLocationRelativeTo(null);
		setVisible(true);
		frame=this;
	}
	public static Store getStore() {
		return store;
	}
	public static void addToScreenDVD(Media dvd) {
		store.addMedia(dvd);
	}
	public static void main(String[] args) {
		Store aStore = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",105,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War","Science Fiction","Geogre Lucas",87,24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",24.7f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter and the Goblet of Fire (2005)",
                "Animaton", "Roger Allers", 120, 19.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Fetch the Bolt Cutters",
                "Science Fiction", "Geogre Lucas", 90, 24.95f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Future Nostalgia",
                "Animation", 18.99f);
        Book book7 = new Book("The Hunger Games",
                "Animation", 19.95f);
        Book book8 = new Book("Catching Fire",
                "Science Fiction", 24.95f);
        Book book9 = new Book("Mockingjay",
                "Animation", 18.99f);
        aStore.addMedia(dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, book7, book8, book9);
		new StoreManagerScreen(aStore);
	}
}
