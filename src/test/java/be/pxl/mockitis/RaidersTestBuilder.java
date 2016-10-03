package be.pxl.mockitis;

import java.util.ArrayList;
import java.util.List;

public class RaidersTestBuilder
{
	private boolean hasLegendary;
	private List<Raider> actualRaiders = new ArrayList<Raider>();

	public RaidersTestBuilder()
	{
	}

	public Raiders build()
	{
		Raiders raiders = new Raiders(hasLegendary);
		//Steek elke individuele raider is de raiders groep
		actualRaiders.forEach(raiders::addAttacker);
		return raiders;
	}

	public RaidersTestBuilder withHaslegendary(boolean hasLegendary)
	{
		this.hasLegendary = hasLegendary;
		return this;
	}

	public RaidersTestBuilder withActualRaiders(List<Raider> actualRaiders)
	{
		this.actualRaiders = actualRaiders;
		return this;
	} 
}
