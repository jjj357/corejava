==================================================
Software: Heart Data Input, Output and Analysis
Author: Mingtao Li
ID: 016214108
Seneca user name: mli101
Date: July 23, 2012
Version: 1.0
==================================================

This assignment includes 3 parts.

1. Data Collection. 

User can input date, time, systolic pressure, diastolic pressure and heart rate. 
Then the data will be saved in a file called medicaldata.txt. Date, time, pressure and heart rate data 
are separated by a ";". To let users to choose date easily, I used a third party open source .jar file, 
swingx-0.9.2.jar. If everything is fine, the data will be stored in the txt file and a confirmation 
window will pop up showing "Your data has been stored successfully!". A method, isInteger(String s), 
is used to determine if user input is a string of numbers. Another method, isBetween(String s,
int min,int max), is used to determine if a string of numbers is between min and max.

   Classes used in part 1: 
      public class Li1 extends JFrame { };
      
      private class submitActionHandler implements ActionListener {   	
		public void actionPerformed (ActionEvent ae){ } };

      private class clearActionHandler implements ActionListener {
                public void actionPerformed (ActionEvent ae){ } }; 




2. Data Render. 

User can choose a time period to show the data in this time period. Same as part 1, 
a third party open source .jar file is used: swingx-0.9.2.jar. To show the data in a chart, another 
third party open source .jar files are used: jfreechart-1.0.14.jar and jcommon-1.0.17.jar. The chart 
will show the systolic pressure,diastolic pressure and heart rate in 3 curvy lines. 
   
   Classes used in part 2: 
      public class Li2 extends JFrame { };
      
      private class submitActionHandler implements ActionListener {   	
		public void actionPerformed (ActionEvent ae){ } };

      private class clearActionHandler implements ActionListener {
                public void actionPerformed (ActionEvent ae){ } };

      


3. Date Analysis. 

User can choose a time period of data to do analysis. Same as part 2, a third party 
open source .jar file is used: swingx-0.9.2.jar. To show the data in a chart, another third party open 
source .jar files are used: jfreechart-1.0.14.jar and jcommon-1.0.17.jar. The chart will show the 
maximum, minimum, mean, median, mode and range for systolic, diastolic, and heart rate in the given 
period of time. 

   Classes used in part 3: 
      public class Li3 extends JFrame { };

      private class sysActionHandler implements ActionListener {   	
		public void actionPerformed (ActionEvent ae){ } };


      private class DiasActionHandler implements ActionListener {   	
		public void actionPerformed (ActionEvent ae){ } };

      private class rateActionHandler implements ActionListener {   	
		public void actionPerformed (ActionEvent ae){ } };

      private class clearActionHandler implements ActionListener {
                public void actionPerformed (ActionEvent ae){ } };



------------------------------END---------------------------------------




