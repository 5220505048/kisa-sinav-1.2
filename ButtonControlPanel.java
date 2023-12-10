import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonControlPanel extends JFrame {

    private JButton[][] buttons = new JButton[4][4];
    private int lastClickedRow = -1;
    private int lastClickedCol = -1;

    public ButtonControlPanel() {
        setTitle("Button Control Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        GridLayout gridLayout = new GridLayout(4, 4);
        setLayout(gridLayout);

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                JButton button = createButton();
                buttons[row][col] = button;
                add(button);
            }
        }

        setVisible(true);
    }

    private JButton createButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(80, 80));
        button.setBackground(Color.RED); // Başlangıçta pasif rengi ayarla
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(button);
            }
        });
        return button;
    }

    private void handleButtonClick(JButton clickedButton) {
        int row = -1;
        int col = -1;

        // Tıklanan butonun konumunu bul
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (buttons[i][j] == clickedButton) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        if (lastClickedRow != -1 && lastClickedCol != -1) {
            // Eğer daha önce başka bir butona tıklandıysa, onun rengini sıfırla
            resetButtonState(buttons[lastClickedRow][lastClickedCol]);
        }

        // Butonu aktif hale getir
        setButtonActiveState(clickedButton);

        // GraphQL şemasına yazma işlemini burada gerçekleştirebilirsiniz
        String graphqlSchema = "GraphQL Schema Adresi";
        System.out.println("Button at row " + row + ", col " + col + " clicked. Writing to GraphQL schema: " + graphqlSchema);

        // Son tıklanan butonun konumunu güncelle
        lastClickedRow = row;
        lastClickedCol = col;
    }

    private void setButtonActiveState(JButton button) {
        button.setBackground(Color.GREEN); // Aktif rengi ayarla
        // Aktif simge ayarlamak için buraya ilgili kodu ekleyebilirsiniz
    }

    private void resetButtonState(JButton button) {
        button.setBackground(Color.RED); // Pasif rengi ayarla
        // Pasif simge ayarlamak için buraya ilgili kodu ekleyebilirsiniz
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ButtonControlPanel());
    }
}