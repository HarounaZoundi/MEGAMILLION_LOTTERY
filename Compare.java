public class Compare
{   
   private int[] array1 ; 
   private int[] array2; 
   private int count = 0;
   private int numb1;
   private int numb2;
      /*
      constuctor
   */
   public Compare(int[] array1,int[] array2, int numb1, int numb2)
   {
      this.array1= array1;
      this.array2= array2;
      this.numb1= numb1;
      this.numb2= numb2;
   }
   // this array compare two array and return the number of mutial elements
   public int compareArray()
   {
      array2 = new int[array1.length];
      for (int i=0; i<array1.length ; i++)
      {  
         if(array1[i] == array2[i])
            count ++;
      }
      return count;
   }
   // this method compare two integer and returning
   // a boolean true if the numbers are the same
   public boolean compareMega()
   {
     
      if(numb1 == numb2)
         return true;
      else 
         return false;      
   
   }



}