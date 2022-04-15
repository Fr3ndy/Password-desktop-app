package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.View;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTree;

import javax.swing.JTextPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.Font;



public class pagina3{

	private JFrame frame;
	
	private JPanel contentPane;
	private JTextField mailc;
	private JTextField nomec;
	private JTextField numc;
	private JTextField altroc;
	private JTextField nomeappc;
	public static String nomee;
	private JPasswordField passc;
	public int nc=0;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pagina3 window = new pagina3();	
					
					
					
					
															
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("deprecation")
	public pagina3() throws FileNotFoundException {
	
		Color H=new Color(222,222,222);
		
		
		frame=new JFrame();
		
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
		frame.setIconImage(icon); 
		pagina2.frame1.setEnabled(false);
		
		 
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setUndecorated(true);
		 frame.setLocationRelativeTo(null);
		
		
		
		JPanel panel = new JPanel();
		
		
		
		
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 434, 278);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton mail = new JRadioButton("EMail");
		mail.setBounds(6, 57, 109, 23);
		panel.add(mail);
		
		JRadioButton pass = new JRadioButton("Password");
		pass.setBounds(6, 83, 109, 23);
		panel.add(pass);
		
		JRadioButton nome = new JRadioButton("Nome");
		nome.setBounds(6, 109, 109, 23);
		panel.add(nome);
		
		JRadioButton num = new JRadioButton("Numero");
		num.setBounds(6, 135, 109, 23);
		panel.add(num);
		
		JRadioButton altro = new JRadioButton("Altro");
		altro.setBounds(6, 161, 109, 23);
		panel.add(altro);
		
		JLabel lblNewLabel = new JLabel("Nome App");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(6, 26, 109, 20);
		panel.add(lblNewLabel);
		mailc = new JTextField();
		mailc.setColumns(10);
		mailc.setBounds(121, 58, 274, 20);
		panel.add(mailc);
		///
				mailc.setEnabled(false);
				mailc.setOpaque(true);
				mailc.setBackground(H);
		
		nomec = new JTextField();
		nomec.setColumns(10);
		nomec.setBounds(121, 110, 274, 20);
		panel.add(nomec);
		///
				nomec.setEnabled(false);
				nomec.setOpaque(true);
				nomec.setBackground(H);
		numc = new JTextField();
		numc.setColumns(10);
		numc.setBounds(121, 136, 274, 20);
		panel.add(numc);
		///
				numc.setEnabled(false);
				numc.setOpaque(true);
				numc.setBackground(H);
		altroc = new JTextField();
		altroc.setColumns(10);
		altroc.setBounds(121, 162, 274, 20);
		panel.add(altroc);
		///
				altroc.setEnabled(false);
				altroc.setOpaque(true);
				altroc.setBackground(H);
		nomeappc = new JTextField();
		nomeappc.setColumns(10);
		nomeappc.setBounds(121, 26, 274, 20);
		panel.add(nomeappc);

		passc = new JPasswordField();
		passc.setBounds(121, 85, 256, 19);
		
		passc.setEnabled(false);
		passc.setOpaque(true);
		passc.setBackground(H);
		panel.add(passc);

		JButton passvisibile = new JButton("");
		passvisibile.setBackground(Color.LIGHT_GRAY);
		passvisibile.setBounds(376, 85, 19, 19);
		passvisibile.setEnabled(false);
		passvisibile.setBackground(H);
		panel.add(passvisibile);
		
		JButton conferma = new JButton("Conferma");
		conferma.setBounds(10, 244, 89, 23);
		conferma.setBackground(new Color(139, 210, 132));
		conferma.setEnabled(false);
		panel.add(conferma);
		
		
		JButton canc = new JButton("Cancella");
		canc.setBounds(335, 244, 89, 23);
		canc.setBackground(new Color(228, 67, 3));
		panel.add(canc);
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci i campi di cui hai bisogno,crea la tua Pass");
		lblNewLabel_1.setForeground(Color.BLACK);
		
		lblNewLabel_1.setBounds(10, 4, 414, 14);
		panel.add(lblNewLabel_1);
		
