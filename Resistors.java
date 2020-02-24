import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Resistors {

    private JFrame jFrame;
    private JPanel panel;
    private Button button;

    private ArrayList<Float> resistors;
    private float volt;
    private float current;
    private int resNoContent;

    private SingleCircuitCalculator circuit;

    public Resistors(){
        circuit = new SingleCircuitCalculator();
        jFrame = new JFrame("Resistors Value");
        resistors = new ArrayList<>();
        button = new Button("Solve!");
    }

    public void setVolt(float volt) {
        this.volt = volt;
    }

    public void setCurrent(float current) {
        this.current = current;
    }

    public void setResNoContent(int resNoContent) {
        this.resNoContent = resNoContent;
    }

    public void init(int resCount){
        for (int i = 0; i <resCount ; i++) {

            JTextField textField = new JTextField();
            textField.setText("Enter Value Here");

            textField.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textField.setText("");
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });

            panel.add(textField);

        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i <resCount ; i++) {
                    JTextField textI = (JTextField) panel.getComponent(i);
                    try {
                        resistors.add(Float.parseFloat(textI.getText()));
                    } catch (NumberFormatException ex) {
                        JLabel label = new JLabel("wrong input format");
                        label.setVisible(true);
                        panel.add(label);
                    }
                }

                newFrame();

            }
        });
        panel.add(button);
        jFrame.add(panel);
        jFrame.setSize(300,200);
        jFrame.setLocation(500,250);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }

    public ArrayList<Float> getResistors() {
        return resistors;
    }

    public String calculateCircuit(){

        circuit.setVoltageSource(volt);
        circuit.setMainCurrent(current);
        circuit.setResistorsCount(resNoContent);
        circuit.setResistors(getResistors());

        circuit.calcEqualRes();
        if (current == 0) {
            circuit.calcMainCurrent();
            circuit.calcVoltageSource();
        }
        else if (volt == 0){
            circuit.calcVoltageSource();
            circuit.calcMainCurrent();
        }
        circuit.calcResistorsVoltage();

        return circuit.toString();

    }

    private void newFrame(){

        JFrame frame = new JFrame("All Values");
        Panel panel = new Panel();
        JTextArea textArea = new JTextArea(calculateCircuit());

        panel.add(textArea);
        frame.add(panel);
        frame.setSize(300,200);
        frame.setLocation(500,250);
        frame.setVisible(true);

    }

}
