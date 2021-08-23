public class Car {

    private String name;
    private boolean available;


    public Car(String name, boolean available, int index) {
        this.name = name;
        this.available = available;

    }

    // modifiers

    // getter
    public String getName() {
        return name;
    }

    // getter
    public boolean isAvailable() {
        return available;
    }

    // setter
    public void setAvailable(boolean available) {
        this.available = available;
    }



}
