import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class Vybor extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Vybor() {
		super("Определение расчетов");
		setBounds(400, 220, 100, 40);

		JPanel panelV = new JPanel(null);

		// Добавляем метку с информацией к работе в самый верх окна
		JLabel top = new JLabel("Выберите тип комнаты:");
		top.setBounds(10, 5, 250, 40);

		JRadioButton pryam = new JRadioButton("Прямоугольная", false);
		pryam.setBounds(10, 45, 150, 40);
		JRadioButton treyg = new JRadioButton("Нестандартная", false);
		treyg.setBounds(10, 75, 150, 40);
		ButtonGroup group = new ButtonGroup();
		group.add(pryam);
		group.add(treyg);

		JButton zapusk = new JButton("Начать");
		zapusk.setBounds(100, 120, 100, 30);
		zapusk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pryam.isSelected()) {
					new PryamougKv();
					dispose();
				} else if (treyg.isSelected()) {
					new NestandartKv();
					dispose();
				}
			}
		});
		
		panelV.add(treyg);
		panelV.add(zapusk);
		panelV.add(pryam);
		panelV.add(top);
		setContentPane(panelV);
		setSize(400, 200);
		setVisible(true);
		// устанавливаем выравнивание текста в метке по центру
		top.setHorizontalAlignment(JLabel.CENTER);

		setResizable(false); // запрещаем изменение размеров главного окна

	}

	public static void main(String[] args) {
		new Vybor();
	}
}
