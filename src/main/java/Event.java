import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Event {
    public Event() {

    }

    public Object object;

    public String methodName;

    public Object[] params;

    public Class[] paramTypes;

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public Event(Object object, String methodName, Object ...args) {
        this.object=object;
        this.methodName=methodName;
        this.params=args;
        construction(params);

    }

    public void invoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = object.getClass().getMethod(this.getMethodName(), this.getParamTypes());

        if (method == null) {
            return;
        }
        method.invoke(this.getObject(), this.getParams());
    }

    public void construction(Object[] params) {
        this.paramTypes = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            this.paramTypes[i] = params[i].getClass();
        }
    }


}
