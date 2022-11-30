
package employ.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateEmployee extends JFrame implements ActionListener {
  
    JButton bck,sub;
    JTextField name,fname,fsal,fadrs,feml,fphn,fdes,tfhe;
    String empid;
    JLabel lblei,fadd;
    
   UpdateEmployee(String empid){
        this.empid=empid;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/adde10.jpg"));
        Image i2= i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading= new JLabel("Update Employee Details");
        heading.setBounds(30, 20, 400, 40);
        heading.setFont(new Font("Raieway",Font.BOLD,20));
        heading.setForeground(Color.BLACK);
        image.add(heading);
        
        JLabel lblname= new JLabel("Name");
        lblname.setBounds(30, 80, 100, 30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        lblname.setForeground(Color.BLACK);
        image.add(lblname);
        
        JLabel labelname= new JLabel();
        labelname.setBounds(90, 80,150, 30);
        image.add(labelname);
        
        JLabel lblfname= new JLabel("Father's Name");
        lblfname.setBounds(30, 120, 200, 30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        lblfname.setForeground(Color.BLACK);
        image.add(lblfname);
        
        fname= new JTextField();
        fname.setBounds(170, 120, 150, 30);
        image.add(fname);
        
        JLabel lbldob= new JLabel("Date of Birth");
        lbldob.setBounds(30, 160, 200, 30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        lbldob.setForeground(Color.BLACK);
        image.add(lbldob);
        
       
        
        JLabel labldob= new  JLabel();
        labldob.setBounds(150, 160, 150, 30);
        image.add(labldob);
        
        JLabel lblsalary= new JLabel("Salary");
        lblsalary.setBounds(30, 200, 200, 30);
        lblsalary.setFont(new Font("serif",Font.BOLD,20));
        lblsalary.setForeground(Color.BLACK);
        image.add(lblsalary);
        
        fsal= new JTextField();
        fsal.setBounds(150, 200, 170, 30);
        image.add(fsal);
        
        JLabel lbladrs= new JLabel("Address");
        lbladrs.setBounds(30, 240, 200, 30);
        lbladrs.setFont(new Font("serif",Font.BOLD,20));
        lbladrs.setForeground(Color.BLACK);
        image.add(lbladrs);
        
        fadrs= new JTextField();
        fadrs.setBounds(150, 240, 200, 30);
        image.add(fadrs);
        
        JLabel lbleml= new JLabel("Email");
        lbleml.setBounds(30, 280, 200, 30);
        lbleml.setFont(new Font("serif",Font.BOLD,20));
        lbleml.setForeground(Color.BLACK);
        image.add(lbleml);
        
        feml= new JTextField();
        feml.setBounds(150, 280, 200, 30);
        image.add(feml);
        
        JLabel lblph= new JLabel("Phone no.");
        lblph.setBounds(30, 320, 200, 30);
        lblph.setFont(new Font("serif",Font.BOLD,20));
        lblph.setForeground(Color.BLACK);
        image.add(lblph);
        
        fphn= new JTextField();
        fphn.setBounds(150, 320, 180, 30);
        image.add(fphn);
        
        JLabel lblhe= new JLabel("Higher Education");
        lblhe.setBounds(30, 360, 200, 30);
        lblhe.setFont(new Font("serif",Font.BOLD,20));
        lblhe.setForeground(Color.BLACK);
        image.add(lblhe);
        
       
        tfhe= new JTextField();
        tfhe.setBackground(Color.WHITE);
        tfhe.setBounds(200, 360, 200, 30);
        image.add(tfhe);
        
        JLabel lbldesignation= new JLabel("Designation");
        lbldesignation.setBounds(30, 400, 200, 30);
        lbldesignation.setFont(new Font("serif",Font.BOLD,20));
        lbldesignation.setForeground(Color.BLACK);
        image.add(lbldesignation);
        
        fdes= new JTextField();
        fdes.setBounds(150, 400, 200, 30);
        image.add(fdes);
        
        JLabel lbladdhr= new JLabel("Adhaar No.");
        lbladdhr.setBounds(30, 440, 200, 30);
        lbladdhr.setFont(new Font("serif",Font.BOLD,20));
        lbladdhr.setForeground(Color.BLACK);
        image.add(lbladdhr);
        
        fadd= new JLabel();
        fadd.setBounds(150, 440, 200, 30);
        image.add(fadd);
        
        JLabel lbleid= new JLabel("Employee id");
        lbleid.setBounds(880,50, 200, 30);
        lbleid.setFont(new Font("serif",Font.BOLD,20));
        lbleid.setForeground(Color.BLACK);
        image.add(lbleid);
        
        lblei= new JLabel();
        lblei.setBounds(990, 50, 200, 30);
        lblei.setFont(new Font("serif",Font.BOLD,20));
        lblei.setForeground(Color.BLACK);
        image.add(lblei);
        
        
        try{
            conn c=new conn();
            String query="select * from employee where empid='"+empid+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                fname.setText(rs.getString("fname"));
                labldob.setText(rs.getString("dob"));
                fsal.setText(rs.getString("salary"));
                fadrs.setText(rs.getString("address"));
                feml.setText(rs.getString("email"));
                fphn.setText(rs.getString("ph"));
                fdes.setText(rs.getString("designation"));
                fadd.setText(rs.getString("adhaar"));
                tfhe.setText(rs.getString("highereducation"));
                lblei.setText(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        sub=new JButton("Update");
        sub.setBounds(400, 530, 100, 30);
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.addActionListener(this);
        image.add(sub);
        
        bck=new JButton("Back");
        bck.setBounds(600, 530, 100, 30);
        bck.setBackground(Color.BLACK);
        bck.setForeground(Color.WHITE);
        bck.addActionListener(this);
        image.add(bck);
        
        /*image.setSize(400,400);
        image.setLocation(900, 80);
        image.setVisible(true);*/
        
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==bck){
             setVisible(false);
             new home();
         }else{
               
                String fnme=fname.getText();
                String sal=fsal.getText();
                String add=fadrs.getText();
                String eml=feml.getText();
                String ph=fphn.getText();
                String hi=tfhe.getText();
                String des=fdes.getText();
              

             try{
                 conn c = new conn();
                 String query="UPDATE  employee SET fname='"+fnme+"',salary='"+sal+"',address='"+add+"',email='"+eml+"',ph='"+ph+"',highereducation='"+hi+"',designation='"+des+"' where empid='"+empid+"'";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Details updated successfully");
                 setVisible(false);
                 new home();
                 
             }catch(Exception e){
                 
                 e.printStackTrace();
            }
        }
    }

    
    public static void main(String[] args){
        new UpdateEmployee("");
   }
}
