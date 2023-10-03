import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PrincipalWindow extends JFrame {
    
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfFirstName;
    JLabel lbmenu; 
    JPanel infoPanel = new JPanel(); 

    public void initialize(){
        //Label inicio
        /*JLabel lbFirstName = new JLabel("First name");
        lbFirstName.setFont(mainFont);
        
        tfFirstName = new JTextField(); 
        tfFirstName.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 4));
        formPanel.add(lbFirstName);
        formPanel.add(tfFirstName);
        */
         
        //Label welcome
        lbmenu = new JLabel(); 
        lbmenu.setFont(mainFont);
    
        //Buttons 
        //Button creation
        JButton historyb = new JButton("History mode");
        historyb.setFont(mainFont);
        historyb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //String fname = tfFirstName.getText();
                lbmenu.setText("Te debe llevar al modo historia");
            }
            
        });
        JButton infob = new JButton("Informacion sobre los personajes");
        infob.setFont(mainFont);
        infob.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //String fname = tfFirstName.getText();
                lbmenu.setText("Te debe llevar a la info de los personajes");
                add(infoPanel);
                
                
            }
            
        });
        //Adding buttons to a panel
        JPanel buttonsPanel = new JPanel(); 
        buttonsPanel.setLayout(new GridLayout(2, 1, 3, 3));
        buttonsPanel.add(historyb);
        buttonsPanel.add(infob);





        //Label principal
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());                    //
        menuPanel.setBackground(new Color(128, 128, 255));
        //mainPanel.add(formPanel, BorderLayout.NORTH);
        menuPanel.add(lbmenu, BorderLayout.CENTER);
        menuPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(menuPanel);
        //Extra config to the main panel
        setTitle("Welcome");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);





    }





     public static void main(String[] args){
        PrincipalWindow pw = new PrincipalWindow();
        pw.initialize();
    }

}
