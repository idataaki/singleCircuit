import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Info{
    private JFrame jFrame;
    private JPanel panel1;

    private JFormattedTextField cv;
    private JFormattedTextField cc;
    private JFormattedTextField resNo;

    private JButton solveButton;
    private JLabel warningLable;

    private float cvContent;
    private float ccContent;
    private int resNoContent;
    private ArrayList<Float> resistorsArr;

    private Resistors resistors;
    private SingleCircuitCalculator circuit;

    public Info(){
        circuit = new SingleCircuitCalculator();
        resistors = new Resistors();
        resistorsArr = new ArrayList<>();
        jFrame = new JFrame("Circuit Elements Info");
        warningLable.setVisible(false);
    }

    public void initForm(){

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (cv.getText().length() == 0)
                        cvContent = 0;
                    else
                        cvContent = Integer.parseInt(cv.getText());

                    if (cc.getText().length() == 0)
                        ccContent = 0;
                    else
                        ccContent = Integer.parseInt(cc.getText());

                    resNoContent = Integer.parseInt(resNo.getText());
                    resistors.init(resNoContent);
                    resistorsArr.addAll(resistors.getResistors());

                    resistors.setCurrent(ccContent);
                    resistors.setVolt(cvContent);
                    resistors.setResNoContent(resNoContent);

                }catch (Exception ex){
                    warningLable.setText("ERROR: Wrong Input");
                    warningLable.setVisible(true);
                }
            }
        });
        jFrame.add(panel1);
        jFrame.setSize(300, 200);
        jFrame.setLocation(500, 250);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
