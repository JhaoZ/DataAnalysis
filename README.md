# DataAnalysis
My data analysis project for AP Computer Science P.

To use this project, you need to import all the java files and download JFreeChart jar at https://www.jfree.org/jfreechart/download/. 

Download version 1.0.1, the zip file if you are using windows and the gz file if you are using linux.
Import the jars into the IDE, you only need to import two.

This two jars are in the lib folder, and even though there are 5 jars, you only need to import jfreechart-1.0.1.jar and jcommon-1.0.0.jar. 

Use eclipse to import the java files and the two jars, you can use build path to add the jars (right click on the project). Once you import them, the import statements in the code should compile.

After importing it, you have to open Anaylsis.java, which is where to run the main code. You also need the csv file.
It will run and post several questions on whether you want to view the charts and graphs, if you want to, input the character "Y".

For most of the program, I would have different variables for each chart, and then add them to a double or int array to then process in the graphs. This is very inefficient and not good coding, and I wish to be able to fix it so that it runs quicker and looks cleaner in the future. Each of my graphs are objects, and I have a method to show them. If I had more time, I would add a method that stores the graph as an image to a specified folder.

The graphs I used were CatergoryPlots and XYPlots, they include line graphs and bar charts. I have a method in each of them that processes my data array and returns a dataset (CategoryDatasat and XYDataSet with series) used to generate my graph. I customized the graphs a bit using the color changes in Java swing and the support from JFreeChart API.

For the tables, I used java swing methods instead of imported jar files. They are simple matrixes, however you can swap the data and move it around (which doesn't actually affect the data), this makes it easier for people who want to compare data side by side.

The graphs I used were based on what I wanted to see, if there was a trend, I would use a line graph, if I wanted to compare certain value, I used a bar graph.

Learning how to use JFreeChart API did take some time, but it was very rewardaring since I can use them in future projects. 

If I had more time, I would've added a menu to view categories and export the data as a csv file.
