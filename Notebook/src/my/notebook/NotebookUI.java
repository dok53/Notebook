/**
 * Class to handle the GUI and all action listners to perform tasks
 * @author Derek O Keeffe
 * @version 1.5
 * @from 01/11/12
 */

package my.notebook;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JLabel;;


public class NotebookUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtEnterNewTask;
	private ArrayList<TaskList> tasks = new ArrayList<TaskList>();
	private JCheckBox High;
	private JCheckBox Medium;
	private JCheckBox Low;
	private JCheckBox chckbxOpen;
	private JCheckBox chckbxClosed;
	private JCheckBox chckbxOpen_1;
	private JCheckBox chckbxClosed_1;
	private JButton btnNewButton;
	private JButton btnCreate;
	private JButton btnDelete;
	private JButton btnSetStatus;
	private JButton btnDeleteTask;
	private JTextField txtTaskListName;
	private List myList;
	private List myListTwo;
	private JButton btnShow;
	private JTextArea txtrDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotebookUI frame = new NotebookUI();
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
	public NotebookUI() {
		setResizable(false);
		
		/*TaskList x = new TaskList("My List");
		TaskList y = new TaskList("Doesnt work");
		tasks.add(x);
		tasks.add(y);*/
		setTitle("Tasks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtEnterNewTask = new JTextField();
		txtEnterNewTask.setForeground(Color.BLUE);
		txtEnterNewTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				txtEnterNewTask.setText("");
			}
		});
		txtEnterNewTask.setText("Enter new task");
		txtEnterNewTask.setFont(new Font("Arial", Font.PLAIN, 11));
		txtEnterNewTask.setBounds(231, 47, 236, 20);
		panel.add(txtEnterNewTask);
		txtEnterNewTask.setColumns(10);
		
		btnNewButton = new JButton("create task");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent arg0) 
			{
				String name = txtEnterNewTask.getText();
				String description = txtrDescription.getText();
				Priority priority = Priority.Low;
				Status status = Status.Closed;
				if (chckbxOpen_1.isSelected())
					status = Status.Open;
				if (High.isSelected())
					priority = Priority.High;
				else if (Medium.isSelected())
					priority = Priority.Medium;
				if (chckbxOpen.isSelected())
					status = Status.Open;
				Task task = new Task(name, priority, description, status);
				if (tasks.size() <= 0 || myList.getSelectedIndex() < 0)
				{
					JOptionPane.showMessageDialog(panel, "Please select/create a list to add the task too");
				}
				else
				{
					int i = myList.getSelectedIndex();
					tasks.get(i).addTask(task);
					int j = myList.getSelectedIndex();
					System.out.println(""+  tasks.get(j).printableToString());//getTask().toString());
					txtEnterNewTask.setText("Enter new task");
					txtrDescription.setText("Description");
				}
			}
		});
		btnNewButton.setBounds(281, 253, 132, 23);
		panel.add(btnNewButton);
		
		High = new JCheckBox("High");
		High.setForeground(Color.BLUE);
		High.setFont(new Font("Arial", Font.PLAIN, 11));
		High.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (High.isSelected())
				{
					High.setSelected(true);
					Medium.setSelected(false);
					Low.setSelected(false);
				}
			}
		});
		High.setBounds(293, 197, 51, 23);
		panel.add(High);
		
		Medium = new JCheckBox("Medium");
		Medium.setForeground(Color.BLUE);
		Medium.setFont(new Font("Arial", Font.PLAIN, 11));
		Medium.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Medium.isSelected())
				{
					High.setSelected(false);
					Medium.setSelected(true);
					Low.setSelected(false);
				}
			}
		});
		Medium.setBounds(346, 197, 63, 23);
		panel.add(Medium);
		
		Low = new JCheckBox("Low");
		Low.setForeground(Color.BLUE);
		Low.setFont(new Font("Arial", Font.PLAIN, 11));
		Low.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Low.isSelected())
				{
					High.setSelected(false);
					Medium.setSelected(false);
					Low.setSelected(true);
				}
			}
		});
		Low.setSelected(true);
		Low.setBounds(404, 197, 63, 23);
		panel.add(Low);
		
		myList = new List();
		myList.setForeground(Color.BLUE);
		myList.setFont(new Font("Arial", Font.PLAIN, 11));
		myList.setBounds(10, 40, 203, 85);
		panel.add(myList);
		
		btnDelete = new JButton("Delete list");
		btnDelete.setForeground(Color.BLUE);
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 11));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (myList.getSelectedIndex() < 0)
				{
					JOptionPane.showMessageDialog(panel, "Sorry there are no task lists created/selected");
				}
				else
				{
					int d = myList.getSelectedIndex();
					myList.remove(d);
				}
			}
		});
		btnDelete.setBounds(122, 131, 91, 23);
		panel.add(btnDelete);
		
		txtTaskListName = new JTextField();
		txtTaskListName.setForeground(Color.BLUE);
		txtTaskListName.setFont(new Font("Arial", Font.PLAIN, 11));
		txtTaskListName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtTaskListName.setText("");
			}
		});
		txtTaskListName.setText("Task list name");
		txtTaskListName.setBounds(10, 11, 109, 23);
		panel.add(txtTaskListName);
		txtTaskListName.setColumns(10);
		
		btnCreate = new JButton("Create");
		btnCreate.setForeground(Color.BLUE);
		btnCreate.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtTaskListName.getText();
				TaskList x = new TaskList (name);
				tasks.add(x);
				myList.add("" + x);
				repaint();
				txtTaskListName.setText("Task list name");
			}
		});
		btnCreate.setBounds(140, 11, 73, 23);
		panel.add(btnCreate);
		
		btnShow = new JButton("Show tasks");
		btnShow.setForeground(Color.BLUE);
		btnShow.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if (myList.getSelectedIndex() < 0)
				{
					JOptionPane.showMessageDialog(panel, "Sorry there are no task lists created/selected");
				}
				int i = myList.getSelectedIndex();
				if (tasks.get(i ).getTask().size() <= 0)
				{
					JOptionPane.showMessageDialog(panel, "Sorry there are no tasks");
				}
				else
				{
					myListTwo.clear();
					int t = myList.getSelectedIndex();
					JOptionPane.showMessageDialog(panel, "Task Description \n " + tasks.get(i).printableToString());
					for (int j = 0; j < tasks.get(t).getTask().size(); j++)
					{
						myListTwo.add("" + tasks.get(t).getTasksName(j));
					}
					repaint();
				}
			}
		});
		btnShow.setFont(new Font("Arial", Font.PLAIN, 11));
		btnShow.setBounds(10, 131, 102, 23);
		panel.add(btnShow);
		
		JLabel lblMyTaskKeeper = new JLabel("My Task Manager");
		lblMyTaskKeeper.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMyTaskKeeper.setBounds(266, 6, 132, 28);
		panel.add(lblMyTaskKeeper);
		
		txtrDescription = new JTextArea();
		txtrDescription.setWrapStyleWord(true);
		txtrDescription.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtrDescription.setText("");
				
			}
		});
		txtrDescription.setFont(new Font("Arial", Font.PLAIN, 11));
		txtrDescription.setForeground(Color.BLUE);
		txtrDescription.setText("Description (Max 250 characters)");
		txtrDescription.setLineWrap(true);
		txtrDescription.setBounds(231, 78, 236, 112);
		panel.add(txtrDescription);
		
		chckbxOpen = new JCheckBox("Open");
		chckbxOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (chckbxOpen.isSelected())
				{
					chckbxClosed.setSelected(false);
					chckbxOpen.setSelected(true);
				}
			}
		});
		chckbxOpen.setFont(new Font("Arial", Font.PLAIN, 11));
		chckbxOpen.setForeground(Color.BLUE);
		chckbxOpen.setBounds(111, 276, 51, 23);
		panel.add(chckbxOpen);
		
		chckbxClosed = new JCheckBox("Closed");
		chckbxClosed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbxClosed.isSelected())
				{
					chckbxClosed.setSelected(true);
					chckbxOpen.setSelected(false);
				}
			}
		});
		chckbxClosed.setForeground(Color.BLUE);
		chckbxClosed.setFont(new Font("Arial", Font.PLAIN, 11));
		chckbxClosed.setBounds(164, 276, 63, 23);
		panel.add(chckbxClosed);
		
		btnSetStatus = new JButton("Set status");
		btnSetStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int j = myList.getSelectedIndex();
				int i = myListTwo.getSelectedIndex();
				if (chckbxOpen.isSelected())
				{
					tasks.get(j).getTask().get(i).setStatus(Status.Open);
				}
				if (chckbxClosed.isSelected())
				{
					tasks.get(j).getTask().get(i).setStatus(Status.Closed);
				}
					
			}
		});
		btnSetStatus.setForeground(Color.BLUE);
		btnSetStatus.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSetStatus.setBounds(10, 276, 91, 23);
		panel.add(btnSetStatus);
		
		myListTwo = new List();
		myListTwo.setForeground(Color.BLUE);
		myListTwo.setBounds(10, 189, 203, 81);
		panel.add(myListTwo);
		
		JLabel lblAssociatedTasks = new JLabel("Associated tasks");
		lblAssociatedTasks.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAssociatedTasks.setForeground(Color.BLACK);
		lblAssociatedTasks.setBounds(54, 169, 127, 14);
		panel.add(lblAssociatedTasks);
		
		btnDeleteTask = new JButton("Delete task");
		btnDeleteTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int j = myList.getSelectedIndex();
				int i = myListTwo.getSelectedIndex();
				tasks.get(j).removeTask(i);
				myListTwo.remove(i);
			}
		});
		btnDeleteTask.setForeground(Color.BLUE);
		btnDeleteTask.setFont(new Font("Arial", Font.PLAIN, 11));
		btnDeleteTask.setBounds(73, 306, 89, 23);
		panel.add(btnDeleteTask);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setForeground(Color.BLACK);
		lblPriority.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPriority.setBounds(241, 200, 46, 14);
		panel.add(lblPriority);
		
		chckbxOpen_1 = new JCheckBox("Open");
		chckbxOpen_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxOpen_1.isSelected())
				{
					chckbxClosed_1.setSelected(false);
					chckbxOpen_1.setSelected(true);
				}
			}
		});
		chckbxOpen_1.setForeground(Color.BLUE);
		chckbxOpen_1.setFont(new Font("Arial", Font.PLAIN, 11));
		chckbxOpen_1.setBounds(293, 223, 51, 23);
		panel.add(chckbxOpen_1);
		
		chckbxClosed_1 = new JCheckBox("Closed");
		chckbxClosed_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(chckbxClosed_1.isSelected())
				{
					chckbxClosed_1.setSelected(true);
					chckbxOpen_1.setSelected(false);
				}
			}
		});
		chckbxClosed_1.setFont(new Font("Arial", Font.PLAIN, 11));
		chckbxClosed_1.setForeground(Color.BLUE);
		chckbxClosed_1.setBounds(350, 223, 63, 23);
		panel.add(chckbxClosed_1);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 13));
		lblStatus.setBounds(241, 225, 46, 14);
		panel.add(lblStatus);
		
		
		
		
	
	}
}

