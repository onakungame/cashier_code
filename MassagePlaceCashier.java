import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MassagePlaceApp extends JFrame implements ActionListener {

    private JLabel title, treatment, therapist;
    private JCheckBox urut, kerok, refleksi;
    private JComboBox<String> therapistList;
    private JButton submit, reset;
    private double totalPrice = 0;

    public MassagePlaceApp() {
        super("MESIN KASIR");

        // Initialize the components
        title = new JLabel("MESIN KASIR PANTI PIJAT");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(20, 10, 300, 30);

        treatment = new JLabel("Pilih jenis perawatan : ");
        treatment.setBounds(20, 50, 200, 30);

        urut = new JCheckBox("Urut (Rp 15.000)");
        urut.setBounds(20, 80, 150, 30);

        kerok = new JCheckBox("Kerok (Rp 20.000)");
        kerok.setBounds(20, 110, 150, 30);

        refleksi = new JCheckBox("Refleksi (Rp 25.000)");
        refleksi.setBounds(20, 140, 150, 30);

        therapist = new JLabel("Pilih terapis : ");
        therapist.setBounds(20, 180, 200, 30);

        String[] therapists = {"Ujang", "Sudiro", "Poltak", "Ucok"};
        therapistList = new JComboBox<>(therapists);
        therapistList.setBounds(20, 210, 150, 30);

        submit = new JButton("Submit");
        submit.setBounds(20, 250, 100, 30);
        submit.addActionListener(this);

        reset = new JButton("Reset");
        reset.setBounds(130, 250, 100, 30);
        reset.addActionListener(this);

        // Add the components to the frame
        add(title);
        add(treatment);
        add(urut);
        add(kerok);
        add(refleksi);
        add(therapist);
        add(therapistList);
        add(submit);
        add(reset);

        // Set the frame properties
        setLayout(null);
        setVisible(true);
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            totalPrice = 0;

            if (urut.isSelected()) {
                totalPrice += 15000;
            }
            if (kerok.isSelected()) {
                totalPrice += 20000;
            }
            if (refleksi.isSelected()) {
                totalPrice += 25000;
            }

            JOptionPane.showMessageDialog(this, "Total Harga : Rp " + totalPrice);
        } else if (e.getSource() == reset) {
            urut.setSelected(false);
            kerok.setSelected(false);
            refleksi.setSelected(false);
            therapistList.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new MassagePlaceApp();
    }
}
