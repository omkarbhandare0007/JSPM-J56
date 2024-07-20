package testCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.project.services.VehicleService;

class vehicleTest {

	@Test
	public void addvehicle() {
		VehicleService.addVehicle();
}
	@Test
	public void specificVehicle() {
		VehicleService.getSpecificVehicles(null);
	}
	@Test
	public void updateVehicle() {
		VehicleService.updateVehicle();
	}
	@Test
	public void deleteVehicle() {
		VehicleService.deleteVehicle();
	}
	
}
