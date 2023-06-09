package ProtectionProxyPattern;

public interface Person
{
	String getName();

	String getGender();

	String getInterests();

	int getHotOrNotRating();

	void setName(String name) throws IllegalAccessException;

	void setGender(String gender) throws IllegalAccessException;

	void setInterests(String interests) throws IllegalAccessException;

	void setHotOrNotRating(int rating) throws IllegalAccessException;
}
