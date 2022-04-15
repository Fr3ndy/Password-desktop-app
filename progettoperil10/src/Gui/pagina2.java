package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.Box;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;



import javax.swing.*;
import javax.swing.JTextPane;

public class pagina2{

	public static JFrame frame1 = new JFrame("Salva Password");
	public static JTree tree = new JTree();
	public static JPanel panel = new JPanel();
	protected Object pagina3;
	public static DefaultMutableTreeNode pass = new DefaultMutableTreeNode("Pass");
	public static JTextPane Contenuto = new JTextPane();
	public static JButton cancellap = new JButton("Elimina");
	static JButton aggiorna = new JButton("Aggiorna");

	//mail
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pagina2 window = new pagina2();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public pagina2()  {
		initialize();
		
	}

	private void initialize() {
		
		frame1.setBounds(100, 100, 654, 526);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		frame1.setLocationRelativeTo(null);
		frame1.setResizable(false);
		//creazione icona
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
		frame1.setIconImage(icon);  
		panel.setBounds(0, 0, 638, 487);
		frame1.getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 638, 25);
		panel.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);
		
		JButton Info = new JButton("Informazioni");
		mnNewMenu_1.add(Info);
		
		Component horizontalStrut = Box.createHorizontalStrut(510);
		menuBar.add(horizontalStrut);
		
		aggiorna.setBackground(Color.BLACK);
		aggiorna.setForeground(Color.white);
		menuBar.add(aggiorna);
		
		JButton crea = new JButton("Crea");
		crea.setBackground(new Color(139, 210, 132));
		crea.setBounds(10, 35, 89, 23);
		
		panel.add(crea);
		
		
		Contenuto.setBounds(388, 69, 240, 407);
		panel.add(Contenuto);
		Contenuto.setContentType("text");
		
		
		cancellap.setBounds(109, 35, 89, 23);
		cancellap.setBackground(new Color(228, 67, 3));
		panel.add(cancellap);
		//cerca file 
		inizializzazione.cercafile();
		//creazione albero
		tree();
		//ascoltatore albero
		ascoltatorealbero();
		//tasto informazioni
		Info.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 informazione.main(null);
			 }
				
		});
		//Ascoltatore tasto crea
		crea.addActionListener(new ActionListener() {
			 private pagina3 ci;
			public void actionPerformed(ActionEvent e) {
				try {
					ci = new pagina3();
					Gui.pagina3.main(null);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			 }
		});
		//tasto aggiorna
		aggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ricarica();
			}
		});
	}
		
	
	
		///metodi separati
	
	
	
		//ricarica
		public static void ricarica() {
			//richiamo albero ,ricarico il modello dell'albero
			tree();
			((DefaultTreeModel) tree.getModel()).reload();
			SwingUtilities.updateComponentTreeUI(frame1);
		}
		//ascoltatore  albero
		public static void ascoltatorealbero() {
			
			//selezioe alementi albero
			tree.addTreeSelectionListener(new TreeSelectionListener() {
		        public void valueChanged(TreeSelectionEvent evt) {
		            System.out.println("ok");
		            FileReader reader;
		            Object obj = evt.getNewLeadSelectionPath().getLastPathComponent();
		            //ascoltatore tasto cancella elemento
		            cancellap.addActionListener(new ActionListener() {
		    			public void actionPerformed(ActionEvent evt) {
		    				FileInputStream fstream = null;  
		    			      DataInputStream in = null;
		    			      BufferedWriter out = null;
		    			      try {
		    			    	  //apro il file
		    			          fstream = new FileInputStream("file.txt");
		    			          //prendo l'inputStream
		    			          in = new DataInputStream(fstream);
		    			          BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    			          String strLine;
		    			          StringBuilder fileContent = new StringBuilder();
		    			          //Leggo il file riga per riga
		    			          while ((strLine = br.readLine()) != null) {
		    			             if(strLine.equals("Nome App:"+obj.toString())){
		    			                //se la riga è uguale a quella ricercata
		    			            		 fileContent.append("Eliminato"+System.getProperty("line.separator"));
		    			             } else {
		    			                //altrimenti la trascrivo così com'è
		    			                fileContent.append(strLine);
		    			                fileContent.append(System.getProperty("line.separator"));
		    			             }
		    			          }
		    			  
		    			          //Sovrascrivo il file con il nuovo contenuto (aggiornato)
		    			          FileWriter fstreamWrite = new FileWriter("file.txt");
		    			          out = new BufferedWriter(fstreamWrite);
		    			          out.write(fileContent.toString());
		    			     
		    			       } catch (Exception e) {
		    			          e.printStackTrace();
	
		    			       } finally {
		    			          //chiusura dell'output e dell'input
		    			          try {
		    			             fstream.close();
		    			             out.flush();
		    			             out.close();
		    			             in.close();
		    			             ricarica();
		    			          } catch (IOException e) {
		    			             e.printStackTrace();
		    			         }
		    			      }
		    			}
		    		});
		            //inserimento del file selezionato sul dettaglio
					try {
						//creazione lettore
						reader = new FileReader("file.txt");
						try (Scanner in = new Scanner(reader)) {
							Contenuto.setText(null);
							boolean c=false;
							while(in.hasNextLine())
							{ 
									String line = in.nextLine();	
								if(line.equals("Nome App:"+obj.toString())) {
									c=true;
								}
								if(line.equals("------------------------------------------")) {
									c=false;													
								}
								if(c) {
									//dammi la posizione dell'inserimento	
									int i=Contenuto.getCaretPosition();
									//inserisci una stringa sulla pos i
									Contenuto.getDocument().insertString(i, line+"\n\n", null);			
									System.out.println("ok2");
								}
							}
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
		        }
			});
		}
		///creazione albero in pannell
		public static void tree() {
			//creazione albero		
			tree=new JTree(pass);
			tree.setVisibleRowCount(40);
			tree.setBounds(10, 69, 368, 407);
			panel.add(tree);
			tree.removeAll();
					FileReader reader;
					try {
						reader = new FileReader("file.txt");
						try (Scanner in = new Scanner(reader)) {
							DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
							DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
							root.removeAllChildren();
							model.reload();
							while(in.hasNextLine())
							{ String line = in.nextLine();
							if(line.contains("Nome App:")) {
								System.out.println(line);
								String k=line.replace("Nome App:","");
							pass.add(new DefaultMutableTreeNode(k));
							}
							model.reload();
							tree.setEditable(true);
							tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
							}
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}		
		}
}
