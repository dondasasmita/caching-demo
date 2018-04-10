package personal_items.item_model;

public class Item {

    private Long id;
    private String nameOfItem;
    private int price;
    private String description;
    private boolean isInUse;

    public Item(Long id, String nameOfItem, int price, String description, boolean isInUse) {
        this.id = id;
        this.nameOfItem = nameOfItem;
        this.price = price;
        this.description = description;
        this.isInUse = isInUse;
    }

    public Item(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInUse() {
        return isInUse;
    }

    public void setInUse(boolean inUse) {
        isInUse = inUse;
    }
}
