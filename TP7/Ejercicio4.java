package TP7;

class Animal {
    public void hacerSonido() {
        System.out.println("Animal hace un sonido random.");
    }

    public void describirAnimal() {
        System.out.println("Este es un animal.");
    }
}

class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau guau!");
    }
}

class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Miau miau!");
    }
}

class Vaca extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Muuuuu!");
    }
}

class AnimalesDemo {
    public static void main(String[] args) {
        Animal[] animales = { new Perro(), new Gato(), new Vaca() };
        for (Animal a : animales) {
            a.describirAnimal();
            a.hacerSonido();
        }
    }
}