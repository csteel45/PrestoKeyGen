package com.jackbe.keygen;
import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class PrestoKeyGen extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JMenuItem helpMenuItem;
	private LookAndFeelMenu jMenu8;
	private JMenu jMenu5;
	private JRadioButton jRadioButton3;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton1;
	private ButtonGroup buttonGroup3;
	private JPanel jPanel1;
	private JMenuItem deleteMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem pasteMenuItem;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JTextField jTextField4;
	private JLabel jLabel5;
	private JTextField jTextField3;
	private JLabel jLabel4;
	private JPanel jPanel12;
	private JPanel jPanel11;
	private JPanel jPanel10;
	private JPanel jPanel9;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JPanel jPanel8;
	private JPanel jPanel7;
	private JPanel jPanel6;
	private JLabel jLabel1;
	private JPanel titelPanel;
	private JButton jButton2;
	private JButton jButton1;
	private JPanel jPanel5;
	private JScrollPane jScrollPane1;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JLabel jLabel14;
	private JComboBox jComboBox8;
	private JPanel jPanel19;
	private JLabel jLabel13;
	private JPanel jPanel18;
	private JTextField jTextField1;
	private JComboBox jComboBox7;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JComboBox jComboBox6;
	private JPanel jPanel16;
	private JPanel jPanel15;
	private JPanel jPanel14;
	private JCheckBox jCheckBox2;
	private JPanel jPanel13;
	private JComboBox jComboBox5;
	private JLabel jLabel10;
	private JComboBox jComboBox4;
	private JLabel jLabel9;
	private JComboBox jComboBox3;
	private JLabel jLabel8;
	private JTextArea jTextArea1;
	private JComboBox jComboBox2;
	private JCheckBox jCheckBox1;
	private JComboBox jComboBox1;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	private Date expDate;
	private JFrame frame;
	private boolean updateDaysChanged = true;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					PrestoKeyGen inst = new PrestoKeyGen();
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				}
				catch(Exception e) {
					System.err.println("Exception in main: " + e);
					e.printStackTrace();
					System.exit(-1);
				}
			}
		});
	}
	
	public PrestoKeyGen() {
		super();
		frame = this;
		initGUI();
		this.pack();
	}
	
	private void initGUI() {
		try {
			{
				expDate = new Date(System.currentTimeMillis());
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.MONTH, 2);
				expDate = cal.getTime();

				//this.setSize(730, 500);
				this.setTitle("Presto Key Generator");
				URL imageURL = getClass().getClassLoader().getResource("images/keygenlogo.gif");
				if(imageURL != null) {
					ImageIcon icon = new ImageIcon(imageURL);
					if(icon != null)
						this.setIconImage(icon.getImage());
				}
				this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent evt) {
						//System.out.println("this.windowClosing, event="+evt);
						System.exit(0);
					}
				});
				this.add(getJPanel2());
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				jMenuBar1.setOpaque(false);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("File");
					jMenu3.setMnemonic(java.awt.event.KeyEvent.VK_F);
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
						exitMenuItem.setMnemonic(java.awt.event.KeyEvent.VK_X);
						exitMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								//System.out.println("exitMenuItem.actionPerformed, event="+evt);
								System.exit(0);
							}
						});
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Edit");
					jMenu4.setMnemonic(java.awt.event.KeyEvent.VK_E);
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("Cut");
						cutMenuItem.setMnemonic(java.awt.event.KeyEvent.VK_T);
						cutMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
							    StringSelection stringSelection = new StringSelection( jTextArea1.getText() );
							    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							    clipboard.setContents( stringSelection, new MyClipBoardOwner() );		
							    jTextArea1.setText("");
							}
						});
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("Copy");
						copyMenuItem.setMnemonic(java.awt.event.KeyEvent.VK_C);
						copyMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								//System.out.println("copyMenuItem.actionPerformed, event="+evt);
							    StringSelection stringSelection = new StringSelection( jTextArea1.getText() );
							    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							    clipboard.setContents( stringSelection, new MyClipBoardOwner() );
							}
						});
					}
					{
						pasteMenuItem = new JMenuItem();
						jMenu4.add(pasteMenuItem);
						pasteMenuItem.setText("Paste");
						pasteMenuItem.setMnemonic(java.awt.event.KeyEvent.VK_P);
						pasteMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								//System.out.println("pasteMenuItem.actionPerformed, event=" + evt);
								Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
								Transferable contents = clipboard.getContents(null);
								boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
								if (hasTransferableText) {
									try {
										jTextArea1.setText((String)contents.getTransferData(DataFlavor.stringFlavor));
									} catch (UnsupportedFlavorException ex) {
										// highly unlikely since we are using a
										// standard DataFlavor
										//System.out.println(ex);
										ex.printStackTrace();
									} catch (IOException ex) {
										//System.out.println(ex);
										ex.printStackTrace();
									}
								}

							}
						});
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						deleteMenuItem = new JMenuItem();
						jMenu4.add(deleteMenuItem);
						deleteMenuItem.setText("Clear");
						deleteMenuItem.setMnemonic(java.awt.event.KeyEvent.VK_E);
						deleteMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								//System.out.println("deleteMenuItem.actionPerformed, event="+evt);
								jTextArea1.setText("");
								jTextField1.setText("");
								jTextField3.setText("");
								jTextField4.setText("");
							}
						});
					}
				}
				{
					jMenu8 = new LookAndFeelMenu();
					jMenu8.setFrame(this);
					jMenu8.setText("Look and Feel");
					jMenu8.setMnemonic(java.awt.event.KeyEvent.VK_L);
					jMenuBar1.add(jMenu8);
				}
				{
					jMenuBar1.add(Box.createHorizontalGlue());
					jMenu5 = new JMenu();
					jMenu5.setText("Help");
					jMenu5.setMnemonic(java.awt.event.KeyEvent.VK_H);
					jMenuBar1.add(jMenu5);
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("About");
						helpMenuItem.setMnemonic(java.awt.event.KeyEvent.VK_A);
						helpMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								//System.out.println("helpMenuItem.actionPerformed, event="+evt);
								AboutDialog dialog = new AboutDialog(frame, "Presto Key Generator", "Christopher Steel", "1.0", "01/24/2011", "\u00a9 Copyright JackBe 2011", "beta");
								dialog.setImage("images/jackbelogo.gif");
								dialog.setVisible(true);
							}
						});
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getButtonGroup3() {
		if(buttonGroup3 == null) {
			buttonGroup3 = new ButtonGroup();
			buttonGroup3.add(jRadioButton1);
			jRadioButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					//System.out.println("jRadioButton1.actionPerformed, event="+evt);
					//TODO add your code for jRadioButton1.actionPerformed
				}
			});
			buttonGroup3.add(jRadioButton2);
			jRadioButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					//System.out.println("jRadioButton2.actionPerformed, event="+evt);
					//TODO add your code for jRadioButton2.actionPerformed
				}
			});
			buttonGroup3.add(jRadioButton3);
			jRadioButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					//System.out.println("jRadioButton3.actionPerformed, event="+evt);
					//TODO add your code for jRadioButton3.actionPerformed
				}
			});
			jRadioButton1.setSelected(true);
		}
		return buttonGroup3;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			BorderLayout jPanel2Layout = new BorderLayout();
			jPanel2.setLayout(jPanel2Layout);
			jPanel2.setOpaque(false);
			jPanel2.add(getJPanel6(), BorderLayout.NORTH);
			jPanel2.add(getJPanel3(), BorderLayout.CENTER);
			jPanel2.add(getJPanel4(), BorderLayout.SOUTH);
		}
		return jPanel2;
	}
	
	private JPanel getJPanel3() {
		if(jPanel3 == null) {
			jPanel3 = new JPanel();
			GridLayout jPanel3Layout = new GridLayout(1, 2);
			jPanel3Layout.setColumns(2);
			jPanel3Layout.setHgap(5);
			jPanel3Layout.setVgap(5);
			jPanel3.setLayout(jPanel3Layout);
			jPanel3.setOpaque(false);
			{
				jPanel1 = new JPanel();
				BoxLayout jPanel1Layout = new BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS);
				jPanel1.setLayout(jPanel1Layout);
			}
			jPanel3.add(getJPanel6x());
			jPanel3.add(jPanel1);
			jPanel1.setAlignmentX(0.0f);
			jPanel1.add(getJPanel9());
			jPanel1.add(getJPanel7());
			jPanel1.add(getJPanel12());
			jPanel1.add(getJPanel16());
			getButtonGroup3();

		}
		return jPanel3;
	}
	
	private JPanel getJPanel4() {
		if(jPanel4 == null) {
			jPanel4 = new JPanel();
			BorderLayout jPanel4Layout = new BorderLayout();
			jPanel4.setLayout(jPanel4Layout);
			jPanel4.add(getJPanel5(), BorderLayout.NORTH);
			jPanel4.add(getJScrollPane1(), BorderLayout.CENTER);
			jPanel4.setPreferredSize(new java.awt.Dimension(300, 150));
		}
		return jPanel4;
	}
	
	private JScrollPane getJScrollPane1() {
		if(jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJTextArea1());
		}
		return jScrollPane1;
	}
	
	private JPanel getJPanel5() {
		if(jPanel5 == null) {
			jPanel5 = new JPanel();
			GridLayout jPanel5Layout = new GridLayout(1, 4);
			jPanel5Layout.setColumns(4);
			jPanel5Layout.setHgap(5);
			jPanel5Layout.setVgap(5);
			jPanel5.setLayout(jPanel5Layout);
			jPanel5.add(getJPanel14());
			jPanel5.add(getJButton1());
			jPanel5.add(getJButton2());
			jPanel5.add(getJPanel15());
		}
		return jPanel5;
	}
	
	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Generate");
			jButton1.setForeground(new java.awt.Color(0,193,97));
			jButton1.setToolTipText("Generates the license key");
			jButton1.setBackground(new java.awt.Color(0,255,64));
			jButton1.setEnabled(false);
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					//System.out.println("jButton1.actionPerformed, event="+evt);
					LicenseInfo license = new LicenseInfo();
					license.setProduct("PMP");
					license.setEmail(jTextField4.getText());
					license.setName(jTextField3.getText());
					Calendar cal = Calendar.getInstance();
					// Set the expiration Calendar for the last second of the day on the expiration date.
					cal.set(Integer.parseInt((String)jComboBox5.getSelectedItem()), jComboBox4.getSelectedIndex(), 
							Integer.parseInt((String)jComboBox3.getSelectedItem()), 23, 59, 59);
					long diff = (cal.getTimeInMillis() - System.currentTimeMillis()) / (1000*60*60*24);
					//System.out.println("Diff = " + diff);
					license.setMonths(Long.toString(diff));
					if(jRadioButton1.isSelected())
						license.setEdition("D");
					if(jRadioButton3.isSelected())
						license.setEdition("W");
					if(jRadioButton2.isSelected())
						license.setEdition("E");
					//System.out.println("Edition = " + license.getEdition());
					license.setType(Long.toString(System.currentTimeMillis()));
					//System.out.println("Type = " + license.getType());
					license.setVersion((String)jComboBox2.getSelectedItem());
					license.setHostname(jTextField1.getText());
					license.setUserLimit(Integer.parseInt((String)jComboBox6.getSelectedItem()));
					license.setAnonLimit(Integer.parseInt((String)jComboBox7.getSelectedItem()));
					if(jCheckBox1.isSelected()) {
						license.setOptions("sharepoint=true,sharepointcount=" + (String)jComboBox1.getSelectedItem());
					}
					else {
						license.setOptions("sharepoint=false,sharepointcount=0");
					}
					//System.out.println("Options = " + license.getOptions());
					String licenseKey = DEcrypter.encode(license);
					//System.out.println(info);
					license.setKey(licenseKey);
					jTextArea1.setText(licenseKey);
					jTextArea1.setBackground(new java.awt.Color(0,0,0));
					jTextArea1.setForeground(new java.awt.Color(255,186,117));

				}
			});
		}
		return jButton1;
	}
	
	private JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Validate");
			jButton2.setBackground(new java.awt.Color(147,185,255));
			jButton2.setForeground(new java.awt.Color(0,0,255));
			jButton2.setToolTipText("Validates an existing license, pasted in below.");
			jButton2.setNextFocusableComponent(getJTextField4());
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					try {
						LicenseInfo info = DEcrypter.decode(jTextArea1.getText());
						jTextArea1.setText(info.toString());
						jTextArea1.setBackground(new java.awt.Color(0,0,0));
						jTextArea1.setForeground(new java.awt.Color(255,186,117));
					}
					catch(Exception e) {
						jTextArea1.setForeground(Color.black);
						jTextArea1.setBackground(Color.red);
					}
				}
			});
		}
		return jButton2;
	}

	
	private JPanel getJPanel6() {
		if(titelPanel == null) {
			titelPanel = new JPanel();
			JButton iconButton = new JButton();
			URL imageURL = getClass().getClassLoader().getResource("images/jackbelogo.gif");
			if(imageURL != null) {
				ImageIcon icon = new ImageIcon(imageURL);
				if(icon != null) {
					iconButton.setIcon(icon);
					iconButton.setDisabledIcon(icon);
				}
			}
			BorderLayout titelPanelLayout = new BorderLayout();
			titelPanel.setLayout(titelPanelLayout);
			titelPanel.setName("titlePanel");
			titelPanel.setPreferredSize(new java.awt.Dimension(400, 50));
			//titelPanel.setSize(780, 50);
			titelPanel.add(iconButton, BorderLayout.WEST);
			iconButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			//iconButton.setOpaque(false);
			iconButton.setBorderPainted(false);
			iconButton.setEnabled(false);
			titelPanel.add(getJPanel13(), BorderLayout.CENTER);
		}
		return titelPanel;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Presto Key Generator");
			jLabel1.setForeground(new java.awt.Color(255,0,0));
			jLabel1.setFont(new java.awt.Font("Vani",3,24));
			jLabel1.setPreferredSize(new java.awt.Dimension(300, 40));
		}
		return jLabel1;
	}
	
	private JPanel getJPanel6x() {
		if(jPanel6 == null) {
			jPanel6 = new JPanel();
			GridLayout jPanel6Layout = new GridLayout(5, 1);
			jPanel6Layout.setColumns(1);
			jPanel6Layout.setHgap(5);
			jPanel6Layout.setVgap(14);
			jPanel6Layout.setRows(5);
			jPanel6.setLayout(jPanel6Layout);
			jPanel6.setOpaque(false);
			jPanel6.setPreferredSize(new java.awt.Dimension(360, 250));
			jPanel6.add(getJPanel11());
			jPanel6.add(getJPanel10());
			jPanel6.add(getJPanel18());
			jPanel6.add(getJPanel19());
			jPanel6.add(getJPanel8());
		}
		return jPanel6;
	}

	private JPanel getJPanel7() {
		if(jPanel7 == null) {
			jPanel7 = new JPanel();
			FlowLayout jPanel7Layout = new FlowLayout();
			jPanel7Layout.setAlignment(FlowLayout.LEFT);
			jPanel7.setLayout(jPanel7Layout);
			jPanel7.add(getJLabel3());
			jPanel7.add(getJComboBox2());
		}
		return jPanel7;
	}
	
	private JPanel getJPanel8() {
		if(jPanel8 == null) {
			jPanel8 = new JPanel();
			FlowLayout jPanel8Layout = new FlowLayout();
			jPanel8Layout.setAlignment(FlowLayout.LEFT);
			jPanel8.setLayout(jPanel8Layout);
			jPanel8.setOpaque(false);
			jPanel8.add(getJLabel10());
			jPanel8.add(getJComboBox5());
			jPanel8.add(getJLabel9());
			jPanel8.add(getJComboBox4());
			jPanel8.add(getJLabel8());
			jPanel8.add(getJComboBox3());
		}
		return jPanel8;
	}

	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Expiration: ");
			jLabel2.setPreferredSize(new java.awt.Dimension(80, 34));
		}
		return jLabel2;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Version");
			jLabel3.setSize(35, 20);
		}
		return jLabel3;
	}
	
	private JPanel getJPanel9() {
		if(jPanel9 == null) {
			jPanel9 = new JPanel();
			GridLayout jPanel9Layout = new GridLayout(3, 1);
			jPanel9Layout.setColumns(1);
			jPanel9Layout.setHgap(5);
			jPanel9Layout.setVgap(5);
			jPanel9Layout.setRows(3);
			jPanel9.setLayout(jPanel9Layout);
			jPanel9.setBorder(BorderFactory.createTitledBorder(null, "License Type", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma",0,11)));
			{
				jRadioButton1 = new JRadioButton();
				jPanel9.add(jRadioButton1);
				jPanel9.add(jRadioButton1);
				FlowLayout jRadioButton2Layout = new FlowLayout();
				jRadioButton1.setLayout(jRadioButton2Layout);
				jRadioButton1.setText(LicenseInfo.getMappedValue("D"));
				jRadioButton1.setForeground(new java.awt.Color(240,120,0));
			}
			{
				jRadioButton3 = new JRadioButton();
				jPanel9.add(jRadioButton3);
				jPanel9.add(jRadioButton3);
				FlowLayout jRadioButton3Layout = new FlowLayout();
				jRadioButton3.setLayout(jRadioButton3Layout);
				jRadioButton3.setText(LicenseInfo.getMappedValue("W"));
				jRadioButton3.setForeground(new java.awt.Color(240,120,0));
			}
			{
				jRadioButton2 = new JRadioButton();
				jPanel9.add(jRadioButton2);
				jPanel9.add(jRadioButton2);
				FlowLayout jRadioButton2Layout = new FlowLayout();
				jRadioButton2.setLayout(jRadioButton2Layout);
				jRadioButton2.setText(LicenseInfo.getMappedValue("E"));
				jRadioButton2.setForeground(new java.awt.Color(240,120,0));
			}
		}
		return jPanel9;
	}
	
	private JPanel getJPanel10() {
		if(jPanel10 == null) {
			jPanel10 = new JPanel();
			FlowLayout jPanel10Layout = new FlowLayout();
			jPanel10Layout.setAlignment(FlowLayout.LEFT);
			jPanel10.setLayout(jPanel10Layout);
			jPanel10.setOpaque(false);
			jPanel10.add(getJLabel4());
			jPanel10.add(getJTextField3());
		}
		return jPanel10;
	}
	
	private JPanel getJPanel11() {
		if(jPanel11 == null) {
			jPanel11 = new JPanel();
			FlowLayout jPanel11Layout = new FlowLayout();
			jPanel11Layout.setAlignment(FlowLayout.LEFT);
			jPanel11.setLayout(jPanel11Layout);
			jPanel11.setOpaque(false);
			jPanel11.add(getJLabel5());
			jPanel11.add(getJTextField4());
		}
		return jPanel11;
	}
	
	private JPanel getJPanel12() {
		if(jPanel12 == null) {
			jPanel12 = new JPanel();
			FlowLayout jPanel12Layout = new FlowLayout();
			jPanel12Layout.setAlignment(FlowLayout.LEFT);
			jPanel12.setLayout(jPanel12Layout);
			jPanel12.add(getJLabel6());
			jPanel12.add(getJCheckBox1());
			jPanel12.add(getJLabel7());
			jPanel12.add(getJComboBox1());
		}
		return jPanel12;
	}
	
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Name");
			jLabel4.setPreferredSize(new java.awt.Dimension(48, 20));
		}
		return jLabel4;
	}
	
	private JTextField getJTextField3() {
		if(jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setPreferredSize(new java.awt.Dimension(220, 25));
			jTextField3.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent evt) {
					//System.out.println("jTextField3 Lost focused");
					if(jTextField3.getText().length() > 0 && jTextField4.getText().length()>3)
						jButton1.setEnabled(true);
					else
						jButton1.setEnabled(false);

				}
			});

		}
		return jTextField3;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Email");
			jLabel5.setPreferredSize(new java.awt.Dimension(48, 20));
		}
		return jLabel5;
	}
	
	private JTextField getJTextField4() {
		if(jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setPreferredSize(new java.awt.Dimension(220, 25));
			jTextField4.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent evt) {
					//System.out.println("jTextField4.focusLost, event="+evt);
					if(jTextField3.getText().isEmpty() && !jTextField4.getText().isEmpty()) {
						//Guess at name based on email. Validate email first
						String email = jTextField4.getText();
						if(email.contains("@")) {
							String name = email.substring(0, email.indexOf('@'));
							name = name.substring(0,1).toUpperCase() + name.substring(1);
							if(name.contains(".")) {
								name = name.replace('.', ' ');
								int index = name.indexOf(' ');
								name = name.substring(0, index + 1) + name.substring(index + 1, index + 2).toUpperCase() + name.substring(index + 2);
							}
							jTextField3.setText(name);
						}
					}
					//System.out.println("jTextField3 Lost focused");
					if(jTextField3.getText().length() > 0 && jTextField4.getText().length()>3)
						jButton1.setEnabled(true);
					else
						jButton1.setEnabled(false);
				}
			});
		}
		return jTextField4;
	}
	
	private JLabel getJLabel6() {
		if(jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("SharePoint");
			jLabel6.setPreferredSize(new java.awt.Dimension(70, 20));
		}
		return jLabel6;
	}

	private JLabel getJLabel7() {
		if(jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("SharePoint Count");
		}
		return jLabel7;
	}
	
	private JComboBox getJComboBox1() {
		if(jComboBox1 == null) {
			ComboBoxModel jComboBox1Model = 
				new DefaultComboBoxModel(
						new String[] { "1", "5", "10", "25", "50", "100" });
			jComboBox1 = new JComboBox();
			jComboBox1.setModel(jComboBox1Model);
			jComboBox1.setSelectedIndex(3);
			jComboBox1.setEditable(true);
			jComboBox1.setEnabled(false);
			jComboBox1.setPreferredSize(new java.awt.Dimension(55, 25));
		}
		return jComboBox1;
	}
	
	private JCheckBox getJCheckBox1() {
		if(jCheckBox1 == null) {
			jCheckBox1 = new JCheckBox();
			jCheckBox1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					//System.out.println("jCheckBox1.actionPerformed, event="+evt);
					if(jCheckBox1.getModel().isSelected()) {
						jComboBox1.setEnabled(true);
					}
					else {
						jComboBox1.setEnabled(false);
					}
				}
			});
		}
		return jCheckBox1;
	}
	
	private JComboBox getJComboBox2() {
		if(jComboBox2 == null) {
			ComboBoxModel jComboBox2Model = 
				new DefaultComboBoxModel(
						new String[] { "2.7", "3.0", "3.1" });
			jComboBox2 = new JComboBox();
			jComboBox2.setModel(jComboBox2Model);
			jComboBox2.setSelectedIndex(2);
			jComboBox2.setToolTipText("Presto version number");
			jComboBox2.setEditable(true);
			jComboBox2.setPreferredSize(new java.awt.Dimension(55, 25));
			jComboBox2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					//System.out.println("jComboBox2.actionPerformed, event="+evt);
					if(Float.parseFloat((String)jComboBox2.getSelectedItem()) < 3.1f) {
						jCheckBox1.setEnabled(false);
						jCheckBox1.setSelected(false);
						jComboBox1.setEnabled(false);
					}
					else {
						jCheckBox1.setEnabled(true);
						jComboBox1.setEnabled(true);
					}
				}
			});
		}
		return jComboBox2;
	}
	
	private JTextArea getJTextArea1() {
		if(jTextArea1 == null) {
			jTextArea1 = new JTextArea();
			jTextArea1.setText("NBkfEAl5OCMUCBU6PSo0Gg8cVDQkOi8uEQg+OHciGRwfOxUHPD0nPgl4eUAzSEhufmFDXklMbnxhSDNKTGcVLwkVASQkIzYDCAkVPiUjTBkLDzJnJBkMCx8nJD4fGRoVIiUjTF9MJGcVZw==JdzlmJX");
			jTextArea1.setLineWrap(true);
			jTextArea1.setBackground(new java.awt.Color(0,0,0));
			jTextArea1.setForeground(new java.awt.Color(255,186,117));
			jTextArea1.setFocusTraversalKeysEnabled(false);
		}
		return jTextArea1;
	}
	
	private JLabel getJLabel8() {
		if(jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("Day");
		}
		return jLabel8;
	}
	
	@SuppressWarnings("deprecation")
	private JComboBox getJComboBox3() {
		if(jComboBox3 == null) {
			String[] days = new String[31];
			for(int i = 0; i < 31; i++) {
				days[i] = Integer.toString(i + 1);
			}
			ComboBoxModel jComboBox3Model = 
				new DefaultComboBoxModel(days);
			jComboBox3 = new JComboBox();
			jComboBox3.setModel(jComboBox3Model);
			jComboBox3.setPreferredSize(new java.awt.Dimension(68, 25));
			jComboBox3.setOpaque(false);
			jComboBox3.setSelectedIndex(expDate.getDate());
			jComboBox3.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					//System.out.println("jComboBox3.itemStateChanged, event="+evt);
				}
			});
			jComboBox3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					Calendar cal = Calendar.getInstance();
					cal.set(Integer.parseInt((String)jComboBox5.getSelectedItem()), jComboBox4.getSelectedIndex(), 1);
					
					//System.out.println("Checking: " + jComboBox5.getSelectedItem() + " " + jComboBox4.getSelectedIndex() + " " + cal.getTime());
					//System.out.println("Least: " + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
					if(Integer.valueOf((String)jComboBox3.getSelectedItem()) > cal.getLeastMaximum(Calendar.DAY_OF_MONTH)) {
						jComboBox3.setSelectedIndex(cal.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
					}
					updateDays();
					
				}
			});
		}
		return jComboBox3;
	}
	
	private JLabel getJLabel9() {
		if(jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText("Month");
		}
		return jLabel9;
	}
	
	@SuppressWarnings("deprecation")
	private JComboBox getJComboBox4() {
		if(jComboBox4 == null) {
			ComboBoxModel jComboBox4Model = 
				new DefaultComboBoxModel(
						new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" });
			jComboBox4 = new JComboBox();
			jComboBox4.setModel(jComboBox4Model);
			jComboBox4.setPreferredSize(new java.awt.Dimension(75, 25));
			jComboBox4.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					//System.out.println("jComboBox4.itemStateChanged, event="+evt);
					updateDays();
				}
			});
			jComboBox4.setSelectedIndex(expDate.getMonth());
		}
		return jComboBox4;
	}
	
	private JLabel getJLabel10() {
		if(jLabel10 == null) {
			jLabel10 = new JLabel();
			jLabel10.setText("Year");
		}
		return jLabel10;
	}
	
	@SuppressWarnings("deprecation")
	private JComboBox getJComboBox5() {
		if(jComboBox5 == null) {
			String[] years = new String[20];
			Date date = new Date(System.currentTimeMillis());
			int year = 1900 + date.getYear();
			for(int i = 0; i < 20; i++) {
				years[i] = Integer.toString(year + i);
			}
			ComboBoxModel jComboBox5Model = 
				new DefaultComboBoxModel(years);
			jComboBox5 = new JComboBox();
			jComboBox5.setModel(jComboBox5Model);
			jComboBox5.setPreferredSize(new java.awt.Dimension(90, 25));
			String selectedYear = Integer.toString((1900 + expDate.getYear()));
			jComboBox5.setSelectedItem(selectedYear);
			jComboBox5.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					updateDays();
				}
			});
		}
		return jComboBox5;
	}
	
	public void updateDays() {
		if(jComboBox5 == null || jComboBox4 == null || jComboBox3 == null)
			return;
		
		Calendar cal = Calendar.getInstance();
		// Set the expiration Calendar for the last second of the day on the expiration date.
		cal.set(Integer.parseInt((String)jComboBox5.getSelectedItem()), jComboBox4.getSelectedIndex(), 
				Integer.parseInt((String)jComboBox3.getSelectedItem()), 23, 59, 59);
		long diff = (cal.getTimeInMillis() - System.currentTimeMillis()) / (1000*60*60*24);
		updateDaysChanged = false;
		jComboBox8.setSelectedItem(Long.toString(diff));
	}
	
	public void updateCal() {
		
	}
	
	private JPanel getJPanel13() {
		if(jPanel13 == null) {
			jPanel13 = new JPanel();
			jPanel13.add(getJLabel1());
		}
		return jPanel13;
	}

	private JCheckBox getJCheckBox2() {
		if(jCheckBox2 == null) {
			jCheckBox2 = new JCheckBox();
			FlowLayout jCheckBox2Layout = new FlowLayout();
			jCheckBox2Layout.setAlignment(FlowLayout.RIGHT);
			jCheckBox2.setLayout(jCheckBox2Layout);
			jCheckBox2.setText("Send email");
			jCheckBox2.setEnabled(false);
			jCheckBox2.setToolTipText("Not Yet Implemented");
		}
		return jCheckBox2;
	}
	
	private JPanel getJPanel14() {
		if(jPanel14 == null) {
			jPanel14 = new JPanel();
			jPanel14.add(getJCheckBox2());
		}
		return jPanel14;
	}
	
	private JPanel getJPanel15() {
		if(jPanel15 == null) {
			jPanel15 = new JPanel();
		}
		return jPanel15;
	}
	
	private JPanel getJPanel16() {
		if(jPanel16 == null) {
			jPanel16 = new JPanel();
			TableLayout jPanel16Layout = new TableLayout(new double[][] {{TableLayout.FILL, 70.0, TableLayout.FILL}, {25.0, 25.0}});
			jPanel16Layout.setHGap(5);
			jPanel16Layout.setVGap(10);
			jPanel16.setLayout(jPanel16Layout);
			jPanel16.add(getJLabel11(), "0, 0");
			jPanel16.add(getJComboBox6(), "1, 0");
			jPanel16.add(getJLabel12(), "0,1");
			jPanel16.add(getJComboBox7(), "1,1");
		}
		return jPanel16;
	}
	
	private JComboBox getJComboBox6() {
		if(jComboBox6 == null) {
			ComboBoxModel jComboBox6Model = 
				new DefaultComboBoxModel(
						new String[] { "0", "1", "2", "3", "4", "5", "10", "20", "25", "50", "100" });
			jComboBox6 = new JComboBox();
			jComboBox6.setModel(jComboBox6Model);
			jComboBox6.setEditable(true);
			jComboBox6.setToolTipText("Choose an existing value or type one in.");
			jComboBox6.setPreferredSize(new java.awt.Dimension(85, 25));
			jComboBox6.setSelectedIndex(1);
		}
		return jComboBox6;
	}
	
	private JLabel getJLabel11() {
		if(jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setText("User limit");
		}
		return jLabel11;
	}

	private JLabel getJLabel12() {
		if(jLabel12 == null) {
			jLabel12 = new JLabel();
			jLabel12.setText("Anonymous User Limit");
			jLabel12.setPreferredSize(new java.awt.Dimension(150, 0));
		}
		return jLabel12;
	}
	
	private JComboBox getJComboBox7() {
		if(jComboBox7 == null) {
			ComboBoxModel jComboBox7Model = 
				new DefaultComboBoxModel(
						new String[] { "0", "1", "2", "3", "4", "5", "10", "20", "25", "50", "100" });
			jComboBox7 = new JComboBox();
			jComboBox7.setModel(jComboBox7Model);
			jComboBox7.setEditable(true);
			jComboBox7.setToolTipText("Choose an existing value or type one in.");
			jComboBox7.setPreferredSize(new java.awt.Dimension(85, 25));
			jComboBox7.setOpaque(false);
		}
		return jComboBox7;
	}
	
	private JTextField getJTextField1() {
		if(jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setText("xxxx");
			jTextField1.setPreferredSize(new java.awt.Dimension(220, 25));
			jTextField1.setToolTipText("Hostname of the box running Presto");
		}
		return jTextField1;
	}
	
	private JPanel getJPanel18() {
		if(jPanel18 == null) {
			jPanel18 = new JPanel();
			FlowLayout jPanel18Layout = new FlowLayout();
			jPanel18Layout.setAlignment(FlowLayout.LEFT);
			jPanel18.setLayout(jPanel18Layout);
			jPanel18.add(getJLabel13());
			jPanel18.add(getJTextField1());
		}
		return jPanel18;
	}
	
	private JLabel getJLabel13() {
		if(jLabel13 == null) {
			jLabel13 = new JLabel();
			jLabel13.setText("Hostname");
		}
		return jLabel13;
	}
	
	private JPanel getJPanel19() {
		if(jPanel19 == null) {
			jPanel19 = new JPanel();
			FlowLayout jPanel19Layout = new FlowLayout();
			jPanel19Layout.setAlignment(FlowLayout.LEFT);
			jPanel19.setLayout(jPanel19Layout);
			jPanel19.add(getJLabel2());
			jPanel19.add(getJComboBox8());
			jPanel19.add(getJLabel14());
		}
		return jPanel19;
	}
	
	private JComboBox getJComboBox8() {
		if(jComboBox8 == null) {
			ComboBoxModel jComboBox8Model = 
				new DefaultComboBoxModel(
						new String[] { "30", "60", "90", "180", "365" });
			jComboBox8 = new JComboBox();
			jComboBox8.setModel(jComboBox8Model);
			jComboBox8.setSelectedIndex(1);
			jComboBox8.setEditable(true);
			jComboBox8.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					if(!updateDaysChanged) {
						updateDaysChanged = true;
						return;
					}
					//System.out.println("jComboBox8.itemStateChanged, event="+evt);
					Calendar cal = Calendar.getInstance();
					if(null == jComboBox8.getSelectedItem())
						return;
					int days = Integer.parseInt((String)jComboBox8.getSelectedItem());
					//System.out.println("Days = " + days);
					cal.add(Calendar.DAY_OF_MONTH, days);
					if(cal.get(Calendar.YEAR) > 2030) {
						cal.set(Calendar.YEAR, 2030);
					}
					jComboBox5.setSelectedItem(Integer.toString(cal.get(Calendar.YEAR)));
					//System.out.println("Setting year = " + cal.get(Calendar.YEAR));
					jComboBox4.setSelectedIndex(cal.get(Calendar.MONTH));
					jComboBox3.setSelectedItem(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)));	
					//System.out.println("New day of month = " + cal.get(Calendar.DAY_OF_MONTH));
				}
			});
		}
		return jComboBox8;
	}
	
	private JLabel getJLabel14() {
		if(jLabel14 == null) {
			jLabel14 = new JLabel();
			jLabel14.setText("Days");
		}
		return jLabel14;
	}
	
	class MyClipBoardOwner implements ClipboardOwner {

		public MyClipBoardOwner() {
		}
		
		/* (non-Javadoc)
		 * @see java.awt.datatransfer.ClipboardOwner#lostOwnership(java.awt.datatransfer.Clipboard, java.awt.datatransfer.Transferable)
		 */
		@Override
		public void lostOwnership(Clipboard clipboard, Transferable contents) {
			// TODO Auto-generated method stub			
		}
	}
	

}
