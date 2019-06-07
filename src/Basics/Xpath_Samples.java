package Basics;

public class Xpath_Samples {

	public static void main(String[] args) {

		
		//Username---- //input[@name= 'username']
		//pwd-----  //input[@name= 'password']     or    //input[contains(@name,'password')]
		//Loginn btn -------- 	//input[@type='submit' and @value= 'Login']
		
		
		//Links----- //a[text()= 'Pricing']    or  //a[contains(text(),'Pricing')]
		
		//To get the xpath of dynamic table based on preceding sibling
		//a[contains(text(),'Mohan AC')]//parent::td[@class='datalistrow']//preceding-sibling::td/input[@name= 'contact_id']
		
		

	}

}
