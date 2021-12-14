package crud;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ig.Connecteur;
import requetes.Requetes_liste;
import securite2.CRUD_mdp;

import java.sql.*;

public class CRUD_etudiant extends JFrame  implements ActionListener{
	Statement st;
	ResultSet rst;
	Connecteur cn=new Connecteur();
	JLabel lb0, lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9;
	JTextField jtf2,jtf3,jtf4,jtf5;
	JButton jb1,jb2,jb3,jb4,jb5,jb7,jb8,jb9,jb10;
    JRadioButton rb1,rb2;
    JComboBox jcb,jcb2;
	JTable tb;
	JScrollPane scrl;
	
	
	public CRUD_etudiant(){
		this.setTitle("Application");
		this.setSize(1000,650);
		this.setResizable(false);
		this.setLocation(350,30);
	JPanel jp=new JPanel();
	jp.setLayout(null);
	jp.setBackground(new Color(0x008080));
	add(jp);
	lb1=new JLabel("Interface graphique de Gestion");
	lb1.setFont(new Font("Arial",Font.BOLD,20));
	lb1.setForeground(new Color(0xF08080));
	lb1.setBounds(70,10,400,30);
	jp.add(lb1);
	
	lb0=new JLabel("ETUDIANT");
	lb0.setFont(new Font("Arial",Font.BOLD,20));
	lb0.setForeground(Color.black);
	lb0.setBounds(150,50,100,30);
	jp.add(lb0);
	lb2=new JLabel("Matricule");
	lb2.setFont(new Font("Arial",Font.BOLD,15));
	lb2.setForeground(Color.lightGray);
	lb2.setBounds(50,90,100,30);
	jp.add(lb2);
	jtf2=new JTextField();
	jtf2.setBounds(130,90,150,30);
	jp.add(jtf2);
	lb3=new JLabel("Nom");
	lb3.setFont(new Font("Arial",Font.BOLD,15));
	lb3.setForeground(Color.lightGray);
	lb3.setBounds(80,130,100,30);
	jp.add(lb3);
   jtf3=new JTextField();
	jtf3.setBounds(130,130,150,30);
	jp.add(jtf3);
	   lb4=new JLabel("Prenom");
		lb4.setFont(new Font("Arial",Font.BOLD,15));
		lb4.setForeground(Color.lightGray);
		lb4.setBounds(60,170,100,30);
		jp.add(lb4);
		jtf4=new JTextField();
		jtf4.setBounds(130,170,150,30);
		jp.add(jtf4);
	
		lb5=new JLabel("DatNaissance");
		lb5.setFont(new Font("Arial",Font.BOLD,15));
		lb5.setForeground(Color.lightGray);
		lb5.setBounds(20,210,100,30);
		jp.add(lb5);
				
		jtf5=new JTextField("   JJ-MM-AAAA");
		jtf5.setBounds(130,210,150,30);
		jp.add(jtf5);
	//sexe
		lb6=new JLabel("Sexe");
		lb6.setFont(new Font("Arial",Font.BOLD,15));
		lb6.setForeground(Color.lightGray);
		lb6.setBounds(75,250,100,30);
		jp.add(lb6);
		
		rb1=new JRadioButton("MASC");
		rb1.setBounds(130,250,80,25);
	
		rb2=new JRadioButton("FEM");
		rb2.setBounds(210,250,70,25);
		jp.add(rb1);
		jp.add(rb2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
	//filiere
		lb7=new JLabel("Filiere");
		lb7.setFont(new Font("Arial",Font.BOLD,15));
		lb7.setForeground(Color.lightGray);
		lb7.setBounds(65,290,100,30);
		jp.add(lb7);
		
		jcb=new JComboBox();
		jcb.addItem("GT");
		jcb.addItem("GII");
		jcb.addItem("GEC");
		jcb.addItem("IDSD");
		jcb.setBounds(130,290,100,25);
		jp.add(jcb);
	//Niveau
		lb8=new JLabel("Niveau");
		lb8.setFont(new Font("Arial",Font.BOLD,15));
		lb8.setForeground(Color.lightGray);
		lb8.setBounds(65,330,100,30);
		jp.add(lb8);
		
		jcb2=new JComboBox();
		jcb2.addItem("1");
		jcb2.addItem("2");
		jcb2.addItem("3");
		jcb2.setBounds(130,330,100,25);
		jp.add(jcb2);
		//
		lb9=new JLabel("Aller à:");
		lb9.setFont(new Font("Arial",Font.BOLD,18));
		lb9.setForeground(Color.black);
		lb9.setBounds(410,540,400,30);
		jp.add(lb9);
	jb1=new JButton("Insertion");
	jb1.setBounds(50,390,300,30);
	jb1.setForeground(Color.black);
	jb1.setBackground(new Color(0xADD8E6));
	jb1.addActionListener(this);
	jp.add(jb1);
	jb2=new JButton("Suppression");
	jb2.setBounds(50,430,300,30);
	jb2.setForeground(Color.black);
	jb2.setBackground(new Color(0xADD8E6));
	jb2.addActionListener(this);
	jp.add(jb2);
	jb3=new JButton("Modification");
	jb3.setBounds(50,470,300,30);
	jb3.setForeground(Color.black);
	jb3.setBackground(new Color(0xADD8E6));
	jb3.addActionListener(this);
	jp.add(jb3);
		jb4=new JButton("Recherche");
		jb4.setBounds(280,90,100,30);
		jb4.setForeground(Color.black);
		jb4.setBackground(new Color(0xADD8E6));
		jb4.addActionListener(this);
		jp.add(jb4);
	
		jb5=new JButton("Actualiser");
		jb5.setBounds(50,510,300,30);
		jb5.setForeground(Color.black);
		jb5.setBackground(new Color(0xADD8E6));
		jb5.addActionListener(this);
		jp.add(jb5);
		jb7=new JButton("Matiere");
		jb7.setBounds(490,540,80,30);
		jb7.setForeground(Color.black);
		jb7.setBackground(new Color(0xADD8E6));
		jb7.addActionListener(this);
		jp.add(jb7);
		jb8=new JButton("Note");
		jb8.setBounds(580,540,80,30);
		jb8.setForeground(Color.black);
	    jb8.setBackground(new Color(0xADD8E6));
		 jb8.addActionListener(this);
			jp.add(jb8);
			jb9=new JButton("Requetes");
			jb9.setBounds(670,540,100,30);
			jb9.setForeground(Color.black);
			jb9.setBackground(new Color(0xADD8E6));
			jb9.addActionListener(this);
			jp.add(jb9);
			jb10=new JButton("Password");
			jb10.setBounds(785,540,110,30);
			jb10.setForeground(Color.black);
			jb10.setBackground(new Color(0xADD8E6));
			jb10.addActionListener(this);
			jp.add(jb10);
		
		
		DefaultTableModel df=new DefaultTableModel();
		init();
		df.addColumn("Matricule");
		df.addColumn("Nom");
		df.addColumn("Prenom");
		df.addColumn("DatNaissance");
		df.addColumn("Sexe");
		df.addColumn("Filiere");
		df.addColumn("Niveau");
		tb.setModel(df);
		jp.add(scrl);
		
		String qry="select * from etudiant";
		try{
			st=cn.chrisConnect().createStatement();
			rst=st.executeQuery(qry);
			while(rst.next()){
				df.addRow(new Object[]{
						rst.getString("matricule"),rst.getString("Nom"),rst.getString("Prenom"),rst.getString("datnaissance")
						,rst.getString("sexe"),rst.getString("filiere"),rst.getString("niveau")
						
				});
				
			}
		}
		catch(SQLException ex){
			
		}
			
	}
	private void init(){
		tb=new JTable();
		scrl=new JScrollPane();
		scrl.setViewportView(tb);
		scrl.setBounds(450,30,480,500);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CRUD_etudiant igr=new CRUD_etudiant();
		igr.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//ajout
		if(e.getSource()==jb1){
			String a,b,c,d,f,g,h;
		a=jtf2.getText();b=jtf3.getText();c=jtf4.getText();d=jtf5.getText();
		if(rb1.isSelected()) f=rb1.getText(); else f=rb2.getText();
		g=jcb.getSelectedItem().toString();
		h=jcb2.getSelectedItem().toString();
			
		String query="insert into etudiant values('"+a+"','"+b+"','"+c+"','"+d+"','"+f+"','"+g+"','"+h+"')";
		try{
			st=cn.chrisConnect().createStatement();
			if(JOptionPane.showConfirmDialog(this,"Voulez vous ajoutez?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				st.executeUpdate(query);
				JOptionPane.showMessageDialog(this,"Insertion reussie!");
			}
			
			
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(this,"Echec insertion!",null,JOptionPane.ERROR_MESSAGE);
			
		}
			
		}
		//suppression
				if(e.getSource()==jb2){
					String a;
					a=jtf2.getText();
				String query="delete from etudiant where matricule='"+a+"'";
				try{
					st=cn.chrisConnect().createStatement();
					if(JOptionPane.showConfirmDialog(this,"Voulez vous supprimer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(this,"Suppression reussie!");
					}
					
					
				}
				catch(SQLException ex){
					JOptionPane.showMessageDialog(this,"Echec suppression!",null,JOptionPane.ERROR_MESSAGE);
					
				}
					
				}
				//modification
				if(e.getSource()==jb3){
					String a,b,c,d,f,g,h;
					a=jtf2.getText();b=jtf3.getText();c=jtf4.getText();d=jtf5.getText();
					if(rb1.isSelected()) f=rb1.getText(); else f=rb2.getText();
					g=jcb.getSelectedItem().toString();
					h=jcb2.getSelectedItem().toString();
					
				String query="update etudiant set nom='"+b+"', prenom='"+c+"', datnaissance='"+d+"', sexe='"+f+"', filiere='"+g+"', niveau='"+h+"' where matricule='"+a+"' " ;
					
				try{
					st=cn.chrisConnect().createStatement();
					if(JOptionPane.showConfirmDialog(this,"Voulez vous modifier?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(this,"modification reussie!");
					}
					
					
				}
				catch(SQLException ex){
					JOptionPane.showMessageDialog(this,"Echec modification!",null,JOptionPane.ERROR_MESSAGE);
					
				}
					
				}
				//recherche
				if(e.getSource()==jb4){
					String a;
					a=jtf2.getText();
				String query="select * from etudiant where matricule='"+a+"'";
				try{
					st=cn.chrisConnect().createStatement();
					rst=st.executeQuery(query);
					if(rst.next()){
						jtf2.setText(rst.getString("matricule"));
						jtf3.setText(rst.getString("nom"));
						jtf4.setText(rst.getString("prenom"));
						jtf5.setText(rst.getString("datnaissance"));
						//affichage dans le bouton radio
						if(rst.getString("sexe").equals("MASC"))
							rb1.setSelected(true);
						else
							rb2.setSelected(true);
						//affichage dans les combos
						jcb.setSelectedItem(rst.getString("filiere"));
						jcb2.setSelectedItem(rst.getString("niveau"));	
					}
					else
						JOptionPane.showMessageDialog(this, "Introuvable!",null,JOptionPane.ERROR_MESSAGE);
					
					
				}
				catch(SQLException ex){
				
					
				}
					
				}//

				
		if(e.getSource()==jb5){
			this.dispose();
			CRUD_etudiant cr=new CRUD_etudiant();
			cr.setVisible(true);
			
		}
		
		
		if(e.getSource()==jb7){
			this.dispose();
			CRUD_matiere mat=new CRUD_matiere();
			mat.setVisible(true);
			
		}
		if(e.getSource()==jb8){
			this.dispose();
			CRUD_note nt=new CRUD_note();
			nt.setVisible(true);
			
		}
		if(e.getSource()==jb9){
			this.dispose();
			 Requetes_liste ls=new  Requetes_liste();
			ls.setVisible(true);
			
		}
		
		//
		if(e.getSource()==jb10){
		this.dispose();
		 CRUD_mdp ls=new  CRUD_mdp();
		ls.setVisible(true);
		
	}
	}

}
