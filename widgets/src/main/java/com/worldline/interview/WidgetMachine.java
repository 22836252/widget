package main.java.com.worldline.interview;

public class WidgetMachine {
    private Engine engine;

    public WidgetMachine(Engine engine) {
        super();
        this.engine = engine;
    }

    public double produceWidgets(int quantity) {
        engine.start();
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }

    private double produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = 0;

        costPerBatch = engine.getCostPerBatch();
        int batchSize=engine.getBatchSize();
        while (batch < quantity) {
            batch = batch + batchSize;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }

}

