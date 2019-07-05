
import javax.swing.*;
import java.awt.event.*;// need for actionListener
import java.awt.*;
import java.util.Random;
import java.text.DecimalFormat;

public class MegaMillionsGUI extends JFrame
{
 
   private int[] computerNum = new int[5];
   private int[] userNum = new int[5];
   private int[] winningNum = new int[5];
   private int winningMega;
   private int computerMega ;
   private int userMega ;
   
   private JPanel topPanel;
   private JPanel bottomPanel;
   private JPanel centerPanel;


   private JTextField field1;   
   private JTextField field2;
   private JTextField field3;
   private JTextField field4;
   private JTextField field5;
   private JTextField field6;
   
   private JLabel messageLabel; 
   
   private JButton playButton;
   private JButton resetButton;
   private JButton autoButton;
   private JButton infoButton;

 
 
   private final int WINDOW_WIDTH = 450;
   private final int WINDOW_HEIGHT = 160;
   
   public MegaMillionsGUI()
   {
      setTitle("MEGA MILLION LOTORY");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
           
        
      // set border Layut
      setLayout(new BorderLayout());
      buildTopPanel();      
      add(topPanel, BorderLayout.NORTH);
      
      buildCenterPanel();      
      //adding the panel to the north border
      add(centerPanel, BorderLayout.CENTER);
     // add(topPanel);
      buildBottonPanel();    
       
     // add(bottomPanel);
    //adding the panel to the south border
      add(bottomPanel, BorderLayout.SOUTH);
      getContentPane().setBackground(Color.CYAN);
   
   
      setVisible(true); 
         
   
   }
   private void buildTopPanel()
   {
     //creating the panel
      topPanel = new JPanel();
      infoButton = new JButton("Game details");
      
      infoButton.addActionListener(new ButtonListener());        
      topPanel.add(infoButton);
      topPanel.setBackground(Color.CYAN);
   
   
         
   }
   private void buildCenterPanel()
   {
       //creating the panel
      centerPanel = new JPanel();
      
      messageLabel = new JLabel("Enter your numbers to play:"); 
      //messageLabel.setForeground(Color.GREEN);
                
      field1 = new JTextField(3);
      field2 = new JTextField(3);
      field3 = new JTextField(3); 
      field4 = new JTextField(3); 
      field5 = new JTextField(3); 
      field6 = new JTextField(3); 
      
      field6.setBackground(Color.YELLOW);
   
      centerPanel.add(messageLabel);
      centerPanel.add(field1);      
      centerPanel.add(field2);
      centerPanel.add(field3);
      centerPanel.add(field4);
      centerPanel.add(field5);
      centerPanel.add(field6);
      
      centerPanel.setBackground(Color.CYAN);
   
   
   
   }
   private void buildBottonPanel()
   {
       //creating the panel
      bottomPanel = new JPanel();
        //setting Layout manager to the panel
      bottomPanel.setLayout(new FlowLayout());
      playButton = new JButton("Play");
      resetButton = new JButton("Reset");     
      autoButton = new JButton("Auto play");
   
      resetButton.setBackground(Color.RED);
      playButton.setBackground(Color.GREEN);
      autoButton.setBackground(Color.YELLOW);
   
      playButton.addActionListener(new ButtonListener());
      resetButton.addActionListener(new ButtonListener());  
      autoButton.addActionListener(new ButtonListener());  
   
      bottomPanel.add(resetButton);      
      bottomPanel.add(playButton);
      bottomPanel.add(autoButton);
      
      bottomPanel.setBackground(Color.CYAN);
   
   
   
   }
   private class ButtonListener implements ActionListener
   {
     
      public void actionPerformed(ActionEvent e)
      {
         String actionComand = e.getActionCommand();
         
         getContentPane().setBackground(Color.GRAY);
         
         if(actionComand.equals("Game details"))
         {
            JOptionPane.showMessageDialog(null,"The Lottery game in "+
               "which the ticket purchaser selects, \nor has the computer randomly"+
               "assign five (5)” different \n“numbers from Field 1 which includes "+
               "a range of consecutivenumbers \nfrom one (1) to fifty-six (56) and one"+
               " (1) number from Field 2 which includes\n arange of consecutive numbers "+
               "from one (1) to forty-six (46), shall be called MEGAMILLIONS\n"+
               "Enter your numbers and press the bottom Play\n"+
               "By pressing autoPlay the computer selects numbers for you\n"+
               "\tGOOD LUCK!!!");
         
         }
         else if(actionComand.equals("Reset"))
         { 
            field1.setText("");
            field2.setText("");
            field3.setText("");
            field4.setText("");
            field5.setText("");
            field6.setText("");
         
         }
         else if(actionComand.equals("Play"))
         {
            String input1 = field1.getText();
            userNum[0] = Integer.parseInt(input1);
              
            String input2 = field2.getText();
            userNum[1] = Integer.parseInt(input2);
                  
            String input3 = field3.getText();
            userNum[2] = Integer.parseInt(input3);  
                
            String input4 = field4.getText();
            userNum[3] = Integer.parseInt(input4); 
                 
            String input5 = field5.getText();
            userNum[4] = Integer.parseInt(input5); 
                 
            String input6 = field6.getText();
            userMega = Integer.parseInt(input6);
              
            Random ran = new Random();
              
            for (int i=0; i< winningNum.length; i++)
            {
               winningNum[i] = ran.nextInt(56)+1;
                 
            }
            winningMega = ran.nextInt(46)+1;
              //calling an object of the Compare class
            Compare game = new Compare(winningNum,userNum,winningMega,userMega);
              //calling an object of the GameResult class 
            GameResult post = new GameResult(game.compareArray(),game.compareMega());
              //print the result
            post.showResult();
            JOptionPane.showMessageDialog(null,"The winning numbers are:\n"+
                       post.showNumbers(winningNum,winningMega));   
              
              //JOptionPane.showMessageDialog(null,post.showNumbers(computerNum,winningMega));
               
               /** for(int item :userNum )
                  System.out.print(item + "," );
                System.out.println("");    
               for(int item :winningNum )
                  System.out.print(item + ",");  
                  */ 
         } 
         else if(actionComand.equals("Auto play"))
         {
            Random ran = new Random();
         
            for (int i=0; i< computerNum.length; i++)
            {
               computerNum[i] = ran.nextInt(56)+1;
                 
            }
            computerMega = ran.nextInt(46)+1;
              
            for (int i=0; i< computerNum.length; i++)
            {
               winningNum[i] = ran.nextInt(56)+1;
                 
            }
            winningMega = ran.nextInt(46)+1;
              //create an object of the Compare  clsaa
            Compare game = new Compare(computerNum,winningNum,computerMega,winningMega);
               //create an object of the GameResult class
            GameResult post = new GameResult(game.compareArray(),game.compareMega());
              // print the result 
            post.showResult();
              
            JOptionPane.showMessageDialog(null,"The winning numbers are:"+
                                   post.showNumbers(winningNum,winningMega)+
                       "\nYour numbers are:"+ post.showNumbers(computerNum,computerMega)); 
                                   
                                              
              
            //  JOptionPane.showMessageDialog(null,post.showNumbers(computerNum,winningMega));
               /**System.out.println(""); 
                 for(int item :computerNum )
                  System.out.print(item + "," );
                System.out.println("");    
               for(int item :winningNum )
                  System.out.print(item + ","); 
                  */
         }
      
        
      }
   }   
   

    /**
      main method
   */
   public static void main(String[] args)
   {
      new MegaMillionsGUI();
   }
}