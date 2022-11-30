
package employ.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class RemoveEmployee extends JFrame implements ActionListener  {
    Choice cempid;
    JButton delete,back;
    RemoveEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempid=new JLabel("Employee id");
        labelempid.setBounds(50, 50, 100, 30);
        add(labelempid);
        
        cempid=new Choice();
        cempid.setBounds(150,55,120,30);
        add(cempid);
        try{
            conn c=new conn();
            String query="select * from employee";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        JLabel labelph=new JLabel("phone no.");
        labelph.setBounds(50, 150, 100, 30);
        add(labelph);
        
        JLabel lblph=new JLabel();
        lblph.setBounds(200, 150, 100, 30);
        add(lblph);
        
        JLabel labeleml=new JLabel("Email ");
        labeleml.setBounds(50, 200, 100, 30);
        add(labeleml);
        
        JLabel lbleml=new JLabel();
        lbleml.setBounds(200, 200, 150, 30);
        add(lbleml);
        
         try{
            conn c=new conn();
            String query="select * from employee where empid ='"+cempid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
               lblname.setText(rs.getString("name"));
               lblph.setText(rs.getString("ph"));
               lbleml.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
    
        cempid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                 try{
                    conn c=new conn();
                    String query="select * from employee where empid ='"+cempid.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    while(rs.next()){
                        lblname.setText(rs.getString("name"));
                        lblph.setText(rs.getString("ph"));
                        lbleml.setText(rs.getString("email"));
            }
                }catch(Exception e){
                    e.printStackTrace();
            
                }
            }
        });  
        
        delete=new JButton ("delete");
        delete.setBounds(220, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back=new JButton("Back");
        back.setBounds(440, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/delete2.jpg"));
        Image i2= i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,600,400);
        add(image);
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
        public void actionPerformed(ActionEvent ae){
             if(ae.getSource()==delete){
                  try{
                 conn c = new conn();
                 String query="delete from employee where empid='"+cempid.getSelectedItem()+"'";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Employee information deleted sucessfully");
                 setVisible(false);
                 new home();
                 
             }catch(Exception e){
                 
                 e.printStackTrace();
             }
             }else{
                 setVisible(false);
                 new home();
             }
        }
    
    public static void main(String[] args){
        new RemoveEmployee();
}
}
