package doghost;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    private Dog dog1;
    private Dog dog2;

    @BeforeEach
    void criaCachorro(){
        dog1 = new Dog("tot", "Joao", 150);
        dog2 = new Dog("rex", "Pedro", 200);
    }

    @Test
    void testConstrutorValido(){
        Dog dogNormal = new Dog("nome","tutor", 5);
        assertEquals(dogNormal.toString(), "Dog [name=nome, tutor=tutor]");
        assertEquals(5, dogNormal.getConsumoRacao());
        assertEquals("nome", dogNormal.getNome());
        assertEquals("tutor", dogNormal.getTutor());

        Dog dogComRestricao = new Dog("nome", "tutor",
                10, "vegano");
        assertEquals(dogComRestricao.toString(), "Dog [name=nome, tutor=tutor]");
        assertEquals(20, dogComRestricao.getConsumoRacao());
        assertEquals("nome", dogComRestricao.getNome());
        assertEquals("tutor", dogComRestricao.getTutor());
    }

    @Test
    void testConstrutorInvalido(){
        try{
            Dog dogNull = new Dog(null, "Olivia", 3);
            fail("Não lancou erro");
        } catch (NullPointerException npe) { }

        try {
            Dog dogNull = new Dog("rex", "         ", 3);
            fail("Não lancou erro");
        } catch (IllegalArgumentException iae) { }

        try {
            Dog dogNull = new Dog("rex", "Olivia", -4);
            fail("Não lancou erro");
        } catch (IllegalArgumentException iae) { }

        try {
            Dog dogNull = new Dog("", "Olivia", 3);
            fail("Não lancou erro");
        } catch (IllegalArgumentException iae) { }

//        try {
//            Dog dogNull = new Dog("toto", "Olivia", 3);
//            fail("Não lancou erro");
//        } catch (NullPointerException npe){ }

        try {
            Dog tutorNull = new Dog("toto", null, 2599);
            fail("Não lancou erro");
        } catch (NullPointerException npe) { }
    }

    @Test
    void testEquals() {
        assertEquals(dog1, dog1);
        assertFalse(dog1.equals(null));
        assertFalse(dog1.equals("Objeto de outra classe"));

        Dog novoDog = new Dog("tito", "Joao", 15);
        assertFalse(dog1.equals(novoDog));
        novoDog = new Dog("tot", "Joana", 15);
        assertFalse(dog1.equals(novoDog));
        novoDog = new Dog("tot", "Joao", 15);
        assertTrue(dog1.equals(novoDog));
    }

    @Test
    void testHashCode() {
        Dog dog = new Dog("tot", "Joao", 150);
        assertEquals(dog.hashCode(), this.dog1.hashCode());
    }
}