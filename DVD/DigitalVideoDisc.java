

public class DigitalVideoDisc {
    // Attribute
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;
    private static int nbDigitalVideoDiscs = 0;
    private int id;

    public DigitalVideoDisc(String title){
		super();
		this.title = title;
        this.id = ++nbDigitalVideoDiscs;
	} 
    
    public DigitalVideoDisc(String title, String category, double cost) {
        this(title);
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, double cost) {
        this(title, category, cost);
        this.director = director;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this(title, category, director, cost);
        this.length = length;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public double getCost() {
        return cost;
    }

    // For Lab03
	public void setTitle(String title) {
		this.title = title;
    }

    public int getId(){
		return id;
    }
    public String toString(){
        return String.format("%d. %s - %s - %s - %d: %.2f$", getId(), getTitle(), getCategory(), getDirector(), getLength(), getCost());
    }

    public boolean isMatch(int id) {
        return this.id == id;
    }
   public boolean isMatch(String title) {
       String[] tmp = title.split(" ", 0);
       for (String x : tmp) {
           if (getTitle().toLowerCase().contains(x.toLowerCase())) return true;
       }
       return false;
   }
}
