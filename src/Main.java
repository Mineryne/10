import javax.swing.*;
import java.awt.event.*;
public class Main {
    public static void main(String[] args) {


        class Model {
            private String text = "";

            public void setText(String text) {
                this.text = text;
            }

            public String getText() {
                return text;
            }
        }


        class Controller {
            private Model model;
            private View view;

            public Controller(Model model, View view) {
                this.model = model;
                this.view = view;


                this.view.addBtnListener(new BtnListener());
            }


            class BtnListener implements ActionListener {
                public void actionPerformed(ActionEvent e) {
                    String text = view.getTextFieldText();
                    model.setText(text);
                    view.setLabelText(model.getText());
                }
            }
        }

        class View extends JFrame {
            private JTextField textField;
            private JLabel label;
            private JButton button;

            public View() {
                setTitle("Простий додаток MVC");
                setSize(300, 200);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                textField = new JTextField(15);
                label = new JLabel("Текст:");
                button = new JButton("Додати");

                JPanel panel = new JPanel();
                panel.add(label);
                panel.add(textField);
                panel.add(button);

                add(panel);
                setVisible(true);
            }


            public void addBtnListener(ActionListener listener) {
                button.addActionListener(listener);
            }


            public String getTextFieldText() {
                return textField.getText();
            }


            public void setLabelText(String text) {
                label.setText("Текст: " + text);
            }
        }

        class SimpleMVCExample {
            public static void main(String[] args) {
                Model model = new Model();
                View view = new View();
                Controller controller = new Controller(model, view);
            }
        }


    }
    }
