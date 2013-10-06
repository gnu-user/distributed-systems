import java.util.EventObject;

public class MyEventClass extends EventObject {
	//here's the constructor
  	public MyEventClass(Object source) {
  		super(source);
  	}
}