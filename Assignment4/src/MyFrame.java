import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

public class MyFrame extends JFrame implements ActionListener  {

	// PRIVATE INSTANCE VARIABLES

	private JPanel contentPane;
	private JLabel _title;
	private JTextField _currentGPAtextField;
	private JTextField _earnedHourstextField;
	private JLabel _numCourses;
	private JLabel _hoursEarned;
	private JLabel _currentGPALabel;
	private JComboBox<String> _comboBox;
	private JScrollPane scrollPane;
	private JPanel _coursePanel;
	private JComboBox _gradeComboBox;
	private JButton _calculate;
	private JTextField _result;
	private JTextField _cumulativeGPATextField;
	private JLabel _cumulativeGPAlbl;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */

	// CONSTRUCTOR ----------------------------
	public MyFrame() {
		
		Initialize();
		UIcomponents();
		calculateGPA();
		// REGISTERING EVENT LISTENERS

	this._currentGPAtextField.addActionListener(this);
		this._comboBox.addActionListener(this);
		this._calculate.addActionListener(this);

	}

	// SETTING UP THE FRAME

	private void Initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

	// CREATING AND SHAPING UI COMPONENTS

	private void UIcomponents() {
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		//TITLE OF THE APP
		this._title = new JLabel();
		_title.setBounds(124, 13, 234, 23);
		this._title.setFont(new Font("Arial", Font.PLAIN, 19));
		this._title.setText("Welcome to GPA calculator");
		contentPane.add(_title);
		
		// CURRENT GPA LABEL
		this._currentGPALabel = new JLabel("Current GPA:");
		_currentGPALabel.setBounds(259, 65, 78, 16);
		this._currentGPALabel.setFont(new Font("Arial", Font.PLAIN, 13));
		contentPane.add(this._currentGPALabel);

		//CURRENT GPA TEXT-FIELD
		this._currentGPAtextField = new JTextField();
		_currentGPAtextField.setBounds(346, 63, 68, 20);
		contentPane.add(this._currentGPAtextField);
	
		// CREDIT HOURS EARNED LABEL
		this._hoursEarned = new JLabel("Credit Hours earned: ");
		_hoursEarned.setBounds(30, 65, 123, 16);
		this._hoursEarned.setFont(new Font("Arial", Font.PLAIN, 13));
		contentPane.add(_hoursEarned);

		// CREDIT HOURS EARNED TEXT-FIELD
		this._earnedHourstextField = new JTextField();
		_earnedHourstextField.setBounds(163, 63, 86, 20);
		contentPane.add(_earnedHourstextField);

		// NUMBER OF COURSES LABEL
		this._numCourses = new JLabel("Number of Courses: ");
		_numCourses.setBounds(244, 108, 104, 14);
		contentPane.add(_numCourses);

		// DROP-DOWN MENU FOR NUMBER OF COURSES
		this._comboBox = new JComboBox<String>();
		_comboBox.setBounds(364, 106, 50, 20);
		_comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this._comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		_comboBox.setSelectedIndex(0);
		contentPane.add(_comboBox);

		// SCROLL PANE WHICH FACILITATES THE SCROLL BAR FEATURE
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 148, 417, 200);
		contentPane.add(scrollPane);
		_coursePanel = new JPanel(new GridBagLayout());
		scrollPane.setViewportView(_coursePanel);
		
		this._calculate = new JButton("Calculate");
		_calculate.setBounds(335, 368, 89, 23);
		contentPane.add(_calculate);
		
		JLabel _resultLabel = new JLabel("Current Term GPA: ");
		_resultLabel.setFont(new Font("Serif", Font.PLAIN, 14));
		_resultLabel.setBounds(10, 370, 116, 14);
		contentPane.add(_resultLabel);
		
		_result = new JTextField();
		_result.setEditable(false);
		_result.setBounds(125, 369, 68, 20);
		contentPane.add(_result);
		_result.setColumns(10);
		
