public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int dim = 10;
        World w = new World(dim);

        // Seed
        System.out.println("\nNew World created:");
        w.random();
        w.print();

        // Tick
        for (int i = 0; i < 100; i++) {
            System.out.println("\nNew World step " + (i+1) + ":");
            w.tick();
            w.print();
        }
    }


}
