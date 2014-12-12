package daugherty.learning.prototypes.jackson.serialization.study.conventional.minimum.annotations;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases.DerivedAttributeInClass;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases.ReadOnlyDto;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.standard.ConventionalDerivedAttributeInClass;
import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.standard.ConventionalReadOnlyDto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConventionalTest {

	private static ObjectMapper mapper;

	@BeforeClass
	public static void setup() {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
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

		assertFalse(readOnly.equals(inflatedReadOnly));
	}

	/**
	 * readOnlyTestWithSetters - is a proof of concept that a read only class
	 * can be successfully deserilized by adding the conventional setters. To
	 * see the differences compare ConventiaonlReadOnlyDto with ReadOnlyDto.
	 * 
	 * @throws IOException
	 */
	@Test
	public void readOnlyTestWithSetters() throws IOException {
		// Create Standard ReadOnly object
		ConventionalReadOnlyDto readOnly = new ConventionalReadOnlyDto("value",
				5);
		System.out.println("\nTo String:");
		System.out.println(readOnly.toString());

		System.out.println("\nJSON:");
		String json = mapper.writeValueAsString(readOnly);
		System.out.println(json);

		ConventionalReadOnlyDto inflatedReadOnly = mapper.readValue(json,
				ConventionalReadOnlyDto.class);
		System.out.println("\nTo String:");
		System.out.println(inflatedReadOnly.toString());

		System.out.println("\nJSON:");
		String inflatedJson = mapper.writeValueAsString(inflatedReadOnly);
		System.out.println(inflatedJson);

		assertTrue(readOnly.equals(inflatedReadOnly));
	}

	@Test
	public void derivedAttributeTest() throws IOException {
		// Create standard derivied attribute
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
		assertFalse(derAttrObject.equals(inflatedDerAttrObject));
	}
	
	@Test
	public void derivedAttributeTestWithSideloadConstructor() throws IOException {
		// Create standard derivied attribute
		int[] fibonacciSequence = { 0, 1, 1, 2, 3, 5, 13, 89, 233, 1597 };
		ConventionalDerivedAttributeInClass derAttrObject = new ConventionalDerivedAttributeInClass(
				fibonacciSequence);

		System.out.println("\nTo String:");
		System.out.println(derAttrObject.toString());

		System.out.println("\nJSON:");
		String json = mapper.writeValueAsString(derAttrObject);
		System.out.println(json);

		ConventionalDerivedAttributeInClass inflatedDerAttrObject = mapper.readValue(json,
				ConventionalDerivedAttributeInClass.class);
		System.out.println("\nTo String:");
		System.out.println(inflatedDerAttrObject.toString());

		System.out.println("\nJSON:");
		String inflatedJson = mapper.writeValueAsString(inflatedDerAttrObject);
		System.out.println(inflatedJson);
		assertTrue(derAttrObject.equals(inflatedDerAttrObject));

	}
	
	

	@Test
	public void genericsTest() {

	}
}
