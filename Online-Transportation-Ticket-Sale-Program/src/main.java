import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	
	public static void fileOpr(File cus ,File com, File vec, List<Customer> customer,List<Company> company , List<Vehicle> vehicle, VehicleFactory vehicleFactory) {
		try {
			//name,surname,gender,vehicleNumber,chosenSeatNumber,baggageInformation,amountOfMoney,email,password
			Scanner in = new Scanner(cus);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				if (line != null) {
					String[] st = line.split(",");
					customer.add(new Customer(st[0],st[1],st[2],st[3],Integer.parseInt(st[4]),Integer.parseInt(st[5]),Integer.parseInt(st[6]),st[7],st[8])) ;
				} 
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	try {
		//vehicleType,companyName,vehicleCode,date,route,price,baggage
		Scanner in = new Scanner(vec);
		while(in.hasNextLine()) {
			String line = in.nextLine();
			if (line != null) {
				String[] st = line.split(",");
				vehicle.add(vehicleFactory.getVehicle(st[0],st[1],st[2],st[3],st[4],Integer.parseInt(st[5]),Integer.parseInt(st[6])));
			} 
		}
		in.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	try {
		//name,mealService,internetConnectionStatus,entertainmentSystemStatus,email,password
		Scanner in = new Scanner(com);
		while(in.hasNextLine()) {
			String line = in.nextLine();
			if (line != null) {
				String[] st = line.split(",");
				company.add(new Company(st[0],Boolean.parseBoolean(st[1]),Boolean.parseBoolean(st[2]),Boolean.parseBoolean(st[3]),st[4],st[5]));
			} 
		}
		in.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}
		
	
	public static void fileWrite(File cus, File com, File vec, List<Customer> customer,List<Company> company , List<Vehicle> vehicle) {
		try {
			
			 FileWriter fileWriter = new FileWriter(cus);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            for (Customer cstomer : customer) {
	                bufferedWriter.write(cstomer.getName()+","+ cstomer.getSurname()+","+cstomer.getGender()+","+cstomer.getVehicleNumber()
	                + ","+cstomer.getChosenSeatNumber()+","+cstomer.getBaggageInformation()+","+cstomer.getAmountOfMoney()+","+
	                		cstomer.getEmail()+","+cstomer.getPassword());
	                bufferedWriter.newLine();
	            }

	            bufferedWriter.close();
	            System.out.println("Customer list is written successfully.");
	            
	            
	            
        } 
		
		catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
		try {
			
			 FileWriter fileWriter = new FileWriter(com);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            for (Company cmpany : company) {
	                bufferedWriter.write(cmpany.getName()+","+ cmpany.getMealService()+"," +cmpany.getInternetConnectionStatus()+","+cmpany.getEntertainmentSystemStatus()+","+
	               cmpany.getEmail()+","+cmpany.getPassword());
	                bufferedWriter.newLine();
	            }

	            bufferedWriter.close();
	            System.out.println("Company list is written successfully.");
	            
	            
	            
       } 
		
		catch (IOException e) {
           System.out.println("Error: " + e.getMessage());
       }
		try {
			
			 FileWriter fileWriter = new FileWriter(vec);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            for (Vehicle vhicle : vehicle) {
	            	
	                if(vhicle instanceof Bus)
					{
	                	bufferedWriter.write("bus"+","+ vhicle.getCompanyName()+","+vhicle.getVehicleCode()+","+vhicle.getDate()
		                + ","+vhicle.getRoute()+","+vhicle.getPrice()+","+vhicle.getBaggageInformation());
		                bufferedWriter.newLine();
						
					}
					
					else if(vhicle instanceof Plane)
					{
						
						bufferedWriter.write("plane"+","+ vhicle.getCompanyName()+","+vhicle.getVehicleCode()+","+vhicle.getDate()
		                + ","+vhicle.getRoute()+","+vhicle.getPrice()+","+vhicle.getBaggageInformation());
		                bufferedWriter.newLine();
						
					}
					
					else if(vhicle instanceof Train)
					{
						
						bufferedWriter.write("train"+","+ vhicle.getCompanyName()+","+vhicle.getVehicleCode()+","+vhicle.getDate()
		                + ","+vhicle.getRoute()+","+vhicle.getPrice()+","+vhicle.getBaggageInformation());
		                bufferedWriter.newLine();
					}
	            }

	            bufferedWriter.close();
	            System.out.println("Customer list is written successfully.");
       } 
		
		catch (IOException e) {
           System.out.println("Error: " + e.getMessage());
       }
	}
	
	public static void main(String[] args) {
		File cus = new File("Customers.txt");
		File vec = new File("Vehicles.txt");
		File com = new File("Companies.txt");
		VehicleFactory vehicleFactory = new VehicleFactory();
		List<Customer> customer = new ArrayList<Customer>();  
		List<Company> company = new ArrayList<Company>();  
		List<Vehicle> vehicle = new ArrayList<Vehicle>(); 
		
		
		fileOpr(cus, com, vec, customer, company, vehicle, vehicleFactory);
		
		for (Company comp : company) {
			for (Vehicle veh : vehicle) {
				if(comp.getName().equalsIgnoreCase(veh.getCompanyName()))	
				{
					
					comp.addVehicle(veh);
				}
			}
        }
		
		for (Vehicle veh : vehicle) {
			for (Customer element : customer) {
				if(element.getVehicleNumber().equalsIgnoreCase(veh.getVehicleCode()))	
				{
					
					if(!veh.addCustomer(element, element.getChosenSeatNumber())) {
						element.setVehicleNumber("-1");
					}
				}
			}
        }
		
		
		while(true) {
		Scanner sc= new Scanner(System.in);
		System.out.println("please enter for customer / company / Policy / Exit and Save for your proccess :");
		String input=sc.nextLine();
		
		if(input.equalsIgnoreCase("customer")) {
			
			System.out.println("login or sign up  :");
			String customer_inp=sc.nextLine();
			
			if(customer_inp.equalsIgnoreCase("login")) {
				
				System.out.println("please enter email :");
				String email=sc.nextLine();
				System.out.println("please enter password :");
				String password=sc.nextLine();
				
				
				boolean flag=false;
				for (Customer customerElement : customer) {
					
					if(customerElement.getEmail().equalsIgnoreCase(email)&&customerElement.getPassword().equalsIgnoreCase(password))
					{   flag=true;
						
						System.out.println("please choose the process -- buy ticket,refund,show ticket"); 
						String processLogIn=sc.nextLine();	
						
						if(processLogIn.equalsIgnoreCase("buy ticket")) {
							System.out.println("please choose vehicleType  :");
							String vehicleType=sc.nextLine();
							System.out.println("please enter date like day/month/year :");
							String date=sc.nextLine();
							String[] dateS=date.split("/");
							System.out.println("please enter route :");
							String route=sc.nextLine();
							
							List<Vehicle> chosen_vehicles = new ArrayList<Vehicle>();
							
							for (Vehicle vehicleElement : vehicle) 
							{
								if(vehicleElement.getRoute().equalsIgnoreCase(route)&&vehicleElement.getDate().equalsIgnoreCase(date))
								{
									
									if(vehicleType.equalsIgnoreCase("bus")&& vehicleElement instanceof Bus)
									{
										chosen_vehicles.add(vehicleElement);
										
									}
									
									else if(vehicleType.equalsIgnoreCase("plane")&& vehicleElement instanceof Plane)
									{
										
										chosen_vehicles.add(vehicleElement);
										
									}
									
									else if(vehicleType.equalsIgnoreCase("train")&& vehicleElement instanceof Train)
									{
										
										chosen_vehicles.add(vehicleElement);
										
									}
									else {
										flag=false;
									}
									
								}
								else
								{
									flag=false;
								}
								
								
							}
							if(chosen_vehicles.size()==0) 
							{
								
								System.out.println("No tickets were found matching your search criteria.");
								break;
								
							}
							else {
							
								for (Vehicle chosenVehicleElement : chosen_vehicles) 
								{
									for(Company element : company) {  
										if(element.getName().equalsIgnoreCase(chosenVehicleElement.getCompanyName())) {
											System.out.println(chosenVehicleElement.getCompanyName()+ "  "+chosenVehicleElement.getVehicleCode() +"  "+  chosenVehicleElement.getPrice());
											System.out.println(" Entertainment System Statu-> "+ element.getEntertainmentSystemStatus()
											+" internet Connection Status-> "+ element.getInternetConnectionStatus()+ " Meal Service-> "+ element.getMealService());
										}
									}
									
									
								}
								
								
								
								System.out.println("please choose number for  vehicle from 1 to " + chosen_vehicles.size()+" : ");
								int chosenNumber=sc.nextInt();
								int i=1;
								for (Vehicle chosenVehicleElement : chosen_vehicles)
								{
									if(i==chosenNumber)
									{   flag=true;
										System.out.println("please choose number for seat from 1 to 10 : ");
										int chosenSeat=sc.nextInt();
										if(chosenVehicleElement.addCustomer(customerElement,chosenSeat)) 
										{   
											customerElement.setVehicleNumber(chosenVehicleElement.getVehicleCode());
											customerElement.setBaggageInformation(chosenVehicleElement.getBaggageInformation());
											customerElement.setChosenSeatNumber(chosenSeat);
											break;
										
											
										}
									}
									else {flag=false;}
									i++;
								}
							}
						}
						else if(processLogIn.equalsIgnoreCase("show ticket")) {
							boolean flg = false;
							for (Vehicle veh : vehicle) {
								if(customerElement.getVehicleNumber().equalsIgnoreCase(veh.getVehicleCode()))	
								{ 
									
									for(Company element : company) {  
										if(element.getName().equalsIgnoreCase(veh.getCompanyName())) {
											flg = true;
											if(veh instanceof Bus)
											{
												System.out.println("Name-> "+ customerElement.getName()+ " Surname-> "+ customerElement.getSurname()
												+ " Gender-> " +customerElement.getGender()+ " Company-> " + veh.getCompanyName()+ " Vehicle type-> Bus ");
												System.out.println("Vehicle code-> " + veh.getVehicleCode()+" Seat number-> "+ customerElement.getChosenSeatNumber()+ " Date-> "
												+ veh.getDate()+ " Route-> " + veh.getRoute()+ " Ticket Price-> "+ veh.getPrice());
												System.out.println("Baggage-> "+ veh.getBaggageInformation() +" Entertainment System Statu-> "+ element.getEntertainmentSystemStatus()
												+" internet Connection Status-> "+ element.getInternetConnectionStatus()+ " Meal Service-> "+ element.getMealService());
												System.out.println();
											}
											
											else if(veh instanceof Plane)
											{
												
												System.out.println("Name-> "+ customerElement.getName()+ " Surname-> "+ customerElement.getSurname()
												+ " Gender-> " +customerElement.getGender()+ " Company-> " + veh.getCompanyName()+ " Vehicle type-> Plane ");
												System.out.println("Vehicle code-> " + veh.getVehicleCode()+" Seat number-> "+ customerElement.getChosenSeatNumber()+ " Date-> "
												+ veh.getDate()+ " Route-> " + veh.getRoute()+ " Ticket Price-> "+ veh.getPrice());
												System.out.println("Baggage-> "+ veh.getBaggageInformation() +" Entertainment System Statu-> "+ element.getEntertainmentSystemStatus()
												+" internet Connection Status-> "+ element.getInternetConnectionStatus()+ " Meal Service-> "+ element.getMealService());
												System.out.println();
											}
											
											else if(veh instanceof Train)
											{
												
												System.out.println("Name-> "+ customerElement.getName()+ " Surname-> "+ customerElement.getSurname()
												+ " Gender-> " +customerElement.getGender()+ " Company-> " + veh.getCompanyName()+ " Vehicle type-> Train ");
												System.out.println("Vehicle code-> " + veh.getVehicleCode()+" Seat number-> "+ customerElement.getChosenSeatNumber()+ " Date-> "
												+ veh.getDate()+ " Route-> " + veh.getRoute()+ " Ticket Price-> "+ veh.getPrice());
												System.out.println("Baggage-> "+ veh.getBaggageInformation() +" Entertainment System Statu-> "+ element.getEntertainmentSystemStatus()
												+" internet Connection Status-> "+ element.getInternetConnectionStatus()+ " Meal Service-> "+ element.getMealService());
												System.out.println();
											}
										}
									}
								}
							}
							if(!flg)
								System.out.println("ticket is not found");
					        
						}
						else if(processLogIn.equalsIgnoreCase("refund")) {
							boolean flg = false;
							for (Vehicle veh : vehicle) {
								if(customerElement.getVehicleNumber().equalsIgnoreCase(veh.getVehicleCode()))	
								{ 
									flg=true;
									veh.refund(customerElement);
								}
							}
							if(!flg)
								System.out.println("ticket is not found");
						}
						
					}
		        }
                if(!flag)
                {
                	System.out.println("wrong input");
                }
			 }
			 else if(customer_inp.equalsIgnoreCase("sign up")) {
				    
				    System.out.println("please enter your name  :");
					String name=sc.nextLine();
					System.out.println("please enter your surname  :");
					String surname=sc.nextLine();
					System.out.println("please enter your gender :");
					String gender=sc.nextLine();
					System.out.println("please enter email :");
					String email=sc.nextLine();
					System.out.println("please enter password :");
					String password=sc.nextLine();
					System.out.println("please enter amount of your money :");
					int amountOfMoney=sc.nextInt();
					
					boolean flag=false;
					for (Customer customerElement2 : customer) {
						
						if(customerElement2.getEmail().equalsIgnoreCase(email))
						{   flag=true;
							System.out.println("This e-mail is registered in the system, please login or try again with a new e-mail");
							break;
							
						}
						
					}
					if (!flag){
						
						Customer signUpCustomer= new Customer(name,surname,gender,email, password,amountOfMoney);
						customer.add(signUpCustomer);
						System.out.println("sign up completed please login");
					}
			 	}
			}
			else if(input.equalsIgnoreCase("company")) {
				
				System.out.println("please enter email :");
				String email=sc.nextLine();
				System.out.println("please enter password :");
				String password=sc.nextLine();
				
				
				boolean flag=false;
				for (Company companyElement : company) {
					
					if(companyElement.getEmail().equalsIgnoreCase(email)&&companyElement.getPassword().equalsIgnoreCase(password))
					{   flag=true;
						
						System.out.println("please choose the process -- add vehicle,delete vehicle,show vehicles"); 
						String processLogIn=sc.nextLine();	
						if(processLogIn.equalsIgnoreCase("add vehicle")) 
						{   
							System.out.println("please enter  vehicle Type  :");
							String vehicleType=sc.nextLine();
							System.out.println("please enter  vehicleCode  :");
							String vehicleCode=sc.nextLine();
							System.out.println("please enter travel date  :");
							String date=sc.nextLine();
							System.out.println("please enter travel route :");
							String route=sc.nextLine();
							System.out.println("please enter price of travel :");
							int price=sc.nextInt();
							System.out.println("please enter baggage weight:");
							int baggageInformation=sc.nextInt();
							
							companyElement.addVehicle(vehicleFactory.getVehicle(vehicleType,companyElement.getName(), vehicleCode,date,route,price,baggageInformation));
							vehicle.add(vehicleFactory.getVehicle(vehicleType,companyElement.getName(), vehicleCode,date,route,price,baggageInformation));
							break;
							
						}
						else if(processLogIn.equalsIgnoreCase("delete vehicle")) 
						{
							System.out.println("please enter  vehicle Code for delete  Vehicle :");
							String vehicleCode=sc.nextLine();
							for (Vehicle chosenVehicleForDelete : vehicle) 
							{
								if(chosenVehicleForDelete.getVehicleCode().equalsIgnoreCase(vehicleCode)) 
								{
									flag=true;
									companyElement.deleteVehicle(chosenVehicleForDelete, vehicle);
									
									break;
								}
								else {
									flag=false;
								}
								
								
							}
							if(!flag) 
							{
								System.out.println("vehicle is not found");
							}
						}
						
						else if(processLogIn.equalsIgnoreCase("show vehicles")) 
						{
							companyElement.Display();
						}
						else {
							flag=false;
						}
					}
				}
				if(!flag)
	            {
	            	System.out.println("wrong input");
	            }
				
			}
		    else if(input.equalsIgnoreCase("policy")) {
				UserPolicy userpol = new UserPolicy();
				userpol.writePolicy();
				}
		    else if(input.equalsIgnoreCase("exit and save")) {
		    	fileWrite(cus ,com, vec, customer, company , vehicle);
				break;
			}
		    else {
		    	System.out.println("wrong input");
		    }
		}
	}
}