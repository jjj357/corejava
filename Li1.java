import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import org.jdesktop.swingx.JXDatePicker;



public class Li1 extends JFrame {

	/**I declare that the attached assignment is my own work in accordance with Seneca Academic Policy. 
	 *  No part of this assignment has been copied manually or electronically from any other source 
	 *  (including web sites) or distributed to other students.
     *      Name: Mingtao Li                   Student ID: 016214108                
	 * 
	 */
	private JLabel label1,label2,label3,label4,label12,label13,label14,label19;
    private JTextField text1,text2,text3,text11,text12,texts1;
    private JButton buttonEnter,buttonClear;
    private String fileName = "medicaldata.txt";
    private JXDatePicker picker1;


    
    public Li1() {
        
        super("mli101 - part 1");
        
        //create a container 
        Container c = getContentPane();
        
        c.setLayout(new GridLayout(9,1));
               
        //create 4 JPanel,then add them to container c
        JPanel panel1 = new JPanel(new GridLayout());
        
        JPanel panel2 = new JPanel(new GridLayout(1,2));
        
        JPanel panel3 = new JPanel(new GridLayout(1,2));
        
        JPanel panel4 = new JPanel(new GridLayout(1,2));
        
        JPanel panel5 = new JPanel(new GridLayout(1,2));
        
        JPanel panel6 = new JPanel(new GridLayout(1,2));
        
        JPanel panel7 = new JPanel(new GridLayout(1,2));
        
        JPanel panel8 = new JPanel(new GridLayout(1,2));
        
        JPanel panel9 = new JPanel(new GridLayout(1,2));
        
               
        label1 = new JLabel("Please enter your data: ");
        label1.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(label1);
               
        //panel 2
        label2 = new JLabel("Systolic pressure (s) (mmHg): ");
        label2.setHorizontalAlignment(JLabel.RIGHT);
        panel2.add(label2);

        //add text field
        text1 = new JTextField("", 40);  
        
        text1.setText("");
        
        panel2.add(text1);
        
        //text1.setHorizontalAlignment(JTextField.RIGHT);
        
        //panel 3
        label3 = new JLabel("Diastolic pressure (d) (mmHg): ");
        label3.setHorizontalAlignment(JLabel.RIGHT);
        panel3.add(label3);

        //add text field
        text2 = new JTextField("", 40);  
        
        text2.setText("");
        
        panel3.add(text2);
        
        //text2.setHorizontalAlignment(JTextField.RIGHT);
        
        //panel 4
        label4 = new JLabel("Hear rate (p) (bpm): ");
        label4.setHorizontalAlignment(JLabel.RIGHT);
        panel4.add(label4);

        //add text field
        text3 = new JTextField("", 40);  
        
        text3.setText("");
        
        panel4.add(text3);
        
        //text3.setHorizontalAlignment(JTextField.RIGHT);
        
        //panel 5
        label12 = new JLabel("Date: ");     
        label12.setHorizontalAlignment(JLabel.RIGHT);
        panel5.add(label12);
       
        //add calendar
        picker1 = new JXDatePicker();
        picker1.setSize(500,100);
        panel5.add(picker1);
        
        //add hour
        label13 = new JLabel("Hour: ");    
        label13.setHorizontalAlignment(JLabel.RIGHT);
        panel6.add(label13);
        
        //add text field
        text11 = new JTextField("", 100);         
        text11.setText("");       
        panel6.add(text11);
        
        //add minute
        label14 = new JLabel("Minute: ");     
        label14.setHorizontalAlignment(JLabel.RIGHT);
        panel7.add(label14);
        
        //add text field
        text12 = new JTextField("", 100);         
        text12.setText("");       
        panel7.add(text12);
        
        //add second
        label19 = new JLabel("Second: ");     
        label19.setHorizontalAlignment(JLabel.RIGHT);
        panel8.add(label19);
        
        //add text field
        texts1 = new JTextField("", 100);         
        texts1.setText("");       
        panel8.add(texts1);

        //add buttonEnter,and buttonClear     
        buttonEnter = new JButton("Enter");
        
        submitActionHandler p = new submitActionHandler();
        
        buttonEnter.addActionListener(p);
        
        panel9.add(buttonEnter);
       
        buttonClear = new JButton("Clear");
        
        clearActionHandler q = new clearActionHandler();
        
        buttonClear.addActionListener(q);    
        
        panel9.add(buttonClear);
        
        c.add(panel1);
        
        c.add(panel2);
        
        c.add(panel3);
        
        c.add(panel4);
        
        c.add(panel5);
        
        c.add(panel6);
        
        c.add(panel7);
        
        c.add(panel8);
        
        c.add(panel9);
        
        
        //set empty string
	    text1.setText("");
		
	    text2.setText("");
	    
	    text3.setText("");
	    
	    picker1.setDate(null);
	    
	    text11.setText("");
		
	    text12.setText("");
	    
	    texts1.setText("");

        setSize(450,560);

        //set container not resizable
        setVisible(true);
        setResizable(false);
         
        }

        
        //submit user input 
        private class submitActionHandler implements ActionListener {        	
			public void actionPerformed (ActionEvent ae){
        		
                if (text1.getText().equals("") ) {
        			
        			JOptionPane.showMessageDialog(text1, "Please enter a systolic pressure first.");
        		}
                
                else if (!isInteger(text1.getText())) {
                	JOptionPane.showMessageDialog(text1, "Please enter an integer for systolic pressure.");
                }
                
                else if (!isBetween(text1.getText(),0,1000)) {
                	JOptionPane.showMessageDialog(text1, "Please enter an integer between 0 and 1000 for systolic pressure.");
                }
                
                else if (text2.getText().equals("") ) {
        			
        			JOptionPane.showMessageDialog(text2, "Please enter a diastolic pressure first.");
        		}
                
                else if (!isInteger(text2.getText())) {
                	JOptionPane.showMessageDialog(text2, "Please enter an integer for diastolic pressure.");
                }
                
                else if (!isBetween(text2.getText(),0,1000)) {
                	JOptionPane.showMessageDialog(text2, "Please enter an integer between 0 and 1000 for diastolic pressure.");
                }

                else if (text3.getText().equals("") ) {
	
             	    JOptionPane.showMessageDialog(text3, "Please enter a heart rate first.");
                }
                
                else if (!isInteger(text3.getText())) {
                	JOptionPane.showMessageDialog(text3, "Please enter an integer for heart rate.");
                }
                
                else if (!isBetween(text3.getText(),0,1000)) {
                	JOptionPane.showMessageDialog(text3, "Please enter an integer between 0 and 1000 for heart rate.");
                }
                
                else if (picker1.getDate()==null) {
                	
             	    JOptionPane.showMessageDialog(text3, "Please enter a date first.");
                }
                
                else if (text11.getText().equals("")) {
                	
             	    JOptionPane.showMessageDialog(text11, "Please enter the hour first.");
                }
                
                else if (!isInteger(text11.getText())) {
                	JOptionPane.showMessageDialog(text11, "Please enter an integer for hour.");
                }
                
                else if (!isBetween(text11.getText(),0,23)) {
                	JOptionPane.showMessageDialog(text11, "Please enter an integer between 0 and 23 for hour.");
                }
                
                else if (text12.getText().equals("")) {
                	
             	    JOptionPane.showMessageDialog(text12, "Please enter the minute first.");
                }
                
                else if (!isInteger(text12.getText())) {
                	JOptionPane.showMessageDialog(text12, "Please enter an integer for minute.");
                }
                
                else if (!isBetween(text12.getText(),0,59)) {
                	JOptionPane.showMessageDialog(text12, "Please enter an integer between 0 and 59 for minute.");
                }
                
                else if (texts1.getText().equals("")) {
                	
             	    JOptionPane.showMessageDialog(texts1, "Please enter the second first.");
                }
                
                else if (!isInteger(texts1.getText())) {
                	JOptionPane.showMessageDialog(texts1, "Please enter an integer for second.");
                }
                
                else if (!isBetween(texts1.getText(),0,59)) {
                	JOptionPane.showMessageDialog(texts1, "Please enter an integer between 0 and 59 for second.");
                }
                
                else if (!text1.getText().equals("") && !text2.getText().equals("") && !text3.getText().equals("") &&
                		!picker1.getDate().equals(null) && !text11.getText().equals("") && !text12.getText().equals("") &&
                		!texts1.getText().equals("")) {
        			        			        			
        		    FileWriter fWriter = null;
        		    BufferedWriter writer = null;
        		    
        		    try {
        		    fWriter = new FileWriter(fileName,true);   //append to file
        		    writer = new BufferedWriter(fWriter);

					//write one line to file and change line        		    
    		        Calendar date1 = Calendar.getInstance();
    		        date1.setTime(picker1.getDate());
    		        
        		    writer.append(text1.getText() + ";" + text2.getText() + ";" + text3.getText() +    //new SimpleDateFormat("HH:mm:ss").format(new Date()) +   
        		    		";" + String.format("%02d", Integer.parseInt(text11.getText())) + ":" + String.format("%02d", Integer.parseInt(text12.getText()))  + ":" + String.format("%02d", Integer.parseInt(texts1.getText())) + ";" + String.format("%02d", date1.get(Calendar.DAY_OF_MONTH)) + 
        		    		";" + String.format("%02d", (date1.get(Calendar.MONTH) + 1)) + ";" + date1.get(Calendar.YEAR));  
        		    		                    
        		    writer.newLine();
        		    writer.close();
        		    JOptionPane.showMessageDialog(text3, "Your data has been stored successfully!");
        		    } catch (IOException e) {
        		    	System.out.println(e.getMessage());
        		    	System.exit(-1);
        		    }
        		}
			}
        }
        		    
        		    
        //clear user input,reset the text field
        private class clearActionHandler implements ActionListener {
            public void actionPerformed (ActionEvent ae){
            		
                int ans2 = JOptionPane.showConfirmDialog(buttonClear,"You really want to clear?");
            		
        		if (ans2 == JOptionPane.YES_OPTION) {
        				
        		    text1.setText("");
        				
        		    text2.setText("");
        		    
        		    text3.setText("");
        		    
        		    picker1.setDate(null);
        		    
        		    text11.setText("");
        			
        		    text12.setText("");
        		    
        		    texts1.setText("");
        		    
        		}	
            }
        }
        
        public boolean isInteger(String s) {
        	Character[] temp = {'0','1','2','3','4','5','6','7','8','9'};
        	boolean result = true;
        	char[] s1 = s.toCharArray();
        	for (int i=0;i < s.length();i++) {
        	  if (java.util.Arrays.asList(temp).lastIndexOf(s1[i]) == -1) {
        	  //if (java.util.Arrays.asList('0','1','2','3','4','5','6','7','8','9').lastIndexOf(s1[i]) == -1) {
        		  result = false;
        	  }
        	}
        	return result;
        }
        
        public boolean isBetween(String s, int min,int max) {
        	boolean result = false;
        	if (isInteger(s)) {
        		if (Integer.parseInt(s) >= min && Integer.parseInt(s) <= max) {
        			result = true;
        		}
        	}
        	return result;
        }
        	
        //main function   
    	public static void main(String[] args) {

            Li1 t = new Li1();
            
            t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	}
    	

    }

