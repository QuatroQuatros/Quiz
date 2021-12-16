import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Telainicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telainicial frame = new Telainicial();
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
	public Telainicial() {
		setTitle("Quiz do 4.444");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(181, 208, 89, 23);
		panel.add(btnIniciar);
		
		JButton btnNewButton = new JButton("Informa\u00E7\u00E3o");
		btnNewButton.setBounds(10, 208, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sobre");
		btnNewButton_1.setBounds(335, 208, 89, 23);
		panel.add(btnNewButton_1);
		
		
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dificuldade win = new Dificuldade();
				
				Telainicial.this.dispose();
				win.setVisible(true);
				
			}
			
		});
	}
}
