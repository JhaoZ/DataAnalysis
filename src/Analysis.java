import java.io.*;
import java.util.*;

public class Analysis {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("birth.csv"));
		ArrayList<String> year = new ArrayList<String>();
		ArrayList<String> month = new ArrayList<String>();
		ArrayList<String> date_of_month = new ArrayList<String>();
		ArrayList<String> day_of_week = new ArrayList<String>();
		ArrayList<String> births = new ArrayList<String>();
		br.readLine();
		String line;
		while ((line = br.readLine()) != "") {
			if (line == null) {
				break;
			}
			if (line.length() > 0) {
				String[] currentDataStrings = line.split(",");
				year.add(currentDataStrings[0]);
				month.add(currentDataStrings[1]);
				date_of_month.add(currentDataStrings[2]);
				day_of_week.add(currentDataStrings[3]);
				births.add(currentDataStrings[4]);
			}
		}
		// System.out.println("Date of Month: " + date_of_month);
		// System.out.println("Day of Week: " + day_of_week);
		// System.out.println("Month: " + month);
		// System.out.println("Year: " + year);
		// System.out.println("Births: " + births);
		long totalBirths = 0;
		for (String num : births) {
			totalBirths += Integer.parseInt(num);
		}
		System.out.println("Total Births: " + totalBirths);
		int minimum = Integer.MAX_VALUE;
		int position = 0;
		for (int i = 0; i < births.size(); i++) {
			if (Integer.parseInt(births.get(i)) < minimum) {
				minimum = Integer.parseInt(births.get(i));
				position = i;
			}
		}
		System.out.println("On " + convertToMonth(Integer.parseInt(month.get(position))) + ". "
				+ date_of_month.get(position) + " " + year.get(position)
				+ ", the least amount of babies were born, which was " + minimum + " babies");
		int maximum = Integer.MIN_VALUE;
		int pos2 = 0;
		for (int i = 0; i < births.size(); i++) {
			if (Integer.parseInt(births.get(i)) > maximum) {
				maximum = Integer.parseInt(births.get(i));
				pos2 = i;
			}
		}
		System.out.println("On " + convertToMonth(Integer.parseInt(month.get(pos2))) + ". " + date_of_month.get(pos2)
				+ " " + year.get(pos2) + ", the most amount of babies were born, which was " + maximum + " babies");
		ArrayList<Integer> Year = convertToInt(year);
		ArrayList<Integer> Month = convertToInt(month);
		ArrayList<Integer> Date = convertToInt(date_of_month);
		ArrayList<Integer> DayOfWeek = convertToInt(day_of_week);
		ArrayList<Integer> Births = convertToInt(births);

		// Week

		String[][] percentagesDayOfTheWeek = new String[2][7];
		int mondayCount = 0;
		int tuesdayCount = 0;
		int wednesdayCount = 0;
		int thursdayCount = 0;
		int fridayCount = 0;
		int saturdayCount = 0;
		int sundayCount = 0;
		int total = 0;
		for (int i = 0; i < DayOfWeek.size(); i++) {
			if (DayOfWeek.get(i) == 1) {
				mondayCount += Births.get(i);
				total += Births.get(i);
			} else if (DayOfWeek.get(i) == 2) {
				tuesdayCount += Births.get(i);
				total += Births.get(i);
			} else if (DayOfWeek.get(i) == 3) {
				wednesdayCount += Births.get(i);
				total += Births.get(i);
			} else if (DayOfWeek.get(i) == 4) {
				thursdayCount += Births.get(i);
				total += Births.get(i);
			} else if (DayOfWeek.get(i) == 5) {
				fridayCount += Births.get(i);
				total += Births.get(i);
			} else if (DayOfWeek.get(i) == 6) {
				saturdayCount += Births.get(i);
				total += Births.get(i);
			} else if (DayOfWeek.get(i) == 7) {
				sundayCount += Births.get(i);
				total += Births.get(i);
			}
		}
		percentagesDayOfTheWeek[0][0] = "Monday";
		percentagesDayOfTheWeek[0][1] = "Tuesday";
		percentagesDayOfTheWeek[0][2] = "Wednesday";
		percentagesDayOfTheWeek[0][3] = "Thursday";
		percentagesDayOfTheWeek[0][4] = "Friday";
		percentagesDayOfTheWeek[0][5] = "Saturday";
		percentagesDayOfTheWeek[0][6] = "Sunday";
		// Pecentages
		percentagesDayOfTheWeek[1][0] = ((((double) mondayCount / total) * 100) + "").substring(0, 5) + "%";
		percentagesDayOfTheWeek[1][1] = ((((double) tuesdayCount / total) * 100) + "").substring(0, 5) + "%";
		percentagesDayOfTheWeek[1][2] = ((((double) wednesdayCount / total) * 100) + "").substring(0, 5) + "%";
		percentagesDayOfTheWeek[1][3] = ((((double) thursdayCount / total) * 100) + "").substring(0, 5) + "%";
		percentagesDayOfTheWeek[1][4] = ((((double) fridayCount / total) * 100) + "").substring(0, 5) + "%";
		percentagesDayOfTheWeek[1][5] = ((((double) saturdayCount / total) * 100) + "").substring(0, 5) + "%";
		percentagesDayOfTheWeek[1][6] = ((((double) sundayCount / total) * 100) + "").substring(0, 5) + "%";

		double[] percentages = new double[7];
		for (int i = 0; i < percentages.length; i++) {
			percentages[i] = Double.parseDouble(percentagesDayOfTheWeek[1][i].substring(0, 5));
		}

		Scanner s1 = new Scanner(System.in);
		System.out.println("Would you like a chart for the percentages of babies born in each day of the week?");

		String viewChart = s1.nextLine();
		if (viewChart.equalsIgnoreCase("Y")) {
			PercentageTable.showPercentTable(percentagesDayOfTheWeek,
					"Percentages of babaies born in each day of the week");
		}

		System.out.println("Would you like to view the bar graph for percentages babies born in each day of the week?");
		viewChart = s1.nextLine();
		if (viewChart.equalsIgnoreCase("Y")) {
			PercentageChart.viewPercentChart("Bar Graph", percentages, "Percents of babies born on certain days");
		}

		// Month

		int janCount = 0;
		int febCount = 0;
		int marCount = 0;
		int aprCount = 0;
		int mayCount = 0;
		int junCount = 0;
		int julCount = 0;
		int augCount = 0;
		int sepCount = 0;
		int octCount = 0;
		int novCount = 0;
		int decCount = 0;
		int totalMonthCount = 0;

		for (int i = 0; i < Month.size(); i++) {
			if (Month.get(i) == 1) {
				janCount += Births.get(i);
				totalMonthCount += Births.get(i);
			} else if (Month.get(i) == 2) {
				febCount += Births.get(i);
				totalMonthCount += Births.get(i);
			} else if (Month.get(i) == 3) {
				marCount += Births.get(i);
				totalMonthCount += Births.get(i);
			} else if (Month.get(i) == 4) {
				aprCount += Births.get(i);
				totalMonthCount += Births.get(i);
			} else if (Month.get(i) == 5) {
				mayCount += Births.get(i);
				totalMonthCount += Births.get(i);
			} else if (Month.get(i) == 6) {
				junCount += Births.get(i);
				totalMonthCount += Births.get(i);
			} else if (Month.get(i) == 7) {
				julCount += Births.get(i);
				totalMonthCount += Births.get(i);
			} else if (Month.get(i) == 8) {
				augCount += Births.get(i);
				totalMonthCount += Births.get(i);
			} else if (Month.get(i) == 9) {
				sepCount += Births.get(i);
				totalMonthCount += Births.get(i);
			} else if (Month.get(i) == 10) {
				octCount += Births.get(i);
				totalMonthCount += Births.get(i);
			} else if (Month.get(i) == 11) {
				novCount += Births.get(i);
				totalMonthCount += Births.get(i);
			} else if (Month.get(i) == 12) {
				decCount += Births.get(i);
				totalMonthCount += Births.get(i);
			}

		}

		String[][] percentagesMonth = new String[2][12];
		percentagesMonth[0][0] = "January";
		percentagesMonth[0][1] = "February";
		percentagesMonth[0][2] = "March";
		percentagesMonth[0][3] = "April";
		percentagesMonth[0][4] = "May";
		percentagesMonth[0][5] = "June";
		percentagesMonth[0][6] = "July";
		percentagesMonth[0][7] = "August";
		percentagesMonth[0][8] = "September";
		percentagesMonth[0][9] = "October";
		percentagesMonth[0][10] = "November";
		percentagesMonth[0][11] = "December";

		percentagesMonth[1][0] = ((((double) janCount / totalMonthCount) * 100) + "").substring(0, 5);
		percentagesMonth[1][1] = ((((double) febCount / totalMonthCount) * 100) + "").substring(0, 5);
		percentagesMonth[1][2] = ((((double) marCount / totalMonthCount) * 100) + "").substring(0, 5);
		percentagesMonth[1][3] = ((((double) aprCount / totalMonthCount) * 100) + "").substring(0, 5);
		percentagesMonth[1][4] = ((((double) mayCount / totalMonthCount) * 100) + "").substring(0, 5);
		percentagesMonth[1][5] = ((((double) junCount / totalMonthCount) * 100) + "").substring(0, 5);
		percentagesMonth[1][6] = ((((double) julCount / totalMonthCount) * 100) + "").substring(0, 5);
		percentagesMonth[1][7] = ((((double) augCount / totalMonthCount) * 100) + "").substring(0, 5);
		percentagesMonth[1][8] = ((((double) sepCount / totalMonthCount) * 100) + "").substring(0, 5);
		percentagesMonth[1][9] = ((((double) octCount / totalMonthCount) * 100) + "").substring(0, 5);
		percentagesMonth[1][10] = ((((double) novCount / totalMonthCount) * 100) + "").substring(0, 5);
		percentagesMonth[1][11] = ((((double) decCount / totalMonthCount) * 100) + "").substring(0, 5);

		System.out.println("Would you like to see the chart for the percentage of babies born in each month?");
		viewChart = s1.nextLine();
		if (viewChart.equalsIgnoreCase("Y")) {
			PercentTableMonth.showPercentTable(percentagesMonth, "Percentages Of Babies born in each month");
		}

		double[] percentages2 = new double[12];
		for (int i = 0; i < percentages2.length; i++) {
			percentages2[i] = Double.parseDouble(percentagesMonth[1][i]);
		}

		System.out.println("Would you like to view the bar graph for the percentages babies born in each month?");

		viewChart = s1.nextLine();
		if (viewChart.equalsIgnoreCase("Y")) {
			PercentChartMonth.viewPercentChart("Percent Chart", percentages2, "Percent of Babies born in each month");
		}

		int birth2000 = 0;
		int birth2001 = 0;
		int birth2002 = 0;
		int birth2003 = 0;
		int birth2004 = 0;
		int birth2005 = 0;
		int birth2006 = 0;
		int birth2007 = 0;
		int birth2008 = 0;
		int birth2009 = 0;
		int birth2010 = 0;
		int birth2011 = 0;
		int birth2012 = 0;
		int birth2013 = 0;
		int birth2014 = 0;
		for (int i = 0; i < Year.size(); i++) {
			if (Year.get(i) == 2000) {
				birth2000 += Births.get(i);
			} else if (Year.get(i) == 2001) {
				birth2001 += Births.get(i);
			} else if (Year.get(i) == 2002) {
				birth2002 += Births.get(i);
			} else if (Year.get(i) == 2003) {
				birth2003 += Births.get(i);
			} else if (Year.get(i) == 2004) {
				birth2004 += Births.get(i);
			} else if (Year.get(i) == 2005) {
				birth2005 += Births.get(i);
			} else if (Year.get(i) == 2006) {
				birth2006 += Births.get(i);
			} else if (Year.get(i) == 2007) {
				birth2007 += Births.get(i);
			} else if (Year.get(i) == 2008) {
				birth2008 += Births.get(i);
			} else if (Year.get(i) == 2009) {
				birth2009 += Births.get(i);
			} else if (Year.get(i) == 2010) {
				birth2010 += Births.get(i);
			} else if (Year.get(i) == 2011) {
				birth2011 += Births.get(i);
			} else if (Year.get(i) == 2012) {
				birth2012 += Births.get(i);
			} else if (Year.get(i) == 2013) {
				birth2013 += Births.get(i);
			} else if (Year.get(i) == 2014) {
				birth2014 += Births.get(i);
			}
		}

		int birthsByYear[] = new int[15];
		birthsByYear[0] = birth2000;
		birthsByYear[1] = birth2001;
		birthsByYear[2] = birth2002;
		birthsByYear[3] = birth2003;
		birthsByYear[4] = birth2004;
		birthsByYear[5] = birth2005;
		birthsByYear[6] = birth2006;
		birthsByYear[7] = birth2007;
		birthsByYear[8] = birth2008;
		birthsByYear[9] = birth2009;
		birthsByYear[10] = birth2010;
		birthsByYear[11] = birth2011;
		birthsByYear[12] = birth2012;
		birthsByYear[13] = birth2013;
		birthsByYear[14] = birth2014;

		System.out.println("Would you like to view the line graph for the births by year?");
		viewChart = s1.nextLine();
		if (viewChart.equalsIgnoreCase("Y")) {
			BirthByYearLineGraph.viewChart("Line Graph", birthsByYear, "Babies born by year");
		}

		// Special Days

		int unSpecialBorn = 0;
		int totalUnspecial = 0;
		int christmasDay = 0;
		int christmasTotal = 0;
		int fridayThe13th = 0;
		int totalFriday = 0;
		int leapDay = 0;
		int totalLeap = 0;

		for (int i = 0; i < Births.size(); i++) {
			if (Month.get(i) == 12 && Date.get(i) == 25) {
				christmasDay += Births.get(i);
				christmasTotal++;
			} else if (Month.get(i) == 2 && Date.get(i) == 29) {
				leapDay += Births.get(i);
				totalLeap++;
			} else if (DayOfWeek.get(i) == 5 && Date.get(i) == 13) {
				fridayThe13th += Births.get(i);
				totalFriday++;
			} else {
				unSpecialBorn += Births.get(i);
				totalUnspecial++;
			}
		}

		double[] averageOfSpecialDayBirths = new double[4];
		averageOfSpecialDayBirths[0] = (double) unSpecialBorn / totalUnspecial;
		averageOfSpecialDayBirths[1] = (double) christmasDay / christmasTotal;
		averageOfSpecialDayBirths[2] = (double) leapDay / totalLeap;
		averageOfSpecialDayBirths[3] = (double) fridayThe13th / totalFriday;

		System.out.println("Would you like to view the bar graph for births on special days?");
		viewChart = s1.nextLine();
		if (viewChart.equalsIgnoreCase("Y")) {
			SpecialDayBarGraph.viewBarChart("Bar Graph", averageOfSpecialDayBirths, "Births on Special Days");
		}

		int spring = 0;
		int summer = 0;
		int fall = 0;
		int winter = 0;
		for (int i = 0; i < Births.size(); i++) {
			if (Month.get(i) >= 3 && Month.get(i) <= 5) {
				spring += Births.get(i);
			} else if (Month.get(i) >= 6 && Month.get(i) <= 8) {
				summer += Births.get(i);
			} else if (Month.get(i) >= 9 && Month.get(i) <= 11) {
				fall += Births.get(i);
			} else {
				winter += Births.get(i);
			}
		}

		int[] birthsBySeason = new int[4];

		birthsBySeason[0] = spring;
		birthsBySeason[1] = summer;
		birthsBySeason[2] = fall;
		birthsBySeason[3] = winter;

		System.out.println("Do you want to see the bar graph for the babies born in each season?");
		viewChart = s1.nextLine();
		if (viewChart.equalsIgnoreCase("Y")) {
			BirthsBySeasonBarGraph.viewBarChart("Bar Graph", birthsBySeason, "Babies Born in Each Season");
		}

		int[] downturn = new int[36];

		int jan2008 = 0;
		int feb2008 = 0;
		int mar2008 = 0;
		int apr2008 = 0;
		int may2008 = 0;
		int jun2008 = 0;
		int jul2008 = 0;
		int aug2008 = 0;
		int sep2008 = 0;
		int oct2008 = 0;
		int nov2008 = 0;
		int dec2008 = 0;
		int jan2009 = 0;
		int feb2009 = 0;
		int mar2009 = 0;
		int apr2009 = 0;
		int may2009 = 0;
		int jun2009 = 0;
		int jul2009 = 0;
		int aug2009 = 0;
		int sep2009 = 0;
		int oct2009 = 0;
		int nov2009 = 0;
		int dec2009 = 0;
		int jan2010 = 0;
		int feb2010 = 0;
		int mar2010 = 0;
		int apr2010 = 0;
		int may2010 = 0;
		int jun2010 = 0;
		int jul2010 = 0;
		int aug2010 = 0;
		int sep2010 = 0;
		int oct2010 = 0;
		int nov2010 = 0;
		int dec2010 = 0;

		for (int i = 0; i < Births.size(); i++) {
			if (Year.get(i) == 2008) {
				if(Month.get(i) == 1) {
					jan2008+=Births.get(i);
				} else if(Month.get(i) == 2) {
					feb2008+=Births.get(i);
				} else if(Month.get(i) == 3) {
					mar2008+=Births.get(i);
				} else if(Month.get(i) == 4) {
					apr2008+=Births.get(i);
				} else if(Month.get(i) == 5) {
					may2008+=Births.get(i);
				} else if(Month.get(i) == 6) {
					jun2008+=Births.get(i);
				} else if(Month.get(i) == 7) {
					jul2008+=Births.get(i);
				} else if(Month.get(i) == 8) {
					aug2008+=Births.get(i);
				} else if(Month.get(i) == 9) {
					sep2008+=Births.get(i);
				} else if(Month.get(i) == 10) {
					oct2008+=Births.get(i);
				} else if(Month.get(i) == 11) {
					nov2008+=Births.get(i);
				} else  {
					dec2008+=Births.get(i);
				}			
			} else if (Year.get(i) == 2009) {
				if(Month.get(i) == 1) {
					jan2009+=Births.get(i);
				} else if(Month.get(i) == 2) {
					feb2009+=Births.get(i);
				} else if(Month.get(i) == 3) {
					mar2009+=Births.get(i);
				} else if(Month.get(i) == 4) {
					apr2009+=Births.get(i);
				} else if(Month.get(i) == 5) {
					may2009+=Births.get(i);
				} else if(Month.get(i) == 6) {
					jun2009+=Births.get(i);
				} else if(Month.get(i) == 7) {
					jul2009+=Births.get(i);
				} else if(Month.get(i) == 8) {
					aug2009+=Births.get(i);
				} else if(Month.get(i) == 9) {
					sep2009+=Births.get(i);
				} else if(Month.get(i) == 10) {
					oct2009+=Births.get(i);
				} else if(Month.get(i) == 11) {
					nov2009+=Births.get(i);
				} else  {
					dec2009+=Births.get(i);
				}
			} else if (Year.get(i) == 2010) {
				if(Month.get(i) == 1) {
					jan2010+=Births.get(i);
				} else if(Month.get(i) == 2) {
					feb2010+=Births.get(i);
				} else if(Month.get(i) == 3) {
					mar2010+=Births.get(i);
				} else if(Month.get(i) == 4) {
					apr2010+=Births.get(i);
				} else if(Month.get(i) == 5) {
					may2010+=Births.get(i);
				} else if(Month.get(i) == 6) {
					jun2010+=Births.get(i);
				} else if(Month.get(i) == 7) {
					jul2010+=Births.get(i);
				} else if(Month.get(i) == 8) {
					aug2010+=Births.get(i);
				} else if(Month.get(i) == 9) {
					sep2010+=Births.get(i);
				} else if(Month.get(i) == 10) {
					oct2010+=Births.get(i);
				} else if(Month.get(i) == 11) {
					nov2010+=Births.get(i);
				} else  {
					dec2010+=Births.get(i);
				}
			}
		}
		
		downturn[0] = jan2008;
		downturn[1] = feb2008;
		downturn[2] = mar2008;
		downturn[3] = apr2008;
		downturn[4] = may2008;
		downturn[5] = jun2008;
		downturn[6] = jul2008;
		downturn[7] = aug2008;
		downturn[8] = sep2008;
		downturn[9] = oct2008;
		downturn[10] = nov2008;
		downturn[11] = dec2008;
		downturn[12] = jan2009;
		downturn[13] = feb2009;
		downturn[14] = mar2009;
		downturn[15] = apr2009;
		downturn[16] = may2009;
		downturn[17] = jun2009;
		downturn[18] = jul2009;
		downturn[19] = aug2009;
		downturn[20] = sep2009;
		downturn[21] = oct2009;
		downturn[22] = nov2009;
		downturn[23] = dec2009;
		downturn[24] = jan2010;
		downturn[25] = feb2010;
		downturn[26] = mar2010;
		downturn[27] = apr2010;
		downturn[28] = may2010;
		downturn[29] = jun2010;
		downturn[30] = jul2010;
		downturn[31] = aug2010;
		downturn[32] = sep2010;
		downturn[33] = oct2010;
		downturn[34] = nov2010;
		downturn[35] = dec2010;
		System.out.println("Would you like to view the chart for the Downturn of baby births month by month after 2007 (starts in 2008)?");

		viewChart = s1.nextLine();
			if(viewChart.equalsIgnoreCase("Y")) {
			DownturnLineGraph.viewChart("Line Graph", downturn, "Downturn of baby births month by month after 2007 (starts in 2008)");
		}
			
			//end of code
	}

	public static ArrayList<Integer> convertToInt(ArrayList<String> list) {
		ArrayList<Integer> Arr = new ArrayList<Integer>();
		for (String thing : list) {
			Arr.add(Integer.parseInt(thing));
		}
		return Arr;
	}

	public static String convertToMonth(int month) {
		if (month == 1) {
			return "Jan";
		} else if (month == 2) {
			return "Feb";
		} else if (month == 3) {
			return "Mar";
		} else if (month == 4) {
			return "Apr";
		} else if (month == 5) {
			return "May";
		} else if (month == 6) {
			return "Jun";
		} else if (month == 7) {
			return "Jul";
		} else if (month == 8) {
			return "Aug";
		} else if (month == 9) {
			return "Sep";
		} else if (month == 10) {
			return "Oct";
		} else if (month == 11) {
			return "Nov";
		}
		return "Dec";
	}

}
