import java.util.List;

public class Clothing extends AbstractProduct {
    private String material;
    private String size;

    public Clothing(String name, double price, double rating, String manufacturer, List<String> description) {
        super(name, price, rating, manufacturer);
        setDescription(description);
    }

    @Override
    public void setDescription(List<String> description) {
        this.material = description.get(0);
        this.size = description.get(1);
    }

    @Override
    public String getDescription() {
        return "Название: " + this.getName() + " | "
                + "Материал: " + this.material + " | "
                + "Размер: " + this.size + " | "
                + "Производитель: " + this.getManufacturer() + " | "
                + "Рейтинг: " + this.getRating() + " | "
                + "Цена: " + this.getPrice();
    }
}
