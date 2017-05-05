package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Persistencia.ReadExcel;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Estadistica extends JFrame {

	private JPanel contentPane;
	private JTextField txtUlt;
	private JTextField txtMed10anos;
	private JTextField txtMedTotal;
	private JTextField txtNivel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Agente a = new Agente();
					ReadExcel RE = new ReadExcel();
					RE.leerArchivoExcel();
					Estadistica frame = new Estadistica();
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
	public Estadistica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelPais = new JPanel();
		tabbedPane.addTab("Por pais", null, panelPais, null);
		panelPais.setLayout(null);
		
		JLabel lblPais = new JLabel("Pais :");
		lblPais.setBounds(53, 37, 69, 20);
		panelPais.add(lblPais);
		
		JComboBox cmbPais1 = new JComboBox();
		cmbPais1.setBounds(144, 36, 133, 23);
		panelPais.add(cmbPais1);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(345, 33, 115, 29);
		panelPais.add(btnAceptar);
		
		JLabel lblUltimoAo = new JLabel("Ultimo a\u00F1o:");
		lblUltimoAo.setBounds(53, 163, 101, 20);
		panelPais.add(lblUltimoAo);
		
		JLabel lblUltimoAos = new JLabel("Ultimo 10 a\u00F1os:");
		lblUltimoAos.setBounds(89, 255, 121, 20);
		panelPais.add(lblUltimoAos);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(89, 308, 69, 20);
		panelPais.add(lblTotal);
		
		JLabel lblMedia = new JLabel("Media:");
		lblMedia.setBounds(53, 212, 69, 20);
		panelPais.add(lblMedia);
		
		txtUlt = new JTextField();
		txtUlt.setEditable(false);
		txtUlt.setBounds(169, 160, 146, 26);
		panelPais.add(txtUlt);
		txtUlt.setColumns(10);
		
		txtMed10anos = new JTextField();
		txtMed10anos.setEditable(false);
		txtMed10anos.setBounds(225, 252, 146, 26);
		panelPais.add(txtMed10anos);
		txtMed10anos.setColumns(10);
		
		txtMedTotal = new JTextField();
		txtMedTotal.setEditable(false);
		txtMedTotal.setBounds(225, 305, 146, 26);
		panelPais.add(txtMedTotal);
		txtMedTotal.setColumns(10);
		
		JPanel panelPaisAno = new JPanel();
		tabbedPane.addTab("Por pais y año", null, panelPaisAno, null);
		panelPaisAno.setLayout(null);
		
		JLabel lblPais_1 = new JLabel("Pais :");
		lblPais_1.setBounds(28, 33, 69, 20);
		panelPaisAno.add(lblPais_1);
		
		JLabel lblAo = new JLabel("A\u00F1o : ");
		lblAo.setBounds(28, 95, 69, 20);
		panelPaisAno.add(lblAo);
		
		JComboBox cmbPais2 = new JComboBox();
		cmbPais2.setBounds(98, 30, 114, 26);
		panelPaisAno.add(cmbPais2);
		
		JComboBox cmbano = new JComboBox();
		cmbano.setBounds(98, 92, 114, 26);
		panelPaisAno.add(cmbano);
		
		JButton btnAceptar_1 = new JButton("Aceptar");
		btnAceptar_1.setBounds(315, 95, 115, 29);
		panelPaisAno.add(btnAceptar_1);
		
		JLabel lblNivel = new JLabel("Nivel : ");
		lblNivel.setBounds(28, 221, 69, 20);
		panelPaisAno.add(lblNivel);
		
		txtNivel = new JTextField();
		txtNivel.setEditable(false);
		txtNivel.setBounds(146, 218, 146, 26);
		panelPaisAno.add(txtNivel);
		txtNivel.setColumns(10);
	}
}
