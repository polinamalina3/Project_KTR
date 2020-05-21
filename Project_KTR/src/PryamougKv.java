//добавляем библиотеки для работы с текстовыми полями, метками
//для создания графического окна
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

//Главный класс, реализующий интерфейс ActionListener
//Интерфейс нужен для обработки события нажатия на кнопку
public class PryamougKv implements ActionListener {
	JFrame frame = new JFrame("Расчет планировки стандартной комнаты"); // главное окно
	JPanel panelLeft = new JPanel(); // панель с метками
	JPanel panelRight = new JPanel(); // панель с текстовыми полями
	JPanel panelBottom = new JPanel(); // панель с кнопками
	public static JTextField[] arrTf = new JTextField[13];// массив текстовых полей
	private boolean poly;
	private boolean oboy;

//конструктор
	public PryamougKv() {
		this.poly = poly;
		this.oboy = oboy;
		System.out.print("" + poly + oboy);
//устанавливаем менеджер компоновки для панели с метками
//делаем выравнивание по вертикали
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
//устанавлиаем размер 250 на 300 пикселей
		panelLeft.setPreferredSize(new Dimension(250, 300));

//устанавливаем менеджер компоновки для панели с текстовыми полями
//делаем выравнивание по вертикали
		panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
//устанавливаем размер 130 на 300 пикселей
		panelRight.setPreferredSize(new Dimension(130, 300));

//добавлям метки через метод addLabel
		addLabel(panelLeft, "Длина комнаты", Color.BLACK);
		addLabel(panelLeft, "Ширина комнаты:", Color.BLACK);
		addLabel(panelLeft, "Высота комнаты:", Color.BLACK);
		addLabel(panelLeft, "Длина окна:", Color.BLACK);
		addLabel(panelLeft, "Ширина окна:", Color.BLACK);
		addLabel(panelLeft, "Количество окон:", Color.BLACK);
		addLabel(panelLeft, "Длина двери:", Color.BLACK);
		addLabel(panelLeft, "Ширина двери:", Color.BLACK);
		addLabel(panelLeft, "Количество дверных проемов:", Color.BLACK);
		addLabel(panelLeft, "Длина обоев:", Color.BLACK);
		addLabel(panelLeft, "Ширина обоев:", Color.BLACK);
		addLabel(panelLeft, "Длина плитки:", Color.BLACK);
		addLabel(panelLeft, "Ширина плитки:", Color.BLACK);
//добавляем текстовые поля через цикл и записываем их в массив
		for (int i = 0; i < arrTf.length; i++) {
			if (arrTf.length >= 0) {
//записываем ссылку из метода в массив для дальнейшей работы с текстовым полем
				arrTf[i] = addTextField(panelRight);
			}

		}

//добавляем кнопки расчета и сброса
		JButton calc = addButton(panelBottom, "Расчет");
//добавляем слушатель на событие нажатия
		calc.addActionListener(this);
		JButton reset = addButton(panelBottom, "Сброс");
//добавляем слушатель на событие нажатия
		reset.addActionListener(this);

//делаем главную форму видимой
		frame.setVisible(true);
//устанавливаем действие при нажатии на крестик - завершение приложения
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// устанавливаем начальное положение относительно центра экрана (по центру)
		frame.setLocationRelativeTo(null);
//Устанавливаем размер главного окна(400 на 450)
		frame.setSize(400, 350);

//добавляем панели на клавное окно
		frame.add(panelLeft, BorderLayout.WEST);
		frame.add(panelRight, BorderLayout.EAST);

		frame.add(panelBottom, BorderLayout.SOUTH);
		frame.setResizable(false); // запрещаем изменение размеров главного окна

	}

//метод добавления текстовых меток
	public void addLabel(JComponent container, String name, Color color) {
//создаем тестовую метку с именем name
		JLabel lb = new JLabel(name);
//устанавливаем максимально допустимый размер
		lb.setMaximumSize(new Dimension(400, 20));
//устанавливаем цвета текста
		lb.setForeground(color);
//устанавливаем выравнивание по правому краю
		lb.setHorizontalAlignment(JLabel.RIGHT);
//добавляем рамку
		lb.setBorder(new EtchedBorder());
//Добавляем текстовую метку в панель
		container.add(lb);
	}

//метод добавления текстовых полей
	public JTextField addTextField(JComponent container) {
//Создаем текстовое поле
		JTextField tf = new JTextField();
//устанавливаем его максимально допустимый размер
		tf.setMaximumSize(new Dimension(150, 20));
//добавляем текстовое поле на панель
		container.add(tf);
//возвращаем ссылку на текстовое поле
		return tf;
	}

//метод добавления кнопок
	public JButton addButton(JComponent container, String name) {
//Создаем кнопку
		JButton btn = new JButton(name);
//Устанавливаем максимально допустимый размер
		btn.setMaximumSize(new Dimension(100, 20));
//Выравниваем по горизонтали по центру
		btn.setHorizontalAlignment(JButton.CENTER);

//добавляем кнопку
		container.add(btn);
//возвращаем ссылку на кнопку
		return btn;
	}

//метод расчета
	public double planirovka(double kolOb, double kolPl) throws Exception {
		double dlinaKomn = 0;
		double shirinaKomn = 0;
		double vysotaKomn = 0;
		double dlinaOkna = 0;
		double shirinaOkna = 0;
		double kolOkon = 0;
		double dlinaDver = 0;
		double shirinaDver = 0;
		double kolDver = 0;
		double dlinaOb = 0;
		double shirinaOb = 0;
		double shirinaPl = 0;
		double dlinaPl = 0;
		double q1 = 0;
		double q2 = 0;
		double q3 = 0;
		double q4 = 0;
		double q5 = 0;
		for (int i = 0; i < 11; i++) {
			if (arrTf[i].getText().length() == 0) {
				arrTf[i].setText(" ");
			}
		}

		if (!arrTf[0].getText().equals(" ")) {
			dlinaKomn = Double.valueOf(arrTf[0].getText()); // dlina komnaty
		}
		if (!arrTf[1].getText().equals(" ")) {
			shirinaKomn = Double.valueOf(arrTf[1].getText()); // shirina komnaty
		}
		if (!arrTf[2].getText().equals(" ")) {
			vysotaKomn = Double.valueOf(arrTf[2].getText()); // visota komnaty
		}
		if (!arrTf[3].getText().equals(" ")) {
			dlinaOkna = Double.valueOf(arrTf[3].getText()); // dlina okna
		}
		if (!arrTf[4].getText().equals(" ")) {
			shirinaOkna = Double.valueOf(arrTf[4].getText()); // shirina okna
		}
		if (!arrTf[5].getText().equals(" ")) {
			kolOkon = Double.valueOf(arrTf[5].getText()); // kol-vo okon
		}
		if (!arrTf[6].getText().equals(" ")) {
			dlinaDver = Double.valueOf(arrTf[6].getText()); // dlina dvery
		}
		if (!arrTf[7].getText().equals(" ")) {
			shirinaDver = Double.valueOf(arrTf[7].getText()); // shirina dvery
		}
		if (!arrTf[8].getText().equals(" ")) {
			kolDver = Double.valueOf(arrTf[8].getText()); // kol-vo dverei
		}
		if (!arrTf[9].getText().equals(" ")) {
			dlinaOb = Double.valueOf(arrTf[9].getText()); // dlina oboev
		}
		if (!arrTf[10].getText().equals(" ")) {
			shirinaOb = Double.valueOf(arrTf[10].getText()); // shirina oboev
		}
		if (!arrTf[11].getText().equals(" ")) {
			dlinaPl = Double.valueOf(arrTf[11].getText()); // shirina oboev
		}
		if (!arrTf[12].getText().equals(" ")) {
			shirinaPl = Double.valueOf(arrTf[12].getText()); // shirina oboev
		}
		if ((dlinaKomn != 0) & (shirinaKomn != 0) & (vysotaKomn != 0)) {
			q1 = 2 * vysotaKomn * (dlinaKomn + shirinaKomn); // Стены квартиры
		}
		if ((dlinaOkna != 0) & (shirinaOkna != 0) & (kolOkon != 0)) {
			q2 = dlinaOkna * shirinaOkna * kolOkon; // Окна квартиры
		}
		if ((dlinaDver != 0) & (shirinaDver != 0) & (kolDver != 0)) {
			q3 = dlinaDver * shirinaDver * kolDver; // Дверь квартиры
		}
		if ((dlinaOb != 0) & (shirinaOb != 0)) {
			q4 = dlinaOb * shirinaOb; // Обои
		}
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		if ((dlinaKomn != 0) & (shirinaKomn != 0)&(shirinaPl != 0) &(dlinaPl != 0)) {
			q5 = (dlinaKomn * shirinaKomn)/(dlinaPl * shirinaPl);
			kolPl = Math.round(q5);// Количество плитки
		}
		if ((q1 != 0) || (q2 != 0) || (q3 != 0) || (q4 != 0) || (q5 != 0)) {
			kolOb = Math.round((q1 - q2 - q3) / q4);// Количество обоев
			
		}

		new Results(kolOb, kolPl);
		return kolOb;

	}

//Метод обработки события нажатия на кнопку
	@Override
	public void actionPerformed(ActionEvent e) {
//узнаем имя кнопки, на которую нажали
		if (e.getActionCommand().equals("Расчет")) {
			try {
				// выполняем расчет
				planirovka(5, 1);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
			}

		} else {
//очищаем все поля
			for (int i = 0; i < arrTf.length; i++) {
				arrTf[i].setText("");
			}
		}
	}
}