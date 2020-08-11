public class Main {

    public static void main(String[] args) {
        LunchOrder lunchOrder = new LunchOrder.Builder()
                .bread("Wheat").condiments("Lettuce").dressing("Mayo").meat("Turkey")
                .build();

        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());
    }
}
