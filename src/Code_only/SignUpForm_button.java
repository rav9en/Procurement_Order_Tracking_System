package Code_only;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java_assginment.login_page;

public class SignUpForm_button {

    // Method to handle sign-up logic
    public void handleSignUp(String firstName, String lastName, String username, 
                             String password, String rePassword, String role) {
        // Check if passwords match
        if (!password.equals(rePassword)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the current date
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(currentDate);

        // Save user details to a file
        try (FileWriter writer = new FileWriter("src/User_data/user_data.txt", true)) {
            writer.write(firstName + "," + lastName + "," + username + "," + password + "," + role + "," + formattedDate + "\n");
            JOptionPane.showMessageDialog(null, "Registration successful!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving registration details. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Proceed to the login page
        login_page loginPage = new login_page();
        loginPage.setVisible(true);
    }
}
