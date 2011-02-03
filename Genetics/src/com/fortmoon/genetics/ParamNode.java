package com.fortmoon.genetics;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 *
 * @since Jan 29, 2011 2:23:35 AM
 */
public class ParamNode implements Node {
	protected Object param;

	public ParamNode(Object param) {
		this.param = param;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	/* (non-Javadoc)
	 * @see com.fortmoon.genetics.Node#evaluate()
	 */
	@Override
	public Float evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

}
