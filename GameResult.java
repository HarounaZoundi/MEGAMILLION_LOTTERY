import javax.swing.JOptionPane;
public class GameResult
{
   private int numb;
   private boolean bool;
   private int[] array;
   /*
      constuctor
   */
   public GameResult(int numb, boolean bool)
   {
      this.numb = numb;
      this.bool = bool;
      
   }
   
   public String showNumbers(int[] ar, int n)
   {
      String s = "";
      for(int item :ar )
         s+= item + "  " ; 
      return s + " MEGA "+ n;
   }
   
   public void showResult()
   {
      //bool = true;
      if (bool)
      {
         switch (numb)
         {
            case 5:
               JOptionPane.showMessageDialog(null,"You win the Jacpot"); 
               break;
            case 4:
               JOptionPane.showMessageDialog(null,"You win $5,000"); 
               break;
            case 3:
               JOptionPane.showMessageDialog(null,"You win $50"); 
               break;
         
            case 2:
               JOptionPane.showMessageDialog(null,"You win $5"); 
               break;
         
            case 1:
               JOptionPane.showMessageDialog(null,"You win $2"); 
               break;
            case 0:
               JOptionPane.showMessageDialog(null,"You win $1"); 
               break;
         }  
      
      }
      else
      {
         switch (numb)
         {
            case 5:
               JOptionPane.showMessageDialog(null,"You win $1,000,000");
               break; 
            case 4:
               JOptionPane.showMessageDialog(null,"You win $500"); 
               break;
            case 3:
               JOptionPane.showMessageDialog(null,"You $5"); 
               break;
         
            default:
               JOptionPane.showMessageDialog(null,"Sorry today is not your lucky day"); 
               break;
         }
         
      }
      
      
   }

}