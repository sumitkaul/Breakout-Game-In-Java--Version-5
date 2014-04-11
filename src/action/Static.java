package action;

public class Static implements Action {
     private String name;
     
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		 this.name= name;
	}

	@Override
	public void performAction() {

	}

}
