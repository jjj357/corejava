import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.*;
import org.jfree.data.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.plot.*;
import org.jfree.util.*;
import org.jfree.chart.demo.*;
import org.jdesktop.swingx.JXDatePicker;



public class Li3 extends JFrame {

	/**I declare that the attached assignment is my own work in accordance with Seneca Academic Policy. 
	 *  No part of this assignment has been copied manually or electronically from any other source 
	 *  (including web sites) or distributed to other students.
     *      Name: Mingtao Li                   Student ID: 016214108                
	 * 
	 */
	private JLabel label1,label2,label3,label4,label5,label6,label7,label9,label10;
    private JTextField text1,text2,text3,text4,texts1,texts2;
    private JButton buttonSys,buttonDias,buttonRate,buttonClear;
    //private String fileName = "../../../Li1/Li1/medicaldata.txt";
    private String fileName = "medicaldata.txt";

    //create a container 
    Container c = getContentPane();    
    //private Icon backgroundImage = new ImageIcon("green1.png", "heart");
    private int countLine = 0;

    
    //create 4 JPanel,then add them to container c
    JPanel panel1 = new JPanel(new GridLayout());
    
    JPanel panel2 = new JPanel(new GridLayout(1,8));
    
    JPanel panel3 = new JPanel(new GridLayout(1,8));
    
    JPanel panel4 = new JPanel(new GridLayout(1,2));
    
    //JPanel panel5 = new JPanel(new GridLayout());
    
    JXDatePicker picker1,picker2;
    


    
    public Li3() {
        
        super("JAC444 - mli101 - part 3 - Data Analysis");
              
        c.setLayout(new GridLayout(4,1));
               
        label1 = new JLabel("Please choose date range to analysis data: ");
        
        panel1.add(label1);
               
        //panel 2
        label2 = new JLabel("From:   Date: ");     
        label2.setHorizontalAlignment(JLabel.RIGHT);
        panel2.add(label2);
       
        //add calendar
        picker1 = new JXDatePicker();
        picker1.setSize(500,100);
        panel2.add(picker1);
        
        //add hour
        label3 = new JLabel("Hour: ");    
        label3.setHorizontalAlignment(JLabel.RIGHT);
        panel2.add(label3);
        
        //add text field
        text1 = new JTextField("", 100);         
        text1.setText("");       
        panel2.add(text1);
        
        //add minute
        label4 = new JLabel("Minute: ");     
        label4.setHorizontalAlignment(JLabel.RIGHT);
        panel2.add(label4);
        
        //add text field
        text2 = new JTextField("", 100);         
        text2.setText("");       
        panel2.add(text2);
        
        //add second
        label9 = new JLabel("Second: ");     
        label9.setHorizontalAlignment(JLabel.RIGHT);
        panel2.add(label9);
        
        //add text field
        texts1 = new JTextField("", 100);         
        texts1.setText("");       
        panel2.add(texts1);
        
        
        
        //panel 3
        label5 = new JLabel("To:   Date: ");   
        label5.setHorizontalAlignment(JLabel.RIGHT);
        panel3.add(label5);
        
        //add calendar
        picker2 = new JXDatePicker();
        picker2.setSize(500,100);
        panel3.add(picker2);

        
        //add hour
        label6 = new JLabel("Hour: ");     
        label6.setHorizontalAlignment(JLabel.RIGHT);
        panel3.add(label6);
        
        //add text field
        text3 = new JTextField("", 100);         
        text3.setText("");       
        panel3.add(text3);
        
        //add minute
        label7 = new JLabel("Minute: ");   
        label7.setHorizontalAlignment(JLabel.RIGHT);
        panel3.add(label7);
        
        //add text field
        text4 = new JTextField("", 100);         
        text4.setText("");       
        panel3.add(text4);
        
        //add second
        label10 = new JLabel("Second: ");     
        label10.setHorizontalAlignment(JLabel.RIGHT);
        panel3.add(label10);
        
        //add text field
        texts2 = new JTextField("", 100);         
        texts2.setText("");       
        panel3.add(texts2);
        
         	     
        //panel 4, add buttons
        buttonSys = new JButton("1 - Analysis Systolic pressure");
        
        sysActionHandler p = new sysActionHandler();
        
        buttonSys.addActionListener(p);
        
        panel4.add(buttonSys);
        
        
        buttonDias = new JButton("2 - Analysis Diastolic pressure");
        
        DiasActionHandler p1 = new DiasActionHandler();
        
        buttonDias.addActionListener(p1);
        
        panel4.add(buttonDias);
        
        
        buttonRate = new JButton("3 - Analysis hear rate");
        
        rateActionHandler p2 = new rateActionHandler();
        
        buttonRate.addActionListener(p2);
        
        panel4.add(buttonRate);
        
       
        buttonClear = new JButton("Clear");
        
        clearActionHandler q = new clearActionHandler();
        
        buttonClear.addActionListener(q);    
        
        panel4.add(buttonClear);      
        
        //error label in panel5
        //label8 = new JLabel("begin");   
        //panel5.add(label8);
        

                       
        c.add(panel1);
        
        c.add(panel2);
        
        c.add(panel3);
        
        c.add(panel4);
        
        //c.add(panel5);
        
        setSize(1080,280);
        
        //label8.setText("end of constr");


        setVisible(true);
        //setResizable(false);      
        
        //JLabel contentPane = new JLabel();
        //contentPane.setIcon(backgroundImage);
        //contentPane.setLayout( new BorderLayout() );
        //contentPane.setOpaque(true);
        //setContentPane( contentPane );
        

        }

