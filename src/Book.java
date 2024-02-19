import java.util.List;

public class Book extends AbstractProduct {

    private String author;
    private int pages;
    private String genre;

    public Book(String name, double price, double rating, String manufacturer, List<String> description) {
        super(name, price, rating, manufacturer);
        setDescription(description);
    }

    @Override
    public void setDescription(List<String> description) {
        this.author = description.get(0);
        this.pages = Integer.parseInt(description.get(1));
        this.genre = description.get(2);
    }

    @Override
    public String getDescription() {
        return "Название: " + this.getName() + " | "
                + "Автор: " + this.author + " | "
                + "Жанр: " + this.genre + " | "
                + "Количество страниц: " + this.pages + " | "
                + "Издатель: " + this.getManufacturer() + " | "
                + "Рейтинг: " + this.getRating() + " | "
                + "Цена: " + this.getPrice();
    }
}
