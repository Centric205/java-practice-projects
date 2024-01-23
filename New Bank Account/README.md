# Bank Account Application

**Scenario**: You are a back-end developer and need to create an application to handle new customer account requests.

**Requirements**:
    
    - App should read a .csv file of names, social security numbers, account type, and initial deposit
    - Use a proper data structure to hold all these accounts
    - Both savings and checking accounts share the following properties:
          > deposit()
          > withdraw()
          > transfer()
          > showInfo()

        11-Digit Account Number (generated with the following process: 1 or 2 depending on Savings or Checking, last two digits of SSN, unique 5-digit number, and random 3-digit number)

    - Savings Account holders are given a Safety Deposit Box, identified by a 3-digit number and accessed with a 4-digit code
    - Checking Account holders are assigned a Debit Card with a 12-digit number and 4-digit PIN
    - Both accounts will use an interface that determines the base interest rate.
      Savings accounts will use .25 points less than the base rate.
      Checking accounts will use 15% of the base rate
    - The ShowInfo method should reveal relevant account information as well as information specific to the Checking account or Savings.

**Learning Objectives**:

   - Learn to develop a robust application _Architecture_
   - Use when to use _abstract classes_ and _abstract methods_
   - Use an interface API to receive information from a developer's application
   - Explore constructor deeper and use the _super()_ keyboard
   - Explore access modifiers and when to use _public_, _private_, or _protected_
   - Read data from a file and store in an appropriate _data structure_
   - Generate random numbers and work with String API

### System Architecture

        <PASTE CLASS DIAGRAM>