package test.java.com.worldline.interview;


import main.java.com.worldline.interview.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EngineTest {


    @Rule
    public ExpectedException exceptions = ExpectedException.none();
    @Test
    public void testStartEngine() {
        Engine engine = new SteamEngine(FuelType.COAL);
        engine.fill(FuelType.COAL, 0);
        exceptions.expect(Exception.class);
        exceptions.expectMessage("engine can not be work.");
        engine.start();

    }

    @Test
    public void TestCOALforSteamEngine() {

        Engine engine = new SteamEngine(FuelType.COAL);
        engine.fill(FuelType.COAL, 30);
        WidgetMachine widgetMachine = new WidgetMachine(engine);
        double cost = widgetMachine.produceWidgets(3);
        Assert.assertEquals(cost, 5.65*2, 0.001);

    }

    @Test
    public void testWoodForSteamEngine() {
        Engine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(FuelType.DIESEL, 50);
        WidgetMachine widgetMachine = new WidgetMachine(engine);
        double cost = widgetMachine.produceWidgets(1);
        Assert.assertEquals(cost, 12, 0.001);
    }


    @Test
    public void testThrowException() {
        Engine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 50);
        WidgetMachine widgetMachine = new WidgetMachine(engine);
        exceptions.expect(Exception.class);
        exceptions.expectMessage("engine can not be work.");
        double cost = widgetMachine.produceWidgets(2);

    }

    @Test
    public void testForFill() {
        Engine engine = new SteamEngine(FuelType.COAL);
        engine.fill(FuelType.PETROL, 50);
        WidgetMachine widgetMachine = new WidgetMachine(engine);
        exceptions.expect(Exception.class);
        exceptions.expectMessage("engine can not be work.");
        double cost = widgetMachine.produceWidgets(2);

    }




}
