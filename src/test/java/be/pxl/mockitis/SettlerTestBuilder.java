package be.pxl.mockitis;

public class SettlerTestBuilder
{
	private boolean assignedToDefense;

	public SettlerTestBuilder()
	{
		
	}
	
	public Settler build()
	{
		Settler settler = new Settler(assignedToDefense);
		return settler;
	}
	
	public SettlerTestBuilder withAssignedToDefense(boolean assignedToDefense)
	{
		this.assignedToDefense = assignedToDefense;
		return this;
	}
}
