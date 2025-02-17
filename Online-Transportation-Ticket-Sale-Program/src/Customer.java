
public class Customer {
	private String name;
	private String surname;
	private String gender;
	private String vehicleNumber="-1";
	private int chosenSeatNumber=-1;
	private int baggageInformation =-1;
	private int amountOfMoney;
	private String password;
	private String email;
	
	
	public Customer(String name, String surname, String gender, String email, String password, int amountOfMoney) {
		
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.amountOfMoney = amountOfMoney;
		
		
	}
	
	public Customer(String name, String surname, String gender, String vehicleNumber, int chosenSeatNumber,
			int baggageInformation, int amountOfMoney,String email, String password) {
		
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.vehicleNumber = vehicleNumber;
		this.chosenSeatNumber = chosenSeatNumber;
		this.baggageInformation = baggageInformation;
		this.amountOfMoney = amountOfMoney;
		this.email = email;
		this.password = password;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getChosenSeatNumber() {
		return chosenSeatNumber;
	}

	public void setChosenSeatNumber(int chosenSeatNumber) {
		this.chosenSeatNumber = chosenSeatNumber;
	}

	public int getBaggageInformation() {
		return baggageInformation;
	}

	public void setBaggageInformation(int baggageInformation) {
		this.baggageInformation = baggageInformation;
	}

	

	public int getAmountOfMoney() {
		return amountOfMoney;
	}

	public void setAmountOfMoney(int amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}
	
	
	
	
}
