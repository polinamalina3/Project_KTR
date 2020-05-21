//добавляем библиотеки для работы с текстовыми полями, метками
//для создания графического окна
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

//Главный класс, реализующий интерфейс ActionListener
//Интерфейс нужен для обработки события нажатия на кнопку
public class Results extends JFrame {
	JFrame frame = new JFrame("Результаты расчетов"); // главное окно
	JPanel panelLeft = new JPanel(); // панель с метками
	JPanel panelRight = new JPanel(); // панель с текстовыми полями
	JPanel panelBottom = new JPanel(); // панель с кнопками
	public JTextField[] arrTf = new JTextField[18];// массив текстовых полей
	private double kolOb;
	private double kolPl;

//конструктор
	public Results(double kolOb, double kolPl) {
		this.kolOb = kolOb;
		this.kolPl = kolPl;
//устанавливаем менеджер компоновки для панели с метками
//делаем выравнивание по вертикали
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
//устанавлиаем размер 250 на 300 пикселей
		panelLeft.setPreferredSize(new Dimension(200, 300));

//устанавливаем менеджер компоновки для панели с текстовыми полями
//делаем выравнивание по вертикали
		panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
//устанавливаем размер 130 на 300 пикселей
		panelRight.setPreferredSize(new Dimension(130, 300));

//добавлям метки через метод addLabel
		addLabel(panelLeft, "Необходимое количество обоев", Color.BLACK);
		addLabel(panelLeft, "Необходимое количество плитки", Color.BLACK);
//добавляем текстовые поля через цикл и записываем их в массив
		for (int i = 12; i < 14; i++) {
			if (arrTf.length >= 0) {
//записываем ссылку из метода в массив для дальнейшей работы с текстовым полем
				arrTf[i] = addTextField(panelRight);
			}

		}
		arrTf[12].setText(""+kolOb);
		arrTf[13].setText(""+kolPl);
//делаем главную форму видимой
		frame.setVisible(true);
//устанавливаем начальное положение относительно центра экрана (по центру)
		frame.setLocationRelativeTo(null);
//Устанавливаем размер главного окна(400 на 450)
		frame.setSize(350, 200);
//добавляем панели на клавное окно
		frame.add(panelLeft, BorderLayout.WEST);
		frame.add(panelRight, BorderLayout.EAST);
		frame.add(panelBottom, BorderLayout.SOUTH);
		frame.setResizable(false); // запрещаем изменение размеров окна

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

}
