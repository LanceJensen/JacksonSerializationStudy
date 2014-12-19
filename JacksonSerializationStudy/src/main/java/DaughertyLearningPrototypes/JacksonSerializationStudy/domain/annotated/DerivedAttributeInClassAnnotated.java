package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.annotated;

import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DerivedAttributeInClassAnnotated {

	@JsonProperty("numbers")
//	@JsonAutoDetect
	private int[] mNumbers = {};
	
	
	public DerivedAttributeInClassAnnotated(int... integers) {
		mNumbers = integers;
	}
	
	public int getSumOfNumbers() {
		if(mNumbers.length == 0) {
			return 0;
		}
		int sum = 0;
		for(int num : mNumbers) {
			sum += num;
		}
		return sum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(mNumbers);
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
		DerivedAttributeInClassAnnotated other = (DerivedAttributeInClassAnnotated) obj;
		if (!Arrays.equals(mNumbers, other.mNumbers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DerivedAttributeInClass [mNumbers=" + Arrays.toString(mNumbers)
				+ "]";
	}
}
