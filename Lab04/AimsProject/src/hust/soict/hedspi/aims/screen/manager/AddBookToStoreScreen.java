package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
	JPanel createCenter() {
	JPanel center = new JPanel();
	center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
	JLabel label0 = new JLabel("enter the id of BOOK");
	center.add(label0);
	JTextField tf0 = new JTextField(30);
	center.add(tf0);
	JLabel label = new JLabel("enter the title of BOOK");
	center.add(label);
	JTextField tf = new JTextField(30);
	center.add(tf);
	JLabel label1= new JLabel("enter the category of BOOK");
	center.add(label1);
	JTextField tf1 = new JTextField(30);
	center.add(tf1);
	JLabel label2= new JLabel("enter the cost of BOOK");
	center.add(label2);
	JTextField tf2 = new JTextField(30);
	center.add(tf2);
	JButton button = new JButton("Add");
	button.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int id = Integer.parseInt(tf0.getText());
			float cost = (float)Double.parseDouble(tf2.getText());
			Book book = new Book(id,tf.getText(),tf1.getText(),cost);
			StoreManagerScreen.addToScreenDVD(book);
		}
	});
	center.add(button);
	return center;
}
	public AddBookToStoreScreen() {
		Container cp =  getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(AddBookToStoreScreen.this),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		
		setTitle("Add to store BOOK");
		setSize(1024,768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
