package securite;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import requetes.Requetes_liste;
import securite2.Authentification2;


public class Authentification extends JFrame implements ActionListener {
	JLabel lb1,lb2,lb3,lb4;
	JTextField jtf2;
	JPasswordField jp3;
	JButton jb1,jb2,jb3,jb4;
	public Authentification(){
		this.setTitle("application java");
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(0x008080));
		add(pn);
		lb1=new JLabel("Bienvenu dans notre l'application ");
		lb1.setBounds(100,10,450,30);
		lb1.setFont(new Font("Arial",Font.BOLD,18));
		lb1.setForeground(new Color (0xF08080));
		pn.add(lb1);
		//
		lb4=new JLabel("Authentifiez vous pour continuer");
		lb4.setBounds(100,30,450,30);
		lb4.setFont(new Font("Arial",Font.BOLD,18));
		lb4.setForeground(new Color (0xF08080));
		pn.add(lb4);
		//login
		lb2=new JLabel("Login:");
		lb2.setBounds(140,70,100,30);
		lb2.setFont(new Font("Arial",Font.BOLD,15));
		lb2.setForeground(Color.white);
		pn.add(lb2);
		
		jtf2=new JTextField();
		jtf2.setBounds(210,70,100,30);
		pn.add(jtf2);
		//pass
				lb3=new JLabel("Password:");
				lb3.setBounds(130,130,200,30);
				lb3.setFont(new Font("Arial",Font.BOLD,15));
				lb3.setForeground(Color.white);
				pn.add(lb3);
				
				jp3=new JPasswordField();
				jp3.setBounds(210,130,100,30);
				pn.add(jp3);
			//bouton1
				jb1=new JButton("ENTRER");
				jb1.addActionListener(this);
				jb1.setBounds(130,180,100,30);
				jb1.setFont(new Font("Arial",Font.BOLD,15));
				jb1.setBackground(new Color(0xADD8E6));
				pn.add(jb1);
				//bt2
				jb2=new JButton("RESSAYER");
				jb2.setBounds(240,180,120,30);
				jb2.addActionListener(this);
				jb2.setFont(new Font("Arial",Font.BOLD,15));
				jb2.setBackground(new Color(0xADD8E6));
				pn.add(jb2);
				//bt3
				jb3=new JButton("CHANGER MOT DE PASSE");
				jb3.setBounds(50,220,250,30);
				jb3.addActionListener(this);
				jb3.setFont(new Font("Arial",Font.BOLD,15));
				jb3.setBackground(new Color(0xADD8E6));
				pn.add(jb3);
				//bt4
				jb4=new JButton("ADMIN");
				jb4.setBounds(320,220,100,30);
				jb4.addActionListener(this);
				jb4.setFont(new Font("Arial",Font.BOLD,15));
				jb4.setBackground(new Color(0xADD8E6));
				pn.add(jb4);
		
				
		
	}
	public static void main(String[] args){
		Authentification aut=new Authentification();
		aut.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent p) {
		// TODO Auto-generated method stub
		if(p.getSource()==jb1){
			String a=jtf2.getText();
			char[] b=jp3.getPassword();
			String b2=new String(b);
			Verification vf=new Verification();
		if(!(a.equals(""))&&!(b2.equals(""))){
			if(vf.verifier(a, b2)==true){
				this.dispose();
				Requetes_liste ls=new Requetes_liste();
				ls.setVisible(true);
				
			}
			else JOptionPane.showMessageDialog(this,"login ou mot de passe incorrect!",null,JOptionPane.ERROR_MESSAGE);
			
		}
		else
		JOptionPane.showMessageDialog(this,"login ou mot de passe vide!",null,JOptionPane.ERROR_MESSAGE);
			
		}
		if(p.getSource()==jb2){
			jtf2.setText("");
			jp3.setText("");
			
		}
		//
		if(p.getSource()==jb3){
			ChangePass cp=new ChangePass();
			cp.setVisible(true);
		
		
	}
		//
		if(p.getSource()==jb4){
			dispose();
		  Authentification2 au=new Authentification2();
			au.setVisible(true);
		
		
	}
	
			
			
		
		
	}

}
