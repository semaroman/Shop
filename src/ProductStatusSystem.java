//SOLID: Принцип единственной ответственности, в данном классе мы работаем только со статусом заказа
public class ProductStatusSystem {
    private final int thresholdValueTimeGoodsProcessing = 1; // принцип избегания магческих чисел
    private final int thresholdValueCollectedOrderTime = 3;
    private final int timeShippedOrder = 5;

    public void printOrderStatus(OrderImpl goods) {
        OrderDateTime orderDateTime = new OrderDateTime();
        if (goods.isOrderPlaced()) {
            long time = orderDateTime.getMinutesDifference(goods.getDateOfOrder());
            if (time < thresholdValueTimeGoodsProcessing) {
                System.out.println("Заказ в обработке");
            }
            if (time >= thresholdValueTimeGoodsProcessing && time < thresholdValueCollectedOrderTime) {
                System.out.println("Заказ в сборке");
            } else if (time >= thresholdValueCollectedOrderTime && time < timeShippedOrder) {
                System.out.println("Заказ собран");
            } else if (time == timeShippedOrder) {
                System.out.println("Заказ отправлен");
            } else if (time > timeShippedOrder) {
                System.out.println("Заказ в пути");
            }
        }
    }
}
