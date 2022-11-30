
package employ.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    
    JTextField tusername,tpassword;
    
    login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //username label
        JLabel lblusername= new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        //username textbox
        tusername= new JTextField();
        tusername.setBounds(150, 20, 200, 30);
        add(tusername);
        
        //password label
        JLabel lblpassword= new JLabel("Password");
        lblpassword.setBounds(40, 80, 100, 30);
        add(lblpassword);
        
        //password textbox
        tpassword= new JTextField();
        tpassword.setBounds(150, 80, 200, 30);
        add(tpassword);
        
        //password instructions label
        JLabel lblspl= new JLabel("(ADMIN ONLY)");
        lblspl.setBounds(40, 0, 500, 30);
        lblspl.setForeground(Color.RED);
        add(lblspl);
        
        //login button
        JButton login=new JButton("login");
        login.setBounds(150, 160, 150, 30);
        login.setBackground(Color.LIGHT_GRAY);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/admin.jpg"));
        Image i2= i1.getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(370,0,200,250);
        add(image);
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username=tusername.getText();
            String password=tpassword.getText();
            
            conn c=new conn();
            String query="select * from login where username= '"+username+"'and password='"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new home();
            }else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(true);
            }
        }
        catch(Exception e){
  
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new login();
    }
}

   


