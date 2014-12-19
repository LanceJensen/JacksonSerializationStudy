package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases;

import java.util.List;

/**
 * This class exists to demonstrate type erasure with Jackson.
 * Animals can contain dogs and cats living together! Ahhhh!
 * @author x212662
 *
 */
public class PetOwner {

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
	
	
	@Override
	public String toString() {
		return "PetOwner [mName=" + mName + ", mPets=" + mPets + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + ((mPets == null) ? 0 : mPets.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PetOwner other = (PetOwner) obj;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (mPets == null) {
			if (other.mPets != null)
				return false;
		} else if (!mPets.equals(other.mPets))
			return false;
		return true;
	}
	
	
}