		JLabel errore = new JLabel("");
		errore.setFont(new Font("Tahoma", Font.ITALIC, 10));
		errore.setForeground(Color.RED);
		errore.setBounds(6, 211, 389, 23);
		errore.setText("Devi inserire un Nome app");
		panel.add(errore);
		
		
		///controllo jtextfield nomeapp
		 nomeappc.getDocument().addDocumentListener(new DocumentListener() {   
			    public void insertUpdate(DocumentEvent e) {
			    	controllo();
			    }
			    public void removeUpdate(DocumentEvent e) {
			    	controllo();
			    }
			    public void changedUpdate(DocumentEvent e) {
			        controllo();
			    }
			    public void controllo(){
			    	if(nomeappc.getText().trim().isEmpty())
					 {
						 conferma.setEnabled(false);
						 System.out.println("212");
						 errore.setText("Devi inserire un Nome app");
					 }else{
						 conferma.setEnabled(true);
						 System.out.println("3232");
						 errore.setText("");
					 }
			    }
			});
		
        
		///ascoltatori radiobutton
		
				//ascoltatore radiobutton mail
				mail.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	if(mail.isSelected()) {
		            		mailc.setEnabled(true);
		            		mailc.setBackground(Color.WHITE);
		            		
		            	}else{
		            		mailc.setEnabled(false);
		            		mailc.setText("");
		            		mailc.setBackground(H);
		            	}
		            }
		            });
				
				//campo password visibile o no
				passvisibile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nc++;
						if(nc%2!=0) {
							System.out.println("funge");
							passc.setEchoChar((char) 0);
						}else {
							passc.setEchoChar('•');
						}	
					}
				});
				
				//ascoltatore radiobutton password
				pass.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	if(pass.isSelected()) {
		            		passc.setEnabled(true);
		            		passc.setBackground(Color.WHITE);
		            		passvisibile.setEnabled(true);
		            	}else{
		            		passc.setEnabled(false);
		            		passc.setText("");
		            		passc.setBackground(H);
		            		passvisibile.setEnabled(false);	
		            	}
		            }
		        });
				//ascoltatore radiobutton nome
				nome.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	if(nome.isSelected()) {
		            		nomec.setEnabled(true);
		            		nomec.setBackground(Color.WHITE);
		            	}else{
		            		nomec.setEnabled(false);
		            		nomec.setText("");
		            		nomec.setBackground(H);
		            	}
		            }
		        });
				//ascoltatore radiobutton numero
				num.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	if(num.isSelected()) {
		            		numc.setEnabled(true);
		            		numc.setBackground(Color.WHITE);
		            	}else{
		            		numc.setEnabled(false);
		            		numc.setText("");
		            		numc.setBackground(H);
		            	}
		            }
		        });
				//ascoltatore radiobutton altro
				altro.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	if(altro.isSelected()) {
		            		altroc.setEnabled(true);
		            		altroc.setBackground(Color.WHITE);
		            	}else{
		            		altroc.setEnabled(false);
		            		altroc.setText("");
		            		altroc.setBackground(H);
		            	}
		            }
		        });
				//ascoltatore bottone conferma
				conferma.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
						 try {
							 
							 //cerca il file
							 inizializzazione.cercafile();
							 //creazione del writer
							 FileWriter w=new FileWriter("file.txt",true);
							 BufferedWriter pout=new BufferedWriter (w);
							 ///inserimento dei contenuti selezionati all'interno del file
							 pout.write("Nome App:"+nomeappc.getText()+"\n");
							
							 if(mail.isSelected()) {
							 pout.write("Mail:"+mailc.getText()+"\n");
							 }
							 if(pass.isSelected()) {
							 pout.write("Password:"+passc.getText()+"\n");
							 }
							 if(nome.isSelected()) {
							 pout.write("Nome:"+nomec.getText()+"\n");
							 }
							 if(num.isSelected()) {
							 pout.write("Numero:"+numc.getText()+"\n");
							 }
							 if(altro.isSelected()) {
							 pout.write("Altro:"+altroc.getText()+"\n");
							 }
							 pout.write("------------------------------------------\n");

							 ///chiusura writer
							 pout.flush();
							 ///creazione dell'albero aggiornato
							 pagina2.tree();
							 ///rendere disponibile la prima finestra
							 pagina2.frame1.setEnabled(true);
							 frame.dispose();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}finally {
							pagina2.ricarica();
						}
					 }
				});
				
			//ascoltatore tasto cancella	
			canc.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 //chiusura finestra
					 pagina2.frame1.setEnabled(true);
					 frame.dispose(); 
				 }	
			});		
	}
}

