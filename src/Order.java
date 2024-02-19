/*
Принцип разделения интерфейса (Interface Segregation Principle, ISP):

Интерфейс Order определяет только операции, связанные с заказом, и не включает ненужные методы.
 */
public interface Order {
    void addProductToCustomerBucket(AbstractProduct product, int amount);
}
