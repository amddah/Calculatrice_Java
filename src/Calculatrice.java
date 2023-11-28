import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        //defini action commande
        radioDiv.setActionCommand("Division");
        radioMult.setActionCommand("Multiplication");
        radioSous.setActionCommand("Soustraction");
        radioAdd.setActionCommand("Addition");

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

        // Paramètres : top, left, bottom, right
        this.getRootPane().setBorder(new EmptyBorder(10, 10, 20, 10));

        this.setSize(500,300);
        this.setVisible(true);

        //d'implémenter ActionListener

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //recupere le nombre dans TextField
                String value1 = Nombre1.getText();
                String value2 = Nombre2.getText();
                double nbr1 =Double.parseDouble(value1);
                double nbr2 =Double.parseDouble(value2);
                // Récupère la commande associée au modèle du bouton radio sélectionné
                String operation = btnGroup.getSelection().getActionCommand();
                // Vérifie si la case à cocher est cochée
                boolean sansvirgule= checkBox.isSelected();

                if ("Addition".equals(operation)) {
                    double somme = nbr2 + nbr1;
                    // si la case à cocher est cochée affiche le resultat en entier
                        AfficheResultat( sansvirgule ? String.valueOf((int) somme) :String.valueOf(somme));
                } else if ("Soustraction".equals(operation)) {
                    double difference = nbr1 - nbr2;
                    AfficheResultat(sansvirgule ? String.valueOf((int) difference) : String.valueOf(difference));
                } else if ("Multiplication".equals(operation)) {
                    double produit = nbr2 * nbr1;
                    AfficheResultat(sansvirgule ? String.valueOf((int) produit) : String.valueOf(produit));
                } else if ("Division".equals(operation)) {
                    // Gérer la division (vérifier la division par zéro, etc.)
                    if (nbr1 != 0) {
                        double quotient = nbr2 / nbr1;
                        AfficheResultat(sansvirgule ? String.valueOf((int) quotient) :String.valueOf(quotient));
                    } else {
                        // Gérer la division par zéro
                        AfficheResultat(String.valueOf(Double.NaN));
                    }
                }



            }
        });

    }

    public void AfficheResultat(String resultat){
        JOptionPane.showMessageDialog(this,resultat,"Information ",JOptionPane.INFORMATION_MESSAGE);
    }



}
