package Tatocautomation;

import java.util.Random;

public class dice {

	private int showthedicenumber;
	public dice(int showthedicenumber)
	{
		this.showthedicenumber = showthedicenumber;
	}

	public String rollthedice() 
			{
			 Random random = new Random(); 
			 String[] number= {"one","two","three","four","five","six"};
             String[] word= {"head","tail"};   
        if (this.showthedicenumber == 2)
        {
        	int  result = random.nextInt(this.showthedicenumber);
            return word[result];
        }
		
		else
		{
			int  output1 = random.nextInt(this.showthedicenumber);
			return( number[output1]);
		}
			}
		public static void main(String[] args) {
			dice dice = new dice(6);
			System.out.println("number or word on dice = "+ dice.rollthedice());
}
}

	