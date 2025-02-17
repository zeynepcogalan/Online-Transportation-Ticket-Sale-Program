
public class Bus implements Vehicle {

	private String companyName;
	private String vehicleCode;
	private int capacity;
	private String date;
	private String route;
	private int price;
	private int baggageInformation ;
	private Customer[] seatStatus;
	private int occupancy=0;
	
	
	
	
    public Bus(String companyName, String vehicleCode, String date, String route, int price,int baggage) {
		
		this.companyName = companyName;
		this.vehicleCode = vehicleCode;
		this.capacity =10;
		this.date = date;
		this.route = route;
		this.price = price;
		this.baggageInformation=baggage;
		seatStatus= new Customer[capacity];
	}

	public void refund(Customer customer) {
		 for(int i=0;i<seatStatus.length;i++) { //old chosen seat number deleted.
  		   if(seatStatus[i] != null && seatStatus[i] == customer) {
  			   seatStatus[i] = null;
  			   System.out.println("Ticket deleted and price refund.");
  			   customer.setChosenSeatNumber(-1);
  			   customer.setVehicleNumber("-1");
  			   customer.setBaggageInformation(-1);
  			   customer.setAmountOfMoney(customer.getAmountOfMoney()+price);
  			   break;
  		   }
  	   }
    }
	
	
	
     public boolean addCustomer(Customer customer, int chosenSeat) {
    	 for(int i=0;i<seatStatus.length;i++) { //old chosen seat number deleted.
  		   if(seatStatus[i] != null && seatStatus[i] == customer) {
  			   seatStatus[i] = null;
  			   int newOccupancy = getOccupancy() - 1;  
			        setOccupancy(newOccupancy);  
  			   break;
  		   }
  	     }
    	   if(chosenSeat<=seatStatus.length && chosenSeat > 0 && seatStatus[chosenSeat-1]== null) {
    		       if(customer.getAmountOfMoney()>= price)
       		          { 
       			  		seatStatus[chosenSeat-1]= customer;
       			  		customer.setAmountOfMoney(customer.getAmountOfMoney()-price);
    			        int newOccupancy = getOccupancy()+ 1;
    			        setOccupancy(newOccupancy);
    			        return true;
       		          }
       		        else {
        			     System.out.println("Unfortunately, your money is not enough to buy this ticket. Your money: "+ customer.getAmountOfMoney());
       		        }
       		  }
    		else {
    			System.out.println("Sorry, seat "+customer.getChosenSeatNumber()+" is full. Registration could not be completed " + customer.getName());
    		}
    		
    		 
    	
    	 return false;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getVehicleCode() {
		return vehicleCode;
	}

	public void setVehicleCode(String vehicleCode) {
		this.vehicleCode = vehicleCode;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

	public Customer[] getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(Customer[] seatStatus) {
		this.seatStatus = seatStatus;
	}
	
	public int getBaggageInformation() {
		return baggageInformation;
	}

	public void setBaggageInformation(int baggageInformation) {
		this.baggageInformation = baggageInformation;
	}
}
