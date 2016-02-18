package LPGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Solution extends JFrame {
 

  public Solution(DefaultTableModel modelV, int total) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
      JPanel jtp = new JPanel();
      jtp.setLayout(new GridLayout(1,2));
      JTextField text = new JTextField("The total weight is: ");
      JTextField answer = new JTextField(""+total);
      
      jtp.add(text);
      jtp.add(answer);
    
    JTable table = new JTable(modelV);
    this.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
    this.getContentPane().add(jtp, BorderLayout.SOUTH);
    pack();
  }

  public static void main(String arg[]) {
    //new Solution().setVisible(true);
  }
}