		this._cumulativeGPAlbl = new JLabel("Cumulative GPA:");
		_cumulativeGPAlbl.setBounds(10, 395, 99, 14);
		this._cumulativeGPAlbl.setFont(new Font("Serif", Font.PLAIN, 14));
		contentPane.add(_cumulativeGPAlbl);
		
		_cumulativeGPATextField = new JTextField();
		_cumulativeGPATextField.setEditable(false);
		_cumulativeGPATextField.setBounds(124, 392, 69, 20);
		contentPane.add(_cumulativeGPATextField);
		_cumulativeGPATextField.setColumns(10);
}
	int counter=0; // KEEP TRACK OF HOW MANY TIMES THE EVENT TRIGGERED

	// ARRAYLIST OF OBJECTS

	ArrayList<JTextField> textfieldgenerator =new ArrayList<JTextField>();
	ArrayList<JComboBox> comboboxgenerator = new ArrayList<JComboBox>();
	ArrayList<JLabel> _index = new ArrayList<JLabel>();
	ArrayList<JComboBox> credithoursgenerator = new ArrayList<JComboBox>();
	

	public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
		
	if(arg0.getSource() == this._comboBox) {
			counter++;	 // INCREASES THE COUNTER


			
			contentPane.setPreferredSize(new Dimension(600,600));

			// GRID-BAG CONSTRAINTS FOR THE LAYOUT
			GridBagConstraints c = new GridBagConstraints();
			GridBagConstraints con = new GridBagConstraints();
			GridBagConstraints indexCons = new GridBagConstraints();
			GridBagConstraints creditCons = new GridBagConstraints();

			// REMOVES ALL COMPONENTS IF THE EVENTS HAVE TRIGGERED MULTIPLE TIMES

			if(counter!=1) {
				
				this._coursePanel.removeAll();

		for(int index= 0; index <= this._comboBox.getSelectedIndex(); index++) {

		//	JTextField textField = new JTextField();
		textfieldgenerator.add(new JTextField()); // FILLING UP THE ARRAYLIST OF TEXTFIELD

			JComboBox creditHours = new JComboBox(); // FILLING UP THE ARRAYLIST OF CREDITHOURS
			credithoursgenerator.add(creditHours);

		JComboBox _gradeComboBox= new JComboBox();
			comboboxgenerator.add(_gradeComboBox); // FILLING UP THE ARRAYLIST OF GRADECOMBOBOX


			// INITIALIZE THE CREDITHOURS COMBO BOXES
			credithoursgenerator.get(index).setBounds(364, 106, 50, 20);
			credithoursgenerator.get(index).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			credithoursgenerator.get(index).setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
			credithoursgenerator.get(index).setSelectedIndex(0);

			// 	INITIALIZE THE GRADES COMBO BOXES
			comboboxgenerator.get(index).setBounds(364, 106, 50, 20);
			comboboxgenerator.get(index).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			comboboxgenerator.get(index).setModel(new DefaultComboBoxModel(new String[] {"A+ (90-100%)", "A (80-89%)", "B+(75-79%)", "B (70-74%)", "C+ (65-69%)", "C (60-64%)", "D+ (55-59%)", "D (50-54%)", "F (0-49%)"}));
			comboboxgenerator.get(index).setSelectedIndex(0);

			// DISPLAYING THE INDEX


		JLabel _number = new JLabel();
		_index.add(_number);
		_number.setText("" + (index+1));
	//	textField.addActionListener(new ActionListener() {

		//	@Override
		//	public void actionPerformed(ActionEvent arg0) {
			       	
				
		//	}	
	//	});
			// SETTING UP THE CONSTRAINTS FOR EACH ELEMENTS

		indexCons.gridx = 13;
		indexCons.gridy = index;

		c.gridx=15;
		c.gridy = index;

		creditCons.gridx = 17;
		creditCons.gridy = index;

		con.gridx = 19;
		con.gridy = index;
			//	 con.fill = GridBagConstraints.HORIZONTAL;

			// MANAGING THE SPACE BETWEEN TWO OBJECTS
		    c.insets=new Insets(5,40,5,40);
			creditCons.insets=new Insets(5,40,5,40);

		textfieldgenerator.get(index).setPreferredSize(new Dimension(70, 20));
		textfieldgenerator.get(index).setEditable(true);

		// ADDING COMPONENTS TO THE PANEL
		_coursePanel.add(textfieldgenerator.get(index), c);
		_coursePanel.add(credithoursgenerator.get(index), creditCons);
		_coursePanel.add(comboboxgenerator.get(index), con);
		_coursePanel.add(_index.get(index), indexCons);

		revalidate();
		repaint();
	
		}
	}
			
	else {


	for(int index= 0; index <= this._comboBox.getSelectedIndex();index++) {


		//	JTextField textField = new JTextField();
		textfieldgenerator.add(new JTextField());
		this._gradeComboBox = new JComboBox();
		comboboxgenerator.add(_gradeComboBox);
		JComboBox creditHours = new JComboBox();
		credithoursgenerator.add(creditHours);

		//

		credithoursgenerator.get(index).setBounds(364, 106, 50, 20);
		credithoursgenerator.get(index).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		credithoursgenerator.get(index).setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6"}));
		credithoursgenerator.get(index).setSelectedIndex(0);


		comboboxgenerator.get(index).setBounds(364, 106, 50, 20);
		comboboxgenerator.get(index).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		comboboxgenerator.get(index).setModel(new DefaultComboBoxModel(new String[]{"A+ (90-100%)", "A (80-89%)", "B+(75-79%)", "B (70-74%)", "C+ (65-69%)", "C (60-64%)", "D+ (55-59%)", "D (50-54%)", "F (0-49%)"}));
		comboboxgenerator.get(index).setSelectedIndex(0);

		JLabel _number = new JLabel();
		_index.add(_number);
		_number.setText("" + (index + 1));
		//	textField.addActionListener(new ActionListener() {

		//	@Override
		//	public void actionPerformed(ActionEvent arg0) {


		//	}
		//	});
		indexCons.gridx = 13;
		indexCons.gridy = index;

		c.gridx = 15;
		c.gridy = index;

		creditCons.gridx = 17;
		creditCons.gridy = index;

		con.gridx = 19;
		con.gridy = index;
		//	 con.fill = GridBagConstraints.HORIZONTAL;

		c.insets = new Insets(5, 40, 5, 40);
		creditCons.insets = new Insets(5, 40, 5, 40);

		textfieldgenerator.get(index).setPreferredSize(new Dimension(70, 20));
		textfieldgenerator.get(index).setEditable(true);
		_coursePanel.add(textfieldgenerator.get(index), c);
		_coursePanel.add(credithoursgenerator.get(index), creditCons);
		_coursePanel.add(comboboxgenerator.get(index), con);
		_coursePanel.add(_index.get(index), indexCons);
		revalidate();
		repaint();
	}
			}
		}
	}

	private void calculateGPA(){

		this._calculate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (arg0.getSource() == _calculate) {

					
					float _subGPA;
					float _qualityPoints=0;

					float _totalGPA = 0;
					float _totalcredits = 0;
					float totalGradePoints = 0;
					for (int i = 0; i < comboboxgenerator.size(); i++) {

						if(comboboxgenerator.get(i).getSelectedIndex() == 0) {
							_subGPA=4.5f;
							_qualityPoints = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem())*_subGPA;
							_totalcredits = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem()) + _totalcredits;
							_totalGPA=_subGPA+4.5f+_totalGPA;
							totalGradePoints=_qualityPoints+totalGradePoints;
						}

						else if (comboboxgenerator.get(i).getSelectedIndex() == 1){
							_subGPA=4.0f;
							_qualityPoints = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem())*_subGPA;
							_totalcredits = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem()) + _totalcredits;
							_totalGPA=_subGPA+4.0f+_totalGPA;
							totalGradePoints=_qualityPoints+totalGradePoints;
						}

						else if (comboboxgenerator.get(i).getSelectedIndex() == 2){
							_subGPA=3.5f;
							_qualityPoints = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem())*_subGPA;
							_totalcredits = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem()) + _totalcredits;
							_totalGPA=_subGPA+3.5f+_totalGPA;
							totalGradePoints=_qualityPoints+totalGradePoints;
						}

						else if (comboboxgenerator.get(i).getSelectedIndex() == 3){
							_subGPA=3.0f;
							_qualityPoints = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem())*_subGPA;
							_totalcredits = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem()) + _totalcredits;
							_totalGPA=_subGPA+3.0f+_totalGPA;
							totalGradePoints=_qualityPoints+totalGradePoints;
						}

						else if (comboboxgenerator.get(i).getSelectedIndex() == 4){
							_subGPA=2.5f;
							_qualityPoints = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem())*_subGPA;
							_totalcredits = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem()) + _totalcredits;
							_totalGPA=_subGPA+2.5f+_totalGPA;
							totalGradePoints=_qualityPoints+totalGradePoints;
						}

						else if (comboboxgenerator.get(i).getSelectedIndex() == 5){
							_subGPA=2.0f;
							_qualityPoints = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem())*_subGPA;
							_totalcredits = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem()) + _totalcredits;
							_totalGPA=_subGPA+2.0f+_totalGPA;
							totalGradePoints=_qualityPoints+totalGradePoints;
						}

						else if (comboboxgenerator.get(i).getSelectedIndex() == 6){
							_subGPA=1.5f;
							_qualityPoints = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem())*_subGPA;
							_totalcredits = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem()) + _totalcredits;
							_totalGPA=_subGPA+1.5f+_totalGPA;
							totalGradePoints=_qualityPoints+totalGradePoints;
						}

						else if (comboboxgenerator.get(i).getSelectedIndex() == 7){
							_subGPA=1.0f;
							_qualityPoints = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem())*_subGPA;
							_totalcredits = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem()) + _totalcredits;
							_totalGPA=_subGPA+1.0f+_totalGPA;
							totalGradePoints=_qualityPoints+totalGradePoints;
						}

						else if (comboboxgenerator.get(i).getSelectedIndex() == 8) {
							_subGPA=0.5f;
							_qualityPoints = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem())*_subGPA;
							_totalcredits = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem()) + _totalcredits;
							_totalGPA=_subGPA+0.5f+_totalGPA;
							totalGradePoints=_qualityPoints+totalGradePoints;
						}
						else if (comboboxgenerator.get(i).getSelectedIndex() == 9) {
							_subGPA=0.0f;
							_qualityPoints = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem())*_subGPA;
							_totalcredits = Float.parseFloat((String) credithoursgenerator.get(i).getSelectedItem()) + _totalcredits;
							_totalGPA=_subGPA+0.0f+_totalGPA;
							totalGradePoints=_qualityPoints+totalGradePoints;


						}

						repaint();
						revalidate();
					}
					System.out.println(totalGradePoints);
					System.out.println(_totalcredits);
					System.out.println(totalGradePoints/_totalcredits);
					_result.setText(" " + totalGradePoints/_totalcredits);

					//////////////////////////////////////////////////////////////////////////////////
					// PART 2: Cumulative GPA

					float oldcreditHours = Float.parseFloat((String) _earnedHourstextField.getText());
					float oldGPA = Float.parseFloat((String) _currentGPAtextField.getText());
					float oldQualityPoints = oldcreditHours * oldGPA;
					float newestQualityPoints = totalGradePoints + oldQualityPoints;
					float newestCreditHours = oldcreditHours + _totalcredits;
					float newestGPA = newestQualityPoints/newestCreditHours;
					_cumulativeGPATextField.setText(""+ newestGPA);

				}
			}
		});
	}
}