
interface Serializable { void serialize(); }
interface Loggable     { void log(); }
interface Cacheable    { void cache(); }

class UserProfile implements Serializable, Loggable {
    public void serialize() { System.out.println("UserProfile serialized"); }
    public void log()       { System.out.println("UserProfile logged"); }
}

class Config implements Serializable, Cacheable {
    public void serialize() { System.out.println("Config serialized"); }
    public void cache()     { System.out.println("Config cached"); }
}

public class InstanceOfInterfaces {
    public static void main(String[] args) {
        Object[] objects = { new UserProfile(), new Config(), "plain string" };
        for (Object obj : objects) {
            System.out.println("Object: " + obj.getClass().getSimpleName());
            if (obj instanceof Serializable s) s.serialize();
            if (obj instanceof Loggable l)     l.log();
            if (obj instanceof Cacheable c)    c.cache();
            System.out.println();
        }
    }
}
