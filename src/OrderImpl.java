import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements Order {
    private List<AbstractProduct> customerBucket = new ArrayList<>();
    private boolean isOrderPlaced;
    private String dateOfOrder;
    private static final OrderImpl bucketOfGoods = new OrderImpl();

    private OrderImpl() {

    }

    public static OrderImpl getBucketGoods() {
        return bucketOfGoods;
    }

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
