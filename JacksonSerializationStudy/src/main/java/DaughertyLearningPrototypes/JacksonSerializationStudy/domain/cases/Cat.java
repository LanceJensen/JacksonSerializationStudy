package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases;

public class Cat extends Animal {

	private int mPurPower;
	private int mClawPower;
	
	public int getPurPower() {
		return mPurPower;
	}
	public void setPurPower(int purPower) {
		this.mPurPower = purPower;
	}
	public int getClawPower() {
		return mClawPower;
	}
	public void setClawPower(int clawPower) {
		this.mClawPower = clawPower;
	}
	@Override
	public String toString() {
		return "Cat [mPurPower=" + mPurPower + ", mClawPower=" + mClawPower
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + mClawPower;
		result = prime * result + mPurPower;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (mClawPower != other.mClawPower)
			return false;
		if (mPurPower != other.mPurPower)
			return false;
		return true;
	}
	
	
}
