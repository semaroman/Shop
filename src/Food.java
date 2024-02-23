import java.util.List;

*/
Принцип подстановки Барбары Лисков (Liskov Substitution Principle, LSP):
Класс Food является подклассом AbstractProduct, и он может быть
использован везде, где ожидается объект типа Product, не нарушая функциональности программы.
 */

public class Food extends AbstractProduct {
    private double weight;
    private String bestBefore;

    public Food(String title, double price, double rating, String manufacturer, List<String> description) {
        super(title, price, rating, manufacturer);
        this.setDescription(description);
    }

    @Override
    public void setDescription(List<String> description) {
        this.weight = Double.parseDouble(description.get(0));
        this.bestBefore = description.get(1);
    }

    @Override
    public String getDescription() {
        return "Название: " + this.getName() + " | "
                + "Производитель: " + this.getManufacturer() + " | "
                + "Вес: " + this.weight + " | "
                + "Срок годности: " + this.bestBefore + " | "
                + "Рейтинг: " + this.getRating() + " | "
                + "Цена: " + this.getPrice();
    }
}
