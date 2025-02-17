
public class VehicleFactory {
	public Vehicle getVehicle(String vehicleType, String companyName, String vehicleCode, String date, String route, int price,int baggage)
	{
	if(vehicleType == null){
	return null;
	}
	if(vehicleType.equalsIgnoreCase("PLANE")){
	return new Plane(companyName, vehicleCode,date,route,price , baggage);
	} else if(vehicleType.equalsIgnoreCase("TRAIN")){
	return new Train(companyName, vehicleCode,date,route,price ,baggage);
	} else if(vehicleType.equalsIgnoreCase("BUS")){
	return new Bus(companyName, vehicleCode,date,route,price ,baggage);
	}
	return null;
	}
}
