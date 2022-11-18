package org.example.DAOImplClasses;
import org.example.DAOInterfaces.UserInterface;
import org.example.DBConnection;
import org.example.Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserImpl implements UserInterface {
    Scanner scanObj=new Scanner(System.in);
    @Override
    public void userRegistration() {
        Connection connection= DBConnection.getConnection();
        User x=null;
        System.out.println("Please Fill Following Information for Registration...!!!");
        System.out.println("Enter Your Full Name ");
        String name=scanObj.nextLine();
        System.out.println("Enter Your Mobile Number Starts with (+91)");
        String mobNo=scanObj.next();
        Pattern pattern=Pattern.compile("[+](91)[0-9]{10}$");
        Matcher m= pattern.matcher(mobNo);
        if (m.find() && m.group().equals(mobNo)){
            System.out.println("Enter Valid Email Id");
            String email=scanObj.next();
            System.out.println("Enter Your Age");
            int age=scanObj.nextInt();
            System.out.println("Enter Your City");
            String city=scanObj.next();
            Random rand=new Random();
            long Uid = (rand.nextInt(1000000) + 1000000000l) * (rand.nextInt(900) + 100);
            System.out.println("Please Create Password");
            String passwrd=scanObj.next();
            try {
                String query = "insert into User(Uid,passwrd,uname,mob,email,age,city) values(?,?,?,?,?,?,?);";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setLong(1,Uid);
                preparedStatement.setString(2,passwrd);
                preparedStatement.setString(3, name);
                preparedStatement.setString(4, mobNo);
                preparedStatement.setString(5, email);
                preparedStatement.setInt(6, age);
                preparedStatement.setString(7, city);
                int row = preparedStatement.executeUpdate();
                System.out.println("Congratulations...!!! Your Have Registered Successfully...!!!");
                System.out.println("Your User Id will be :"+Uid);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else {
            System.out.println("Invalid Mobile Number, Please Try Again...!!!");
        }
    }
}
