package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.standard;

import DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases.ReadOnlyDto;

public class ConventionalReadOnlyDto extends ReadOnlyDto {

	private ConventionalReadOnlyDto() {
		super();
	}
	
	public ConventionalReadOnlyDto(String firstMember, int secondMember) {
		super(firstMember, secondMember);
	}

	public void setFirstMember(String firstMember) {
		this.mFirstMember = firstMember;
	}
	
	public void setSecondMember(int secondMember) {
		this.mSecondMember = secondMember;
	}
}
