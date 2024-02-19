import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в наш магазин!");
        String input = "";
        while (true) {
            System.out.println("""
                                        
                    Выберите действие:
                    1. Показать товары
                    2. Добавить в корзину
                    3. Статус заказа
                    """);
            try {
                input = scanner.nextLine();
                if (input.equals("")) {
                    throw new IllegalArgumentException("Input cannot be empty");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }

            int operation = Integer.parseInt(input);
            if (operation == 0) {
                System.out.println("Exit ...");
                break;
            }
            StoreWarehouse storeWarehouse = new StoreWarehouse();
            switch (operation) {
                case 1:
                    System.out.println("Код товара | Название | Цена | Рейтинг товара | Производитель | Описание");

                    for (String productKey : storeWarehouse.getProductsMap().keySet()) {
                        System.out.println(productKey + " | " + storeWarehouse.getProductsMap().get(productKey).getDescription() + "\n");
                    }
                    break;
                case 2:
                    System.out.println("""
                            Введите код товара, которые хотите добавить в корзину,
                            чтобы завершить добавление введите 'ок'
                            """);
                    String productCode = scanner.nextLine();
                    storeWarehouse = new StoreWarehouse();
                    while (!Objects.equals(productCode, "ok")) {
                        if (storeWarehouse.getProductsMap().containsKey(productCode)) {
                            OrderDateTime dateTimeFormatter = new OrderDateTime();
                            OrderImpl.getBucketGoods().setDateOfOrder(dateTimeFormatter.getCurrentDateTime());
                            OrderImpl.getBucketGoods().addProductToCustomerBucket(storeWarehouse.getProductsMap().get(productCode), 1);
                        }
                        productCode = scanner.nextLine();
                    }
                    if (OrderImpl.getBucketGoods().getCustomerBucket().size() > 0) {
                        OrderImpl.getBucketGoods().setOrderPlaced(true);
                        System.out.println("Ваша корзина: ");
                        for (Product product : OrderImpl.getBucketGoods().getCustomerBucket()) {
                            System.out.println("'" + product.getName() + "'" + " в количестве: х" + product.getAmount());
                        }
                        System.out.println("Сумма к оплате: " + OrderImpl.getBucketGoods().sumOfBucket(OrderImpl.getBucketGoods().getCustomerBucket()));
                    }
                    break;
                case 3:
                    ProductStatusSystem orderStatus = new ProductStatusSystem();
                    orderStatus.printOrderStatus(OrderImpl.getBucketGoods());
                    break;
                default:
                    System.out.println("Такой операции нет");
                    break;
            }
        }
    }
}
