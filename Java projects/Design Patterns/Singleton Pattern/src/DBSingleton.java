public class DBSingleton {

    private static DBSingleton instance;

    private DBSingleton() {}

    public static DBSingleton getInstance() {
        if (instance == null) {
            instance = new DBSingleton();
        }
        return instance;
    }
}
