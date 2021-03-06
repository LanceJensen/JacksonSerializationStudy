package daugherty.learning.prototypes.jackson.serialization.study.explicit.serialization;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;











import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.annotated.DerivedAttributeInClassAnnotated;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases.Animal;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases.Cat;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases.DerivedAttributeInClass;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases.Dog;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases.PetOwner;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases.ReadOnlyDto;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.mixins.AnimalInformation;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.mixins.DerivedAttributeInClassInformation;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.mixins.ReadOnlyDtoInformation;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.standard.ConventionalDerivedAttributeInClass;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.standard.ConventionalReadOnlyDto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExplicitSerializationTest {

	private static ObjectMapper mapper;
	
	@BeforeClass
	public static void setup() {
		ObjectMapper mapper = new ObjectMapper();
	}

	@Test
	public void derivedAttribute() throws IOException {
		// Create standard derived attribute
		int[] fibonacciSequence = { 0, 1, 1, 2, 3, 5, 13, 89, 233, 1597 };
		DerivedAttributeInClassAnnotated derAttrObject = new DerivedAttributeInClassAnnotated(
				fibonacciSequence);
		System.out.println("\nTo String:");
		System.out.println(derAttrObject.toString());
		System.out.println("\nJSON:");
		String json = mapper.writeValueAsString(derAttrObject);
		System.out.println(json);
		DerivedAttributeInClassAnnotated inflatedDerAttrObject = mapper.readValue(json,
				DerivedAttributeInClassAnnotated.class);
		System.out.println("\nTo String:");
		System.out.println(inflatedDerAttrObject.toString());
		System.out.println("\nJSON:");
		String inflatedJson = mapper.writeValueAsString(inflatedDerAttrObject);
		System.out.println(inflatedJson);
		assertTrue(derAttrObject.equals(inflatedDerAttrObject));
	}
}
