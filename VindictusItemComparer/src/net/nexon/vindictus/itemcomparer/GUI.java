package net.nexon.vindictus.itemcomparer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JSlider;

import net.nexon.vindictus.itemcomparer.inport.StaticScrolls;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class GUI extends JFrame {

	private JPanel contentPane;

	private final static String VERSION = Main.VERSION;
	private final int bitchcount = 6;

	private JTextField minatk_Text;
	private JTextField ignore_Text;
	private JTextField result_Text;
	private JTextField price_Text;
	private JList char_List;
	private JList sort_List;
	private JList pre_List;
	private JList suf_List;
	private JList minlvl_List;
	private JList maxlvl_List;
	private JList smin_List;
	private JList smax_List;
	private JList cpu_List;
	private JCheckBox noinfo_Check;
	private JCheckBox nocsv_Check;
	private JCheckBox regina_Check;
	private JSlider plus_Slider;
	private JTextField minmatk_Text;
	private JComboBox apreBox = new JComboBox();
	private JComboBox asufBox = new JComboBox();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox barha_Check = new JCheckBox("barha weapon");
	private JCheckBox guard_Check;
	private JCheckBox cloth90_Check;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void calc() {

		String output = "-c " + char_List.getSelectedValue() + " -s "
				+ sort_List.getSelectedValue() + " -min "
				+ minlvl_List.getSelectedValue() + " -max "
				+ maxlvl_List.getSelectedValue() + " -smin "
				+ smin_List.getSelectedValue() + " -smax "
				+ smax_List.getSelectedValue() + " -plus "
				+ plus_Slider.getValue();

		String cpu = "";
		String pre = "";
		String suf = "";

		if (pre_List.getSelectedValuesList().size() > 0) {
			String temp = pre_List.getSelectedValuesList().toString();
			temp = temp.replace("[", "");
			temp = temp.replace("]", "");

			pre = " -pre \"" + temp + "\"";
		}

		if (suf_List.getSelectedValuesList().size() > 0) {
			String temp = suf_List.getSelectedValuesList().toString();
			temp = temp.replace("[", "");
			temp = temp.replace("]", "");
			suf = " -suf \"" + temp + "\"";
		}

		if (cpu_List.getSelectedIndex() > 0) {
			cpu = " -f " + cpu_List.getSelectedValue();
		}
		output += pre + suf + cpu;

		if (noinfo_Check.isSelected()) {
			output += " -noinfo";
		}
		if (regina_Check.isSelected()) {
			output += " -weapon Regina";
		}
		if (barha_Check.isSelected()) {
			output += " -weapon Barha";
		}
		if (guard_Check.isSelected()) {
			output += " -weapon Guardian";
		}
		if (cloth90_Check.isSelected()) {
			output += " -weapon Cloth90";
		}
		if (nocsv_Check.isSelected()) {
			output += " -nocsv";
		}

		if (!apreBox.getSelectedItem().equals("ALL")) {
			output += " -apre \"" + apreBox.getSelectedItem() + "\"";
		}
		if (!asufBox.getSelectedItem().equals("ALL")) {
			output += " -asuf \"" + asufBox.getSelectedItem() + "\"";
		}
		if (minatk_Text.getText().length() > 0) {
			output += " -atk " + minatk_Text.getText().trim();
		}
		if (minmatk_Text.getText().length() > 0) {
			output += " -matk " + minmatk_Text.getText().trim();
		}
		if (ignore_Text.getText().length() > 0) {
			output += " -i \"" + ignore_Text.getText().trim().replace(" ", "")
					+ "\"";
		}
		if (price_Text.getText().length() > 0) {
			output += " -price " + price_Text.getText().trim();
		}
		if (result_Text.getText().length() > 0) {
			output += " -r " + result_Text.getText().trim();
		}

		System.out.println(output);
		String[] args = output.split(" ");

		try {
			String x = "cmd.exe /c start java -jar VindictusItemComparer.jar "
					+ output;
			if (System.getProperty("os.name").toLowerCase().contains("windows")) {
				System.out.println(x);
				Process p = Runtime.getRuntime().exec(x, null,
						new File(System.getProperty("user.dir")));
				p.waitFor();
			} else {
				JOptionPane.showMessageDialog(new JFrame(),
						"Error. Other OS other than Windows not supported yet.\nUse \n"
								+ x + "\nto run the programm via console.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int getCovergirl() {
		int x = (int) (Math.random() * bitchcount + 1);
		return x;
	}

	/**
	 * Create the frame.
	 */
	public GUI() {

		setTitle("VIC Starter GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(new JFrame(), VERSION);

			}
		});
		menuBar.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.9);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);

		JButton btnCalc = new JButton("Calc");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc();
			}
		});
		btnCalc.setFont(new Font("Tahoma", Font.BOLD, 24));
		splitPane_1.setRightComponent(btnCalc);

		JPanel panel = new JPanel();
		splitPane_1.setLeftComponent(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Main", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.add(panel_1);

		char_List = new JList();
		panel_1.add(char_List);
		char_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		char_List.setToolTipText("Character");
		char_List.setModel(new AbstractListModel() {
			String[] values = new String[] { "arisha", "evie", "fiona", "hurk",
					"kai", "karok", "lann", "lynn", "vella" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		char_List.setSelectedIndex(0);

		sort_List = new JList();
		panel_1.add(sort_List);
		sort_List.setToolTipText("Sort");
		sort_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sort_List.setModel(new AbstractListModel() {
			String[] values = new String[] { "atk", "matk", "def", "sta",
					"staatk", "stamatk", "cheapdef", "cheapatk", "cheapmatk",
					"cheapsta" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		sort_List.setSelectedIndex(1);

		JPanel panel_13 = new JPanel();
		panel_1.add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.Y_AXIS));

		JPanel panel_8 = new JPanel();
		panel_13.add(panel_8);
		panel_8.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Scroll Overwrite",
				TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0,
						0, 0)));

		pre_List = new JList();
		panel_8.add(pre_List);
		pre_List.setToolTipText("Duplicate Sets with these scroll prefixes.");
		pre_List.setModel(new AbstractListModel() {
			String[] values = new String[] { "Enlightenment", "Remember",
					"Repeatsay", "Silent", "Time", "Tutelary", "Well-balanced" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});

		suf_List = new JList();
		suf_List.setToolTipText("Duplicate Sets with these scroll suffixes.");
		suf_List.setModel(new AbstractListModel() {
			String[] values = StaticScrolls.suffix_Names();

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_8.add(suf_List);

		JPanel panel_15 = new JPanel();
		panel_13.add(panel_15);

		JPanel panel_19 = new JPanel();
		panel_15.add(panel_19);
		panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.Y_AXIS));

		JPanel panel_17 = new JPanel();
		panel_19.add(panel_17);
		
		JPanel panel_22 = new JPanel();
		panel_17.add(panel_22);
		panel_22.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_20 = new JPanel();
		panel_22.add(panel_20);
		
				regina_Check = new JCheckBox("regina weapon");
				regina_Check.setSelected(true);
				panel_20.add(regina_Check);
				buttonGroup.add(regina_Check);
				regina_Check
						.setToolTipText("assume regina weapon for different set bonus");
				
						buttonGroup.add(barha_Check);
						panel_20.add(barha_Check);
						barha_Check
								.setToolTipText("assume regina weapon for different set bonus");
						
						JPanel panel_21 = new JPanel();
						panel_22.add(panel_21);
						
						guard_Check = new JCheckBox("guard weapon");
						buttonGroup.add(guard_Check);
						panel_21.add(guard_Check);
						guard_Check.setToolTipText("assume regina weapon for different set bonus");
						
						cloth90_Check = new JCheckBox("cloth90 weapon");
						buttonGroup.add(cloth90_Check);
						panel_21.add(cloth90_Check);
						cloth90_Check.setToolTipText("assume regina weapon for different set bonus");

		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Armor Scroll Overwrite",
				TitledBorder.LEADING, TitledBorder.BOTTOM, null, null));
		panel_19.add(panel_18);

		apreBox.setModel(new DefaultComboBoxModel(new String[] { "ALL",
				"Enlightenment", "Remember", "Repeatsay", "Silent", "Time",
				"Tutelary", "Well-balanced" }));
		panel_18.add(apreBox);

		asufBox.setModel(new DefaultComboBoxModel(new String[] {"ALL", "Master", "Stigma", "Announcement", "Armadillo", "Echo", "Enthu", "Expedition", "Force", "Journey", "Resistant", "Sentinel"}));
		panel_18.add(asufBox);

		plus_Slider = new JSlider();
		plus_Slider.setToolTipText("Upgrade level");
		plus_Slider.setPaintTicks(true);
		plus_Slider.setOrientation(SwingConstants.VERTICAL);
		plus_Slider.setSnapToTicks(true);
		plus_Slider.setValue(6);
		plus_Slider.setPaintLabels(true);
		plus_Slider.setMajorTickSpacing(1);
		plus_Slider.setMaximum(15);
		panel_1.add(plus_Slider);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Restrictions",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Level",
				TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0,
						0, 0)));
		panel_2.add(panel_7);

		minlvl_List = new JList();
		panel_7.add(minlvl_List);

		minlvl_List.setToolTipText("min Level");
		minlvl_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		minlvl_List.setModel(new AbstractListModel() {
			String[] values = new String[] { "50", "60", "70", "80", "90",
					"100" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		minlvl_List.setSelectedIndex(3);

		JLabel label = new JLabel("-");
		panel_7.add(label);

		maxlvl_List = new JList();
		panel_7.add(maxlvl_List);
		maxlvl_List.setToolTipText("max Level");
		maxlvl_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		maxlvl_List.setModel(new AbstractListModel() {
			String[] values = new String[] { "50", "60", "70", "80", "90",
					"100" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		maxlvl_List.setSelectedIndex(4);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Stars",
				TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0,
						0, 0)));
		panel_2.add(panel_5);

		smin_List = new JList();
		panel_5.add(smin_List);
		smin_List.setToolTipText("min Stars");
		smin_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		smin_List.setModel(new AbstractListModel() {
			String[] values = new String[] { "1", "2", "3", "4", "5" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		smin_List.setSelectedIndex(1);

		JLabel lblNewLabel = new JLabel("-");
		panel_5.add(lblNewLabel);

		smax_List = new JList();
		panel_5.add(smax_List);
		smax_List.setToolTipText("max Stars");
		smax_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		smax_List.setModel(new AbstractListModel() {
			String[] values = new String[] { "1", "2", "3", "4", "5" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		smax_List.setSelectedIndex(4);

		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.Y_AXIS));

		JPanel panel_10 = new JPanel();
		panel_12.add(panel_10);
		panel_10.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Min atk",
				TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0,
						0, 0)));

		minatk_Text = new JTextField();
		minatk_Text.setToolTipText("Minimum atk the sets must have");
		panel_10.add(minatk_Text);
		minatk_Text.setColumns(5);

		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Min matk",
				TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0,
						0, 0)));
		panel_12.add(panel_16);

		minmatk_Text = new JTextField();
		minmatk_Text.setToolTipText("Minimum matk the sets must have");
		minmatk_Text.setColumns(5);
		panel_16.add(minmatk_Text);

		JPanel panel_11 = new JPanel();
		panel_12.add(panel_11);
		panel_11.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Price",
				TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0,
						0, 0)));

		price_Text = new JTextField();
		price_Text.setToolTipText("Maximum price (10 = 10million)");
		price_Text.setColumns(5);
		panel_11.add(price_Text);

		JPanel panel_4 = new JPanel();
		panel_12.add(panel_4);
		panel_4.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Ignore",
				TitledBorder.LEADING, TitledBorder.BOTTOM, null, Color.BLACK));

		ignore_Text = new JTextField();
		panel_4.add(ignore_Text);
		ignore_Text
				.setToolTipText("Sets containing those words will be ignored. Use comma for more words. E.g. arma,raider");
		ignore_Text.setColumns(5);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Other", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.add(panel_3);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "CPU", TitledBorder.LEADING,
				TitledBorder.BOTTOM, null, new Color(0, 0, 0)));
		panel_3.add(panel_6);

		cpu_List = new JList();
		panel_6.add(cpu_List);
		cpu_List.setToolTipText("CPUs to use");
		cpu_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cpu_List.setModel(new AbstractListModel() {
			String[] values = new String[] { "ALL ", "1", "2", "3", "4" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		cpu_List.setSelectedIndex(0);

		JPanel panel_14 = new JPanel();
		panel_3.add(panel_14);
		panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.Y_AXIS));

		JPanel panel_9 = new JPanel();
		panel_14.add(panel_9);
		panel_9.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Results",
				TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0,
						0, 0)));

		result_Text = new JTextField();
		result_Text.setText("30");
		panel_9.add(result_Text);
		result_Text.setToolTipText("Amound of results. (Default = 30)");
		result_Text.setColumns(5);

		noinfo_Check = new JCheckBox("noinfo");
		panel_14.add(noinfo_Check);
		noinfo_Check.setToolTipText("Dont write extra info");
		noinfo_Check.setSelected(true);

		nocsv_Check = new JCheckBox("nocsv");
		nocsv_Check.setToolTipText("Dont write extra info");
		nocsv_Check.setSelected(true);
		panel_14.add(nocsv_Check);

		JLabel lblPic = new JLabel("");
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setIcon(new ImageIcon(
				GUI.class
						.getResource("/net/nexon/vindictus/itemcomparer/covergirls/covergirl"
								+ getCovergirl() + ".jpg")));
		splitPane.setLeftComponent(lblPic);
	}
}
