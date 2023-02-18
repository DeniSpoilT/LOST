package floraAndFauna.animals;

import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.animals.AnimalFactory;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalFactoryTest {
    public AnimalFactory animalFactory;

    @BeforeEach
    public void init() {
        animalFactory = new AnimalFactory();
    }

    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @EnumSource(AnimalType.class)
    public void createAnimalByAllAnimalTypesTest(AnimalType type) {
        Animal animal = animalFactory.createAnimal(type);
        assertEquals(type, animal.getAnimalType());
    }

    @Test
    public void createAnimalByNullTest() {
        Throwable ex = assertThrows(NullPointerException.class,
                () -> {
                    animalFactory.createAnimal(null);
                });
        assertEquals("Cannot invoke \"com.komarov.lost.floraAndFauna.animals.AnimalType.ordinal()\" because \"type\" is null", ex.getMessage());
    }

    @RepeatedTest(50)
    public void getRandomAnimalTypeTest() {
        AnimalType type = animalFactory.getRandomAnimalType();
        assertTrue(Arrays.asList(AnimalType.values()).contains(type));
    }
}
