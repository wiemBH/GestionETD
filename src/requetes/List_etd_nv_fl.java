package requetes;
/*Application de gestion des notes des �tudiants
 * r�alis�e en 2016 � Ndjam�na au Tchad par 
 * Targoto Christian
 * Contact: +23560316682  / ct@chrislink.net*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ig.Connecteur;

import java.sql.*;

public class List_etd_nv_fl extends JFrame implements ActionListener{
	JLabel lab1,lab2;
	JComboBox jcb1,jcb2;
	JButton jb1,jb2,jb3;
	JTable tb;
	JScrollPane scrl;
	Statement st;
	ResultSet rst;
	Connecteur cn=new Connecteur();
	public List_etd_nv_fl(){
		this.setTitle("application");
		this.setSize(1000,600);
		this.setLocation(350,30);
		this.setResizable(false);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(0x008080));
		add(pn);
		lab1=new JLabel("LISTE DES ETUDIANTS");
		lab1.setBounds(200,30,650,30);
		lab1.setFont(new Font("Arial",Font.BOLD,25));
		lab1.setBackground(new Color(0x008080));
		//lab1.setBorder(BorderFactory.createLineBorder(Color.black));
		pn.add(lab1);
		lab1=new JLabel("FILIERE :");
		lab1.setBounds(60,80,100,30);
		lab1.setFont(new Font("Arial",Font.BOLD,18));
		pn.add(lab1);
		jcb1=new JComboBox();
		jcb1.addItem("GT");
		jcb1.addItem("GII");
		jcb1.addItem("GEC");
		jcb1.addItem("IDSD");
		jcb1.setBounds(180,80,80,30);
		pn.add(jcb1);
		
		//label2
				lab2=new JLabel("NIVEAU :");
				lab2.setBounds(360,80,80,30);
				lab2.setFont(new Font("Arial",Font.BOLD,15));
				pn.add(lab2);
				//combo2
				jcb2=new JComboBox();
				jcb2.addItem("1");
				jcb2.addItem("2");
				jcb2.addItem("3");
				jcb2.setBounds(440,80,80,30);
				pn.add(jcb2);
				//
				jb1=new JButton("Recherche");
				jb1.setBounds(640,80,100,30);
				jb1.setForeground(Color.black);
				jb1.setBackground(new Color(0xADD8E6));
				jb1.addActionListener(this);
				pn.add(jb1);
				
				//
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
				pn.add(scrl);
		
	}
	private void init(){
		tb=new JTable();
		scrl=new JScrollPane();
		scrl.setViewportView(tb);
		scrl.setBounds(10,150,960,400);
		
	}
public static void main(String[] args){
		
	List_etd_nv_fl ls=new List_etd_nv_fl();
		ls.setVisible(true);
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==jb1){
		String a,b;
		a=jcb1.getSelectedItem().toString();
		b=jcb2.getSelectedItem().toString();
		DefaultTableModel df=new DefaultTableModel();
		df.addColumn("Matricule");
		df.addColumn("Nom");
		df.addColumn("Prenom");
		df.addColumn("DatNaissance");
		df.addColumn("Sexe");
		df.addColumn("Filiere");
		df.addColumn("Niveau");
		tb.setModel(df);
		String qry="select * from etudiant where filiere='"+a+"'and niveau='"+b+"'";
				
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
			JOptionPane.showMessageDialog(this,"INTROUVABLE",null,JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}


}
