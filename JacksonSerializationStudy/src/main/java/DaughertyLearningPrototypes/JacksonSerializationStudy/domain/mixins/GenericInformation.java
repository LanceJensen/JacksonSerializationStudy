package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.mixins;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility=Visibility.ANY,
getterVisibility=Visibility.NONE, isGetterVisibility=Visibility.NONE)
public abstract class GenericInformation {

	
}
