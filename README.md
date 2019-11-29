# TechnicalTask

### How to run the code:
1. Put your csv file with data in "src/main/resources" folder and name it "X.csv".
2. Run Main class from any suitable IDE.
3. Wait till program will end its work.  
In "src/main/resources" folder you will find 3 files: database with all parsed data; error.csv file with all wrong data; statistics.log file with results of program work.


### How the problem was solved:
While working on given problem I was trying to keep the code simple and performant. Firstly, I red data from file and saved it in a LinkedList of strings. After that I parsed all string and converted them in instances of my class - Record (this class is intended to describe an entity from data file). Then I divided all records into two lists: one with error data, other with right data.  
Last steps were inserting right data to database, wrong data to scv file and filling up the statistics file. For this tasks I created two components: one for database, other for files. In order to make the program work faster I decided to add many records to an SQL insert statement and then execute it once for many records. This helped me to reduce number of SQL operations in, approximately, 900 times.     
