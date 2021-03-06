package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import com.mlsd.utilities.Utilities;
import com.mlsd.xom.common.Appeal.AppealType;
import com.mlsd.xom.common.AssetDetails.AssetSource;
import com.mlsd.xom.common.AssetDetails.AssetUseType;
import com.mlsd.xom.common.BenefitDetails.ProgramType;
import com.mlsd.xom.common.HomeWorkerDetails.WorkType;
import com.mlsd.xom.common.IncomeDetails.IncomeType;

/**
 * The Person object is the basic information a person can have as well as the
 * common details among all services that uses a Person.
 *
 * @author Ahmed Sharafeldin
 */
public class Person {

	/**
	 * The gender of the person.
	 * 
	 * @author Ahmed Sharafeldin
	 *
	 */
	public enum Gender {
		MALE, FEMALE
	}

	/**
	 * The marital status of the person.
	 * 
	 * @author Ahmed Sharafeldin
	 *
	 */
	public enum MaritalStatus {
		SINGLE, MARRIED, DIVORCED, WIDOWED
	}

	/* Logging constants used inside this class. */
	public static final String personClassName = Person.class.getName();
	public static final Logger logger = Logger.getLogger(personClassName);

	/* Default values for dynamic domain attributes. */
	private static final String DEFAULT_ID_TYPE = "National ID";
	private static final String DEFAULT_NATIONALITY = "Saudi Arabia";
	private static final String TEMPORARY_RESIDENCY_REASON = "Accompanying a dependent";

	private int age = 17;
	private String id = "";
	private String nin = "";
	private String name = "";
	private String idType = DEFAULT_ID_TYPE;
	private String nationality = DEFAULT_NATIONALITY;

	private Gender gender = Gender.MALE;
	private MaritalStatus maritalStatus = MaritalStatus.SINGLE;

	private boolean isEmployed = false;
	private boolean isBlacklisted = false;
	private boolean residencyFlag = false;
	private boolean militaryStatus = false;
	private boolean personExistsInCRM = true;
	private boolean personExistsInNIC = true;
	private boolean documentsAreValid = true;
	private boolean dependentIsApproved = true;
	private boolean hasAPrivateBusiness = false;
	private boolean livesInAGovernmentHouse = false;

	private int noOfOffsprings = 0;
	private int numberOfHomeWorkers = 0;
	private int numberOfCommercialWorkers = 0;

	private List<Appeal> appeals = new ArrayList<>();
	private List<AssetDetails> assets = new ArrayList<>();
	private List<SourceMapper> sourcesMap = new ArrayList<>();
	private List<IncomeDetails> incomeDetails = new ArrayList<>();
	private List<BenefitDetails> benefitDetails = new ArrayList<>();
	private List<HomeWorkerDetails> homeWorkers = new ArrayList<>();
	private List<CommercialWorkerDetails> commercialWorkers = new ArrayList<>();

	private VitalityDetails vitalityStatus = new VitalityDetails();
	private MedicalCondition medicalCondition = new MedicalCondition();
	private EducationDetails educationDetails = new EducationDetails();
	private ImprisonmentDetails imprisonment = new ImprisonmentDetails();
	private GuardianshipStatus guardianshipstatus = new GuardianshipStatus();
	private PersonalStatusDetails statusDetails = new PersonalStatusDetails();
	private RejectionMessagesContainer rejectionMessages = new RejectionMessagesContainer();
	private ResidencyDetailsOutsideKSA residencyOutsideKSA = new ResidencyDetailsOutsideKSA();

	public Person() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public boolean isHasAPrivateBusiness() {
		return hasAPrivateBusiness;
	}

	public void setHasAPrivateBusiness(boolean hasAPrivateBusiness) {
		this.hasAPrivateBusiness = hasAPrivateBusiness;
	}

	public boolean isBlacklisted() {
		return isBlacklisted;
	}

	public void setBlacklisted(boolean isBlacklisted) {
		this.isBlacklisted = isBlacklisted;
	}

	public List<BenefitDetails> getBenefitDetails() {
		if (benefitDetails == null)
			benefitDetails = new ArrayList<>();
		return benefitDetails;
	}

	public void setBenefitDetails(List<BenefitDetails> benefitDetails) {
		this.benefitDetails = benefitDetails;
	}

