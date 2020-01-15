import java.lang.reflect.InvocationTargetException;

public abstract class Notifier {
    public EventHandler eventHandler=new EventHandler();

public EventHandler getEventHandler( ) {
        return eventHandler;
    }

//    public void setEventHandler(EventHandler eventHandler) {
//        this.eventHandler = eventHandler;
//    }
    public abstract void addListener(Object object,String methodName,Object...args);

    public abstract void notifierAllListener() throws NoSuchMethodException, IllegalAccessException;

}
