import java.util.List;
import java.util.ArrayList;

public class Company {

	private String name;
	private boolean mealService;
	private boolean internetConnectionStatus;
	private boolean entertainmentSystemStatus;
	private String password;
	private String email;
	private List<Vehicle> companies_vehicles;
	
	public Company(String name, boolean mealService, boolean internetConnectionStatus,
			boolean entertainmentSystemStatus,String email, String password) {
		
		this.name = name;
		this.mealService = mealService;
		this.internetConnectionStatus = internetConnectionStatus;
		this.entertainmentSystemStatus = entertainmentSystemStatus;
		this.email = email;
		this.password = password;
		this.companies_vehicles = new ArrayList<Vehicle>();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void addVehicle(Vehicle vehicle) {
		if(!companies_vehicles.contains(vehicle))
		{   
			companies_vehicles.add(vehicle);
		}
		else {
			System.out.println("vehicle already exists ");
		}
		
	}
	
    public void deleteVehicle(Vehicle vehicle, List<Vehicle> vehicles) {
    	if(vehicle.getOccupancy()==0)
    	{
    		companies_vehicles.remove(vehicle);
    	    System.out.println("Deleted");
    	    for (Vehicle element : vehicles) {
                if(element==vehicle)
                {
                	vehicles.remove(element);
                	break;
                }
            }
    	}
    	else {
    		System.out.println("Occupancy is not 0");
    	}
    	
    	
	}
    
    public void Display() {
    	System.out.println(getName());
    	int i=0;
    	for (Vehicle element : companies_vehicles) {
    		
            System.out.println(i+") Vehicle Number : "+element.getVehicleCode()+"  Occupancy : "+ element.getOccupancy()+" Route :"+element.getRoute());
            i++;
    	}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getMealService() {
		return mealService;
	}

	public void setMealService(boolean mealService) {
		this.mealService = mealService;
	}

	public boolean getInternetConnectionStatus() {
		return internetConnectionStatus;
	}

	public void setInternetConnectionStatus(boolean internetConnectionStatus) {
		this.internetConnectionStatus = internetConnectionStatus;
	}

	public boolean getEntertainmentSystemStatus() {
		return entertainmentSystemStatus;
	}

	public void setEntertainmentSystemStatus(boolean entertainmentSystemStatus) {
		this.entertainmentSystemStatus = entertainmentSystemStatus;
	}
	
}
