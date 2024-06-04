import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimalTest {

	Animal animal = new Animal();	@Test
	void retornarAnimalTest() {
		assertEquals("Moréia", animal.retornarAnimal("Peixe","Recife","Ovíparo","Moderada"));
	}

}
