
package employ.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{
    
    JTable table;
    Choice emid;
    JButton search,print,update,back;
    
    ViewEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        table= new JTable();
        JLabel searchlbl= new JLabel("search Employee id:");
        searchlbl.setBounds(20, 20, 130, 20);
        add(searchlbl);
        
        emid=new Choice();
        emid.setBounds(150,20, 150, 20);
        add(emid);
        
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            
            while(rs.next()){
                emid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane js=new JScrollPane(table);
        js.setBounds(0, 100, 900, 600);
        add(js);
        
        search=new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        
        
        print=new JButton("Print");
        print.setBounds(260, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update=new JButton("Update");
        update.setBounds(540, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBounds(790, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from employee where empid='"+emid.getSelectedItem()+"'";
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()== print){
            try{
                table.print();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
           setVisible(false);
            new UpdateEmployee(emid.getSelectedItem());
            
        }else{
            setVisible(false);
            new home();
        }
    }
    
    public static void main(String[] args){
        new ViewEmployee();
    }
}
