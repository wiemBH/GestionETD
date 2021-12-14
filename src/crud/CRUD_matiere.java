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

import java.sql.*;

public class CRUD_matiere extends JFrame  implements ActionListener{
	Statement st;
	ResultSet rst;
	Connecteur cn=new Connecteur();
	JLabel lb0, lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9;
	JTextField jtf2,jtf3,jtf4,jtf5;
	JButton jb1,jb2,jb3,jb4,jb5,jb7,jb8,jb9;
    JRadioButton rb1,rb2;
    JComboBox jcb,jcb2;
	JTable tb;
	JScrollPane scrl;
	
	
	public CRUD_matiere(){
		this.setTitle("application");
		this.setSize(1000,650);
		this.setResizable(false);
		this.setLocation(350,30);
	JPanel jp=new JPanel();
	jp.setLayout(null);
	jp.setBackground(new Color(0x008080));
	add(jp); 
	
	lb1=new JLabel("Interface graphique de Gestion");
	lb1.setFont(new Font("Arial",Font.BOLD,20));
	lb1.setForeground(new Color (0xF08080));
	lb1.setBounds(70,30,400,30);
	jp.add(lb1);
	
	lb0=new JLabel("Matiere");
	lb0.setFont(new Font("Arial",Font.BOLD,20));
	lb0.setForeground(Color.black);
	lb0.setBounds(150,60,100,30);
	jp.add(lb0);
	lb2=new JLabel("Identifiant");
	lb2.setFont(new Font("Arial",Font.BOLD,15));
	lb2.setForeground(Color.lightGray);
	lb2.setBounds(50,100,100,30);
	jp.add(lb2);
	jtf2=new JTextField();
	jtf2.setBounds(130,100,250,30);
	jp.add(jtf2);
	lb3=new JLabel("Appellation");
	lb3.setFont(new Font("Arial",Font.BOLD,15));
	lb3.setForeground(Color.lightGray);
	lb3.setBounds(50,140,100,30);
	jp.add(lb3);
	jtf3=new JTextField();
	jtf3.setBounds(130,140,250,30);
	jp.add(jtf3);
			lb7=new JLabel("Filiere :");
			lb7.setFont(new Font("Arial",Font.BOLD,15));
			lb7.setForeground(Color.lightGray);
			lb7.setBounds(50,180,100,30);
			jp.add(lb7);
			jcb=new JComboBox();
			jcb.addItem("GT");
			jcb.addItem("GII");
			jcb.addItem("GEC");
			jcb.addItem("IDSD");
			jcb.setBounds(130,190,200,30);
			jp.add(jcb);
			lb8=new JLabel("Niveau :");
			lb8.setFont(new Font("Arial",Font.BOLD,15));
			lb8.setForeground(Color.LIGHT_GRAY);
			lb8.setBounds(50,230,250,30);
			jp.add(lb8);
			jcb2=new JComboBox();
			jcb2.addItem("1");
			jcb2.addItem("2");
			jcb2.addItem("3");
			jcb2.setBounds(130,240,200,30);
			jp.add(jcb2);
	jb1=new JButton("Insertion");
	jb1.setBounds(80,300,250,40);
	jb1.setForeground(new Color(0,0,0));
	jb1.setBackground(new Color(0xADD8E6));
	jb1.addActionListener(this);
	jp.add(jb1);
	jb2=new JButton("Suppression");
	jb2.setBounds(80,360,250,40);
	jb2.setForeground(new Color(0,0,0));
	jb2.setBackground(new Color(0xADD8E6));
	jb2.addActionListener(this);
	jp.add(jb2);
	jb3=new JButton("Modification");
	jb3.setBounds(80,420,250,40);
	jb3.setForeground(new Color(0,0,0));
	jb3.setBackground(new Color(0xADD8E6));
	jb3.addActionListener(this);
	jp.add(jb3);
		jb4=new JButton("Recherche");
		jb4.setBounds(80,480,250,40);
		jb4.setForeground(new Color(0,0,0));
		jb4.setBackground(new Color(0xADD8E6));
		jb4.addActionListener(this);
		jp.add(jb4);
		jb5=new JButton("Actualiser");
		jb5.setBounds(80,540,250,40);
		jb5.setForeground(new Color(0,0,0));
		jb5.setBackground(new Color(0xADD8E6));
		jb5.addActionListener(this);
		jp.add(jb5);
		lb9=new JLabel("Aller à:");
		lb9.setFont(new Font("Arial",Font.BOLD,18));
		lb9.setForeground(new Color(0,0,0));
		lb9.setBounds(400,550,100,30);
		jp.add(lb9);
				jb7=new JButton("Etudiant");
				jb7.setBounds(550,550,100,30);
				jb7.setForeground(Color.black);
				jb7.setBackground(new Color(0xADD8E6));
				jb7.addActionListener(this);
				jp.add(jb7);
			jb8=new JButton("Note");
			jb8.setBounds(680,550,100,30);
			jb8.setForeground(Color.black);
			jb8.setBackground(new Color(0xADD8E6));
			jb8.addActionListener(this);
			jp.add(jb8);
			jb9=new JButton("Requetes");
			jb9.setBounds(810,550,100,30);
			jb9.setForeground(Color.black);
			jb9.setBackground(new Color(0xADD8E6));
			jb9.addActionListener(this);
			jp.add(jb9);
		DefaultTableModel df=new DefaultTableModel();
		init();
		df.addColumn("Identifiant");
		df.addColumn("Appellation");
		df.addColumn("Filière");
		df.addColumn("Niveau");
		tb.setModel(df);
		jp.add(scrl);
		String qry="select * from matiere";
		try{
			st=cn.chrisConnect().createStatement();
			rst=st.executeQuery(qry);
			while(rst.next()){
				df.addRow(new Object[]{
						rst.getString("idmat"),rst.getString("appelation"),
						rst.getString("filiere"),rst.getString("niveau")
						
						
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
		scrl.setBounds(450,50,480,450);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CRUD_matiere mt=new CRUD_matiere();
		mt.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//ajout
		if(e.getSource()==jb1){
			String a,b,c,d;
		a=jtf2.getText();b=jtf3.getText();
		c=jcb.getSelectedItem().toString();
		d=jcb2.getSelectedItem().toString();
			
		String query="insert into matiere values('"+a+"','"+b+"','"+c+"','"+d+"')";
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
				if(e.getSource()==jb2){
					String a;
					a=jtf2.getText();
				String query="delete from matiere where idmat='"+a+"'";
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
					
				}//
				//modification
				if(e.getSource()==jb3){
					String a,b,c,d;
					a=jtf2.getText();
					b=jtf3.getText();
					c=jcb.getSelectedItem().toString();
					d=jcb2.getSelectedItem().toString();
				String query="update matiere set appelation='"+b+"',filiere='"+c+"',niveau='"+d+"' where idmat='"+a+"'";
				try{
					st=cn.chrisConnect().createStatement();
					if(JOptionPane.showConfirmDialog(this,"Voulez vous modifiez",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(this,"Modification reuissie!");
					}
				}
				catch(SQLException ex){
					JOptionPane.showMessageDialog(this,"Modification impossible!",null,JOptionPane.ERROR_MESSAGE);
					
				}
					
				}
				
				if(e.getSource()==jb4){
					String a;
					a=jtf2.getText();
				String query="select * from matiere where idmat='"+a+"'";
				try{
					st=cn.chrisConnect().createStatement();
					rst=st.executeQuery(query);
					if(rst.next()){
						jtf2.setText(rst.getString("idmat"));
						jtf3.setText(rst.getString("appelation"));
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
			CRUD_matiere cr=new CRUD_matiere();
			cr.setVisible(true);
			
		}
		
		
		
		if(e.getSource()==jb7){
			this.dispose();
		CRUD_etudiant cr=new CRUD_etudiant();
		cr.setVisible(true);
			
		}
		if(e.getSource()==jb8){
			this.dispose();
		CRUD_note cr=new CRUD_note();
		cr.setVisible(true);
			
		}
		
		if(e.getSource()==jb9){
			this.dispose();
			 Requetes_liste ls=new  Requetes_liste();
			ls.setVisible(true);
			
		}
	}

}

