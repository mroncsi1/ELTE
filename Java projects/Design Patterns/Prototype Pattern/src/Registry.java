import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<Type, Item> items;

    public Registry() {
        items = new HashMap<>();
        loadItems();
    }

    public Item createItem(Type type) {
        Item item = null;

        try {
            item = (Item)(items.get(type)).clone();
        } catch (CloneNotSupportedException ex) {
            System.out.printf("Error message: %s%n", ex.getMessage());
        }

        return item;
    }

    private void loadItems() {
        Movie movie = new Movie();
        movie.setTitle("Basic Movie");
        movie.setPrice(24.99);
        movie.setRuntime("2 hours");
        items.put(Type.MOVIE, movie);

        Book book = new Book();
        book.setNumberOfPages(335);
        book.setPrice(19.99);
        book.setTitle("Basic Book");
        items.put(Type.BOOK, book);
    }
}
