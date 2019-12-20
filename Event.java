


/**

 
 * variable = true or false?


 */

public class Event implements Comparable<Event> {
	public final Variable node;
	public final Value value;






	public Event(Variable node, Value outcome) {

		if (node.domain.containsValue(outcome)) {

			this.node = node;

			this.value = outcome;

		} else

			throw new ValidationError("null value not accepted for events.");

	}


	public Event(Variable node, String outcome) {
		if (node.domain.containsKey(outcome)) {
			this.node = node;
			this.value = node.domain.get(outcome);

		} else
			throw new ValidationError("Variable <" + node.name + "> does not contain the value \"" + outcome + "\".");

	}

	

	@Override

	public int compareTo(Event other) {
		if (node == other.node) {
			return value.compareTo(other.value);
		} else {
			return node.name.compareTo(other.node.name);
		}

	}

	
	

	
	
	public boolean equals(Event other) {
		return other.node == node && other.value == value;

	}


//for store
	public int hashCode() {
		return node.hashCode() * value.hashCode();

	}



	public boolean equals(Object other) {
		if (other instanceof Event)
			return equals((Event) other);
		return false;

	}





	public String toString() {
		return node.name + " = " + value.name;

	}

}