    //analysis systolic pressure
    private class sysActionHandler implements ActionListener {   	
		public void actionPerformed (ActionEvent ae){
						
			//if one of 2 date fields is empty
            if (picker1.getDate()==null|| picker2.getDate()==null){
            	JOptionPane.showMessageDialog(text1, "Please enter date first.");
            }
          //if one of 6 text fields is empty
            else if (text1.getText().equals("") || text2.getText().equals("") || text3.getText().equals("") || text4.getText().equals("") || texts1.getText().equals("") || texts2.getText().equals("")) {
    			JOptionPane.showMessageDialog(text1, "Please enter time first.");
    		}
			//if "to" date is before "from" date,show error message
            else {
    			//get beginning year,month,day,hour and minute and ending year,month,day,hour and minute
    			Calendar date1 = Calendar.getInstance();
    			date1.setTime(picker1.getDate());
    			
    			String year1 = Integer.toString(date1.get(Calendar.YEAR));
    			String month1 = String.format("%02d", date1.get(Calendar.MONTH)+1);
    			String day1 = String.format("%02d", date1.get(Calendar.DAY_OF_MONTH));
    			
    			Calendar date2 = Calendar.getInstance();
    			date2.setTime(picker2.getDate()); 
    			
    			String year2 = Integer.toString(date2.get(Calendar.YEAR));
    			String month2 = String.format("%02d", date2.get(Calendar.MONTH)+1);
    			String day2 = String.format("%02d", date2.get(Calendar.DAY_OF_MONTH));   
            	
            	if (Long.parseLong(year1+month1+day1) > Long.parseLong(year2+month2+day2)) {   			
    			    JOptionPane.showMessageDialog(picker1, "\"From\" date should be earlier than \"To\" date.");
    		    }           
                else {

            	String hour1 = String.format("%02d", Integer.parseInt(text1.getText()));
    			String minute1 = String.format("%02d", Integer.parseInt(text2.getText()));
    			String second1 = String.format("%02d", Integer.parseInt(texts1.getText()));
    			String s1 = year1 + month1 + day1 + hour1 + minute1 + second1;
    			

    			
    			String hour2 = String.format("%02d", Integer.parseInt(text3.getText()));
    			String minute2 = String.format("%02d", Integer.parseInt(text4.getText()));
    			String second2 = String.format("%02d", Integer.parseInt(texts2.getText()));
    			String s2 = year2 + month2 + day2 + hour2 + minute2 + second2;
			
			//get line number in the data file fileName
		    try{
				//search data in file
				Scanner in = new Scanner(new File(fileName));

				while (in.hasNextLine())
				{  
				   in.nextLine();
                   countLine++;
				}
				in.close();
				}
		    catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
		    catch(Exception ex) {
				System.out.println(ex);
			}
		    
		    //label8.setText("countLine is " + Integer.toString(countLine-1) + ",s1 is " + s1 + ",s2 is " + s2);
		    
		    //create a new array to store medical data
		    String[] array1 = new String[countLine * 4 ];

		   
			int i = 0;			
			try{
			//search data in file
			Scanner in = new Scanner(new File(fileName));

			//label8.setText("Before while loop");
			
			while (in.hasNextLine())
			{
			   String s = in.nextLine();
			   String year0 = s.split(";")[6].trim();
			   String month0 = String.format("%02d",Integer.parseInt(s.split(";")[5]));
			   String day0 = String.format("%02d",Integer.parseInt(s.split(";")[4]));
			   String time0 = s.split(";")[3];
			   String hour0 = String.format("%02d",Integer.parseInt(time0.split(":")[0]));
			   String minute0 = String.format("%02d",Integer.parseInt(time0.split(":")[1]));
			   String second0 = String.format("%02d",Integer.parseInt(time0.split(":")[2]));
			   String s0 = year0 + month0 + day0 + hour0 + minute0 + second0;
			   int systolic = Integer.parseInt(s.split(";")[0]);
			   int diastolic = Integer.parseInt(s.split(";")[1]);
			   int heartrate = Integer.parseInt(s.split(";")[2]);

			   //label8.setText(label8.getText() + ",s0 is " + s0 + ",systolic is " + Integer.toString(systolic));

			   if((Long.parseLong(s0) >= Long.parseLong(s1) && Long.parseLong(s0) <= Long.parseLong(s2)))		   				
			   {
			      array1[i] = Integer.toString(systolic);
			      array1[i+1] = Integer.toString(diastolic);
			      array1[i+2] = Integer.toString(heartrate);
			      array1[i+3] = s0;			      
			      i = i + 4;
			      //label8.setText(label8.getText() + ", s0 is " + s0 + ", i is " + Integer.toString(i));
			   }
			} //end of while
			in.close();
			}  //end of try
			catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
			catch(Exception ex) {
				System.out.println(ex);
			}
			
			int arrayLength = i/4;
		    String[] arraySys = new String[arrayLength];
		    
		    for (int k=0;k<arrayLength;k++){
		      arraySys[k] = array1[4*k];
		    }
               
			//label8.setText("after while loop, i is " + Integer.toString(i));
			
			//get systolic statistical data: max,min,mean,median,mode and range
			int maxIndex = 0;
			int minIndex = 0;
			int total = 0;
			double mean = 0;
			double median = 0;
			double mode = 0;
			int range = 0;
			
			for (int j=0;j<arrayLength;j++)  {  
				if(Integer.parseInt(arraySys[j]) > Integer.parseInt(arraySys[maxIndex])){
					maxIndex = j;
				}
				if(Integer.parseInt(arraySys[j]) < Integer.parseInt(arraySys[minIndex])){
					minIndex = j;
				}
				total += Integer.parseInt(arraySys[j]);
				
				
			}
			
			mean = total / arrayLength;
			range =  Integer.parseInt(arraySys[maxIndex]) - Integer.parseInt(arraySys[minIndex]);
			
			//get mode, if more than one number,take the first number
			Arrays.sort(arraySys);
			int[] countModeSys = new int[arrayLength];
			
			for (int j=0;j<arrayLength;j++)  {  
				countModeSys[j] = 0;
				for (int k=j;k<arrayLength;k++)  {  
					if (Integer.parseInt(arraySys[j]) == Integer.parseInt(arraySys[k])) {
						countModeSys[j]++;
					}
				}
			}
			
			int maxRepeatSys = 0;
			
			for (int j=0;j<arrayLength;j++)  {  
				if (countModeSys[j] > countModeSys[maxRepeatSys]){					
					maxRepeatSys = j;
				}
			}
			
			mode = Integer.parseInt(arraySys[maxRepeatSys]);
			
			/*//count how many items have the same max value
			int counter = 0;
			int modeTotal = 0;
			for (int j=0;j<arrayLength;j++)  {  
				if (countModeSys[j] == countModeSys[maxRepeatSys]){					
					counter++;
					modeTotal += Integer.parseInt(arraySys[j]);
				}
			}
			
			mode = modeTotal/counter;  */
			
			//get median
			Arrays.sort(arraySys);
			if (arrayLength%2 != 0) {
				median = Integer.parseInt(arraySys[(arrayLength + 1)/2 - 1]);
			}
			else {
				median = (Integer.parseInt(arraySys[(arrayLength + 1)/2 - 1]) + Integer.parseInt(arraySys[(arrayLength + 1)/2])) / 2;
			}
			
			
			try{
	    	  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    	  dataset.setValue(Integer.parseInt(array1[maxIndex*4]), "systolic" ,"max"); 
	    	  dataset.setValue(Integer.parseInt(array1[maxIndex*4+1]), "diastolic" ,"max"); 
	    	  dataset.setValue(Integer.parseInt(array1[maxIndex*4+2]), "heart rate" ,"max"); 
	    	  
	    	  dataset.setValue(Integer.parseInt(array1[minIndex*4]), "systolic" ,"min"); 
	    	  dataset.setValue(Integer.parseInt(array1[minIndex*4+1]), "diastolic" ,"min"); 
	    	  dataset.setValue(Integer.parseInt(array1[minIndex*4+2]), "heart rate" ,"min"); 
	    	   
	    	  dataset.setValue(mean,"systolic","mean");
	    	  dataset.setValue(median,"systolic","median");
	    	  dataset.setValue(mode,"systolic","mode"); 
	    	  dataset.setValue(range,"systolic","range");

	    	  JFreeChart chart = ChartFactory.createBarChart
	    	  ("1 - Systolic Pressure Report","heart data,max date is "+array1[maxIndex*4+3].substring(0,4)+"/"+array1[maxIndex*4+3].substring(4,6)+"/"+array1[maxIndex*4+3].substring(6,8)+"/"+array1[maxIndex*4+3].substring(8,10)+":"+array1[maxIndex*4+3].substring(10,12)+":"+array1[maxIndex*4+3].substring(12)+",min date is "+array1[minIndex*4+3].substring(0,4)+"/"+array1[minIndex*4+3].substring(4,6)+"/"+array1[minIndex*4+3].substring(6,8)+"/"+array1[minIndex*4+3].substring(8,10)+":"+array1[minIndex*4+3].substring(10,12)+":"+array1[minIndex*4+3].substring(12), "value", dataset, 
	    	   PlotOrientation.VERTICAL, true, true, false);
	    	  chart.setBackgroundPaint(Color.yellow);
	    	  chart.getTitle().setPaint(Color.blue); 
	    	  CategoryPlot p = chart.getCategoryPlot(); 
	    	  p.setRangeGridlinePaint(Color.red); 
	    	  ChartFrame frame1=new ChartFrame("1 - Systolic Pressure Report",chart);
	    	  frame1.setVisible(true);
	    	  frame1.setSize(1000,800);
	    	  frame1.setResizable(true);
	    	  //panel5.add(frame1);
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			
			//label8.setText("after chart block");
		}
		}
    }
    }
	
