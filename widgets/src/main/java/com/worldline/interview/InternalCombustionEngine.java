package main.java.com.worldline.interview;

public class InternalCombustionEngine extends Engine {

    public InternalCombustionEngine(FuelType requiredFuelType) {
        super(requiredFuelType);
        if (requiredFuelType == FuelType.PETROL || requiredFuelType == FuelType.DIESEL) {
            this.requiredFuelType = requiredFuelType;
        } else {
            throw new IllegalStateException("Wrong FuelType");
        }
        this.batchSize = 8;
    }
    public void start() {
        if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void fill(FuelType fuelType, int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }

        this.fuelType = fuelType;
    }



    @Override
    public double getCostPerBatch() {
        return this.fuelType == FuelType.WOOD ? 9 : 12;
    }
}
