package session4.example.vector.k.com.myrestaurant;


public class MyData extends Object {

    private String itemId;
    private String itemName;
    private String describtion;
    private String category;
    private int sortPosition;
    private double price;
    private String image;

    public MyData() {

    }

    public MyData(String itemId, String itemName, String describtion, String category, int sortPosition, double price, String image) {

        this.itemId = itemId;
        this.itemName = itemName;
        this.describtion = describtion;
        this.category = category;
        this.sortPosition = sortPosition;
        this.price = price;
        this.image = image;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescribtion() {
        return this.describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSortPosition() {
        return this.sortPosition;
    }

    public void setSortPosition(int sortPosition) {
        this.sortPosition = sortPosition;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", describtion='" + describtion + '\'' +
                ", category='" + category + '\'' +
                ", sortPosition=" + sortPosition +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
