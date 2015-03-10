// 36 - loadCrap

import java.awt.*;
 import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReadFile extends JFrame{
	 private JTextField addressBar;
	 private JEditorPane display;
	 
	 //constructor
	 public ReadFile() {
	 //giving application a name
	 super("Dilek Browser");

	 addressBar = new JTextField("enter a URL hoss!");
	 addressBar.addActionListener(
	 new ActionListener() {
	 public void actionPerformed(ActionEvent event){
	//responsible reading html file and displaying
	loadCrap(event.getActionCommand());
	}
	 }
	 );
	 add(addressBar, BorderLayout.NORTH);

	 display = new JEditorPane();
	display.setEditable(false);
	 //it waits for you to click link
	 display.addHyperlinkListener(
	new HyperlinkListener(){
	 public void hyperlinkUpdate(HyperlinkEvent event){
			
		 if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
	 loadCrap(event.getURL().toString());
	}
	}
	 } );
	 
	 add(new JScrollPane(display), BorderLayout.CENTER);
	 setSize(500,300);
	 setVisible(true);
	 }
	 //load crap to display on the screen
	private void loadCrap(String userText){
	try {
	 display.setPage(userText);
	addressBar.setText(userText);
	} catch (Exception e) {
	 System.out.println("crap!");
	 }
	 }

	}
