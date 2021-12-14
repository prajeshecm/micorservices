                                        Housing Loan Application (HLA)


Purpose :

	HLA ( Housing Loan Application ) Is an app 
	which helps customerRank to identify whether customerRank is eligible for housing loan 
	And if eligible what will be the rate of interest 
	And the customerRank who is eligible ( or not )  for housing loan will also get an email to agree and next step in the process.

Use case :

	//Scenario 1 :  Success scenario 
		Given a customerRank in SSN background with good score
		And customerRank with details
		When I trigger HLA
		Then customerRank has to validate against SSN team
		And if eligible customerRank 
		And custom details has to send to notification team
		And email has to send to customerRank with rate and other details
	
	//Scenario 2 :  Failure scenario 
		Given a customerRank in SSN background with negative mark
		And customerRank with details
		When I trigger HLA
		Then customerRank has to validate against SSN team
		And customerRank details has to save in customerRank data
		And custom details has to send to notification team
		And email has to send to customerRank with not approved.
	
	//Scenario 3 : 

Architecture :




Domain :

	Customer 
		Name 	String
		DOB 	Date
		SSN 	String
		Address 1 	String
		State 	String
		City 	String
		Zip 	int
		Loan Amount 	Float
		Years 	int
		Monthly Salary	Float
		Email	String
		phome	int
	
	CustomerValidation 
	
		SSN 	String
		DOB 	Date
		Name	String
		Score	int
		Type 	String
	
	CustomerNotification 
	
		Customer Eligible	String
		Rate	float
		Years	int
		Approved Amt	float
		Customer Name	String

Components :

	Tech Stack : 
			§ Micro service REST API 
			§ Database :
				□ SQL : PostSQL ***
				□ No SQL : Mongo DB 
			§ Messaging service : Kafka 
			§ Application Load Balancer for high availability ***
			§ Docker for containerized application 
			§ Actuator for health check 
			§ Spring security 
