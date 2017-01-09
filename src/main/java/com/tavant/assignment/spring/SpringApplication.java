package com.tavant.assignment.spring;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class SpringApplication {

	final static Logger log = Logger.getLogger(SpringApplication.class.getName());
	int noOfTimesCalled = 0;
	public void doAddAndMultiply() {

		Scanner scanner = new Scanner(System.in);
		Object[] inputs;
		int i = 0;
		log.info("no of inputs to add");
		int count = scanner.nextInt();

		if (count <= 0) {
			scanner.close();
			throw new ArithmeticException("count should be more than zero");
		} else {
			inputs = new Object[count];
		}

		log.info("inputs to add and multiply");

		for (i = 0; i < count; i++) {
			if (scanner.hasNext()) {
				try {
					inputs[i] = scanner.nextInt();
				} catch (Exception e) {
					scanner.close();
					throw new InputMismatchException("Please enter only integers,Sorry for the inconvenience!!");
				}
			}
		}

		int length = inputs.length;
		int total = sumOfTheInputs(inputs, length);

		log.info("Addition Value : " + total);

		Object multiplyTotal = multiplicationOfInputs(inputs, length);
		log.info("Multiplication Value :" + multiplyTotal);
		scanner.close();
	}
	
	public int sumOfTheInputs(Object[] inputs, int length) {
		int total = 0;
		for (int i = 0; i < length;) {
			total = add(inputs[i], total);
			i++;
		}
		return total;
	}
	
	public int add(Object input, int total) {
		if (input instanceof Float) {
			total += ((Float) input).floatValue();
		} else if (input instanceof Double) {
			total += ((Double) input).doubleValue();
		} else if (input instanceof String) {
			total += Integer.parseInt(String.valueOf(input));
		} else {
			total += ((Integer) input).intValue();
		}
		return total;
	}

	public Object multiplicationOfInputs(Object[] inputs, int length) {
		Object counter = 0;
		Object value = 0;
		if (inputs != null && inputs.length > 0) {
			value = inputs[0];
			for (int i = 0; i < length - 1;) {
				counter = inputs[i + 1];
				value = repeatedAddition(counter, value);
				i++;
			}
		} else {
			throw new NullPointerException("inputs array empty or null");
		}
		return value;
	}

	public int repeatedAddition(Object counter, Object value) {
		int total = 0, i;
		noOfTimesCalled = 0;
		if (counter instanceof Float) {
			float cnter = ((Float) counter).floatValue();
			if (cnter > 0) {
				for (i = 0; i < cnter;) {
					total = add(value, total);
					i++;
				}
				noOfTimesCalled = (int) cnter;
			} else if (cnter < 0) {
				for (i = 0; i > cnter;) {
					total = add(value, total);
					i--;
				}
				noOfTimesCalled = (int) cnter;
			}
		} else if (counter instanceof Double) {
			double cnter = ((Double) counter).doubleValue();
			if (cnter > 0) {
				for (i = 0; i < cnter;) {
					total = add(value, total);
					i++;
				}
				noOfTimesCalled = (int) cnter;
			} else if (cnter < 0) {
				for (i = 0; i > cnter;) {
					total = add(value, total);
					i--;
				}
				noOfTimesCalled = (int) cnter;
			}
		} else if (counter instanceof String) {
			int cnter = Integer.parseInt(String.valueOf(counter));
			total = callIterationsForAdd(cnter, value);
		} else {
			int cnter = ((Integer) counter).intValue();
			total = callIterationsForAdd(cnter, value);
		}
		return total;
	}

	public int callIterationsForAdd(int cnter, Object value) {
		int total = 0, i;
		noOfTimesCalled = 0;
		if (cnter > 0) {
			for (i = 0; i < cnter;) {
				total = add(value, total);
				i++;
			}
			noOfTimesCalled = cnter;
		} else if (cnter < 0) {
			for (i = 0; i > cnter;) {
				total = add(value, total);
				i--;
			}
			noOfTimesCalled = cnter;
		}
		return total;
	}
	
	public int noOfIterationsCalled(int counter, int value){
		callIterationsForAdd(counter, value);
		return noOfTimesCalled;
	}
	
	public int noOfIterationsCalled(Object counter, Object value){
		repeatedAddition(counter, value);
		return noOfTimesCalled;
	}

}
