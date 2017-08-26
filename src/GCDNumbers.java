import java.util.Scanner;

public class GCDNumbers {

	public static void main(String[] args) {
		int num1, num2;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the first number: ");
		num1 = sc.nextInt();
		System.out.println("Please enter the second number: ");
		num2 = sc.nextInt();
		
		int gcd = GcdNumbers(num1,num2);
		System.out.println("The GCD is: " + gcd);
		
		sc.close();
	}
	
	public static int GcdNumbers(int number1, int number2){
		if(number2 == 0){
			return number1;
		}
		return GcdNumbers(number2, number1%number2);
	}

}

