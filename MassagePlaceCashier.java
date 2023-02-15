import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MassagePlaceCashierApp extends JFrame implements ActionListener {
    
    JLabel clientLabel, therapistLabel, treatmentLabel, durationLabel, dateLabel, timeLabel, totalLabel;
    JTextField clientTextField, therapistTextField, treatmentTextField, durationTextField, dateTextField, timeTextField, totalTextField;
    JButton submitButton;
    String therapistNames[] = {"ucok", "bilal", "kurnia", "kotul"};
    String treatments[] = {"urut", "pijat", "kerok"};
    double treatmentPrices[] = {10, 15, 12};
    
    public MassagePlaceCashierApp() {
        // Set up the frame
        setTitle("Massage Place Cashier App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        // Add labels and text fields for client, therapist, treatment, duration, date, time, and total
        clientLabel = new JLabel("Client Name:");
        therapistLabel = new JLabel("Therapist Name:");
        treatmentLabel = new JLabel("Treatment:");
        durationLabel = new JLabel("Duration:");
        dateLabel = new JLabel("Date:");
        timeLabel = new JLabel("Time:");
        totalLabel = new JLabel("Total:");
        
        clientTextField = new JTextField();
        therapistTextField = new JTextField();
        treatmentTextField = new JTextField();
        durationTextField = new JTextField();
        dateTextField = new JTextField();
        timeTextField = new JTextField();
        totalTextField = new JTextField();
        
        // Set the location and size of each component
        clientLabel.setBounds(10, 20, 100, 20);
        clientTextField.setBounds(120, 20, 200, 20);
        
        therapistLabel.setBounds(10, 50, 100, 20);
        therapistTextField.setBounds(120, 50, 200, 20);
        
        treatmentLabel.setBounds(10, 80, 100, 20);
        treatmentTextField.setBounds(120, 80, 200, 20);
        
        durationLabel.setBounds(10, 110, 100, 20);
        durationTextField.setBounds(120, 110, 200, 20);
        
        dateLabel.setBounds(10, 140, 100, 20);
        dateTextField.setBounds(120, 140, 200, 20);
        
        timeLabel.setBounds(10, 170, 100, 20);
        timeTextField.setBounds(120, 170, 200, 20);
        
        totalLabel.setBounds(10, 200, 100, 20);
        totalTextField.setBounds(120, 200, 200, 20);
        totalTextField.setEditable(false);
        
        // Add a submit button
        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 230, 100, 30);
        submitButton.addActionListener(this);
        
        // Add all the components to the frame
        add(clientLabel);
        add(clientTextField);
        add(therapistLabel);
        add(therapistTextField);
        add(treatmentLabel);
        add(treatmentTextField);
        add(durationLabel);
        add(durationTextField);
        add(dateLabel);
        add(dateTextField);
        add(timeLabel);
        add(timeTextField);
        add(totalLabel);
        add(totalTextField);
        add(submitButton);
    
    // Display the frame
    setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submitButton) {
        // Calculate the total price based on the selected treatment and duration
        int duration = Integer.parseInt(durationTextField.getText());
        double price = 0;
        switch (treatmentTextField.getText()) {
            case "urut":
                price = treatmentPrices[0];
                break;
            case "pijat":
                price = treatmentPrices[1];
                break;
            case "kerok":
                price = treatmentPrices[2];
                break;
        }
        double total = price * duration;
        
        // Set the total price in the total text field
        totalTextField.setText("$" + total);
    }
}

public static void main(String[] args) {
    // Create a new instance of the app
    MassagePlaceCashierApp app = new MassagePlaceCashierApp();
    
    // Set the therapist names as options for the therapist text field
    String therapistOptions = "";
    for (String therapist : app.therapistNames) {
        therapistOptions += therapist + ",";
    }
    app.therapistTextField.setText(therapistOptions.substring(0, therapistOptions.length() - 1));
    
    // Set the treatment names as options for the treatment text field
    String treatmentOptions = "";
    for (String treatment : app.treatments) {
        treatmentOptions += treatment + ",";
    }
    app.treatmentTextField.setText(treatmentOptions.substring(0, treatmentOptions.length() - 1));
    
    // Set the current date and time in the date and time text fields
    Date now = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    app.dateTextField.setText(dateFormat.format(now));
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    app.timeTextField.setText(timeFormat.format(now));
}
