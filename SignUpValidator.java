import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SignUpValidatorResult {
    public boolean isValid;
    public String errorMessage;

    public SignUpValidatorResult(boolean isValid, String errorMessage) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
    }
}

public class SignUpValidator {

    public static void main(String[] args) {
        SignUpValidator signUpValidator = new SignUpValidator();
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

     
        SignUpValidatorResult result = signUpValidator.validateSignUp(email, phoneNumber, password);

        if (result.isValid) {
            System.out.println("Sign-up successful!");
        } else {
            System.out.println("Sign-up failed. Error: " + result.errorMessage);
        }

        
        scanner.close();
    }

    public SignUpValidatorResult validateSignUp(String email, int phoneNumber, String password) {
        SignUpValidatorResult emailResult = validateEmail(email);
        SignUpValidatorResult phoneResult = validatePhoneNumber(phoneNumber);
        SignUpValidatorResult passwordResult = validatePassword(password);

        if (emailResult.isValid && phoneResult.isValid && passwordResult.isValid) {
            return new SignUpValidatorResult(true, "Validation successful");
        } else {
           
            StringBuilder errorMessage = new StringBuilder("Validation failed:");
            if (!emailResult.isValid) {
                errorMessage.append("\n").append(emailResult.errorMessage);
            }
            if (!phoneResult.isValid) {
                errorMessage.append("\n").append(phoneResult.errorMessage);
            }
            if (!passwordResult.isValid) {
                errorMessage.append("\n").append(passwordResult.errorMessage);
            }

            return new SignUpValidatorResult(false, errorMessage.toString());
        }
    }

    public SignUpValidatorResult validateEmail(String email) {
       
        String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            return new SignUpValidatorResult(true, "Email is valid");
        } else {
            return new SignUpValidatorResult(false, "Email is invalid");
        }
    }

    public SignUpValidatorResult validatePhoneNumber(int phoneNumber) {
   
        if (String.valueOf(phoneNumber).length() == 10) {
            return new SignUpValidatorResult(true, "Phone number is valid");
        } else {
            return new SignUpValidatorResult(false, "Phone number is invalid");
        }
    }

    public SignUpValidatorResult validatePassword(String password) {
      
        if (password.length() >= 8) {
            return new SignUpValidatorResult(true, "Password is valid");
        } else {
            return new SignUpValidatorResult(false, "Password is too short (minimum 8 characters)");
        }
    }
}