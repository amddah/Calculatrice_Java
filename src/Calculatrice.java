import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Calculatrice extends JFrame {


    private JButton btn =new JButton("Calculer");
    private JLabel label1 = new JLabel("Nombre 1:");
    private JLabel label2 = new JLabel("Nombre 2:");

    private JTextField Nombre1= new JTextField(10);
    private JTextField Nombre2= new JTextField(10);
    private JCheckBox checkBox = new JCheckBox("Sans Virgule");
    private JPanel panSaisi = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
    private JPanel panCheckBox = new JPanel(new FlowLayout(FlowLayout.CENTER));
    //group button radio
    private ButtonGroup btnGroup = new ButtonGroup();
    private JRadioButton radioAdd= new JRadioButton();
    private JRadioButton radioSous= new JRadioButton();
    private JRadioButton radioMult= new JRadioButton();
    private JRadioButton radioDiv= new JRadioButton();
    private JPanel panRadio = new JPanel();

    public Calculatrice(){
        panSaisi.setLayout(new GridLayout(1,4));

        panSaisi.add(btn);
        panSaisi.add(label1);
        panSaisi.add(Nombre1);
        panSaisi.add(label2);
        panSaisi.add(Nombre2);

        panCheckBox.add(checkBox,BorderLayout.CENTER);

        //panel de button radio
        radioAdd.setText("Addition");
        btnGroup.add(radioAdd);

        radioSous.setText("Soustraction");
        btnGroup.add(radioSous);

        radioMult.setText("Multiplication");
        btnGroup.add(radioMult);

        radioDiv.setText("Division");
        btnGroup.add(radioDiv);
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Opération");
        titledBorder.setTitleJustification(TitledBorder.DEFAULT_JUSTIFICATION);
        panRadio.setBorder(BorderFactory.createCompoundBorder(titledBorder, new EmptyBorder(10, 10, 10, 10)));

        //ajouter le button radio a panel panRadio
        panRadio.add(radioAdd);
        panRadio.add(radioSous);
        panRadio.add(radioMult);
        panRadio.add(radioDiv);
        panCheckBox.add(panRadio);

        panRadio.setLayout(new GridLayout(1,4));


        //ajouter les composent a fenetre
        this.setTitle("Caluclatrice");
        this.setLayout(new BorderLayout());
        this.add(panSaisi,BorderLayout.NORTH);

        this.add(panCheckBox,BorderLayout.CENTER);
        //this.add(panRadio,BorderLayout.CENTER);
        //this.getContentPane().add(panRadio);
        // Paramètres : top, left, bottom, right
        this.getRootPane().setBorder(new EmptyBorder(10, 10, 20, 10));

        this.setSize(500,300);
        this.setVisible(true);
    }



}
