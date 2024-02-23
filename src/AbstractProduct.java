import java.util.List;
import java.util.Objects;

/*
Принцип единственной ответственности (Single Responsibility Principle, SRP):
Класс AbstractProduct отвечает только за определение базовых операций для товара.
Классы, представляющие конкретные товары (Book, Clothing, Food), отвечают только
за свою специфическую реализацию товара.

Принцип подстановки Барбары Лисков (Liskov Substitution Principle, LSP):
Классы Book, Clothing, Food являются подклассами AbstractProduct, и они могут быть
использованы везде, где ожидается объект типа Product, не нарушая функциональности программы.
 */
public abstract class AbstractProduct implements Product {
    private final String name;
    private final double price;
    private final double rating;
    private final String manufacturer;
    private int amount;

    public AbstractProduct(String name, double price, double rating, String manufacturer) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractProduct other = (AbstractProduct) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public abstract void setDescription(List<String> description);

    public abstract String getDescription();
}
