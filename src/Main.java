import services.CreateAnimalServiceImpl;

public class Main {

    public static void main(String[] args) {
        CreateAnimalServiceImpl animalServiceImpl = new CreateAnimalServiceImpl();

        // create 10 animals
        System.out.println("Create 10 animals using CreateAnimalServiceImpl.createAnimals()");
        System.out.println();
        animalServiceImpl.createAnimals();

        // create N animals
        int n = 4;
        System.out.println("Create " + n + " animals using CreateAnimalServiceImpl.createAnimalsN()");
        System.out.println();
        animalServiceImpl.createAnimalsN(n);
    }
}
