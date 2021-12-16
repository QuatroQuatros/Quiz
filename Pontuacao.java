import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pontuacao extends JFrame {

	private JPanel contentPane;
	private final JLabel precisao = new JLabel("Quantidade de erros 0");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pontuacao frame = new Pontuacao(0,0,0);
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
	public Pontuacao(int qtdPerguntas, int qtdAcertos, int qtdErros) {
		setTitle("Pontua\u00E7\u00E3o");
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
		
		JLabel qtdPerguntasTxt = new JLabel("");
		qtdPerguntasTxt.setHorizontalAlignment(SwingConstants.CENTER);
		qtdPerguntasTxt.setBounds(102, 30, 230, 14);
		panel.add(qtdPerguntasTxt);
		qtdPerguntasTxt.setText("Quantidade de perguntas: " + String.valueOf(qtdPerguntas));
		
		JLabel qtdAcertosTxt = new JLabel("");
		qtdAcertosTxt.setHorizontalAlignment(SwingConstants.CENTER);
		qtdAcertosTxt.setBounds(102, 81, 230, 14);
		panel.add(qtdAcertosTxt);
		qtdAcertosTxt.setText("Quantidade de acertos: " +String.valueOf(qtdAcertos));
		
		JLabel qtdErrosTxt = new JLabel("");
		qtdErrosTxt.setHorizontalAlignment(SwingConstants.CENTER);
		qtdErrosTxt.setBounds(102, 130, 230, 14);
		panel.add(qtdErrosTxt);	
		qtdErrosTxt.setText("Quantidade de erros: " + String.valueOf(qtdErros));
		
		precisao.setBounds(102, 167, 230, 31);
		panel.add(precisao);
		precisao.setHorizontalAlignment(SwingConstants.CENTER);
		precisao.setText("Precisão " + String.valueOf(100 - (100/qtdPerguntas) * qtdErros) + "%");
		
		JButton btnNewGame = new JButton("Novo Jogo");
		btnNewGame.setBounds(53, 209, 132, 23);
		panel.add(btnNewGame);
		
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dificuldade win = new Dificuldade();
				
				Pontuacao.this.dispose();
				win.setVisible(true);
				
			}
			
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setBounds(261, 209, 132, 23);
		panel.add(btnSair);
	}
}
