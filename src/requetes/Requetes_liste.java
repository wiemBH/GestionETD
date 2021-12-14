package requetes;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import crud.CRUD_etudiant;

import securite2.Authentification2;
public class Requetes_liste  extends JFrame implements ActionListener {
	JLabel lab1;
	JButton jb0,jb1,jb2,jb3,jb4,jb5,jb6;
	public Requetes_liste(){
		this.setTitle("application java");
		this.setSize(1000,600);
		this.setResizable(false);
		this.setLocation(350,30);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(0x008080));
		add(pn);
		lab1=new JLabel("Les Requetes disponible");
		lab1.setBounds(300,60,430,50);
		lab1.setFont(new Font("Arial",Font.BOLD,30));
		lab1.setBackground(Color.black);
		pn.add(lab1);
		jb0=new JButton("GESTION");
		jb0.setBounds(340,180,250,40);
		jb0.setBackground(new Color (0xF08080));
		jb0.setForeground(Color.black);
		jb0.addActionListener(this);
		pn.add(jb0);
		jb1=new JButton("Liste des étudiants ");
		jb1.setBounds(300,240,340,30);
		jb1.setBackground(new Color(0xADD8E6));
		jb1.setForeground(Color.black);
		jb1.addActionListener(this);
		pn.add(jb1);
		jb2=new JButton("Liste des matières ");
		jb2.setBounds(300,280,340,30);
		jb2.setBackground(new Color(0xADD8E6));
		jb2.setForeground(Color.black);
		jb2.addActionListener(this);
		pn.add(jb2);
		jb3=new JButton("Liste des notes des étudiants ");
		jb3.setBounds(300,320,340,30);
		jb3.setBackground(new Color(0xADD8E6));
		jb3.setForeground(Color.black);
		jb3.addActionListener(this);
		pn.add(jb3);
		jb4=new JButton("Liste des notes d'un étudiant ");
		jb4.setBounds(300,360,340,30);
		jb4.setBackground(new Color(0xADD8E6));
		jb4.setForeground(Color.black);
		jb4.addActionListener(this);
		pn.add(jb4);
		jb5=new JButton("Liste des moyennes ");
		jb5.setBounds(300,400,340,30);
		jb5.setBackground(new Color(0xADD8E6));
		jb5.setForeground(Color.black);
		jb5.addActionListener(this);
		pn.add(jb5);
		}
	public static void main(String[] args){
		
		Requetes_liste ls=new Requetes_liste();
		ls.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent p) {
		// TODO Auto-generated method stub
		
		if(p.getSource()==jb0){
			Authentification2 au=new Authentification2();
			au.setVisible(true);
			
		}
		if(p.getSource()==jb1){
			List_etd_nv_fl ls=new List_etd_nv_fl();
			ls.setVisible(true);
			
		}
		if(p.getSource()==jb2){
			List_mat_nv_fl ls=new List_mat_nv_fl();
			ls.setVisible(true);
			
		}
		if(p.getSource()==jb3){
			List_notes_mat ls=new List_notes_mat();
			ls.setVisible(true);
			
		}
		if(p.getSource()==jb4){
			List_notes_etd ls=new List_notes_etd();
			ls.setVisible(true);
			
		}
		
		if(p.getSource()==jb5){
			List_moy_mat ls=new List_moy_mat();
			ls.setVisible(true);
			
		}
		
		
		
	}

}
