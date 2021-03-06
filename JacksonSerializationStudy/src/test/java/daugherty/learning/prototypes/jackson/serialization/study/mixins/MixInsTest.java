package daugherty.learning.prototypes.jackson.serialization.study.mixins;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;










import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

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

public class MixInsTest {

	private static ObjectMapper mapper;

	@BeforeClass
	public static void setup() {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		mapper.addMixInAnnotations(ReadOnlyDto.class, ReadOnlyDtoInformation.class);
		mapper.addMixInAnnotations(DerivedAttributeInClass.class, DerivedAttributeInClassInformation.class);
		mapper.addMixInAnnotations(Animal.class, AnimalInformation.class);
	}

	/**
	 * readOnlyTest - details one of the pitfalls of read only objects and
	 * serialization by conventional means. The project can be searlized easily
	 * but we can not deserialize it without modifying the object or adding
	 * annotations.
	 * 
	 * @throws IOException
	 */
	@Test
	public void readOnlyTest() throws IOException {
		// Create Standard ReadOnly object
		ReadOnlyDto readOnly = new ReadOnlyDto("value", 5);
		System.out.println("\nTo String:");
		System.out.println(readOnly.toString());

		System.out.println("\nJSON:");
		String json = mapper.writeValueAsString(readOnly);
		System.out.println(json);

		ReadOnlyDto inflatedReadOnly = mapper
				.readValue(json, ReadOnlyDto.class);
		System.out.println("\nTo String:");
		System.out.println(inflatedReadOnly.toString());

		System.out.println("\nJSON:");
		String inflatedJson = mapper.writeValueAsString(inflatedReadOnly);
		System.out.println(inflatedJson);

		assertTrue(readOnly.equals(inflatedReadOnly));
	}

	@Test
	public void derivedAttributeTest() throws IOException {
		// Create standard derived attribute
		int[] fibonacciSequence = { 0, 1, 1, 2, 3, 5, 13, 89, 233, 1597 };
		DerivedAttributeInClass derAttrObject = new DerivedAttributeInClass(
				fibonacciSequence);
		System.out.println("\nTo String:");
		System.out.println(derAttrObject.toString());
		System.out.println("\nJSON:");
		String json = mapper.writeValueAsString(derAttrObject);
		System.out.println(json);
		DerivedAttributeInClass inflatedDerAttrObject = mapper.readValue(json,
				DerivedAttributeInClass.class);
		System.out.println("\nTo String:");
		System.out.println(inflatedDerAttrObject.toString());
		System.out.println("\nJSON:");
		String inflatedJson = mapper.writeValueAsString(inflatedDerAttrObject);
		System.out.println(inflatedJson);
		assertTrue(derAttrObject.equals(inflatedDerAttrObject));
	}

	@Test
	public void genericsTest() throws IOException {
		PetOwner owner = new PetOwner();
		owner.setName("Jesse Jensen");
		ArrayList<Animal> pets = new ArrayList<Animal>();
		Cat cat = new Cat();
		cat.setName("Mike");
		cat.setClawPower(10);
		cat.setPurPower(11);
		pets.add(cat);
		Dog dog = new Dog();
		dog.setName("Fido");
		dog.setBarkPower(11);
		dog.setBitePower(0);
		pets.add(dog);
		owner.setPets(pets);
		
		System.out.println("\nTo String:");
		System.out.println(owner.toString());
		System.out.println("\nJSON:");
		String json = mapper.writeValueAsString(owner);
		System.out.println(json);
		PetOwner inflatedOwner = mapper.readValue(json,
				PetOwner.class);
		System.out.println("\nTo String:");
		System.out.println(inflatedOwner.toString());
		System.out.println("\nJSON:");
		String inflatedJson = mapper.writeValueAsString(inflatedOwner);
		System.out.println(inflatedJson);
		assertTrue(owner.equals(inflatedOwner));
		
	}
}
