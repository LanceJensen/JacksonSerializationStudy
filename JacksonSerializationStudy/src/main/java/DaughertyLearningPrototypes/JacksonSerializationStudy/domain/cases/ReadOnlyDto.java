package DaughertyLearningPrototypes.JacksonSerializationStudy.domain.cases;

public class ReadOnlyDto {
	
	
	protected String mFirstMember;
	protected int mSecondMember;
	
	public ReadOnlyDto(){
		
	}
	
	public ReadOnlyDto(String firstMember, int secondMember) {
		mFirstMember = firstMember;
		mSecondMember = secondMember;
	}
	
	public String getFirstMember() {
		return mFirstMember;
	}
	public int getSecondMember() {
		return mSecondMember;
	}
	
	@Override
	public String toString() {
		return "ReadOnlyDto [mFirstMember=" + mFirstMember + ", mSecondMember="
				+ mSecondMember + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mFirstMember == null) ? 0 : mFirstMember.hashCode());
		result = prime * result + mSecondMember;
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
		ReadOnlyDto other = (ReadOnlyDto) obj;
		if (mFirstMember == null) {
			if (other.mFirstMember != null)
				return false;
		} else if (!mFirstMember.equals(other.mFirstMember))
			return false;
		if (mSecondMember != other.mSecondMember)
			return false;
		return true;
	}
	
	
}
