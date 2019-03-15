package com.bobman159.rundml.core.tabledef.tests;

import static org.junit.Assert.fail;

import java.sql.Types;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bobman159.rundml.core.exprtypes.Column;
import com.bobman159.rundml.core.tabledef.TableDefinition;

class TableDefinitionTests {
	
	private static TableDefinition tbDef;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tbDef = new TableDefinition("rundml","typetest");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddColumn() {
		tbDef.addColumn("dfltInteger", Types.INTEGER);
		tbDef.addColumn("dfltNumber72", Types.DECIMAL);
		tbDef.addColumn("notNullChar", Types.CHAR);
		
		Assert.assertEquals(3,tbDef.columns().count());
		
		Column col01 = tbDef.getColumnName("dfltInteger");
		Assert.assertEquals("DFLTINTEGER", col01.getName());
		Assert.assertEquals(Types.INTEGER, col01.getType());
		
		Column col02 = tbDef.getColumnName("dfltNumber72");
		Assert.assertEquals("DFLTNUMBER72", col02.getName());
		Assert.assertEquals(Types.DECIMAL, col02.getType());
		
		Column col03 = tbDef.getColumnName("notNullChar");
		Assert.assertEquals("NOTNULLCHAR", col03.getName());
		Assert.assertEquals(Types.CHAR, col03.getType());
		
		
		tbDef.columns().forEach(col -> {

			if (col.getName().equalsIgnoreCase("dfltInteger")) {
				Assert.assertEquals("DFLTINTEGER",col.getName());
				Assert.assertEquals(Types.INTEGER,col.getType());				
			} else if (col.getName().equalsIgnoreCase("dfltnumber72")) {
				Assert.assertEquals("DFLTNUMBER72",col.getName());
				Assert.assertEquals(Types.DECIMAL,col.getType());				
			} else if (col.getName().equalsIgnoreCase("notnullchar")) {
				Assert.assertEquals("NOTNULLCHAR",col.getName());
				Assert.assertEquals(Types.CHAR,col.getType());
			} else {
				fail("Column: " + col.getName() + 
					 " was not found in table definition");
			}
		});

	}

	@Test
	void testQualifedTableName() {
		String qualTbName = tbDef.qualifedTableName();
		Assert.assertEquals("rundml.typetest", qualTbName);
	}

}
