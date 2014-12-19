package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.mixins;

import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases.Cat;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases.Dog;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({ @Type(value = Cat.class, name = "cat"), @Type(value = Dog.class, name = "dog") })
public class AnimalInformation {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
