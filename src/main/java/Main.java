import java.lang.reflect.Method;

class Test{
    private void message(){
        System.out.printf("hello java");
    }
}

public class Main {

    public void messageTest(){
       // System.out.printf(String.format("Runtime.freeMemory()=%d", Runtime.freeMemory()));
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.casique.Test");
            Object o = c.newInstance();
            Method m = c.getDeclaredMethod("message", null);
            m.setAccessible(true);
            m.invoke(o, null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
