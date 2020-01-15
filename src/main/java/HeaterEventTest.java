import java.lang.reflect.InvocationTargetException;

public class HeaterEventTest {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Integer temperature=98;
        HeaterNotifier heaterNotifier=new HeaterNotifier();
        heaterNotifier.addListener(new AleramListener(), "alertWarn", temperature);
        heaterNotifier.addListener(new DisPlayListener(), "showTemperature", temperature);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        heaterNotifier.boilWater(temperature);
    }
}

