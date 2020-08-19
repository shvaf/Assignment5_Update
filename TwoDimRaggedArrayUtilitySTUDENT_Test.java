

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = null;
	private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8}};
	private double[][] dataSet2 = {{7, 2, 9, 4},{5},{8, 1, 3},{11, 6, 7, 2}};
	private double[][] dataSet3 = {{7.2, 2.5, 9.3, 4.8},{5.9},{8.1, 1.7, 3.3},{11.6, 6.9, 7.3, 2.7}};
	private double[][] dataSet4 = {{-2.5, -5.3, 6.1},{-4.4, 8.2},{2.3, -7.5},{-4.2, 7.3, -5.9, 2.6}};
	private double[][] district3 = {{1.65, 4.50, 2.36, 7.45, 3.44, 6.23},
									{2.22, -3.24, -1.66, -5.48, 3.46},
									{4.23, 2.29, 5.29},
									{2.76, 3.76, 4.29, 5.48, 3.43},
									{3.38, 3.65, 3.76},
									{2.46, 3.34, 2.38, 8.26, 5.34}};
	private double[][] district4 = {{1253.65, 4.50, 2154.36, 7532.45, 3388.44},
									{2876.22, -3.24, 1954.66},
									{4896.23, 2.29, 5499.29},
									{2256.76, 3.76, 4286.29, 5438.48, 3794.43},
									{3184.38, 3654.65, 3455.76, 6387.23, 4265.77, 4592.45},
									{2657.46, 3265.34, 2256.38, 8935.26, 5287.34, 6598.23}};
	private double[][] district5 = {{12536.54, 45665.05, 21543.66, 75324.57, 33884.48, 65982.39},
									{28762.21, 35762.42, 19546.63},
									{48962.34, 28552.95, 23863.66, 54992.97},
									{22567.63, 36237.64, 42862.95, 54384.86, 37944.37},
									{31843.86, 36546.57, 34557.68, 63872.39, 42657.70, 45924.51},
									{26574.65, 32653.46, 22563.87, 89352.68, 52873.49}};
	private double[][] studentTest1 = {{123.4, 5566.0, -3.00},
										{-5.00},
										{5000, 5000, 5000, 5000},
										{-4000, 2000, 2000, 4000, 5000},
										{1000},
										{1000,-1000},
										{1000,1000,1000},
										{1000}};
	private double[][] studentTest2 = {{1000, 2000, 3000, 4000, 5000},
										{-6000, -7000, -8000, -9000},
										{10000, 20000, 30000, 40000},
										{-50000, -60000, -70000},
										{80000, 90000},
										{-1000, 1000}};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testGetTotal() {
		//Testing dataSet1
		double total1 = TwoDimRaggedArrayUtility.getTotal(dataSet1);
		assertEquals(36,total1, .001);
		//Testing studentTest1
		double total2 = TwoDimRaggedArrayUtility.getTotal(studentTest1);
		assertEquals(39681.4,total2, .001);		
		//Testing studnetTest2
		double total3 = TwoDimRaggedArrayUtility.getTotal(studentTest2);
		assertEquals(75000,total3, .001);
		//fail("Student testGetTotal not implemented");	
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		//Testing dataSet1
		double value1 = TwoDimRaggedArrayUtility.getAverage(dataSet1);
		assertEquals(4.5,value1, .001);
		//Testing studentTest1
		double value2 = TwoDimRaggedArrayUtility.getAverage(studentTest1);
		assertEquals(1984.07,value2, .001);		
		//Testing studnetTest2
		double value3 = TwoDimRaggedArrayUtility.getAverage(studentTest2);
		assertEquals(3750,value3, .001);
		//fail("Student testGetTotal not implemented");	
		//fail("Student testGetAverage not implemented");	
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		//Testing dataSet2
		double value1 = TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 3);
		assertEquals(26,value1, .001);
		//Testing studentTest1
		double value2 = TwoDimRaggedArrayUtility.getRowTotal(studentTest1, 3);
		assertEquals(9000,value2, .001);		
		//Testing studnetTest2
		double value3 = TwoDimRaggedArrayUtility.getRowTotal(studentTest2, 5);
		assertEquals(0,value3, .001);
		//fail("Student testGetRowTotal not implemented");	
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnTotal() {
		//Testing dataSet2
		double value1 = TwoDimRaggedArrayUtility.getColumnTotal(district5, 6);
		assertEquals(0,value1, .001);
		//Testing studentTest1
		double value2 = TwoDimRaggedArrayUtility.getColumnTotal(studentTest1, 3);
		assertEquals(9000,value2, .001);		
		//Testing studnetTest2
		double value3 = TwoDimRaggedArrayUtility.getColumnTotal(studentTest2, 0);
		assertEquals(34000,value3, .001);
		//fail("Student testGetColumnTotal not implemented");	
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		double value1 = TwoDimRaggedArrayUtility.getHighestInArray(district4);
		assertEquals(8935.26,value1, .001);
		//Testing studentTest1
		double value2 = TwoDimRaggedArrayUtility.getHighestInArray(studentTest1);
		assertEquals(5566.0,value2, .001);		
		//Testing studnetTest2
		double value3 = TwoDimRaggedArrayUtility.getHighestInArray(studentTest2);
		assertEquals(90000,value3, .001);
		//fail("Student testGetHighestInArray not implemented");	
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
		TwoDimRaggedArrayUtility.writeToFile(dataSet1, outputFile);
		assertFalse(outputFile.equals(null));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}