package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Exercicio_2 extends JFrame implements ActionListener {

	private Pizza pizza = new Pizza();
	private Random gerador = new Random();
	private DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");

	private JPanel painelCombo = new JPanel(new FlowLayout());

	private String tipoPizza[] = { "Pepperoni", "Mussarela", "Supreme" };
	
	private JComboBox<String> boxPizza = new JComboBox<String>(tipoPizza);
	
	private JLabel lblExtras = new JLabel("Coberturas Extras");
	private JPanel painelExtras = new JPanel(new FlowLayout());
	private JCheckBox ckBacon = new JCheckBox("Bacon");
	private JCheckBox ckCebola = new JCheckBox("Cebola");
	private JCheckBox ckChampignon = new JCheckBox("Champignon");
	private JCheckBox ckTomate = new JCheckBox("Tomate");
	private JCheckBox ckCatupiry = new JCheckBox("Catupiry");
	private JCheckBox ckPresunto = new JCheckBox("Presunto");

	private JLabel lblSize = new JLabel("Tamanho");
	private JPanel painelRadio = new JPanel(new FlowLayout());
	private JRadioButton ckindividual = new JRadioButton("Individual", true);
	private JRadioButton ckregular = new JRadioButton("Regular");
	private JRadioButton ckfamilia = new JRadioButton("Familia");

	private ButtonGroup btGroup = new ButtonGroup();
	private JRadioButton rbIndividual = new JRadioButton();
	private JRadioButton rbRegular = new JRadioButton();
	private JRadioButton rbFamilia = new JRadioButton();

	private JPanel painelTxtArea = new JPanel();
	private JTextArea txtArea = new JTextArea(15, 40);

	private JPanel painelButton = new JPanel(new FlowLayout());
	private JButton btnComprar = new JButton("Comprar");

	public Exercicio_2() {

		ajustaTela();
		adicionaComponentes();
		eventoCombo();

		btnComprar.addActionListener(this);
		boxPizza.addActionListener(this);
		ckindividual.addActionListener(this);
		ckregular.addActionListener(this);
		ckfamilia.addActionListener(this);
	}

	private void ajustaTela() {

		this.setTitle("Pizzaria Unip");
		this.setSize(750, 700);
		this.setLayout(null);

	}

	private void adicionaComponentes() {

		boxPizza.setPreferredSize(new Dimension(250,25));
		
		painelCombo.setBounds(10, 10, 700, 30);
		painelCombo.add(boxPizza);
		this.add(painelCombo);

		btGroup.add(ckindividual);
		btGroup.add(ckregular);
		btGroup.add(ckfamilia);
		painelRadio.add(ckindividual);
		painelRadio.add(ckregular);
		painelRadio.add(ckfamilia);
		painelRadio.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tamanho"));

		painelRadio.setBounds(10, 60, 700, 60);
		this.add(painelRadio);

		painelExtras.add(ckBacon);
		painelExtras.add(ckCebola);
		painelExtras.add(ckChampignon);
		painelExtras.add(ckTomate);
		painelExtras.add(ckCatupiry);
		painelExtras.add(ckPresunto);
		painelExtras
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Coberturas Extras"));

		painelExtras.setBounds(10, 140, 700, 60);
		this.add(painelExtras);

		painelButton.setBounds(10, 220, 700, 60);
		painelButton.add(btnComprar);
		this.add(painelButton);

		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		txtArea.setFont(new Font("Arial Black", Font.BOLD, 14));

		painelTxtArea.setBounds(10, 280, 700, 300);
		painelTxtArea.add(txtArea);
		this.add(painelTxtArea);

	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		if (evento.getSource() == ckindividual) {
			if (ckindividual.isSelected())
				pizza.setTipo("Individual");

		}
		if (evento.getSource() == ckregular) {
			if (ckregular.isSelected())
				pizza.setTipo("Regular");

		}
		if (evento.getSource() == ckfamilia) {
			if (ckfamilia.isSelected())
				pizza.setTipo("Familia");
		}

		if (evento.getSource() == btnComprar) {

			List<Coberturas> coberturas = new ArrayList<Coberturas>();

			if (ckBacon.isSelected())
				coberturas.add(new Coberturas("Bacom", 2.0d));
			if (ckCebola.isSelected())
				coberturas.add(new Coberturas("Cebola", 1.5d));
			if (ckChampignon.isSelected())
				coberturas.add(new Coberturas("Champignon", 2.50d));
			if (ckTomate.isSelected())
				coberturas.add(new Coberturas("Tomate", 1.0d));
			if (ckCatupiry.isSelected())
				coberturas.add(new Coberturas("Catupiry", 3.0d));
			if (ckPresunto.isSelected())
				coberturas.add(new Coberturas("Presunto", 2.5d));

			pizza.setCoberturas(coberturas);

			valorPizza(pizza);
			imprimePedido(pizza);
		}

		if (evento.getSource() == boxPizza) {

			eventoCombo();

		}

	}

	private void eventoCombo() {
		pizza.setNome(boxPizza.getSelectedItem().toString());

		if (boxPizza.getSelectedItem().equals("Pepperoni")) {

			ckindividual.setText("Individual R$ 15,00");
			ckregular.setText("Regular R$ 27,00");
			ckfamilia.setText("Familia R$ 33,00");
		}
		if (boxPizza.getSelectedItem().equals("Mussarela")) {

			ckindividual.setText("Individual R$ 12,00");
			ckregular.setText("Regular R$ 21,60");
			ckfamilia.setText("Familia R$ 26,40");
		}
		if (boxPizza.getSelectedItem().equals("Supreme")) {

			ckindividual.setText("Individual R$ 17,00");
			ckregular.setText("Regular R$ 30,60");
			ckfamilia.setText("Familia R$ 37,40");
		}
	}

	private void imprimePedido(Pizza pizza) {

		txtArea.setText(null);
		Double somaExtras = 0.0d;

		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String hojeFormatado = hoje.format(formatter);

		txtArea.append("Pedido Nº: " + gerador.nextInt(99999) + " - Data: " + hojeFormatado);
		txtArea.append("\n----------------------\n");
		txtArea.append("Pizza: " + pizza.getNome());
		txtArea.append("\nTamanho: " + pizza.getTipo());
		txtArea.append("\nExtras: ");

		for (Coberturas coberturas : pizza.getCoberturas()) {
			txtArea.append("\n  -> " + coberturas.getTipoCobertura() + " R$ " + decimalFormat.format(coberturas.getValor()));
		}

		
		txtArea.append("\nValor Pizza R$ " + decimalFormat.format(pizza.getValor()));

		for (Coberturas coberturas : pizza.getCoberturas()) {
			pizza.setValor(pizza.getValor() + coberturas.getValor());
			somaExtras += coberturas.getValor();
		}

		txtArea.append("\nValor Extras R$ " + decimalFormat.format(somaExtras));
		txtArea.append("\nValor Total R$ " + decimalFormat.format(pizza.getValor()));

	}

	private void valorPizza(Pizza pizza) {

		if (pizza.getNome().equals("Pepperoni")) {
			if (pizza.getTipo().equals("Individual"))
				pizza.setValor(15.00d);
			if (pizza.getTipo().equals("Regular"))
				pizza.setValor(27.00d);
			if (pizza.getTipo().equals("Familia"))
				pizza.setValor(33.00d);
		}

		if (pizza.getNome().equals("Mussarela")) {
			if (pizza.getTipo().equals("Individual"))
				pizza.setValor(12.00d);
			if (pizza.getTipo().equals("Regular"))
				pizza.setValor(21.60d);
			if (pizza.getTipo().equals("Familia"))
				pizza.setValor(26.40d);
		}

		if (pizza.getNome().equals("Supreme")) {
			if (pizza.getTipo().equals("Individual"))
				pizza.setValor(17.00d);
			if (pizza.getTipo().equals("Regular"))
				pizza.setValor(30.60d);
			if (pizza.getTipo().equals("Familia"))
				pizza.setValor(37.40d);
		}
	}

	public static void main(String[] args) {

		Exercicio_2 ex2 = new Exercicio_2();
		ex2.setLocationRelativeTo(null); // centralizar
		ex2.setVisible(true);
		ex2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
