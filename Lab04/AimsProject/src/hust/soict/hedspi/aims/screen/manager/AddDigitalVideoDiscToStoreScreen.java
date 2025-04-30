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

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	@Override
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
		JLabel label = new JLabel("enter the title of DVD");
		center.add(label);
		JTextField tf = new JTextField(30);
		center.add(tf);
		JLabel label1= new JLabel("enter the category of DVD");
		center.add(label1);
		JTextField tf1 = new JTextField(30);
		center.add(tf1);
		JLabel label2= new JLabel("enter the director of DVD");
		center.add(label2);
		JTextField tf2 = new JTextField(30);
		center.add(tf2);
		JLabel label3= new JLabel("enter the length of DVD");
		center.add(label3);
		JTextField tf3 = new JTextField(30);
		center.add(tf3);
		JLabel label4= new JLabel("enter the cost of DVD");
		center.add(label4);
		JTextField tf4 = new JTextField(30);
		center.add(tf4);
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int length = Integer.parseInt(tf3.getText());
				float cost = (float)Double.parseDouble(tf4.getText());
				DigitalVideoDisc dvd = new DigitalVideoDisc(tf.getText(),tf1.getText(),tf2.getText(),length,cost);
				StoreManagerScreen.addToScreenDVD(dvd);
			}
		});
		center.add(button);
		return center;
	}
	
	public AddDigitalVideoDiscToStoreScreen() {
		Container cp =  getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(AddDigitalVideoDiscToStoreScreen.this),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		
		setTitle("Add to store DVD");
		setSize(1024,768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
