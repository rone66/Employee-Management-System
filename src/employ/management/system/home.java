
package employ.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class home extends JFrame implements ActionListener{
    JButton view,update,add,remove;
    home(){
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/home1.jpg"));
        Image i2= i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading= new JLabel("Employee Management System");
        heading.setBounds(350, 20, 400, 40);
        heading.setFont(new Font("Raieway",Font.BOLD,25));
        heading.setForeground(Color.BLACK);
        image.add(heading);
        
        add= new JButton("Add Employee");
        add.setBounds(450, 100, 150, 40);
        add.addActionListener(this);
        image.add(add);
        
        view= new JButton("View Employees");
        view.setBounds(450, 170, 150, 40);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.addActionListener(this);
        image.add(view);
        
        update= new JButton("Update Employee");
        update.setBounds(450, 240, 150, 40);
        update.addActionListener(this);
        image.add(update);
        
        remove= new JButton("Remove Employee");
        remove.setBounds(425, 310, 200, 40);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(this);
        image.add(remove);
        
        
        
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
           setVisible(false);
           new addEmployee(); 
        }else if(ae.getSource()==update){
             setVisible(false);
            new ViewEmployee();
        }else if(ae.getSource()== view){
            setVisible(false);
            new ViewEmployee();
        }else if(ae.getSource()== remove){
            setVisible(false);
            new RemoveEmployee();
        }
      
        
    }
    public static void main(String[] args){
        new home();
    }
    
    
}
