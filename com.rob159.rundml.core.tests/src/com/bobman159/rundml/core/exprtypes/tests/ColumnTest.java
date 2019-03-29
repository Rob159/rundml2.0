package com.bobman159.rundml.core.exprtypes.tests;

import java.sql.Types;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bobman159.rundml.core.expressions.Expression;
import com.bobman159.rundml.core.exprtypes.Column;

class ColumnTest {

	private static final String COLLHS = "COLLHS";
	private static final String COLRHS = "COLRHS";
	
	@BeforeAll
	static void setUpBeforeClass() {
		//No set up needed
	}

	@AfterAll
	static void tearDownAfterClass() {
		//no tear down needed
	}

	@BeforeEach
	void setUp() {
		//no set up needed
	}

	@AfterEach
	void tearDown() {
		//no tear down needed
	}

	@Test
	void testAdd() {
		
		Column colLhs = new Column(COLLHS,Types.INTEGER);
		String expr = colLhs.add(10).serialize();
		Assert.assertEquals("COLLHS + 10",expr);
		
		Column colLhs2 = new Column(COLLHS,Types.INTEGER);
		String expr2 = colLhs2.add(10).serialize();
		Assert.assertEquals("COLLHS + 10",expr2);
		
		Column colRhs = new Column(COLRHS,Types.SMALLINT);
		String expr3 = colRhs.add(10).serialize();
		Assert.assertEquals("COLRHS + 10",expr3);
		
		String expr4 = Expression.number(10).add(colRhs).serialize();
		Assert.assertEquals("10 + COLRHS",expr4);
		
		String expr5 = colLhs.add(colRhs).serialize();
		Assert.assertEquals("COLLHS + COLRHS",expr5);
		
		String expr6 = colRhs.add(colLhs).serialize();
		Assert.assertEquals("COLRHS + COLLHS",expr6);
	}
	
	@Test
	void testSubtract() {
		
		Column colLhs = new Column(COLLHS,Types.INTEGER);
		String expr = colLhs.subtract(10).serialize();
		Assert.assertEquals("COLLHS - 10",expr);
		
		Column colLhs2 = new Column(COLLHS,Types.INTEGER);
		String expr2 = colLhs2.subtract(10).serialize();
		Assert.assertEquals("COLLHS - 10",expr2);
		
		Column colRhs = new Column(COLRHS,Types.SMALLINT);
		String expr3 = colRhs.subtract(10).serialize();
		Assert.assertEquals("COLRHS - 10",expr3);
		
		String expr4 = Expression.number(10).subtract(colRhs).serialize();
		Assert.assertEquals("10 - COLRHS",expr4);
		
		String expr5 = colLhs.subtract(colRhs).serialize();
		Assert.assertEquals("COLLHS - COLRHS",expr5);
		
		String expr6 = colRhs.subtract(colLhs).serialize();
		Assert.assertEquals("COLRHS - COLLHS",expr6);
	}
	
	@Test
	void testMultiply() {
		
		Column colLhs = new Column(COLLHS,Types.INTEGER);
		String expr = colLhs.multiply(10).serialize();
		Assert.assertEquals("COLLHS * 10",expr);
		
		Column colLhs2 = new Column(COLLHS,Types.INTEGER);
		String expr2 = colLhs2.multiply(10).serialize();
		Assert.assertEquals("COLLHS * 10",expr2);
		
		Column colRhs = new Column(COLRHS,Types.SMALLINT);
		String expr3 = colRhs.multiply(10).serialize();
		Assert.assertEquals("COLRHS * 10",expr3);
		
		String expr4 = Expression.number(10).multiply(colRhs).serialize();
		Assert.assertEquals("10 * COLRHS",expr4);
		
		String expr5 = colLhs.multiply(colRhs).serialize();
		Assert.assertEquals("COLLHS * COLRHS",expr5);
		
		String expr6 = colRhs.multiply(colLhs).serialize();
		Assert.assertEquals("COLRHS * COLLHS",expr6);
	}
	
	@Test
	void testDivide() {
		
		Column colLhs = new Column(COLLHS,Types.INTEGER);
		String expr = colLhs.divide(10).serialize();
		Assert.assertEquals("COLLHS / 10",expr);
		
		Column colLhs2 = new Column(COLLHS,Types.INTEGER);
		String expr2 = colLhs2.divide(10).serialize();
		Assert.assertEquals("COLLHS / 10",expr2);
		
		Column colRhs = new Column(COLRHS,Types.SMALLINT);
		String expr3 = colRhs.divide(10).serialize();
		Assert.assertEquals("COLRHS / 10",expr3);
		
		String expr4 = Expression.number(10).divide(colRhs).serialize();
		Assert.assertEquals("10 / COLRHS",expr4);
		
		String expr5 = colLhs.divide(colRhs).serialize();
		Assert.assertEquals("COLLHS / COLRHS",expr5);
		
		String expr6 = colRhs.divide(colLhs).serialize();
		Assert.assertEquals("COLRHS / COLLHS",expr6);
	}
	
	@Test
	void testColumn() {
		
		Column colLhs = new Column(COLLHS,Types.INTEGER);
		Assert.assertEquals(COLLHS,colLhs.getName());
		Assert.assertEquals(Types.INTEGER,colLhs.getType());
	
	}

}
