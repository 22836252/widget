package main.java.com.worldline.interview;

public class SteamEngine extends Engine {

	public SteamEngine(FuelType requiredFuelType) {
		super(requiredFuelType);
		if (requiredFuelType == FuelType.WOOD || requiredFuelType == FuelType.COAL) {
			this.requiredFuelType = requiredFuelType;
		} else {
			throw new IllegalStateException("Wrong FuelType");
		}

		this.batchSize = 2;
	}


	@Override
	public double getCostPerBatch() {
		return this.fuelType == FuelType.WOOD ? 4.35 : 5.65;
	}


}
