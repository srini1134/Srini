package com.srinivas.mytest;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ZipRangeTest {
	
	private ArrayList<Range> expectedResult;
	
    @Before
    public void setUp() {
    	System.out.println("@Before setUp");
    	this.expectedResult = new ArrayList<Range>();
    }
    
    @After
    public void clear() {
        System.out.println("@After clear");
        this.expectedResult.clear();
        ZipRange.clear();
    }
    
	@Test
	public void TestZipRange1() {
		setUp();
		
		Range a = new Range(94133, 94133);
		Range b = new Range(94200, 94299);
		Range c = new Range(94600, 94699);
		
		ZipRange.AddRange(a);
		ZipRange.AddRange(b);
		ZipRange.AddRange(c);
		
		Assert.assertEquals("failure - expected result size match", 3, ZipRange.size());
		
		Range e = new Range(94133, 94133);
		Range f = new Range(94200, 94299);
		Range g = new Range(94600, 94699);
		
		expectedResult.add(e);
		expectedResult.add(f);
		expectedResult.add(g);
		Assert.assertEquals("failure - expected result content match", expectedResult, ZipRange.getZipRanges());
		
		clear();
		
	}
	
	@Test
	public void TestZipRange2() {
		setUp();
		
		Range a = new Range(94133, 94133);
		Range b = new Range(94200, 94299);
		Range c = new Range(94226, 94399);
		
		ZipRange.AddRange(a);
		ZipRange.AddRange(b);
		ZipRange.AddRange(c);
		
		Assert.assertEquals("failure - expected result size match", 2, ZipRange.size());
		
		Range e = new Range(94133, 94133);
		Range f = new Range(94200, 94399);
		
		expectedResult.add(e);
		expectedResult.add(f);
		
		Assert.assertEquals("failure - expected result content match", expectedResult, ZipRange.getZipRanges());
		
		clear();
		
	}
	

}
