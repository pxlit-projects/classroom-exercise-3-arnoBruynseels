package be.pxl.mockitis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SettlementTest {

	private List<Raider> raiderList = new ArrayList<Raider>();
	private int amountOfRaiders;
	
	@Before
	public void initRaiderList()
	{
		raiderList.clear();
	}
	
    @Test
    public void settlement_WhenMoreSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
    	
    	Raiders raiders = new RaidersTestBuilder()
    			.withHaslegendary(false)
    			.withActualRaiders(raiderList)
    			.build();
        
        Settler defender = new SettlerTestBuilder().withAssignedToDefense(true).build();
        Settler farmer = new SettlerTestBuilder().withAssignedToDefense(false).build();
        Settler clerk = new SettlerTestBuilder().withAssignedToDefense(false).build();

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);

        Settlement settlement = new Settlement(settlers);

        assertThat(settlement.defend(raiders)).isTrue();
    }

    @Test
    public void settlement_WhenEqualSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
    	
    	amountOfRaiders = 1;
    	
    	//Add amount of raiders
    	for (int i = 0; i < amountOfRaiders; i++)
    	{
    		raiderList.add(new Raider());
		}
    	    	
    	Raiders raiders = new RaidersTestBuilder()
    			.withHaslegendary(true)
    			.withActualRaiders(raiderList)
    			.build();
        
        Settler defender = new SettlerTestBuilder().withAssignedToDefense(true).build();
        Settler farmer = new SettlerTestBuilder().withAssignedToDefense(true).build();
        Settler clerk = new SettlerTestBuilder().withAssignedToDefense(false).build();

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);

        Settlement settlement = new Settlement(settlers);

        assertThat(settlement.defend(raiders)).isTrue();
        
    }

    @Test
    public void settlement_WhenLessSettlersAssignedToDefenseThanAmountOfRaiders_CanNotDefendItself() throws Exception {
    	
    	amountOfRaiders = 2;
    	
    	//Add amount of raiders
    	for (int i = 0; i < amountOfRaiders; i++)
    	{
    		raiderList.add(new Raider());
		}
    	    	
    	Raiders raiders = new RaidersTestBuilder()
    			.withHaslegendary(true)
    			.withActualRaiders(raiderList)
    			.build();
        
        Settler defender = new SettlerTestBuilder().withAssignedToDefense(true).build();
        Settler farmer = new SettlerTestBuilder().withAssignedToDefense(true).build();
        Settler clerk = new SettlerTestBuilder().withAssignedToDefense(false).build();

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);

        Settlement settlement = new Settlement(settlers);

        assertThat(settlement.defend(raiders)).isFalse();
    }
}
