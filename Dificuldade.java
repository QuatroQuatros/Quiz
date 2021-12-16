import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Dificuldade extends JFrame {

	private JPanel contentPane;
	
	private int DIFF_MIN = 1;
	private int DIFF_MAX = 3;
	private int DIFF_INIT = 1;  
	
	int diffValue = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dificuldade frame = new Dificuldade();
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
	public Dificuldade() {
		setTitle("Sinta a Press\u00E3o nen\u00E9m");
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
		
		JSlider diff = new JSlider(JSlider.HORIZONTAL, DIFF_MIN, DIFF_MAX, DIFF_INIT);
		
		diff.setMajorTickSpacing(1);
		diff.setMinorTickSpacing(1);
		diff.setPaintTicks(true);
		diff.setPaintLabels(true);
		
		diff.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				diffValue = diff.getValue();
				System.out.print(diffValue);
					
			}
			
		});
		
		diff.setBounds(79, 93, 278, 51);
		panel.add(diff);
		
		JLabel lblNewLabel = new JLabel("Selecione a Dificuldade");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(64, 11, 306, 38);
		panel.add(lblNewLabel);
		
		
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(139, 200, 164, 23);
		panel.add(btnConfirmar);
		
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Perguntas win = new Perguntas(diffValue);
				
				Dificuldade.this.dispose();
				win.setVisible(true);
				
			}
			
		});
	}
	

}
