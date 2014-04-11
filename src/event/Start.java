package event;

public class Start implements Event {
    String name ;   
	
	public Start()
	{
		name = "Start";
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
         this.name = name;
	}

}
