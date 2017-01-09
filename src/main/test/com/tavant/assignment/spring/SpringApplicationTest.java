package com.tavant.assignment.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.tavant.assignment.spring.mock.MockInputs;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class SpringApplicationTest {

	@InjectMocks
	SpringApplication springApp;

	@Test
	public void testAddAndMultiplyIntegersPositiveCase() {
		Object[] inputs = MockInputs.getInputs();
		int length = inputs.length;
		int actual = springApp.sumOfTheInputs(inputs, length);
		Assert.assertEquals(155, actual);

		Object actualMultiply = springApp.multiplicationOfInputs(inputs, length);
		Assert.assertEquals(13200000, actualMultiply);
	}

	@Test
	public void testAddAndMultiplyNegativeIntegers() {
		Object[] inputs = { -1, 0 };
		int length = inputs.length;
		int actual = springApp.sumOfTheInputs(inputs, length);
		Assert.assertEquals(-1, actual);

		Object actualMultiply = springApp.multiplicationOfInputs(inputs, length);
		Assert.assertEquals(0, actualMultiply);
	}

	@Test(expected = NullPointerException.class)
	public void testAddAndMultiplyIntegersNegativeCase() {
		Object[] inputs = {};
		int length = inputs.length;
		int actual = springApp.sumOfTheInputs(inputs, length);
		Assert.assertEquals(0, actual);

		Object actualMultiply = springApp.multiplicationOfInputs(inputs, length);
		Assert.assertEquals(0, actualMultiply);
	}

	@Test
	public void testAddAndMultiplyFloatNumbersPositiveCase() {
		Object[] inputs = MockInputs.getFloatInputs();
		int length = inputs.length;
		int actual = springApp.sumOfTheInputs(inputs, length);
		Assert.assertEquals(8744, actual);

		Object actualMultiply = springApp.multiplicationOfInputs(inputs, length);
		Assert.assertEquals(7781400, actualMultiply);
	}

	@Test
	public void testAddAndMultiplyDoubleNumbersPositiveCase() {
		Object[] inputs = MockInputs.getDoubleInputs();
		int length = inputs.length;
		int actual = springApp.sumOfTheInputs(inputs, length);
		Assert.assertEquals(10, actual);

		Object actualMultiply = springApp.multiplicationOfInputs(inputs, length);
		Assert.assertEquals(10, actualMultiply);
	}

	@Test
	public void testAddAndMultiplyStringNumbersPositiveCase() {
		Object[] inputs = MockInputs.getStringInputs();
		int length = inputs.length;
		int actual = springApp.sumOfTheInputs(inputs, length);
		Assert.assertEquals(215, actual);

		Object actualMultiply = springApp.multiplicationOfInputs(inputs, length);
		Assert.assertEquals(6854400, actualMultiply);
	}

	@Test
	public void testAddAndMultiplyAllNumbers() {
		Object[] inputs = { 12, 12.98f, 20.0f, "50", -100 };
		int length = inputs.length;
		int actual = springApp.sumOfTheInputs(inputs, length);
		Assert.assertEquals(-6, actual);

		Object actualMultiply = springApp.multiplicationOfInputs(inputs, length);
		Assert.assertEquals(15600000, actualMultiply);
	}

	
	@Test
	public void testNoOfIterationsCalledForAdd(){
	
		Assert.assertEquals(5, springApp.noOfIterationsCalled(5,3));
		Assert.assertEquals(20, springApp.noOfIterationsCalled(20, 5));
	}
	
	@Test
	public void testNoOfIterationsCalledForAddNegativeCase(){
	
		Assert.assertEquals(-5, springApp.noOfIterationsCalled(-5,67));
		Assert.assertEquals(0, springApp.noOfIterationsCalled(0, 5));
	}
	
	@Test
	public void testNoOfIterationsCalledForAddInObjects(){
	
		Assert.assertEquals(9, springApp.noOfIterationsCalled(9.85,0.5));
		Assert.assertEquals(2, springApp.noOfIterationsCalled("2", 76.8f));
	}
	 
}
