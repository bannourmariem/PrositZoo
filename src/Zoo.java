public class Zoo {

    private Animal[] animals;
    private String city;
    private String name;
    private final int nbrCages = 25;  // on le rend constant
    private int nbrAnimals;


    public Zoo() {
    }

    public Zoo(String name, String city, int nbrCages) {
        animals = new Animal[nbrCages];
        this.name = name;
        this.city = city;
       // this.nbrCages = nbrCages;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isBlank()) {
            this.name = name;
        } else {
            System.out.println("Nom du Zoo Inconnu");
        }
    }


    public int getNbrCages() {
        return nbrCages;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }


    void displayZoo() {
        System.out.println("Name: " + name + ", City: " + city + ", N° Cages/Animals: " + nbrCages);
    }

  /*  boolean addAnimal(Animal animal) {
        if (searchAnimal(animal) != -1)
            return false;
        if (nbrAnimals == nbrCages)
            return false;
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }  */

  public boolean addAnimal(Animal animal) {
      if (searchAnimal(animal) != -1) {
          return false; // L'animal est déjà dans le zoo
      }

      if (isZooFull(this)) {
          return false; // Le zoo est plein, impossible d'ajouter plus d'animaux
      }
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
            if (animal.getName() == animals[i].getName())
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
