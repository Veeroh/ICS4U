package rst;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.*;

public class Story{
	static JFrame frame;
	static TalkingPanel talk;
	
	// Assets directories
	// Assets made by: Allyson Parangalan
	static String OutsideSaloon = "Assets//OutsideSaloon.jpg";
	static String ShiftyTest = "Assets//ShiftyTest.png";
	
	/**
	 * Constructor
	 * Made By: Luke Strickland
	 */
	public Story(){
		frame = new JFrame("RST");
		frame.setSize(750,790);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Story frame = new Story();
		talk = new TalkingPanel(OutsideSaloon, ShiftyTest, ShiftyTest, "Hello oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo@Name: I've been excpecting you");
		add(talk);
	} 
	
	/**
	 * Adds object to JFrame
	 * pre: none
	 * Post: Object has been added to JFrame
	 * Made by: Luke Strickland
	 */
	public static void add(Component e){
		frame.add((Component) e);
	}
	
	/**
	 * Removes object from JFrame
	 * pre: none
	 * Post: Object has been removed from JFrame
	 * Made by: Luke Strickland
	 */
	public static void delete(Component e){
		frame.remove((Component) e);
	}
}

