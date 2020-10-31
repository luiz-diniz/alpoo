package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Exercicio_1 extends JFrame implements ActionListener, KeyListener {
	private JPanel contentPane;
	private JPanel panel;
	private JTextField txtBatata;
	private JTextField txtCenoura;
	private JTextField txtPimentao;
	private JTextField txtCebola;
	private JLabel lblBatata;
	private JTextField txtPepino;
	private JLabel lblPimentao;
	private JLabel lblCenoura;
	private JLabel lblCebola;
	private JTextField txtTomate;
	private JTextField txtBeterraba;
	private JLabel lblBeterraba;
	private JLabel lblPepino;
	private JLabel lblTomate;
	private JButton btnComprar;
	private JLabel lblProdutos;
	private JLabel lblValor;
	private JLabel lblQuantidade;
	private JCheckBox chbxBatata;
	private JCheckBox chbxCenoura;
	private JCheckBox chbxCebola;
	private JCheckBox chbxBeterraba;
	private JCheckBox chbxPepino;
	private JCheckBox chbxPimentao;
	private JCheckBox chbxTomate;
	private JLabel lblTotal;

	public static void main(String[] args) {
		Exercicio_1 tela = new Exercicio_1();
		tela.setVisible(true);
	}

	public Exercicio_1() {
		ajustaTela();
		addComponentes();
	}

	private void ajustaTela() {
		this.setTitle("Mercadinho Unip");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 353);
	}

	private void addComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(10, 11, 414, 200);

		contentPane.add(panel);
		panel.setLayout(new GridLayout(8, 3, 5, 5));

		lblProdutos = new JLabel("Produtos");
		panel.add(lblProdutos);

		lblValor = new JLabel("Valor");
		panel.add(lblValor);

		lblQuantidade = new JLabel("Quantidade (kg)");
		panel.add(lblQuantidade);

		chbxBatata = new JCheckBox("Batata");
		panel.add(chbxBatata);

		lblBatata = new JLabel("R$ 1.50");
		panel.add(lblBatata);

		txtBatata = new JTextField();
		panel.add(txtBatata);
		txtBatata.setColumns(10);

		chbxCenoura = new JCheckBox("Cenoura");
		panel.add(chbxCenoura);

		lblCenoura = new JLabel("R$ 2.00");
		panel.add(lblCenoura);

		txtCenoura = new JTextField();
		panel.add(txtCenoura);
		txtCenoura.setColumns(10);

		chbxCebola = new JCheckBox("Cebola");
		panel.add(chbxCebola);

		lblCebola = new JLabel("R$ 3.10");
		panel.add(lblCebola);

		txtCebola = new JTextField();
		panel.add(txtCebola);
		txtCebola.setColumns(10);

		chbxBeterraba = new JCheckBox("Beterraba");
		panel.add(chbxBeterraba);

		lblBeterraba = new JLabel("R$ 2.35");
		panel.add(lblBeterraba);

		txtBeterraba = new JTextField();
		panel.add(txtBeterraba);
		txtBeterraba.setColumns(10);

		chbxPepino = new JCheckBox("Pepino");
		panel.add(chbxPepino);

		lblPepino = new JLabel("R$ 1.85");
		panel.add(lblPepino);

		txtPepino = new JTextField();
		panel.add(txtPepino);
		txtPepino.setColumns(10);

		chbxPimentao = new JCheckBox("Pimentão");
		panel.add(chbxPimentao);

		lblPimentao = new JLabel("R$ 3.00");
		panel.add(lblPimentao);

		txtPimentao = new JTextField();
		panel.add(txtPimentao);
		txtPimentao.setColumns(10);

		chbxTomate = new JCheckBox("Tomate");
		panel.add(chbxTomate);

		lblTomate = new JLabel("R$ 3.50");
		panel.add(lblTomate);

		txtTomate = new JTextField();
		panel.add(txtTomate);
		txtTomate.setColumns(10);

		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(161, 227, 89, 23);
		btnComprar.addActionListener(this);
		contentPane.add(btnComprar);

		lblTotal = new JLabel("Total a pagar: ");
		lblTotal.setBounds(161, 271, 140, 14);
		contentPane.add(lblTotal);

		txtBatata.addKeyListener(this);
		txtBeterraba.addKeyListener(this);
		txtCebola.addKeyListener(this);
		txtCenoura.addKeyListener(this);
		txtPepino.addKeyListener(this);
		txtPimentao.addKeyListener(this);
		txtTomate.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		if (evento.getSource() == btnComprar) {
			Double soma = 0.0d;

			try {

				if (!buscaErros()) {
					soma += chbxBatata.isSelected() ? 1.5 * Double.valueOf(txtBatata.getText()) : 0.0d;
					soma += chbxCenoura.isSelected() ? 2.0 * Double.valueOf(txtCenoura.getText()) : 0.0d;
					soma += chbxCebola.isSelected() ? 3.1 * Double.valueOf(txtCebola.getText()) : 0.0d;
					soma += chbxBeterraba.isSelected() ? 2.35 * Double.valueOf(txtBeterraba.getText()) : 0.0d;
					soma += chbxPepino.isSelected() ? 1.85 * Double.valueOf(txtPepino.getText()) : 0.0d;
					soma += chbxPimentao.isSelected() ? 3.0 * Double.valueOf(txtPimentao.getText()) : 0.0d;
					soma += chbxTomate.isSelected() ? 3.5 * Double.valueOf(txtTomate.getText()) : 0.0d;

					DecimalFormat df = new DecimalFormat("#,##0.00");
					String format = df.format(soma);

					lblTotal.setText(" Total a pagar R$ " + String.valueOf(format));

				} else {
					return;
				}

			} catch (NumberFormatException erro) {
				lblTotal.setText("Apenas números!!!");
			}
		}
	}

	private boolean buscaErros() {
		if (chbxBatata.isSelected() && txtBatata.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informe o peso da batata !!!");
			txtBatata.requestFocus();
			return true;
		}

		if (chbxCenoura.isSelected() && txtCenoura.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informe o peso da cenoura !!!");
			txtCenoura.requestFocus();
			return true;
		}

		if (chbxCebola.isSelected() && txtCebola.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informe o peso da cebola !!!");
			txtCebola.requestFocus();
			return true;
		}

		if (chbxBeterraba.isSelected() && txtBeterraba.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informe o peso da beterraba !!!");
			txtBeterraba.requestFocus();
			return true;
		}

		if (chbxPepino.isSelected() && txtPepino.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informe o peso do pepino !!!");
			txtPepino.requestFocus();
			return true;
		}

		if (chbxPimentao.isSelected() && txtPimentao.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informe o peso da pimentão !!!");
			txtPimentao.requestFocus();
			return true;
		}

		if (chbxTomate.isSelected() && txtTomate.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informe o peso do tomate !!!");
			txtTomate.requestFocus();
			return true;
		}

		return false;
	}

	@Override
	public void keyReleased(KeyEvent e) {

		// controla a marcacao de desmarcacao automatica do checkBox
	    chbxBatata.setSelected(txtBatata.getText().isEmpty() ? false : true);
	    chbxBeterraba.setSelected(txtBeterraba.getText().isEmpty() ? false : true);
	    chbxCebola.setSelected(txtCebola.getText().isEmpty() ? false : true);
	    chbxCenoura.setSelected(txtCenoura.getText().isEmpty() ? false : true);
	    chbxPepino.setSelected(txtPepino.getText().isEmpty() ? false : true);
	    chbxPimentao.setSelected(txtPimentao.getText().isEmpty() ? false : true);
	    chbxTomate.setSelected(txtTomate.getText().isEmpty() ? false : true);		
	    
	    // Troca virgula por ponto e - por vazio
	    txtBatata.setText(!txtBatata.getText().isEmpty() ? txtBatata.getText().replace(",", ".").replace("-", "") : txtBatata.getText());
	    txtBeterraba.setText(!txtBeterraba.getText().isEmpty() ? txtBeterraba.getText().replace(",", ".").replace("-", "") : txtBeterraba.getText());
	    txtCebola.setText(!txtCebola.getText().isEmpty() ? txtCebola.getText().replace(",", ".").replace("-", "") : txtCebola.getText());
	    txtCenoura.setText(!txtCenoura.getText().isEmpty() ? txtCenoura.getText().replace(",", ".").replace("-", "") : txtCenoura.getText());
	    txtPepino.setText(!txtPepino.getText().isEmpty() ? txtPepino.getText().replace(",", ".").replace("-", "") : txtPepino.getText());
	    txtPimentao.setText(!txtPimentao.getText().isEmpty() ? txtPimentao.getText().replace(",", ".") : txtPimentao.getText());
	    txtTomate.setText(!txtTomate.getText().isEmpty() ? txtTomate.getText().replace(",", ".").replace("-", "") : txtTomate.getText());

	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}
}



