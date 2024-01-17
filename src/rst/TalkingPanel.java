package rst;

import java.awt.*;

import javax.swing.*;
import java.util.*;

public class TalkingPanel extends JPanel implements Runnable{
	Image background, person1, person2;
	Thread runner;
	boolean isSpeaking = false;
	
	// Position variables
	int p1x = -300, p1y = 300;
	int p2x = 650, p2y = 300;
	int speed = 5;
	
	int pos = 0, count = 0, line = 0;
	String dialog;
	String[] text = new String[4];
	char letter;
	int textY = 670;
	
	/**
	 * Constructor
	 * Made By: Luke Strickland
	 */
	public TalkingPanel(String Background, String p1, String p2, String dialogg){
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		dialog = dialogg;
		// Sets up background
		background = kit.getImage(Background);
		background = background.getScaledInstance(750, 750, Image.SCALE_SMOOTH);
		
		// Sets up text lines
		text[0] = "";
		text[1] = "";
		text[2] = "";
		text[3] = "";
		
		// Sets up characters
		person1 = kit.getImage(p1);
		person1 = person1.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		person2 = kit.getImage(p2);
		person2 = person1.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		
		runner = new Thread(this);
		runner.start();
	}
	
	/**
	 * paints the components
	 * pre: none
	 * post: the components have been painted
	 * Made By: Luke Strickland
	 */
	public void paintComponent(Graphics comp)
	{
		Graphics2D comp2D = (Graphics2D) comp;
		comp2D.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		
		
		// Paints all assets to the screen
		comp2D.drawImage(background, 0, 0, this);
		comp2D.drawImage(person1, p1x, p1y, this);
		comp2D.drawImage(person2, p2x, p2y, this);
		if (isSpeaking){
	        comp2D.setPaint(new Color(255,255,255));
			comp2D.drawString(text[0], 10, 670 + (0 * 15));
			comp2D.drawString(text[1], 10, 670 + (1 * 15));
			comp2D.drawString(text[2], 10, 670 + (2 * 15));
		}
	}
	
	/**
	 * Runs through the scene and any animation
	 * pre: none
	 * Post: the scene has been run
	 * Made By: Luke Strickland
	 */
	public void run(){
		Thread thisThread = Thread.currentThread();
		// Give time for program to load
		try{
			Thread.sleep(500);
		}
		catch (InterruptedException e){
		// do nothing
		}
		while (runner == thisThread){
			if (!isSpeaking){
				if (p1x < 0){ // Moves player 1
					p1x += speed;
				}
				if (p2x > 350){ // Moves player 2

					p2x -= speed;
				}else{
					isSpeaking = true;
				}
				// Sleeps
				try{
					Thread.sleep(25);
				}
				catch (InterruptedException e){
				// do nothing
				}
				
				// Repaints the window
			}
			else{ // Talks
				if (pos != dialog.length()){
					letter = dialog.charAt(pos);
					pos += 1;
					count += 1;
					if (letter == 64){
						// Sleeps
						try{
							Thread.sleep(1000);
						}
						catch (InterruptedException e){
						// do nothing
						}
						for (int i = 0; i <= 3; i ++){
							text[i] = "";
						}
						count = 0;
						line = 0;
					}
					else{
						text[line] += letter;
					}
					if (count == 65 && line == 3){
						// Sleeps
						try{
							Thread.sleep(250);
						}
						catch (InterruptedException e){
						// do nothing
						}
						for (int i = 0; i <= 3; i ++){
							text[i] = "";
						}
						count = 0;
						line = 0;
					}
					else if (count == 65){
						line += 1;
						count = 0;
					}

				}

				// Sleeps
				try{
					Thread.sleep(50);
				}
				catch (InterruptedException e){
				// do nothing
				}
			}
			
			
			
			// Repaints the window
			repaint();
		}
	}
	
}
