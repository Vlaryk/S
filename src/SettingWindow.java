import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {

    private static final int WIDTH = 350;
    private static final int HEIGHT = 230;
    private static final String SIZE_FIELD = "Установленный размер поля: ";
    private static final String WIN_LENGTH = "Установленная длина: ";


    private JButton btnStart;

    SettingWindow(GameWindow gameWindow){
        setLayout(new GridLayout(10,1));

        // Режим игры
        ButtonGroup group = new ButtonGroup();
        JRadioButton pvp = new JRadioButton("Человек против человека");
        JRadioButton pve = new JRadioButton("Человек против компьютера");
        group.add(pvp);
        group.add(pve);
        add(new JLabel("Выберите режим игры"));
        add(pvp);
        add(pve);

        // Размер поля
        add(new JLabel("Выберите размеры поля"));
        JLabel jLabelSizeField = new JLabel(SIZE_FIELD);
        add(jLabelSizeField);
        JSlider jSliderSizeField = new JSlider(3,10,3);
        add(jSliderSizeField);
        jSliderSizeField.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jLabelSizeField.setText(SIZE_FIELD + jSliderSizeField.getValue());
            }
        });

        // Длина для победы
        add(new JLabel("Выберите длину для победы"));
        JLabel lBWinLength = new JLabel(WIN_LENGTH);
        add(lBWinLength);
        JSlider jSliderLength = new JSlider(3,10,3);
        add(jSliderLength);
        jSliderLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lBWinLength.setText(WIN_LENGTH + jSliderLength.getValue());
                jSliderLength.setMaximum(jSliderSizeField.getValue());
            }
        });


        btnStart = new JButton("Start new game");
        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                gameWindow.startNewGame(0, jSliderSizeField.getValue(), jSliderSizeField.getValue(), jSliderLength.getValue());
            }
        });

        add(btnStart);
    }
}
