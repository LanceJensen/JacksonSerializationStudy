package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases;

import java.util.List;

/**
 * This class exists to demonstrate type erasure with Jackson.
 * Animals can contain dogs and cats living together! Ahhhh!
 * @author x212662
 *
 */
public class VariousExtendedClassesInList {

	private String mName;
	private List<Animal> mPets;
	
	public String getName() {
		return mName;
	}
	public void setName(String name) {
		this.mName = name;
	}
	public List<Animal> getPets() {
		return mPets;
	}
	public void setPets(List<Animal> pets) {
		this.mPets = pets;
	}
}
