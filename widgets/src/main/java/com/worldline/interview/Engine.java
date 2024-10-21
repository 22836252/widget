package main.java.com.worldline.interview;


public class Engine {

    protected boolean running;
    protected int fuelLevel;
    protected FuelType requiredFuelType;
    protected FuelType fuelType;
    protected double getCostPerBatch;
    protected int batchSize;

    public Engine(FuelType requiredFuelType) {
        this.requiredFuelType = requiredFuelType;
        running = false;
        fuelLevel = 0;
        batchSize= 0;
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

    public double getCostPerBatch() {
        return getCostPerBatch;
    }


    public int getBatchSize() {
        return batchSize;
    }
}
