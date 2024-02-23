import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoreWarehouse {
    public HashMap<String, AbstractProduct> getProductsMap() {
        return productsMap; //принцип DRY: подход -> извлечение общей функциональности
    } 

    private final HashMap<String, AbstractProduct> productsMap = initDefaultProductsMap();

    public HashMap<String, AbstractProduct> initDefaultProductsMap() {
        HashMap<String, AbstractProduct> productsMap = new HashMap<>();
        productsMap.put("12323", new Food("Хлеб", 36, 4.8, "Хлебозавод №2", new ArrayList<>(List.of("914", "29-02-2024"))));
        productsMap.put("84231", new Food("Молокозавод", 85, 4.6, "Молкомбинат №7", new ArrayList<>(List.of("728", "08-10-2024"))));
        productsMap.put("67293", new Food("Яйца", 143, 4.7, "Птицефабрика №4", new ArrayList<>(List.of("165", "18-07-2024"))));
        productsMap.put("47811", new Book("Гарри Поттер и философский камень", 768, 5.0, "Издательство 'Росмэн'", new ArrayList<>(List.of("Дж.К.Роулинг", "464", "роман"))));
        productsMap.put("45467", new Book("Властелин Колец", 3087, 4.9,"Издательство 'Махаон'", new ArrayList<>(List.of("Дж.Р.Р.Толкин", "752", "роман"))));
        productsMap.put("40381", new Book("Песнь льда и пламени", 615, 4.8, "Издательство 'АСТ'", new ArrayList<>(List.of("Джордж Р.Р. Мартин", "960", "роман"))));
        productsMap.put("74005", new Clothing("Рубашка", 4328, 4.2, "Zolla", new ArrayList<>(List.of("Хлопок", "M"))));
        productsMap.put("78980", new Clothing("Брюки", 7315, 4.3, "Henderson", new ArrayList<>(List.of("Шерсть", "L"))));
        productsMap.put("71385", new Clothing("Футболка", 2987, 4.1, "Sela", new ArrayList<>(List.of("Полиэстер", "S"))));
        return productsMap;
    }
}
