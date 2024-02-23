import java.util.ArrayList;
import java.util.List;

/*
Принцип открытости/закрытости (Open/Closed Principle, OCP):
класс OrderImpl может быть расширен для добавления новых операций или функциональностей,
связанных с заказами, без изменения существующего кода.

Принцип инверсии зависимостей (Dependency Inversion Principle, DIP):
класс Order зависит от AbstractProduct, а не от конкретных классов товаров.
Это позволяет гибко менять или добавлять новые типы товаров, не внося изменения в Order.
 */
public class OrderImpl implements Order {
    private List<AbstractProduct> customerBucket = new ArrayList<>();
    private boolean isOrderPlaced;
    private String dateOfOrder;
    private static final OrderImpl bucketOfGoods = new OrderImpl();

    private OrderImpl() {

    }

    public static OrderImpl getBucketGoods() {
        return bucketOfGoods;
    } //принцип DRY: подход -> извлечение общей функциональности

    @Override
    public void addProductToCustomerBucket(AbstractProduct product, int amount) {
        product.setAmount(amount);
        if (customerBucket.contains(product)) {
            for (Product productImplOnBucket : customerBucket) {
                if (productImplOnBucket.equals(product)) {
                    productImplOnBucket.setAmount(productImplOnBucket.getAmount() + 1);
                }
            }
        } else
            customerBucket.add(product);
    }

    public double sumOfBucket(List<AbstractProduct> customerBucket) {
        double sum = 0;
        for (AbstractProduct abstractProduct : customerBucket) {
            sum += abstractProduct.getPrice() * abstractProduct.getAmount();
        }
        return sum;
    }

    public List<AbstractProduct> getCustomerBucket() {
        return customerBucket;
    }

    public boolean isOrderPlaced() {
        return isOrderPlaced;
    }

    public void setOrderPlaced(boolean orderPlaced) {
        this.isOrderPlaced = orderPlaced;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }
}
