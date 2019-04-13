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
    void testConstrutor(){
        Dog d = new Dog("nome","tutor", 5);
        assertEquals(d, "Dog [name=nome, tutor=tutor]");

        try{
            Dog dogNull = new Dog(null, "Olivia", 3);
            fail("Não lancou erro");
        } catch (NullPointerException npe) {
        }
        try {
            Dog dogNull = new Dog("rex", "         ", 3);
            fail("Não lancou erro");
        } catch (IllegalArgumentException iae) {
        }
        try {
            Dog dogNull = new Dog("rex", "Olivia", -4);
            fail("Não lancou erro");
        } catch (IllegalArgumentException iae) {
        }
        try {
            Dog dogNull = new Dog("", "Olivia", 3);
            fail("Não lancou erro");
        } catch (IllegalArgumentException iae) {

        }
//        try {
//            Dog dogNull = new Dog("toto", "Olivia", 3);
//            fail("Não lancou erro");
//        } catch (NullPointerException npe){
//
//        }
        try {
            Dog tutorNull = new Dog("toto", null, 2599);
            fail("Não lancou erro");
        } catch (NullPointerException npe) {

        }
    }

    @Test
    void getConsumoRacao() {

    }

    @Test
    void toString1() {
    }

    @Test
    void equals1() {
    }

    @Test
    void hashCode1() {
    }
}