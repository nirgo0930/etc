package JobSearching;

public class Main
{
	public static void main(String[] args)
	{
		JobData jobData = new JobData();

		JobSeeker jobSeeker = new JobSeeker(jobData);

		jobData.jobPosting("영어학원", 3, 150);
		jobData.jobPosting("편의점", 12, 100);
		jobData.jobPosting("배달", 6, 200);
	}
}