	public PersonalStatusDetails getStatusDetails() {
		if (statusDetails == null)
			statusDetails = new PersonalStatusDetails();
		return statusDetails;
	}

	public void setStatusDetails(PersonalStatusDetails statusDetails) {
		this.statusDetails = statusDetails;
	}

	public MedicalCondition getMedicalCondition() {
		if (medicalCondition == null)
			medicalCondition = new MedicalCondition();
		return medicalCondition;
	}

	public void setMedicalCondition(MedicalCondition medicalCondition) {
		this.medicalCondition = medicalCondition;
	}

	public List<Appeal> getAppeals() {
		if (appeals == null)
			appeals = new ArrayList<>();
		return appeals;
	}

	public void setAppeals(List<Appeal> appeals) {
		this.appeals = appeals;
	}

	public GuardianshipStatus getGuardianshipstatus() {
		if (guardianshipstatus == null)
			guardianshipstatus = new GuardianshipStatus();
		return guardianshipstatus;
	}

	public void setGuardianshipstatus(GuardianshipStatus guardianshipstatus) {
		this.guardianshipstatus = guardianshipstatus;
	}

	/**
	 * The home workers used by the service is a number, however the business
	 * rule process on a list. This method converts the number into default
	 * records in the list.
	 * 
	 * @return the home workers as a list.
	 */
	public List<HomeWorkerDetails> getHomeWorkers() {
		if (homeWorkers == null) {
			homeWorkers = new ArrayList<>();
		}
		int noOfHomeWorkers = this.getNumberOfHomeWorkers();
		if (noOfHomeWorkers != homeWorkers.size()) {
			HomeWorkerDetails homeWorker = new HomeWorkerDetails();
			while (noOfHomeWorkers > 0) {
				homeWorkers.add(homeWorker);
				noOfHomeWorkers--;
			}
		}
		return homeWorkers;
	}

	public void setHomeWorkers(List<HomeWorkerDetails> homeWorkers) {
		this.homeWorkers = homeWorkers;
	}

	/**
	 * The commercial workers used by the service is a number, however the
	 * business rule process on a list. This method converts the number into
	 * default records in the list.
	 * 
	 * @return the commercial workers as a list.
	 */
	public List<CommercialWorkerDetails> getCommercialWorkers() {
		if (commercialWorkers == null) {
			commercialWorkers = new ArrayList<>();
		}
		int noOfCommercialWorkers = this.getNumberOfCommercialWorkers();
		CommercialWorkerDetails commercialWorker = new CommercialWorkerDetails();
		for (int i = 0; i < noOfCommercialWorkers; i++) {
			commercialWorkers.add(commercialWorker);
		}
		return commercialWorkers;
	}

	public void setCommercialWorkers(List<CommercialWorkerDetails> commercialWorkers) {
		this.commercialWorkers = commercialWorkers;
	}

	public List<AssetDetails> getAssets() {
		if (assets == null)
			assets = new ArrayList<>();
		return assets;
	}

	public void setAssets(List<AssetDetails> assets) {
		this.assets = assets;
	}

	public int getNoOfOffsprings() {
		return noOfOffsprings;
	}

	public void setNoOfOffsprings(int noOfOffsprings) {
		this.noOfOffsprings = noOfOffsprings;
	}

	public int getNumberOfHomeWorkers() {
		return numberOfHomeWorkers;
	}

	public void setNumberOfHomeWorkers(int numberOfHomeWorkers) {
		this.numberOfHomeWorkers = numberOfHomeWorkers;
	}

	public int getNumberOfCommercialWorkers() {
		return numberOfCommercialWorkers;
	}

