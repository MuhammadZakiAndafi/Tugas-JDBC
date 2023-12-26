import java.util.Scanner;

public class Login {
    String user = "zaki";
    String password = "andafi123";
    String captcha = "qwaszx";
    String inputCaptcha;
    String inputUser;
    String inputPassword;
    
    //method login
    public void login(){
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("~~~~~~~~~~~~~~ L O G I N ~~~~~~~~~~~~~~");

    //Password
    while(true){
        System.out.println("Inputkan Username");
        inputUser = scanner.next();
        System.out.println("Inputkan Password");
        inputPassword = scanner.next();
            
    if (inputPassword.equals(password)&&inputUser.equals(user)){
        System.out.println("_______  L O G I N   S U K S E S  _______\n\n");
        break;
    }else{
        System.out.println("Username atau password anda salah \n");
        }
    }
            
    //Captcha
    System.out.println("Kode captcha = " + captcha);
    System.out.println("Masukkan captcha");
    inputCaptcha = scanner.next();
    
    while(!inputCaptcha.equalsIgnoreCase(captcha)){
        System.out.println("Kode captcha salah!!!!!\n");
        System.out.println("Masukkan captcha");
        inputCaptcha = scanner.next();
        }
    
    System.out.println("CAPTCHA BENAR, ANDA MANUSIA\n\n");
    }
}

