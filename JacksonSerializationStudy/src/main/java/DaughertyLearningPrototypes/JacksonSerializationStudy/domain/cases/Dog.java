package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases;

public class Dog extends Animal{

	private int mBarkPower;
	private int mBitePower;
	
	public int getBarkPower() {
		return mBarkPower;
	}
	public void setBarkPower(int barkPower) {
		this.mBarkPower = barkPower;
	}
	public int getBitePower() {
		return mBitePower;
	}
	public void setBitePower(int bitePower) {
		this.mBitePower = bitePower;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + mBarkPower;
		result = prime * result + mBitePower;
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
		Dog other = (Dog) obj;
		if (mBarkPower != other.mBarkPower)
			return false;
		if (mBitePower != other.mBitePower)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dog [mBarkPower=" + mBarkPower + ", mBitePower=" + mBitePower
				+ "]";
	}
	
	
}
