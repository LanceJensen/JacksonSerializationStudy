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
	
	
}
