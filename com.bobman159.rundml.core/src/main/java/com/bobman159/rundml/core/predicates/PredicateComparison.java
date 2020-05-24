package com.bobman159.rundml.core.predicates;

import com.bobman159.rundml.core.sql.sql.conditions.Op;
import com.bobman159.rundml.core.sql.types.ExprTypeHelper;
import com.bobman159.rundml.core.sql.types.ISQLType;

/**
 * Represents the comparison (&lt;,&gt; etc) clause for an SQL predicate 
 * WHERE, AND or OR clause.
 *
 */
public class PredicateComparison implements IPredicate {
	
	private ISQLType exprRhs;
	private Op compareOp;

	/**
	 * Define a predicate comparison clause
	 * @param compareOp the comparison operator (&lt;, &gt;, etc)
	 * @param expr the right side expression of the comparison.
	 * 
	 * @see com.bobman159.rundml.core.sql.sql.conditions.Op
	 */
	public PredicateComparison(Op compareOp, Object expr) {
		exprRhs = ExprTypeHelper.convertExpression(expr);
		this.compareOp = compareOp;
	}

	@Override
	public String serialize() {
		// TODO Auto-generated method stub
		return null;
	}

}
