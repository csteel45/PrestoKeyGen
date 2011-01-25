/*
 * @(#)LookAndFeelMenu.java $Revision: 1.1 $ $Date: 2000/11/08 21:01:33 $
 * 
 * Copyright © 2007 TIBCO Software, Inc. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of TIBCO
 * Software, Inc. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with TIBCO Software.
 * 
 * TIBCO MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR
 * NON-INFRINGEMENT. TIBCO SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY
 * LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES.
 * 
 * Copyright Version 1.0
 */
package com.jackbe.keygen;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Provides a menu item for setting the Look and Feel.
 * 
 * @author Christopher Steel, Principal Architect - TIBCO
 * @version Aug 24, 2007 3:02:58 PM
 */
public class LookAndFeelMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JMenuItem aquaItem = new JMenuItem("Liquid");
	JMenuItem windowsItem = new JMenuItem("Windows");
	JMenuItem motifItem = new JMenuItem("Motif");
	JMenuItem metalItem = new JMenuItem("Metal");
	JMenuItem nimbusItem = new JMenuItem("Nimbus");
	JMenuItem systemItem = new JMenuItem("System");

	public LookAndFeelMenu() {
		this(null, "Look and Feel");
	}
	
	public LookAndFeelMenu(JFrame parentFrame, String title) {
		super(title);
		this.frame = parentFrame;
		aquaItem.setMnemonic('L');
		aquaItem.setName("Liquid");
		windowsItem.setMnemonic('W');
		windowsItem.setName("Windows");
		motifItem.setName("Motif");
		motifItem.setMnemonic('O');
		metalItem.setName("Metal");
		metalItem.setMnemonic('M');
		nimbusItem.setName("Nimbus");
		nimbusItem.setMnemonic('N');
		systemItem.setName("System");
		systemItem.setMnemonic('S');
		this.setMnemonic('L');
		this.add(aquaItem);
		this.add(windowsItem);
		this.add(motifItem);
		this.add(metalItem);
		this.add(nimbusItem);
		this.add(systemItem);

		if(this.frame != null)
			setActionHandlers();
	}
	
	public void setActionHandlers() {
		aquaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel", frame);
			}
		});
		windowsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLookAndFeel(
						"com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
						frame);
			}
		});
		motifItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLookAndFeel(
						"com.sun.java.swing.plaf.motif.MotifLookAndFeel", frame);
			}
		});
		metalItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel", frame);
			}
		});
		nimbusItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel", frame);
			}
		});
		systemItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLookAndFeel(UIManager.getSystemLookAndFeelClassName(), frame);
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		setActionHandlers();
	}

	private static void setLookAndFeel(String lookAndFeelClass, Component c) {
		try {
			UIManager.setLookAndFeel(lookAndFeelClass);
			SwingUtilities.updateComponentTreeUI(c);
		}
		catch (Exception e) {
			System.out
					.println("LookAndFeelMenu.setLookAndFeel exception: " + e);
			e.printStackTrace();
		}
	}
}
