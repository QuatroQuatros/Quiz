import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.SwingConstants;

public class Carregar extends JFrame {

	private JPanel contentPane;
	JLabel randomMsg = new JLabel("");
	JProgressBar barra = new JProgressBar();
	
	
	String[] mensagens = { "Baixando Perguntas...", "Caçando um Javali", "Consertando o computador", "Procurando respostas no brainly"};
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carregar frame = new Carregar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Carregar() {
		setTitle("Carregando...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		barra.setForeground(Color.BLUE);
		barra.setBackground(Color.LIGHT_GRAY);
		
		barra.setBounds(10, 148, 414, 41);
		barra.setStringPainted(true);
		panel.add(barra);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Carregar.class.getResource("/img/loading.gif")));
		lblNewLabel.setBounds(118, 11, 200, 150);
		panel.add(lblNewLabel);
		randomMsg.setHorizontalAlignment(SwingConstants.CENTER);
	
		randomMsg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		randomMsg.setBounds(96, 200, 267, 29);
		panel.add(randomMsg);
		
		
		new Temporizador().start();
	}
	
	public class Temporizador extends Thread{
		public void run() {
			while(barra.getValue() < 100) {
				try {
					sleep(50);
					barra.setValue(barra.getValue()+1);
					
					if(barra.getValue() == 10 || barra.getValue() == 40 || barra.getValue() == 70) {
						Random ran = new Random();
						int n = ran.nextInt(mensagens.length);
						randomMsg.setText(mensagens[n]);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			JOptionPane.showMessageDialog(null, "Carregado!");
			Perguntas win = new Perguntas(1);
			Carregar.this.dispose();
			win.setVisible(true);
		}
	}
}