    //analysis diastolic pressure
    private class DiasActionHandler implements ActionListener {   	
		public void actionPerformed (ActionEvent ae){
			
        //if one of 2 date fields is empty
        if (picker1.getDate()==null|| picker2.getDate()==null){
	        JOptionPane.showMessageDialog(text1, "Please enter date first.");
        }
        //if one of 6 text fields is empty
        else if (text1.getText().equals("") || text2.getText().equals("") || text3.getText().equals("") || text4.getText().equals("") || texts1.getText().equals("") || texts2.getText().equals("")) {
	        JOptionPane.showMessageDialog(text1, "Please enter time first.");
        }
        //if "to" date is before "from" date,show error message
        else {
	        //get beginning year,month,day,hour and minute and ending year,month,day,hour and minute
	        Calendar date1 = Calendar.getInstance();
	        date1.setTime(picker1.getDate());
	
	        String year1 = Integer.toString(date1.get(Calendar.YEAR));
	        String month1 = String.format("%02d", date1.get(Calendar.MONTH)+1);
	        String day1 = String.format("%02d", date1.get(Calendar.DAY_OF_MONTH));
	
	        Calendar date2 = Calendar.getInstance();
	        date2.setTime(picker2.getDate()); 
	
	        String year2 = Integer.toString(date2.get(Calendar.YEAR));
	        String month2 = String.format("%02d", date2.get(Calendar.MONTH)+1);
	        String day2 = String.format("%02d", date2.get(Calendar.DAY_OF_MONTH));   
	
	        if (Long.parseLong(year1+month1+day1) > Long.parseLong(year2+month2+day2)) {   			
	            JOptionPane.showMessageDialog(picker1, "\"From\" date should be earlier than \"To\" date.");
            }           
            else {

	        String hour1 = String.format("%02d", Integer.parseInt(text1.getText()));
	        String minute1 = String.format("%02d", Integer.parseInt(text2.getText()));
	        String second1 = String.format("%02d", Integer.parseInt(texts1.getText()));
	        String s1 = year1 + month1 + day1 + hour1 + minute1 + second1;
		
	        String hour2 = String.format("%02d", Integer.parseInt(text3.getText()));
	        String minute2 = String.format("%02d", Integer.parseInt(text4.getText()));
	        String second2 = String.format("%02d", Integer.parseInt(texts2.getText()));
	        String s2 = year2 + month2 + day2 + hour2 + minute2 + second2;
			
			//get line number in the data file fileName
		    try{
				//search data in file
				Scanner in = new Scanner(new File(fileName));

				while (in.hasNextLine())
				{  
				   in.nextLine();
                   countLine++;
				}
				in.close();
				}
		    catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
		    catch(Exception ex) {
				System.out.println(ex);
			}
		    
		    //label8.setText("countLine is " + Integer.toString(countLine-1) + ",s1 is " + s1 + ",s2 is " + s2);
		    
		    //create a new array to store medical data
		    String[] array1 = new String[countLine * 4 ];

		   
			int i = 0;			
			try{
			//search data in file
			Scanner in = new Scanner(new File(fileName));

			//label8.setText("Before while loop");
			
			while (in.hasNextLine())
			{
			   String s = in.nextLine();
			   String year0 = s.split(";")[6].trim();
			   String month0 = String.format("%02d",Integer.parseInt(s.split(";")[5]));
			   String day0 = String.format("%02d",Integer.parseInt(s.split(";")[4]));
			   String time0 = s.split(";")[3];
			   String hour0 = String.format("%02d",Integer.parseInt(time0.split(":")[0]));
			   String minute0 = String.format("%02d",Integer.parseInt(time0.split(":")[1]));
			   String second0 = String.format("%02d",Integer.parseInt(time0.split(":")[2]));
			   String s0 = year0 + month0 + day0 + hour0 + minute0 + second0;
			   int systolic = Integer.parseInt(s.split(";")[0]);
			   int diastolic = Integer.parseInt(s.split(";")[1]);
			   int heartrate = Integer.parseInt(s.split(";")[2]);

			   //label8.setText(label8.getText() + ",s0 is " + s0 + ",systolic is " + Integer.toString(systolic));

			   if((Long.parseLong(s0) >= Long.parseLong(s1) && Long.parseLong(s0) <= Long.parseLong(s2)))		   				
			   {
			      array1[i] = Integer.toString(systolic);
			      array1[i+1] = Integer.toString(diastolic);
			      array1[i+2] = Integer.toString(heartrate);
			      array1[i+3] = s0;			      
			      i = i + 4;
			      //label8.setText(label8.getText() + ", s0 is " + s0 + ", i is " + Integer.toString(i));
			   }
			} //end of while
			in.close();
			}  //end of try
			catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
			catch(Exception ex) {
				System.out.println(ex);
			}
			
			int arrayLength = i/4;
		    String[] arrayDias = new String[arrayLength];

		    
		    for (int k=0;k<arrayLength;k++){

		      arrayDias[k] = array1[4*k+1];

		    }
               
			//label8.setText("after while loop, i is " + Integer.toString(i));
			
			//get diastolic statistical data: max,min,mean,median,mode and range
			int maxIndex = 0;
			int minIndex = 0;
			int total = 0;
			int mean = 0;
			double median = 0;
			double mode = 0;
			int range = 0;
			
			for (int j=0;j<arrayLength;j++)  {  
				if(Integer.parseInt(arrayDias[j]) > Integer.parseInt(arrayDias[maxIndex])){
					maxIndex = j;
				}
				if(Integer.parseInt(arrayDias[j]) < Integer.parseInt(arrayDias[minIndex])){
					minIndex = j;
				}
				total += Integer.parseInt(arrayDias[j]);
				
				
			}
			
			mean = total / arrayLength;
			range =  Integer.parseInt(arrayDias[maxIndex]) - Integer.parseInt(arrayDias[minIndex]);
			
			//get mode
			int[] countModeSys = new int[arrayLength];
			
			for (int j=0;j<arrayLength;j++)  {  
				countModeSys[j] = 0;
				for (int k=j;k<arrayLength;k++)  {  
					if (Integer.parseInt(arrayDias[j]) == Integer.parseInt(arrayDias[k])) {
						countModeSys[j]++;
					}
				}
			}
			
			int maxRepeatSys = 0;
			
			for (int j=0;j<arrayLength;j++)  {  
				if (countModeSys[j] > countModeSys[maxRepeatSys]){					
					maxRepeatSys = j;
				}
			}
			
			//count how many items have the same max value
			int counter = 0;
			int modeTotal = 0;
			for (int j=0;j<arrayLength;j++)  {  
				if (countModeSys[j] == countModeSys[maxRepeatSys]){					
					counter++;
					modeTotal += Integer.parseInt(arrayDias[j]);
				}
			}
			
			mode = modeTotal/counter;
			
			//get median
			Arrays.sort(arrayDias);
			if (arrayLength%2 != 0) {
				median = Integer.parseInt(arrayDias[(arrayLength + 1)/2 - 1]);
			}
			else {
				median = (Integer.parseInt(arrayDias[(arrayLength + 1)/2 - 1]) + Integer.parseInt(arrayDias[(arrayLength + 1)/2])) / 2;
			}
			
			
			try{
	    	  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    	  dataset.setValue(Integer.parseInt(array1[maxIndex*4]), "systolic" ,"max"); 
	    	  dataset.setValue(Integer.parseInt(array1[maxIndex*4+1]), "diastolic" ,"max"); 
	    	  dataset.setValue(Integer.parseInt(array1[maxIndex*4+2]), "heart rate" ,"max"); 
	    	  
	    	  dataset.setValue(Integer.parseInt(array1[minIndex*4]), "systolic" ,"min"); 
	    	  dataset.setValue(Integer.parseInt(array1[minIndex*4+1]), "diastolic" ,"min"); 
	    	  dataset.setValue(Integer.parseInt(array1[minIndex*4+2]), "heart rate" ,"min"); 
	    	   
	    	  dataset.setValue(mean,"diastolic","mean");
	    	  dataset.setValue(median,"diastolic","median");
	    	  dataset.setValue(mode,"diastolic","mode"); 
	    	  dataset.setValue(range,"diastolic","range");

	    	  JFreeChart chart = ChartFactory.createBarChart
	    	  ("2 - Diastolic Pressure Report","heart data,max date is "+array1[maxIndex*4+3].substring(0,4)+"/"+array1[maxIndex*4+3].substring(4,6)+"/"+array1[maxIndex*4+3].substring(6,8)+"/"+array1[maxIndex*4+3].substring(8,10)+":"+array1[maxIndex*4+3].substring(10,12)+":"+array1[maxIndex*4+3].substring(12)+",min date is "+array1[minIndex*4+3].substring(0,4)+"/"+array1[minIndex*4+3].substring(4,6)+"/"+array1[minIndex*4+3].substring(6,8)+"/"+array1[minIndex*4+3].substring(8,10)+":"+array1[minIndex*4+3].substring(10,12)+":"+array1[minIndex*4+3].substring(12), "value", dataset, 
	    	   PlotOrientation.VERTICAL, true, true, false);
	    	  chart.setBackgroundPaint(Color.cyan);
	    	  chart.getTitle().setPaint(Color.blue); 
	    	  CategoryPlot p = chart.getCategoryPlot(); 
	    	  p.setRangeGridlinePaint(Color.red); 
	    	  ChartFrame frame1=new ChartFrame("2 - Diastolic Pressure Report",chart);
	    	  frame1.setVisible(true);
	    	  frame1.setSize(1000,800);
	    	  frame1.setResizable(true);
	    	  //panel5.add(frame1);
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			
			//label8.setText("after chart block");
		}
		}
		}
    }//end of diasActionHandler
    
