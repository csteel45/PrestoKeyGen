package com.fortmoon.genetics;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 *
 * @since Jan 29, 2011 2:22:40 AM
 */
public class ConstNode implements Node {
	protected Float constant;

	public ConstNode(Float constant) {
		this.constant = constant;
	}

	public ConstNode(int constant) {
		setConstant(constant);
	}

	public Object getConstant() {
		return constant;
	}

	public void setConstant(Float constant) {
		this.constant = constant;
	}

	public void setConstant(int constant) {
		this.constant = new Float(constant);
	}

	/* (non-Javadoc)
	 * @see com.fortmoon.genetics.Node#evaluate()
	 */
	@Override
	public Float evaluate() {
		// TODO Auto-generated method stub
		return constant;
	}
	
	public String toString() {
		return constant.toString();
	}
	
	
}
