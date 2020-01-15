import java.lang.reflect.InvocationTargetException;

public class HeaterNotifier extends Notifier {
    public Integer temperature;

    @Override
    public void addListener(Object object,String methodName,Object ...args) {
        System.out.println("添加监听者");
        /**
         * 通知需要有去执行通知消息的人
         */
        EventHandler handler=this.getEventHandler();
        //这个地方报过空指针的错原因是Notifier类只是将EventHandler声明为成员变量没有实例化
        handler.addEvent(object,methodName,args);


    }

    @Override
    public void notifierAllListener() throws NoSuchMethodException, IllegalAccessException {
        System.out.println("开始通知监听者");
        try {
            this.getEventHandler().notifyX();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void boilWater(Integer warnTemperature) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (int i = 0; i <=100; i++) {
            this.temperature = i;
            if (warnTemperature<temperature) {
                notifierAllListener();
                break;
            }
        }
    }
}
