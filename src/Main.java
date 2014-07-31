public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int dim = 10;
        world w = new world(dim);
        w.print();

        // Seed
        System.out.println("\nNew world:");
        randomWorld(dim, w);
        w.print();

        // Tick
        for (int i = 0; i < 100; i++) {
            System.out.println("\nNew world step " + i + ":");
            w.tick();
            w.print();
        }

    }

    private static void randomWorld(int dim, world w) {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (Math.random() > 0.5) {
                    w.seed(i, j);
                }
            }
        }
    }
}
