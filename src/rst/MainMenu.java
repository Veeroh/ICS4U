package rst;

import java.awt.*;
import java.awt.image.ImageObserver;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenu extends JPanel implements Runnable {
	
	static Image Background, Logo;	//Images
	static JButton play = new JButton("Play");	//Play Button
	/*
	 * Constructor 
	 * Made by: Alex Gordon
	 */
	
	public MainMenu(String background, String logo) {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Thread runner;
		
		Background = kit.getImage(background);	//Gets image
		Background = Background.getScaledInstance(750, 750, Image.SCALE_SMOOTH);

		Logo = kit.getImage(logo);	//Gets image
		Logo = Logo.getScaledInstance(450, 450, Image.SCALE_SMOOTH);

		runner = new Thread(this);	//Creates new thread
		runner.start();
	}
	/* 
	 * Paints objects to panel
	 */
	public void paintComponent(Graphics comp)
	{
		Graphics2D comp2D = (Graphics2D) comp;
		comp2D.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		
		comp2D.drawImage(Background, 0, 0, (ImageObserver) this);
		comp2D.drawImage(Logo, 0, 0, (ImageObserver) this);
	}

	public void run() {
		Thread thread1 = Thread.currentThread();
		try{
			Thread.sleep(3000);	//Gives time for images to load (3 sec)
		}
		catch (InterruptedException e){}
		repaint();
	}
}
