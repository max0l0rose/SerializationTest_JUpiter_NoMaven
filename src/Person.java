import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Person implements Serializable {
	private int age;
	private String name;
	private Address address; // must be serializable too
}


