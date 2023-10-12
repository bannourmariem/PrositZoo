public class Zoo {

    Animal[] animals;
    String name, city;
    final int nbrCages = 25;  // on le rend constante 

    int nbrAnimals;

    public Zoo() {
    }

    public Zoo(String name, String city, int nbrCages) {
        animals = new Animal[nbrCages];
        this.name = name;
        this.city = city;
       // this.nbrCages = nbrCages;
    }

    void displayZoo() {
        System.out.println("Name: " + name + ", City: " + city + ", N° Cages/Animals: " + nbrCages);
    }

    boolean addAnimal(Animal animal) {
        if (searchAnimal(animal) != -1)
            return false;
        if (nbrAnimals == nbrCages)
            return false;
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    boolean removeAnimal(Animal animal) {
        int indexAnimal = searchAnimal(animal);
        if (indexAnimal == -1)
            return false;
        for (int i = indexAnimal; i < nbrAnimals; i++) {
            animals[i] = animals[i + 1];
            animals[nbrAnimals] = null;
            this.nbrAnimals--;
        }
        return true;
    }

    void displayAnimals() {
        System.out.println("Liste des animaux de " + name + ":");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    int searchAnimal(Animal animal) {
        int index = -1;
        for (int i = 0; i < nbrAnimals; i++) {
            if (animal.name == animals[i].name)
                return i;
        }
        return index;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", City: " + city + ", N° Cages/Animals: " + nbrCages;
    }

    //instru 15  comparer zoo 
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals > z2.nbrAnimals) {
            return z1;
        } else if (z1.nbrAnimals < z2.nbrAnimals) {
            return z2;
        } else {
            // si nbanimals in z1 = nbanimals in z2 don retourner soit que z1 ou z2
            System.out.println("les deux zoo sont egeaux");
            return z1;
        }
    }

    // Méthode statique pour vérifier si le zoo est plein
    public static boolean isZooFull(Zoo zoo) {
        return zoo.nbrAnimals >= zoo.nbrCages;
    }
}