	public void setNumberOfCommercialWorkers(int numberOfCommercialWorkers) {
		this.numberOfCommercialWorkers = numberOfCommercialWorkers;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		if (name == null)
			name = "";
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		if (gender == null)
			gender = Gender.MALE;
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public MaritalStatus getMaritalStatus() {
		if (maritalStatus == null)
			maritalStatus = MaritalStatus.SINGLE;
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNationality() {
		if (nationality == null)
			nationality = "";
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public boolean isLivesInAGovernmentHouse() {
		return livesInAGovernmentHouse;
	}

	public void setLivesInAGovernmentHouse(boolean livesInAGovernmentShelter) {
		this.livesInAGovernmentHouse = livesInAGovernmentShelter;
	}

	public boolean isEmployed() {
		return isEmployed;
	}

	public void setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}

	public VitalityDetails getVitalityStatus() {
		if (vitalityStatus == null)
			vitalityStatus = new VitalityDetails();
		return vitalityStatus;
	}

	public void setVitalityStatus(VitalityDetails vitalityStatus) {
		this.vitalityStatus = vitalityStatus;
	}

	public EducationDetails getEducationDetails() {
		if (educationDetails == null)
			educationDetails = new EducationDetails();
		return educationDetails;
	}

	public void setEducationDetails(EducationDetails profession) {
		this.educationDetails = profession;
	}

	public ResidencyDetailsOutsideKSA getResidencyOutsideKSA() {
		if (residencyOutsideKSA == null)
			residencyOutsideKSA = new ResidencyDetailsOutsideKSA();
		return residencyOutsideKSA;
	}

	public void setResidencyOutsideKSA(ResidencyDetailsOutsideKSA residency) {
		this.residencyOutsideKSA = residency;
	}

	public ImprisonmentDetails getImprisonment() {
		if (imprisonment == null)
			imprisonment = new ImprisonmentDetails();
		return imprisonment;
	}

	public void setImprisonment(ImprisonmentDetails imprisonment) {
		this.imprisonment = imprisonment;
	}

	public List<IncomeDetails> getIncomeDetails() {
		if (incomeDetails == null)
			incomeDetails = new ArrayList<>();
		return incomeDetails;
	}

	public void setIncomeDetails(List<IncomeDetails> employments) {
		incomeDetails = employments;
	}

	public RejectionMessagesContainer getRejectionMessages() {
		if (rejectionMessages == null)
			rejectionMessages = new RejectionMessagesContainer();
		return rejectionMessages;
	}

	public void setRejectionMessages(RejectionMessagesContainer rejectionMessages) {
		this.rejectionMessages = rejectionMessages;
	}

	public String getId() {
		if (id == null)
			id = "";
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNin() {
		if (nin == null)
			nin = "";
		return nin;
	}

	public void setNin(String nin) {
		this.nin = nin;
	}

	public String getIdType() {
		if (idType == null)
			idType = "";
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public List<SourceMapper> getSourcesMap() {
		if (sourcesMap == null)
			sourcesMap = new ArrayList<>();
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

	public boolean isMilitaryStatus() {
		return militaryStatus;
	}

	public void setMilitaryStatus(boolean militaryStatus) {
		this.militaryStatus = militaryStatus;
	}

	public boolean isPersonExistsInCRM() {
		return personExistsInCRM;
	}

	public void setPersonExistsInCRM(boolean personExistsInCRM) {
		this.personExistsInCRM = personExistsInCRM;
	}

	public boolean isPersonExistsInNIC() {
		return personExistsInNIC;
	}

	public void setPersonExistsInNIC(boolean personExistsInNIC) {
		this.personExistsInNIC = personExistsInNIC;
	}

	public boolean isDependentIsApproved() {
		return dependentIsApproved;
	}

	public void setDependentIsApproved(boolean dependentIsApproved) {
		this.dependentIsApproved = dependentIsApproved;
	}

	public boolean isDocumentsAreValid() {
		return documentsAreValid;
	}

	public void setDocumentsAreValid(boolean documentsAreValid) {
		this.documentsAreValid = documentsAreValid;
	}

	public static String getDefaultIdType() {
		return DEFAULT_ID_TYPE;
	}

	public static String getDefaultNationality() {
		return DEFAULT_NATIONALITY;
	}

	public static String getTemporaryResidencyReason() {
		return TEMPORARY_RESIDENCY_REASON;
	}

	public boolean isResidencyFlag() {
		return residencyFlag;
	}

	public void setResidencyFlag(boolean residencyFlag) {
		this.residencyFlag = residencyFlag;
	}

	public boolean isDeceased() {
		VitalityDetails vitality = this.getVitalityStatus();
		return vitality.isDeceased();
	}

	public boolean isAlive() {
		return !this.isDeceased();
	}

	// ////////////// Added functions //////////////////////////////////

	/**
	 * Adds a rejection message record to the full rejection messages list.
	 * 
	 * @param rejectionMessage
	 *            the message record to be added.
	 */
	public void setRejectionMessage(RejectionMessageDetails rejectionMessage) {
		String sourceMethod = "setRejectionMessage";
		logger.entering(personClassName, sourceMethod);
		List<RejectionMessageDetails> rejectionMsgs = rejectionMessages.getRejectionMsg();
		if (rejectionMsgs == null) {
			rejectionMsgs = new ArrayList<>();
		}
		if (rejectionMsgs.size() > 0) {
			String msgCode = rejectionMessage.getMessageCode();
			if (msgCode != null) {
				for (RejectionMessageDetails message : rejectionMsgs) {
					if (msgCode.equals(message.getMessageCode())) {
						logger.exiting(personClassName, sourceMethod);
						return;
					}
				}
			}
		}
		logger.exiting(personClassName, sourceMethod);
		rejectionMsgs.add(rejectionMessage);
	}

	/**
	 * Checks if the person has a valid absence reason. If he's resident outside
	 * KSA or at least exceeds the specified period.
	 * 
	 * @return the validity of the absence reason.
	 */
	public boolean hasAValidAbsenceReason() {
		String sourceMethod = "hasAValidAbsenceReason";
		logger.entering(personClassName, sourceMethod);
		ResidencyDetailsOutsideKSA residency = this.getResidencyOutsideKSA();
		if (residency != null && TEMPORARY_RESIDENCY_REASON.equals(residency.getReasonForTemporaryResidency())) {
			logger.exiting(personClassName, sourceMethod, true);
			return true;
		} else {
			logger.exiting(personClassName, sourceMethod, false);
			return false;
		}
	}

	/**
	 * Checks if the absence duration from the country has exceeded a specific
	 * period of time in days or not.
	 * 
	 * @param noofdays
	 *            : the number of days the applicant spent outside the country.
	 * @return whether the absence duration exceeds the number of days.
	 */
	public boolean absenceDurationFromTheCountryisGreaterThan(int noofdays) {
		String sourceMethod = "absenceDurationFromTheCountryisGreaterThan";
		logger.entering(personClassName, sourceMethod);
		int days = this.getResidencyOutsideKSA().getNoOfDaysOutsideKSA();
		if (days > noofdays) {
			logger.exiting(personClassName, sourceMethod, true);
			return true;
		} else {
			logger.exiting(personClassName, sourceMethod, false);
			return false;
		}

	}

	/**
	 * Checks if the applicant total income of type Salary exceeds a specific
	 * limit.
	 * 
	 * @param threshold
	 *            : the value that is compared with the applicant income.
	 * @return if the applicant total salary exceeds the threshold or not.
	 */
	public boolean totalApplicantSalaryIsMoreThan(int threshold) {
		String sourceMethod = "totalApplicantSalaryIsMoreThan";
		logger.entering(personClassName, sourceMethod);
		int sum = 0;
		List<IncomeDetails> applicantIncomeDetails = this.getIncomeDetails();
		if (applicantIncomeDetails != null && applicantIncomeDetails.size() > 0) {
			for (IncomeDetails incomeDetail : applicantIncomeDetails) {
				if (IncomeType.SALARY.equals(incomeDetail.getIncomeType())) {
					sum += incomeDetail.getIncomeAmount();
				}
			}
		}
		if (sum > threshold) {
			logger.exiting(personClassName, sourceMethod, true);
			return true;
		} else {
			logger.exiting(personClassName, sourceMethod, false);
			return false;
		}
	}

	/**
	 * Compares the total applicant income (regardless of the type) with a
	 * threshold. Used for AdHoc service, One Time Support.
	 * 
	 * @param threshold
	 *            the value to compare with
	 * @return whether the total applicant income is more than the threshold
	 */
	public boolean totalApplicantIncomeIsMoreThanThreshold(int threshold) {
		String sourceMethod = "totalApplicantIncomeIsMoreThanThreshold";
		logger.entering(personClassName, sourceMethod);
		int sum = 0;
		List<IncomeDetails> applicantIncomeDetails = this.getIncomeDetails();
		if (applicantIncomeDetails != null && applicantIncomeDetails.size() > 0) {
			for (IncomeDetails incomeDetail : applicantIncomeDetails)
				sum += incomeDetail.getIncomeAmount();
		}
		if (sum > threshold) {
			logger.exiting(personClassName, sourceMethod, true);
			return true;
		} else {
			logger.exiting(personClassName, sourceMethod, false);
			return false;
		}
	}

	/**
	 * Checks if the person has an income of type Private Business.
	 * 
	 * @return whether there is an income of type Private Business.
	 */
	public boolean incomeTypesDoesNotIncludeAPrivateBusiness() {
		String sourceMethod = "incomeTypesDoesNotIncludeAPrivateBusiness";
		logger.entering(personClassName, sourceMethod);
		List<IncomeDetails> personIncomeDetails = this.getIncomeDetails();
		if (personIncomeDetails != null) {
			for (IncomeDetails incomeDetail : personIncomeDetails) {
				if (IncomeType.PRIVATEBUSINESS.equals(incomeDetail.getIncomeType())) {
					logger.exiting(personClassName, sourceMethod, false);
					return false;
				}
			}
		}
		logger.exiting(personClassName, sourceMethod, true);
		return true;
	}

	/**
	 * Checks if the person has any redundant home workers. Currently this
	 * function is not in use since the home workers are being checked by a
	 * number.
	 * 
	 * @return whether there is redundancy or not.
	 */
	public boolean hasRedundentHomeWorkers() {
		String sourceMethod = "hasRedundentHomeWorkers";
		logger.entering(personClassName, sourceMethod);
		WorkType first;
		WorkType second;
		WorkType third;
		List<HomeWorkerDetails> applicantHomeWorkers = this.getHomeWorkers();
		if (applicantHomeWorkers != null) {
			if (applicantHomeWorkers.size() == 2) {
				first = applicantHomeWorkers.get(0).getTypeOfWork();
				second = applicantHomeWorkers.get(1).getTypeOfWork();
				if (first.equals(second)) {
					logger.exiting(personClassName, sourceMethod, true);
					return true;
				}
			}
			if (applicantHomeWorkers.size() == 3) {
				first = applicantHomeWorkers.get(0).getTypeOfWork();
				second = applicantHomeWorkers.get(1).getTypeOfWork();
				third = applicantHomeWorkers.get(2).getTypeOfWork();
				if (first.equals(second) || first.equals(third) || second.equals(third)) {
					logger.exiting(personClassName, sourceMethod, true);
					return true;
				}
			}
		}
		logger.exiting(personClassName, sourceMethod, false);
		return false;
	}

	/**
	 * Checks the report date of the personal status details is expired or
	 * valid.
	 * 
	 * @param noofdays
	 *            : the number of days the report is valid.
	 * @return whether the person status report date exceeds a specific time in
	 *         days.
	 */
	public boolean reportDateExpirationIsLessThan(int noofdays) {
		String sourceMethod = "ReportDateExpirationIsLessThan";
		logger.entering(personClassName, sourceMethod);
		Calendar statusReportDate = this.getStatusDetails().getStatusReportDate();
		if (statusReportDate == null) {
			statusReportDate = Calendar.getInstance();
		}
		int days = Utilities.daysBetween(Calendar.getInstance().getTime(), statusReportDate.getTime());
		if (days > noofdays) {
			logger.exiting(personClassName, sourceMethod, true);
			return true;
		} else {
			logger.exiting(personClassName, sourceMethod, false);
			return false;
		}
	}

	/**
	 * Checks the availability of an appeal within the persons appeals list.
	 * 
	 * @param appealType
	 *            : The appeal type to test with the existing appeals of the
	 *            person.
	 * @return whether a specific appeal type doesn't exist in the persons
	 *         appeals.
	 */
	public boolean appealTypeDoesntExistInAppeals(AppealType appealType) {
		String sourceMethod = "appealTypeDoesntExistInAppeals";
		logger.entering(personClassName, sourceMethod);
		List<Appeal> appealsList = this.getAppeals();

		if (appealsList != null && appealType != null) {
			for (Appeal appeal : appealsList) {
				AppealType personAppealType = appeal.getAppealType();
				if (personAppealType.equals(appealType)) {
					logger.exiting(personClassName, sourceMethod, false);
					return false;
				}
			}
		}
		logger.exiting(personClassName, sourceMethod, true);
		return true;
	}

	/**
	 * Checks the status of the appeal.
	 * 
	 * @param appealType
	 *            : The type of appeal to be checked.
	 * @return whether the appeal is approved.
	 */
	public boolean appealStatusIsApproved(AppealType appealType) {
		String sourceMethod = "appealStatusIsApproved";
		logger.entering(personClassName, sourceMethod);
		List<Appeal> appealsList = this.getAppeals();
		if (appealsList != null && appealType != null) {
			for (Appeal appeal : appealsList) {
				if (appeal.getAppealType().equals(appealType)) {
					logger.exiting(personClassName, sourceMethod, true);
					return appeal.isAppealStatus();
				}
			}
		}
		logger.exiting(personClassName, sourceMethod, false);
		return false;
	}

	/**
	 * Compares the NIN of the applicant and the guardian.
	 * 
	 * @param applicant
	 *            : the applicant to compare with.
	 * @return whether both people share the same NIN.
	 */
	public boolean underTheApplicantCustody(Applicant applicant) {
		String sourceMethod = "underTheApplicantCustody";
		logger.entering(personClassName, sourceMethod);
		String guardianNIN = this.getGuardianshipstatus().getGuardianNIN();
		String applicantNIN = applicant.getNin();
		if (guardianNIN == null) {
			guardianNIN = "";
		}
		if (applicantNIN == null) {
			applicantNIN = "";
		}
		if (!"".equals(guardianNIN) && !"".equals(applicantNIN) && guardianNIN.equals(applicantNIN)) {
			logger.exiting(personClassName, sourceMethod, true);
			return true;
		} else {
			logger.exiting(personClassName, sourceMethod, false);
			return false;
		}
	}

	/**
	 * Compares the NIN of the applicant and the guardian.
	 * 
	 * @param applicant
	 *            : the applicant to compare with.
	 * @return whether both people share the same NIN.
	 */
	public boolean notUnderTheApplicantCustody(Applicant applicant) {
		String sourceMethod = "NotUnderTheApplicantCustody";
		logger.entering(personClassName, sourceMethod);
		String guardianNIN = this.getGuardianshipstatus().getGuardianNIN();
		String applicantNIN = applicant.getNin();
		if (guardianNIN == null) {
			guardianNIN = "";
		}
		if (applicantNIN == null) {
			applicantNIN = "";
		}
		if (!"".equals(guardianNIN) || !"".equals(applicantNIN) && guardianNIN.equals(applicantNIN)) {
			logger.exiting(personClassName, sourceMethod, false);
			return false;
		} else {
			logger.exiting(personClassName, sourceMethod, true);
			return true;
		}
	}

	/**
	 * Checks the validity of the personal status report by getting the status
	 * report date and add the report validity in days value to ensure that it
	 * doesn't exceeds today.
	 * 
	 * @return the validity of the report.
	 */
	public boolean notValidStatusReport() {
		String sourceMethod = "notValidStatusReport";
		logger.entering(personClassName, sourceMethod);
		Calendar today = Calendar.getInstance();
		Calendar statusReportDate = this.getStatusDetails().getStatusReportDate();
		int validityPeriod = this.getStatusDetails().getStatusReportValidityInDays();
		if (statusReportDate == null) {
			statusReportDate = Calendar.getInstance();
		}
		int daysBetweenTodayAndReport = Utilities.daysBetween(statusReportDate.getTime(), today.getTime());
		int difference = daysBetweenTodayAndReport - validityPeriod;

		if (difference > 0 || daysBetweenTodayAndReport < 0) {
			logger.exiting(personClassName, sourceMethod, true);
			return true; // Not Valid Status Report
		} else {
			logger.exiting(personClassName, sourceMethod, false);
			return false; // Valid Status Report
		}
	}

	/**
	 * Calculates the number of deduction days if the applicant exceeds the
	 * grace period outside KSA
	 * 
	 * @param gracePeriod
	 *            : the period if exceeded then the deduction days is calculated
	 * @return the number of deduction days calculated
	 */
	public Integer numberOfDeductionDays(int gracePeriod) {
		String sourceMethod = "numberOfDeductionDays";
		logger.entering(personClassName, sourceMethod);
		int numberOfDaysOutsideKSA = this.getResidencyOutsideKSA().getNoOfDaysOutsideKSA();
		int deductionDays = 0;
		deductionDays = numberOfDaysOutsideKSA - gracePeriod;
		if (this.isResidencyFlag()) {
			if (deductionDays > 30) {
				deductionDays = 30;
			}
		}
		logger.exiting(personClassName, sourceMethod, deductionDays);
		return deductionDays;
	}

	/**
	 * Checks if the imprisonment person is within the imprisonment duration.
	 * 
	 * @return whether the person is within the duration.
	 */
	public boolean withinImprisonmentDuration() {
		String sourceMethod = "withinImprisonmentDuration";
		logger.entering(personClassName, sourceMethod);
		Calendar today = Calendar.getInstance();
		Calendar imprisonmentReportDate = this.getImprisonment().getImprisonmentReportDate();
		int sentenceDuration = this.getImprisonment().getSentenceDurationInDays();

		if (imprisonmentReportDate == null) {
			imprisonmentReportDate = Calendar.getInstance();
		}
		int daysBetweenTodayAndReport = Utilities.daysBetween(imprisonmentReportDate.getTime(), today.getTime());
		int difference = sentenceDuration - daysBetweenTodayAndReport;

		if (difference >= 0) {
			logger.exiting(personClassName, sourceMethod, true);
			return true; // Within Duration
		}
		logger.exiting(personClassName, sourceMethod, false);
		return false;

	}

	/**
	 * Checks if the person is beneficiary in the Social-Security program.
	 * 
	 * @return whether the person is beneficiary.
	 */
	public boolean socialSecurityBeneficiary() {
		String sourceMethod = "socialSecurityBeneficiary";
		logger.entering(personClassName, sourceMethod);
		List<BenefitDetails> personBenefits = this.getBenefitDetails();
		if (personBenefits != null && personBenefits.size() > 0) {
			for (BenefitDetails benefit : personBenefits) {
				if (benefit.isBeneficiary()) {
					if (ProgramType.SOCIALSECURITY.equals(benefit.getProgramType())) {
						logger.exiting(personClassName, sourceMethod, true);
						return true;
					}
				}
			}
		}
		logger.exiting(personClassName, sourceMethod, false);
		return false;
	}

	/**
	 * Gets the GrantedFromState assets of the person.
	 * 
	 * @return the list of assets
	 */
	public List<AssetDetails> getGrantedFromStateAssets() {
		String sourceMethod = "getGrantedFromStateAssets";
		logger.entering(personClassName, sourceMethod);
		List<AssetDetails> personAssets = this.getAssets();
		List<AssetDetails> grantedFromState = new ArrayList<>();
		if (personAssets == null || personAssets.size() == 0) {
			logger.exiting(personClassName, sourceMethod);
			return grantedFromState;
		}
		for (AssetDetails asset : personAssets) {
			if (AssetSource.GRANTEDFROMSTATE.equals(asset.getAssetSource())) {
				grantedFromState.add(asset);
			}
		}
		logger.exiting(personClassName, sourceMethod);
		return grantedFromState;
	}

	/**
	 * Gets the ResidentialAssets assets of the person.
	 * 
	 * @return the list of assets
	 */
	public List<AssetDetails> getResidentialAssets() {
		String sourceMethod = "getResidentialAssets";
		logger.entering(personClassName, sourceMethod);
		List<AssetDetails> personAssets = this.getAssets();
		List<AssetDetails> residentialAssets = new ArrayList<>();
		if (personAssets == null || personAssets.size() == 0) {
			logger.exiting(personClassName, sourceMethod);
			return residentialAssets;
		}
		for (AssetDetails asset : personAssets) {
			if (AssetUseType.RESIDENTIAL.equals(asset.getAssetUseType()) && AssetSource.NONE.equals(asset.getAssetSource())) {
				residentialAssets.add(asset);
			}
		}
		logger.exiting(personClassName, sourceMethod);
		return residentialAssets;
	}

	/**
	 * Gets the InheritedAssets assets of the person.
	 * 
	 * @return the list of assets
	 */
	public List<AssetDetails> getInheritedAssets() {
		String sourceMethod = "getInheritedAssets";
		logger.entering(personClassName, sourceMethod);
		List<AssetDetails> personAssets = this.getAssets();
		List<AssetDetails> inheritedAssets = new ArrayList<>();
		if (personAssets == null || personAssets.size() == 0) {
			logger.exiting(personClassName, sourceMethod);
			return inheritedAssets;
		}
		for (AssetDetails asset : personAssets) {
			if (AssetSource.INHERITED.equals(asset.getAssetSource()) && asset.isNotShared()) {
				inheritedAssets.add(asset);
			}
		}
		logger.exiting(personClassName, sourceMethod);
		return inheritedAssets;
	}
	
	
	// ////////// End Of Class ////////////////////////
}
