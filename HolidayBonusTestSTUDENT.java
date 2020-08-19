
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestSTUDENT {
	
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

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	

	/**
	 * Test calculateHolidayBonus method with a high of 5000, low of 1000 and 2000 as other		 
	 */
//	public void testCalculateHolidayBonusB() {
//		double[] result = HolidayBonus.calculateHolidayBonus(dataSet1,5000,1000,2000);
//		System.out.println(result);
//	}
	/*
	 * @Test public void testCalculateHolidayBonusB() { double[] result =
	 * HolidayBonus.calculateHolidayBonus(dataSet1,5000,1000,2000);
	 * System.out.println(result); assertEquals(3000.0,result[0],.001); }
	 */
		@Test
		public void testCalculateHolidayBonusA() {
			try{
			//System.out.println(dataSet1);
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1,5000,1000,2000);
			assertEquals(3000.0,result[0],.001);
			}
			catch (Exception e) {
				fail("This should not have caused an Exception");
			} 
		}
		@Test
		public void testCalculateHolidayBonusB() {
			try{
			double[] result = HolidayBonus.calculateHolidayBonus(studentTest2,5000,1000,2000);
			assertEquals(0,result[1],.001);
			}
			catch (Exception e) {
				fail("This should not have caused an Exception");
			}
		}
		@Test
		public void testCalculateHolidayBonusC() {
			try{
			double[] result = HolidayBonus.calculateHolidayBonus(studentTest1,5000,1000,2000);
			assertEquals(7000,result[0],.001);
			}
			catch (Exception e) {
				fail("This should not have caused an Exception");
			}
		}
		@Test
		public void testCaculateTotalHolidayBonusA() {
			double result1 = HolidayBonus.calculateTotalHolidayBonus(studentTest1, 5000, 1000, 2000);
			assertEquals(44000, result1, 0.001);
		}
		@Test
		public void testCaculateTotalHolidayBonusB() {
			double result2 = HolidayBonus.calculateTotalHolidayBonus(studentTest2, 5000, 1000, 2000);
			assertEquals(39000, result2, 0.001);
		}

		
}