import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    public List<Event> objects;

    public EventHandler() {
        objects = new ArrayList<Event>();
    }

    public void addEvent(Object object, String methodName, Object... args) {
        objects.add(new Event(object, methodName,args));
    }

    public void notifyX() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (Event e:objects
             ) {
            e.invoke();
        }
    }
}
