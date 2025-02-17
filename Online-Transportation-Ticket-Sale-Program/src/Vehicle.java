
public interface Vehicle {

	void refund(Customer customer); 
	
	boolean addCustomer(Customer customer, int chosenSeat);
	
	String getVehicleCode();
	
	String getCompanyName();
	
	int getBaggageInformation();
	
    String getDate();

	String getRoute();
	
	Customer[] getSeatStatus();
	
	int getOccupancy();
	
	 int getPrice();
	

	
}
