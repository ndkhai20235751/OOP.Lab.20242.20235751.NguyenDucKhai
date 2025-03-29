public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; 
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; 
    private int qtyOrdered;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The disc has been added.");
        } else System.out.println("The cart is almost full.");
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i=0;i<qtyOrdered;i++) {
            if (itemsOrdered[i]==disc) {
                for (int j=i;j<qtyOrdered-1;j++) {
                    itemsOrdered[j]=itemsOrdered[j+ 1];
                }
                itemsOrdered[qtyOrdered-1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                return;
            }
        }
    }
    public float totalCost() {
        float total = 0;
        for (int i=0; i<qtyOrdered;i++) total +=itemsOrdered[i].getCost();
        return total;
    }
    public void displayCart() {
        System.out.println("Items list: ");
        for (int i =0;i <qtyOrdered; i++) System.out.println((i + 1) + " " + itemsOrdered[i].getTitle() + " " + itemsOrdered[i].getCost());
        System.out.println("Total Cost: " + totalCost());
    }
}