package MastersTestCases;

public class demo12345 {
	

public void m1(){
	int count=10;
	if(count==0)
	{
		System.out.println("No retailers found in the list");
	}
	else
	{
		for(int i=1;i<=count;){
		String abc="Activated";
		if(i==count){
			if(abc.equalsIgnoreCase("Activated")){
				System.out.println("Get all the values(retailers/");
				System.out.println("Click on open ");
			}
				
				else{
					System.out.println("Click on Next button");
					System.out.println(i);
					i=1;
					count=10;
				}
			
		}
		/*else if(count==0){
			System.out.println("By using soft assert and write fail message ");
			break;
			
		}*/
		else{
			if(abc.equalsIgnoreCase("Activated")){
				System.out.println("Get all the values(retailers/");
				System.out.println("Click on open ");
				
				break;
			}
			else{
				System.out.println("When i is  less than count and abc value is not activated");
				i++;
				//abc="Activated";
			}
			
		}
			
		
	}
	}
}
public static void main(String[] args) {
	
	demo12345 a=new demo12345();
	a.m1();
	
}
}



