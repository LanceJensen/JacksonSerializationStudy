package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.mixins;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class DerivedAttributeInClassInformation {

	public DerivedAttributeInClassInformation(@JsonProperty("sumOfNumbers")int sum) {
		
	}
	
}
