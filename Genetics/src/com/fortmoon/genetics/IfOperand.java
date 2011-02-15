/*
 * @(#)IfOperand.java $Date: Feb 15, 2011 6:28:27 PM $
 * 
 * Copyright © 2011 FortMoon Consulting, Inc. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of FortMoon
 * Consulting, Inc. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with FortMoon Consulting.
 * 
 * FORTMOON MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR
 * NON-INFRINGEMENT. FORTMOON SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY
 * LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES.
 * 
 */
package com.fortmoon.genetics;

import java.util.ArrayList;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 *
 * @since Jan 29, 2011 7:54:05 AM
 */
public class IfOperand implements Operand{

		public <T extends Node> Number evaluate(ArrayList<T> args) {
				if(args.get(0).evaluate(args).doubleValue() > 0) {
					return args.get(1).evaluate(args);
				}
				else {
					return args.get(2).evaluate(args);
				}
		}

		/* (non-Javadoc)
		 * @see com.fortmoon.genetics.Operand#evaluate(java.lang.Number, java.lang.Number)
		 */
		@Override
		public <T extends Node> Number evaluate(Number num1, Number num2) {
			ArrayList<Node> inputs = new ArrayList<Node>(2);
			inputs.add(new ConstNode(num1));
			inputs.add(new ConstNode(num2));
			return evaluate(inputs);
		}
		
		public String toString() {
			return "if";
		}

}