    //analysis hear rate
    private class rateActionHandler implements ActionListener {   	
		public void actionPerformed (ActionEvent ae){
			
	        //if one of 2 date fields is empty
	        if (picker1.getDate()==null|| picker2.getDate()==null){
		        JOptionPane.showMessageDialog(text1, "Please enter date first.");
	        }
	        //if one of 6 text fields is empty
	        else if (text1.getText().equals("") || text2.getText().equals("") || text3.getText().equals("") || text4.getText().equals("") || texts1.getText().equals("") || texts2.getText().equals("")) {
		        JOptionPane.showMessageDialog(text1, "Please enter time first.");
	        }
	        //if "to" date is before "from" date,show error message
	        else {
		        //get beginning year,month,day,hour and minute and ending year,month,day,hour and minute
		        Calendar date1 = Calendar.getInstance();
		        date1.setTime(picker1.getDate());
		
		        String year1 = Integer.toString(date1.get(Calendar.YEAR));
		        String month1 = String.format("%02d", date1.get(Calendar.MONTH)+1);
		        String day1 = String.format("%02d", date1.get(Calendar.DAY_OF_MONTH));
		
		        Calendar date2 = Calendar.getInstance();
		        date2.setTime(picker2.getDate()); 
		
		        String year2 = Integer.toString(date2.get(Calendar.YEAR));
		        String month2 = String.format("%02d", date2.get(Calendar.MONTH)+1);
		        String day2 = String.format("%02d", date2.get(Calendar.DAY_OF_MONTH));   
		
		        if (Long.parseLong(year1+month1+day1) > Long.parseLong(year2+month2+day2)) {   			
		            JOptionPane.showMessageDialog(picker1, "\"From\" date should be earlier than \"To\" date.");
	            }           
	            else {

		        String hour1 = String.format("%02d", Integer.parseInt(text1.getText()));
		        String minute1 = String.format("%02d", Integer.parseInt(text2.getText()));
		        String second1 = String.format("%02d", Integer.parseInt(texts1.getText()));
		        String s1 = year1 + month1 + day1 + hour1 + minute1 + second1;
			
		        String hour2 = String.format("%02d", Integer.parseInt(text3.getText()));
		        String minute2 = String.format("%02d", Integer.parseInt(text4.getText()));
		        String second2 = String.format("%02d", Integer.parseInt(texts2.getText()));
		        String s2 = year2 + month2 + day2 + hour2 + minute2 + second2;
    			
			//get line number in the data file fileName
		    try{
				//search data in file
				Scanner in = new Scanner(new File(fileName));

				while (in.hasNextLine())
				{  
				   in.nextLine();
                   countLine++;
				}
				in.close();
				}
		    catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
		    catch(Exception ex) {
				System.out.println(ex);
			}
		    
		    //label8.setText("countLine is " + Integer.toString(countLine-1) + ",s1 is " + s1 + ",s2 is " + s2);
		    
		    //create a new array to store medical data
		    String[] array1 = new String[countLine * 4 ];

		   
			int i = 0;			
			try{
			//search data in file
			Scanner in = new Scanner(new File(fileName));

			//label8.setText("Before while loop");
			
			while (in.hasNextLine())
			{
			   String s = in.nextLine();
			   String year0 = s.split(";")[6].trim();
			   String month0 = String.format("%02d",Integer.parseInt(s.split(";")[5]));
			   String day0 = String.format("%02d",Integer.parseInt(s.split(";")[4]));
			   String time0 = s.split(";")[3];
			   String hour0 = String.format("%02d",Integer.parseInt(time0.split(":")[0]));
			   String minute0 = String.format("%02d",Integer.parseInt(time0.split(":")[1]));
			   String second0 = String.format("%02d",Integer.parseInt(time0.split(":")[2]));
			   String s0 = year0 + month0 + day0 + hour0 + minute0 + second0;
			   int systolic = Integer.parseInt(s.split(";")[0]);
			   int diastolic = Integer.parseInt(s.split(";")[1]);
			   int heartrate = Integer.parseInt(s.split(";")[2]);

			   //label8.setText(label8.getText() + ",s0 is " + s0 + ",systolic is " + Integer.toString(systolic));

			   if((Long.parseLong(s0) >= Long.parseLong(s1) && Long.parseLong(s0) <= Long.parseLong(s2)))		   				
			   {
			      array1[i] = Integer.toString(systolic);
			      array1[i+1] = Integer.toString(diastolic);
			      array1[i+2] = Integer.toString(heartrate);
			      array1[i+3] = s0;			      
			      i = i + 4;
			      //label8.setText(label8.getText() + ", s0 is " + s0 + ", i is " + Integer.toString(i));
			   }
			} //end of while
			in.close();
			}  //end of try
			catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
			catch(Exception ex) {
				System.out.println(ex);
			}
			
			int arrayLength = i/4;
		    String[] arrayRate = new String[arrayLength];
		    
		    for (int k=0;k<arrayLength;k++){

		      arrayRate[k] = array1[4*k+2];
		    }
               
			//label8.setText("after while loop, i is " + Integer.toString(i));
			
			//get hear rate statistical data: max,min,mean,median,mode and range

			int maxIndex = 0;
			int minIndex = 0;
			int total = 0;
			int mean = 0;
			double median = 0;
			double mode = 0;
			int range = 0;
			
			for (int j=0;j<arrayLength;j++)  {  
				if(Integer.parseInt(arrayRate[j]) > Integer.parseInt(arrayRate[maxIndex])){
					maxIndex = j;
				}
				if(Integer.parseInt(arrayRate[j]) < Integer.parseInt(arrayRate[minIndex])){
					minIndex = j;
				}
				total += Integer.parseInt(arrayRate[j]);
				
				
			}
			
			mean = total / arrayLength;
			range =  Integer.parseInt(arrayRate[maxIndex]) - Integer.parseInt(arrayRate[minIndex]);
			
			//get mode
			int[] countModeSys = new int[arrayLength];
			
			for (int j=0;j<arrayLength;j++)  {  
				countModeSys[j] = 0;
				for (int k=j;k<arrayLength;k++)  {  
					if (Integer.parseInt(arrayRate[j]) == Integer.parseInt(arrayRate[k])) {
						countModeSys[j]++;
					}
				}
			}
			
			int maxRepeatSys = 0;
			
			for (int j=0;j<arrayLength;j++)  {  
				if (countModeSys[j] > countModeSys[maxRepeatSys]){					
					maxRepeatSys = j;
				}
			}
			
			//count how many items have the same max value
			int counter = 0;
			int modeTotal = 0;
			for (int j=0;j<arrayLength;j++)  {  
				if (countModeSys[j] == countModeSys[maxRepeatSys]){					
					counter++;
					modeTotal += Integer.parseInt(arrayRate[j]);
				}
			}
			
			mode = modeTotal/counter;
			
			//get median
			Arrays.sort(arrayRate);
			if (arrayLength%2 != 0) {
				median = Integer.parseInt(arrayRate[(arrayLength + 1)/2 - 1]);
			}
			else {
				median = (Integer.parseInt(arrayRate[(arrayLength + 1)/2 - 1]) + Integer.parseInt(arrayRate[(arrayLength + 1)/2])) / 2;
			}
			
			
			try{
	    	  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    	  dataset.setValue(Integer.parseInt(array1[maxIndex*4]), "systolic" ,"max"); 
	    	  dataset.setValue(Integer.parseInt(array1[maxIndex*4+1]), "diastolic" ,"max"); 
	    	  dataset.setValue(Integer.parseInt(array1[maxIndex*4+2]), "heart rate" ,"max"); 
	    	  
	    	  dataset.setValue(Integer.parseInt(array1[minIndex*4]), "systolic" ,"min"); 
	    	  dataset.setValue(Integer.parseInt(array1[minIndex*4+1]), "diastolic" ,"min"); 
	    	  dataset.setValue(Integer.parseInt(array1[minIndex*4+2]), "heart rate" ,"min"); 
	    	   
	    	  dataset.setValue(mean,"heart rate","mean");
	    	  dataset.setValue(median,"heart rate","median");
	    	  dataset.setValue(mode,"heart rate","mode"); 
	    	  dataset.setValue(range,"heart rate","range");

	    	  JFreeChart chart = ChartFactory.createBarChart
	    	  ("3 - Heart Rate Report","heart data,max date is "+array1[maxIndex*4+3].substring(0,4)+"/"+array1[maxIndex*4+3].substring(4,6)+"/"+array1[maxIndex*4+3].substring(6,8)+"/"+array1[maxIndex*4+3].substring(8,10)+":"+array1[maxIndex*4+3].substring(10,12)+":"+array1[maxIndex*4+3].substring(12)+",min date is "+array1[minIndex*4+3].substring(0,4)+"/"+array1[minIndex*4+3].substring(4,6)+"/"+array1[minIndex*4+3].substring(6,8)+"/"+array1[minIndex*4+3].substring(8,10)+":"+array1[minIndex*4+3].substring(10,12)+":"+array1[minIndex*4+3].substring(12), "value", dataset, 
	    	   PlotOrientation.VERTICAL, true, true, false);
	    	  chart.setBackgroundPaint(Color.white);
	    	  chart.getTitle().setPaint(Color.blue); 
	    	  CategoryPlot p = chart.getCategoryPlot(); 
	    	  p.setRangeGridlinePaint(Color.red); 
	    	  ChartFrame frame1=new ChartFrame("3 - Heart Rate Report",chart);
	    	  frame1.setVisible(true);
	    	  frame1.setSize(1000,800);
	    	  frame1.setResizable(true);
	    	  //panel5.add(frame1);
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			
			//label8.setText("after chart block");
		}
		}
		}
    }//end of rateActionHandler
    
    
    //clear user input,reset the text field
    private class clearActionHandler implements ActionListener {
        public void actionPerformed (ActionEvent ae){
            int ans2 = JOptionPane.showConfirmDialog(buttonClear,"You really want to clear?");
    		
    		if (ans2 == JOptionPane.YES_OPTION) {
        	text1.setText("");   
        	text2.setText("");   
        	text3.setText("");   
        	text4.setText("");   
        	texts1.setText(""); 
        	texts2.setText(""); 
        	picker1.setDate(null);
        	picker2.setDate(null);
        	
        }       
        }
    }
	       
    public static void main(String arg[]){
        Li3 t = new Li3();
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }		
}

