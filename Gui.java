import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Font;

//TODO make the remove button search, implement the timeclass thingy.
public class Gui extends JFrame {
	private JPanel contentPane;
	private JTextField listInput;
	static String[] toDoList = new String[50];
	String newToDo;
	int removeToDo;
	List listClass = new List();
	JTextArea list = new JTextArea();
	JList<String> list_1 = new JList<String>();
	int count;
	JTextArea txtrTime = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAdd = new JButton("+");
		btnAdd.setBounds(680, 40, 147, 292);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 56));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addToDo();

			}
		});

		JButton btnRemove = new JButton("remove");
		btnRemove.setBounds(5, 40, 113, 292);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeToDo();
			}
		});
		
		JButton btnClear = new JButton("clear");
		btnClear.setBounds(5, 5, 113, 20);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearList();
			}
		});

		/*JButton btnTestprint = new JButton("testPrint");
		btnTestprint.setBounds(0, 0, 796, 37);
		btnTestprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < getCount(); i++) {
					System.out.println(toDoList[i]);
				}
			}
		});*/

		listInput = new JTextField();
		listInput.setBounds(5, 339, 822, 35);
		listInput.setColumns(50);
		contentPane.setLayout(null);
		contentPane.add(btnAdd);
	//	contentPane.add(btnTestprint);
		contentPane.add(btnRemove);
		contentPane.add(listInput);
		contentPane.add(btnClear);
	//	list.setEditable(false);

	//	list.setBounds(140, 61, 255, 97);
	//	contentPane.add(list);

	//	txtrTime.setEditable(false);
	//	txtrTime.setText("");
	//	txtrTime.setBounds(401, 61, 75, 265);
	//	contentPane.add(txtrTime);		
		
		list_1.setBounds(140, 40, 520, 292);
		contentPane.add(list_1);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_1.setLayoutOrientation(JList.VERTICAL);
		list_1.setVisibleRowCount(-1);
		list_1.setFixedCellHeight(24);
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void addToDo() {
		newToDo = "[" + TimeClass.timeStamp()+ "]     " + listInput.getText();
		toDoList = listClass.addToDo(toDoList, newToDo);
		list_1.setListData(toDoList);
		setText();
	}

	private void removeToDo() {
		removeToDo = list_1.getSelectedIndex();
		ArrayList<String> tempToDoList = new ArrayList<String>(Arrays.asList(toDoList));
		tempToDoList.remove(removeToDo);
		toDoList = tempToDoList.toArray(new String[0]);
		setText();
		list_1.setListData(toDoList);
	}

	private void setText() {
		listClass.SetText(list, toDoList);
	}

	private int getCount() {
		return listClass.getCount();
	}
	
	private void clearList() {
		toDoList = new String[50];
		list_1.setListData(toDoList);
	}
}