package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.standard;

import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases.DerivedAttributeInClass;

public class ConventionalDerivedAttributeInClass extends DerivedAttributeInClass {

	public ConventionalDerivedAttributeInClass() {
		super();
	}
	
	public ConventionalDerivedAttributeInClass(int... integers) {
		super(integers);
	}
	
	public int[] getFibonacciSequence() {
		return this.mNumbers;
	}
	
	private void setFibonacciSequence(int... numbers) {
		this.mNumbers = numbers;
	}
}
