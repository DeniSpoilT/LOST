package island;

import com.komarov.lost.floraAndFauna.plants.Plant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class CellTest {
    @Mock
    List<Plant> plantsOnCell;

    @Test
    public void shouldCheckGetPlantsOnCellSize() {
        Mockito.doReturn(25).when(plantsOnCell).size();
        assertEquals(25, plantsOnCell.size());
    }

    @Test
    public void getPlant(){
        Mockito.doReturn(new Plant()).when(plantsOnCell).get(anyInt());
        assertInstanceOf(Plant.class, plantsOnCell.get(2));
    }
}
