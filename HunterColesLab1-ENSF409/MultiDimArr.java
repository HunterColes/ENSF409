import java.util.Scanner;

public class MultiDimArr {

	private char[][] arr;
	private char[] src;
	int length;
	int space;
	
	public MultiDimArr(String input)
	{
		length = input.length();
		src = input.toCharArray();
		arr = new char[3][60];
	}
	
	public void loader()
	{
		//part 1
		for(int i = 0; i<length; i++)
		{
	     arr[0][i] = src[length - 1 - i];
	     if(src[i] == 32) space++;     
	     
		}
		//part 2
		int j = 0;
		while(space!= -1)
		{
			int temp = 0;
		 for(int i = 0; i< length; i++)
		 {
				if(src[i]==32) 	temp++;
				if(temp == space && src[i]!=32) 	arr[1][j++] = src[i];	 
		 }
		 arr[1][j++]=32;
		 space--;
		}
		//part 3
		for(int i = 0; i<length; i++)
		{
	     arr[2][i] = src[i];
	     if(i % 5 == 0 && Character.isLetter(src[i]) && i!= 0)
	    	arr[2][i] = Character.toUpperCase(arr[2][i]);
		}
	}
 	public void print()
 	{
 		System.out.println("the contest of the array are:");
 		for(int i = 0;i<3;i++)
 		{
 		for(int j = 0; j< length;j++)
 			System.out.print(arr[i][j]);
 		System.out.println();
 		}
 	}
	
	public static void main(String[] args)
	{
		String input;
		Scanner scan = new Scanner(System.in);	
		System.out.println("Please enter your sentance you would like to have stored in an array:");
		input = scan.nextLine(); 
		MultiDimArr source = new MultiDimArr(input);
		source.loader();
		source.print();
	}
}