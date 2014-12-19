package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.mixins;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ReadOnlyDtoInformation {

	public ReadOnlyDtoInformation(@JsonProperty("firstMember")String firstMember, @JsonProperty("secondMember")int secondMember) {
	}
	
}
