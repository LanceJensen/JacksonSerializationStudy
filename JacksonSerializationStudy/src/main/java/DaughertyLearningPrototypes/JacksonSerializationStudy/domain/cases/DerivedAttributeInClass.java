package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases;

import java.io.IOException;
import java.util.Arrays;

public class DerivedAttributeInClass {

	protected int[] mNumbers = {};
	
	private DerivedAttributeInClass() {
		
	}
	
	private DerivedAttributeInClass(int sum) throws IOException {
		int[] fibonacciSequence = { 0, 1, 1, 2, 3, 5, 13, 89, 233, 1597};
		int total = 0;
		for(int i = 0; i < fibonacciSequence.length; i++) {
			total += fibonacciSequence[i];
			if(total == sum) {
				mNumbers = Arrays.copyOfRange(fibonacciSequence, 0, i +1);
				break;
			}
			if(total > sum) {
				throw new IOException("Invalid State:  The sum passed is not in the fibonacciSequesce.");
				
			}
		}
	}
	
	public DerivedAttributeInClass(int... integers) {
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
		DerivedAttributeInClass other = (DerivedAttributeInClass) obj;
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
