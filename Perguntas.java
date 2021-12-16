import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JProgressBar;

public class Perguntas extends JFrame {

	private JPanel contentPane;
	private String resposta;

	public int acertos, erros, n, x;
	
	JRadioButton r1 = new JRadioButton("");
	JRadioButton r2 = new JRadioButton("");
	JRadioButton r3 = new JRadioButton("");
	JRadioButton r4 = new JRadioButton("");
	
	JLabel pergunta = new JLabel("");
	JProgressBar tempo = new JProgressBar();
	JButton btnResp = new JButton("Confirmar Resposta");
	Random ran = new Random();

	int vel = 1;
	
	
	List<String> alternativas = Arrays.asList("1", "2", "3", "4");
	
	String[] operacoes = {"+", "-", "*", "/"};
	
	String[][] perguntas = criaPerguntas();
	
	
	public String[][] criaPerguntas(){
		
		String[][] a = new String[5][];
		
		for (int i =0; i < 5; i++) {
			int n1 = ran.nextInt(50);
			int n2 = ran.nextInt(50);
			int n3 = ran.nextInt(operacoes.length);
			int r = 0;
			
			
			if(n3 == 0) {
				r = n1 + n2; 
			} else if(n3 == 1) {
				r = n1 - n2; 
			} else if(n3 == 2 && n1 != 0 || n2!= 0) {
				r = n1 * n2; 
			} else if(n3 == 3 && n1 != 0 || n2!= 0) {
				r = n1 / n2; 
			} else {
				System.out.println("Deveria ter uma excessão aqui...");
			}
			
			String p = "Quantos são " + String.valueOf(n1) + " "+ String.valueOf(operacoes[n3])+ " " +  String.valueOf(n2) + "?";
			String[] batata = {p, String.valueOf(ran.nextInt(80)), String.valueOf(ran.nextInt(80)), String.valueOf(ran.nextInt(80)), String.valueOf(r), String.valueOf(r)};
			a[i] = batata;
		}
		System.out.println(a.toString());
		return a;
	
	}
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perguntas frame = new Perguntas(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public int geraPergunta() {
		int n = ran.nextInt(perguntas.length);
		pergunta.setText(perguntas[n][0]);
		
		Collections.shuffle(alternativas);

		r1.setText(perguntas[n][Integer.parseInt(alternativas.get(0))]);
		r2.setText(perguntas[n][Integer.parseInt(alternativas.get(1))]);
		r3.setText(perguntas[n][Integer.parseInt(alternativas.get(2))]);
		r4.setText(perguntas[n][Integer.parseInt(alternativas.get(3))]);
		
		x++;
		setTitle("Pergunta " + String.valueOf(x));
		tempo.setValue(100);
		
		return n;
	}

    public String[][] removeElement( String[][] perguntas, int index ){
    	String[][] novoArray = new String[perguntas.length -1][];
    	int itens = perguntas.length - (index + 1);
    	System.arraycopy(perguntas, 0, novoArray, 0, index);
    	System.arraycopy(perguntas, index+1, novoArray, index, itens);

    	return novoArray;
    }
    


	public Perguntas(int velocidade) {
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
		
		pergunta.setHorizontalAlignment(SwingConstants.CENTER);
		pergunta.setBounds(35, 11, 372, 68);
		panel.add(pergunta);
			
		r1.setBounds(156, 102, 155, 23);
		panel.add(r1);
		r2.setBounds(156, 128, 155, 23);
		panel.add(r2);
		r3.setBounds(156, 154, 155, 23);
		panel.add(r3);
		r4.setBounds(156, 180, 155, 23);
		panel.add(r4);
			
		btnResp.setBounds(118, 227, 193, 23);
		panel.add(btnResp);
	
		tempo.setBounds(35, 11, 372, 14);
		tempo.setValue(100);
		panel.add(tempo);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		
		n = geraPergunta();
		x = 1;
		setTitle("Pergunta " + String.valueOf(x));
		vel = velocidade;
		new Temporizador().start();
		
		btnResp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(r1.isSelected() ||r2.isSelected() || r3.isSelected() || r4.isSelected()) {
					if(r1.isSelected() && Integer.parseInt(r1.getText()) == Integer.parseInt(perguntas[n][5])) {
						acertos++;
						perguntas = removeElement(perguntas, n);
						if(perguntas.length > 0) {
							n = geraPergunta();
						}else {
							tempo.setValue(0);
						}
					} else if(r2.isSelected() && Integer.parseInt(r2.getText()) == Integer.parseInt(perguntas[n][5])) {
						acertos++;
						perguntas = removeElement(perguntas, n);
						if(perguntas.length > 0) {
							n = geraPergunta();
						}else {
							tempo.setValue(0);
						}
					}else if(r3.isSelected() && Integer.parseInt(r3.getText()) == Integer.parseInt(perguntas[n][5])) {
						acertos++;
						perguntas = removeElement(perguntas, n);
						if(perguntas.length > 0) {
							n = geraPergunta();
						}else {
							tempo.setValue(0);
						}
					}else if(r4.isSelected() && Integer.parseInt(r4.getText()) == Integer.parseInt(perguntas[n][5])) {
						acertos++;
						perguntas = removeElement(perguntas, n);
						if(perguntas.length > 0) {
							n = geraPergunta();
						}else {
							tempo.setValue(0);
						}
					}else {
						erros++;
						perguntas = removeElement(perguntas, n);
						if(perguntas.length > 0) {
							n = geraPergunta(); 
						}else {
							tempo.setValue(0);
						}
					}
				
				}
				
				
				
			}
			
			
			
		});
			
		
	}
	public class Temporizador extends Thread{
		public void run() {
			while(tempo.getValue() > 0) {
				try {
					sleep(50);
					tempo.setValue(tempo.getValue()-vel);
					if (tempo.getValue() == 0 && perguntas.length != 0) {
						erros++;
						perguntas = removeElement(perguntas, n);
						if(perguntas.length >0) {
							n = geraPergunta();
						}

					}
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
			Pontuacao win = new Pontuacao(x, acertos, erros);
			Perguntas.this.dispose();
			win.setVisible(true);
		}
	}
}

