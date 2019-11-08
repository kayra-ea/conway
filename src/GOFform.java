import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GOFform {
    private JPanel MainPanel;
    private JPanel glDisplay;
    private JPanel menuPanel;
    private JButton btnGo;
    private JButton btnPause;
    private JTextField txtCol;
    private JTextField txtRow;
    private JRadioButton rdoR;
    private JRadioButton rdoB;
    private JRadioButton rdoG;
    private JLabel lblDimSize;
    private JLabel lblColor;

    public GOFform(){
        //Handle any necessary binding with ActionListeners, etc.
        btnGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((GLDisplay) glDisplay).play(); //Start playing the game of Life
            }
        });

        btnPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((GLDisplay) glDisplay).stop();
            }
        });
        txtRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int size = Integer.parseInt(txtRow.getText());
                    if (size >= 20 && size <= 400){
                        ((GLDisplay)glDisplay).setDimension(size);
                    } else {
                        txtRow.setText("WRONG WRONG WRONG WRONG!!!!!!!!!");
                    }
                } catch (NumberFormatException error){
                    txtRow.setText("ENTER AN INTEGER!!!!!!!!!!!!");
                }
            }
        });
        txtCol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int size = Integer.parseInt(txtRow.getText());
                    if (size >= 20 && size <= 400){
                        ((GLDisplay)glDisplay).setDimension(size);
                    } else {
                        txtRow.setText("WRONG WRONG WRONG WRONG!!!!!!!!!");
                    }
                } catch (NumberFormatException error){
                    txtRow.setText("ENTER AN INTEGER!!!!!!!!!!!!");
                }
            }
        });
        rdoR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((GLDisplay)glDisplay).setColor(Color.red);
            }
        });

        rdoB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((GLDisplay)glDisplay).setColor(Color.blue);
            }
        });
        rdoG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((GLDisplay)glDisplay).setColor(Color.green);
            }
        });
    }

    public static void main(String[] args){
        GOFform gol = new GOFform();
        JFrame frame = new JFrame("Conway's Game of Life");
        frame.add(gol.MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        glDisplay = new GLDisplay();
    }
}
