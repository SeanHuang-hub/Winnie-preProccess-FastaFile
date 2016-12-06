package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import process.Similarity;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class preFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					preFrame frame = new preFrame();
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
	public preFrame() {
		setTitle("Pre-Proccess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFastaFilePath = new JLabel("Fasta File Path :");
		lblFastaFilePath.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblFastaFilePath.setBounds(20, 25, 120, 16);
		contentPane.add(lblFastaFilePath);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(152, 20, 255, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(231, 60, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDeleteLessThan = new JLabel("Delete less than:");
		lblDeleteLessThan.setBounds(100, 65, 119, 16);
		contentPane.add(lblDeleteLessThan);
		
		JLabel lblInput = new JLabel("input : 0.00 - 1.00");
		lblInput.setBounds(241, 86, 120, 16);
		contentPane.add(lblInput);
		
		JLabel lblFinish = new JLabel("finish");
		lblFinish.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblFinish.setForeground(Color.RED);
		lblFinish.setBounds(417, 101, 48, 16);
		lblFinish.setVisible(false);
		contentPane.add(lblFinish);
		
		JButton btnProcess = new JButton("PROCESS");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filePath = textField.getText();
				double percent;
				if(textField_1.getText().toString() == ""){
					percent = 0;
				}else{
					percent = Double.valueOf(textField_1.getText().toString());
				}
				
				Similarity  similarity = new Similarity();
				similarity.similarityProcess(filePath, percent);
				
				lblFinish.setVisible(true);
			}
		});
		btnProcess.setBounds(377, 60, 117, 29);
		contentPane.add(btnProcess);
		
		JButton btnPath = new JButton("Path");
		btnPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION)
				{ 
					File selectedFile = fileChooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					textField.setText(path);
				} 
			}
		});
		btnPath.setBounds(419, 21, 75, 29);
		contentPane.add(btnPath);
		
	}
}
