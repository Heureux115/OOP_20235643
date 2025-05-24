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
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
		JLabel label0 = new JLabel("enter the id of CD");
		center.add(label0);
		JTextField tf0 = new JTextField(30);
		center.add(tf0);
		JLabel label = new JLabel("enter the title of CD");
		center.add(label);
		JTextField tf = new JTextField(30);
		center.add(tf);
		JLabel label1= new JLabel("enter the category of CD");
		center.add(label1);
		JTextField tf1 = new JTextField(30);
		center.add(tf1);
		JLabel label2= new JLabel("enter the cost of CD");
		center.add(label2);
		JTextField tf2 = new JTextField(30);
		center.add(tf2);
		JLabel label3= new JLabel("enter the director of CD");
		center.add(label3);
		JTextField tf3 = new JTextField(30);
		center.add(tf3);
		JLabel label4= new JLabel("enter the artist of CD");
		center.add(label4);
		JTextField tf4 = new JTextField(30);
		center.add(tf4);
		JLabel label5= new JLabel("enter the tracks of CD(each track seperated by / and the title and the length separated by - )");
		center.add(label5);
		JTextField tf5 = new JTextField(30);
		center.add(tf5);
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = tf5.getText();
				String[] str1= str.split("/");
				int id = Integer.parseInt(tf0.getText());
				float cost = (float)Double.parseDouble(tf2.getText());
				CompactDisc cd = new CompactDisc(id,tf.getText(),tf1.getText(),cost,tf3.getText(),tf4.getText());
				for(String i : str1) {
					String[] str2 = i.split("-");
					int length = Integer.parseInt(str2[1]);
					cd.addTrack(new Track(str2[0],length));
				}
				StoreManagerScreen.addToScreenDVD(cd);
			}
		});
		center.add(button);
		return center;
	}
	public AddCompactDiscToStoreScreen() {
		Container cp =  getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(AddCompactDiscToStoreScreen.this),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		
		setTitle("Add to store CD");
		setSize(1024,768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
