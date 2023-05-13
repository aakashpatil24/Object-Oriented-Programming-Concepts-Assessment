import java.util.ArrayList;;

class Candidate {
	private String name;
	private String dateOfBirth;
	private String address;
	private String email;
	private String phoneNumber;
	private double hscPCMPercentage;
	private double hscPCBPercentage;
	private double ugCGPA;
	private double pgCGPA;
	private int numberOfProjects;
	private boolean isFullTime;
	private double interviewMarks;
	private boolean isIndianCitizen;

	public Candidate(String name, String dateOfBirth, String address, String email, String phoneNumber,
			double hscPCMPercentage, double hscPCBPercentage, double ugCGPA, double pgCGPA, int numberOfProjects,
			boolean isFullTime, double interviewMarks, boolean isIndianCitizen) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hscPCMPercentage = hscPCMPercentage;
		this.hscPCBPercentage = hscPCBPercentage;
		this.ugCGPA = ugCGPA;
		this.pgCGPA = pgCGPA;
		this.numberOfProjects = numberOfProjects;
		this.isFullTime = isFullTime;
		this.interviewMarks = interviewMarks;
		this.isIndianCitizen = isIndianCitizen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getHscPCMPercentage() {
		return hscPCMPercentage;
	}

	public void setHscPCMPercentage(double hscPCMPercentage) {
		this.hscPCMPercentage = hscPCMPercentage;
	}

	public double getHscPCBPercentage() {
		return hscPCBPercentage;
	}

	public void setHscPCBPercentage(double hscPCBPercentage) {
		this.hscPCBPercentage = hscPCBPercentage;
	}

	public double getUgCGPA() {
		return ugCGPA;
	}

	public void setUgCGPA(double ugCGPA) {
		this.ugCGPA = ugCGPA;
	}

	public double getPgCGPA() {
		return pgCGPA;
	}

	public void setPgCGPA(double pgCGPA) {
		this.pgCGPA = pgCGPA;
	}

	public int getNumberOfProjects() {
		return numberOfProjects;
	}

	public void setNumberOfProjects(int numberOfProjects) {
		this.numberOfProjects = numberOfProjects;
	}

	public boolean isFullTime() {
		return isFullTime;
	}

	public void setFullTime(boolean fullTime) {
		isFullTime = fullTime;
	}

	public double getInterviewMarks() {
		return interviewMarks;
	}

	public void setInterviewMarks(double interviewMarks) {
		this.interviewMarks = interviewMarks;
	}

	public boolean isIndianCitizen() {
		return isIndianCitizen;
	}

	public void setIndianCitizen(boolean indianCitizen) {

		isIndianCitizen = indianCitizen;
	}

	public boolean isEligible() {
		// Check all the eligibility criteria and return true or false accordingly
		boolean isEligible = true;
		if (!isIndianCitizen || dateOfBirth.compareTo("1999/07/01") < 0) {
			isEligible = false;
		}
		if (hscPCMPercentage < 60) {
			isEligible = false;
		} else if ((hscPCMPercentage < 50 && (hscPCBPercentage < 50 || !isFullTime))
				|| (hscPCBPercentage < 50 && (hscPCMPercentage < 50 || !isFullTime))) {
			isEligible = false;
		}
		if (ugCGPA < 8 || pgCGPA < 8) {
			isEligible = false;
		}
		if (numberOfProjects < 2 || !isFullTime) {
			isEligible = false;
		}
		if (interviewMarks < 35) {
			isEligible = false;
		}
		return isEligible;
	}
}

class RecruitmentProcess {
	private ArrayList<Candidate> candidates;

	public RecruitmentProcess() {
		this.candidates = new ArrayList<>();
	}

	public void addCandidate(Candidate candidate) {
		candidates.add(candidate);
	}

	public ArrayList<Candidate> getEligibleCandidates() {
		ArrayList<Candidate> eligibleCandidates = new ArrayList<>();
		for (Candidate candidate : candidates) {
			if (candidate.isEligible()) {
				eligibleCandidates.add(candidate);
			}
		}
		return eligibleCandidates;
	}

	public void informCandidates() {
		ArrayList<Candidate> eligibleCandidates = getEligibleCandidates();
		for (Candidate candidate : eligibleCandidates) {
			String message = "Dear " + candidate.getName() + ",\n\n"
					+ "Congratulations! You have been selected for employment at ABC.\n\n"
					+ "Please contact our HR team to schedule a meeting for further instructions.\n\n"
					+ "Thank you for your interest in our company.\n\n" + "Best regards,\n" + "ABC Recruitment Team";
			System.out.println(message);
			System.out.println("Email sent to " + candidate.getEmail());
		}
	}
}

class ABC {
	public static void main(String[] args) {
		RecruitmentProcess recruitmentProcess = new RecruitmentProcess();

		Candidate candidate1 = new Candidate("Piyusha Kadam", "2000/08/08", "Kusgaon, Lonavala,India",
				"piyushakadam@gmail.com", "1234567890", 85, 90, 9.5, 9.0, 3, true, 40, true);

		Candidate candidate2 = new Candidate("Aakash Patil", "2001/09/24", "Savda,Jalgoan,INDIA", "aakash@gmail.com", "9876543210", 95,
				95, 9.0, 9.0, 8, true, 95, true);

		Candidate candidate3 = new Candidate("Bob Smith", "1998/07/01", "789 Elm St, Anytown, USA",
				"bobsmith@gmail.com", "5555555555", 90, 80, 8.5, 8.5, 2, true, 30, true);

		recruitmentProcess.addCandidate(candidate1);
		recruitmentProcess.addCandidate(candidate2);
		recruitmentProcess.addCandidate(candidate3);

		((RecruitmentProcess) recruitmentProcess).informCandidates();

	}
}