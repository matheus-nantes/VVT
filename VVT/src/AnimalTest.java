import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimalTest {

	Animal animal = new Animal();	@Test
	void retornarAnimalTest() {
		assertEquals("Sapo Venenoso", animal.retornarAnimal("Anfíbio","Tropical","Ovíparo","Alta"));
	}

}
