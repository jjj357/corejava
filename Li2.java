
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;

import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.*;
import org.jfree.data.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.plot.*;
import org.jfree.util.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.demo.*;
import org.jdesktop.swingx.JXDatePicker;

import org.jfree.data.time.*;

import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;



public class Li2 extends JFrame {

	/**I declare that the attached assignment is my own work in accordance with Seneca Academic Policy. 
	 *  No part of this assignment has been copied manually or electronically from any other source 
	 *  (including web sites) or distributed to other students.
     *      Name: Mingtao Li                   Student ID: 016214108                
	 * 
	 */
	private JLabel label1,label2,label3,label4,label5,label6,label7,label9,label10;
    private JTextField text1,text2,text3,text4,texts1,texts2;
    private JButton buttonEnter,buttonClear;
    //private String fileName = "../../../Li1/Li1/medicaldata.txt";
    private String fileName = "medicaldata.txt";
    //create a container 
    Container c = getContentPane();    
    private int countLine = 0;

    
    //create 4 JPanel,then add them to container c
    JPanel panel1 = new JPanel(new GridLayout());
    
    JPanel panel2 = new JPanel(new GridLayout(1,8));
    
    JPanel panel3 = new JPanel(new GridLayout(1,8));
    
    JPanel panel4 = new JPanel(new GridLayout(1,2));
    
    //JPanel panel5 = new JPanel(new GridLayout());
    
    JXDatePicker picker1,picker2;
    


    
    public Li2() {
        
        super("JAC444 - mli101 - part 2");
        
        c.setLayout(new GridLayout(4,1));
               
        label1 = new JLabel("Please choose date range to view data: ");
        
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
        
         	     
        //panel 4, add buttonEnter,and buttonClear     
        buttonEnter = new JButton("Enter");
        
        submitActionHandler p = new submitActionHandler();
        
        buttonEnter.addActionListener(p);
        
        panel4.add(buttonEnter);
       
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
        }

    //submit user input 
    private class submitActionHandler implements ActionListener {   	
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
		    String[] array1 = new String[countLine * 4];
		   
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
               
			//label8.setText("after while loop, i is " + Integer.toString(i));
			
			try{

	    	  //JFreeChart chart = ChartFactory.createBarChart
				ApplicationFrame demo = new ApplicationFrame("mli101 - Assignment 2 - part 2");
	          
	          
	          TimeSeries ts1 = new TimeSeries("systolic");
	          for (int j=0;j<=i-4;j=j+4)  {   
	             ts1.add(new Second(Integer.parseInt(array1[j+3].substring(12)), Integer.parseInt(array1[j+3].substring(10,12)),Integer.parseInt(array1[j+3].substring(8,10)),
	            		 Integer.parseInt(array1[j+3].substring(6,8)),Integer.parseInt(array1[j+3].substring(4,6)),Integer.parseInt(array1[j+3].substring(0,4))), Integer.parseInt(array1[j]));
	          }
	          
	          TimeSeries ts2 = new TimeSeries("diastolic");
	          for (int j=0;j<=i-4;j=j+4)  {  
	             ts2.add(new Second(Integer.parseInt(array1[j+3].substring(12)), Integer.parseInt(array1[j+3].substring(10,12)),Integer.parseInt(array1[j+3].substring(8,10)),
	            		 Integer.parseInt(array1[j+3].substring(6,8)),Integer.parseInt(array1[j+3].substring(4,6)),Integer.parseInt(array1[j+3].substring(0,4))), Integer.parseInt(array1[j+1]));
	          }
	          
	          TimeSeries ts3 = new TimeSeries("heart rate");
	          for (int j=0;j<=i-4;j=j+4)  {  
		         ts3.add(new Second(Integer.parseInt(array1[j+3].substring(12)), Integer.parseInt(array1[j+3].substring(10,12)),Integer.parseInt(array1[j+3].substring(8,10)),
		                 Integer.parseInt(array1[j+3].substring(6,8)),Integer.parseInt(array1[j+3].substring(4,6)),Integer.parseInt(array1[j+3].substring(0,4))), Integer.parseInt(array1[j+2]));
	          }
	          
	          TimeSeriesCollection dataset = new TimeSeriesCollection();
	          dataset.addSeries(ts1);
	          dataset.addSeries(ts2);
	          dataset.addSeries(ts3);
	          
	          ChartFactory.setChartTheme(new StandardChartTheme("JFree/Shadow", true));
	          JFreeChart chart = ChartFactory.createTimeSeriesChart(
	                  "Heart Data Report",  // title
	                  "heart data",         // (red-systolic,blue-diastolic,green-heart-rate)",             // x-axis label
	                  "value",   // y-axis label
	                  dataset,            // data
	                  true,               // create legend?
	                  true,               
	                  false               // generate URLs?
	              );

	              chart.setBackgroundPaint(Color.green);

	              XYPlot plot = (XYPlot) chart.getPlot();
	              plot.setBackgroundPaint(Color.lightGray);
	              plot.setDomainGridlinePaint(Color.white);
	              plot.setRangeGridlinePaint(Color.white);
	              plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
	              plot.setDomainCrosshairVisible(true);
	              plot.setRangeCrosshairVisible(true);

	              XYItemRenderer r = plot.getRenderer();
	              if (r instanceof XYLineAndShapeRenderer) {
	                  XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
	                  renderer.setBaseShapesVisible(true);
	                  renderer.setBaseShapesFilled(true);
	                  renderer.setDrawSeriesLineAsPath(true);
	              }

	              DateAxis axis = (DateAxis) plot.getDomainAxis();
	              axis.setDateFormatOverride(new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss"));               //MMM-yyyy"));
	              
	              
	          ChartPanel panel = new ChartPanel(chart);
	          panel.setFillZoomRectangle(true);
	          panel.setMouseWheelEnabled(true);
	          
	          panel.setPreferredSize(new java.awt.Dimension(1000, 800));
	          //setContentPane(panel);
	          
	          demo.setContentPane(panel);
	          
	          //ChartPanel chartPanel = (ChartPanel) panel;
	          //chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	          //setContentPane(chartPanel);
	          
	          demo.pack();
	          RefineryUtilities.centerFrameOnScreen(demo);
	          demo.setVisible(true);
	          
	          
                 // JFreeChart chart = ChartFactory.createLineChart
	    	  
	    	  // PlotOrientation.VERTICAL, false, true, false);
	    	 /* chart.setBackgroundPaint(Color.green);
	    	  chart.getTitle().setPaint(Color.blue); 
	    	  CategoryPlot p = chart.getCategoryPlot(); 
	    	  p.setRangeGridlinePaint(Color.red); 
	    	  ChartFrame frame1=new ChartFrame("JAC444 part 2 - Heart Data Result",chart);
	    	  frame1.setVisible(true);
	    	  frame1.setSize(400,350);
	    	  frame1.setResizable(true);
	    	  panel5.add(frame1);   */
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
        Li2 t = new Li2();
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }		
}

