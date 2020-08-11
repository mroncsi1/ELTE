public class Main {

    public static void main(String[] args) {
        DBSingleton instance = DBSingleton.getInstance();

        System.out.println(instance);

        DBSingleton anotherInstance = DBSingleton.getInstance();

        System.out.println(anotherInstance);
    }
}
