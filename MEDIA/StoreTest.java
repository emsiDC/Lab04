
public class StoreTest {
    public static void main(String[] args) {
        // Create a new store with a 5 DVDs max
        Store store = new Store(5);
        // Create some DVDs to add to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("t1", "Music", "Minh1", 5, 17.44f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("t2", "Music", "Minh2", 4, 16.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("t3", "Music", "Minh3", 6, 20.23f);

        // Add DVDs to the store
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Display the current state of the store
        store.displayStore();

        // Remove a DVD from the store
        store.removeDVD(dvd2);

        // Display the updated store
        store.displayStore();
    }
}