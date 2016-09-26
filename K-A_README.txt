STEPS TO RUN THIS JPA SERVER APPLICATION:

1.
First need to install Apache Derby 10.12.1.1 to run this project.
Note: Project has been set up and run on Wildfly 10.1.0.Final.

2.
Once the database has been installed, start it by going to %DERBY_HOME%\bin and starting the Derby db via 
running the command :
-> NetworkServerControl -p 1527 start

NOTE! 
LEAVE THIS WINDOW RUNNING AT ALL TIMES WHILE RUNNING THIS PROJECT OR YOUR DATABASE WILL NOT CONNECT TO WILDFLY B/C 
IT WON'T BE RUNNING!

3.
Next, test your Derby install by creating a new database in a NEW COMMAND PROMPT WINDOW go to:
-> ij
-> connect 'jdbc:derby://localhost:1527/EmployeeMgmt;create=true';
-> create table temp_table (id int);
-> insert into temp_table (id) values (8);
-> select * from temp_table;

You should see:
"
ID
----------
8
1 row selected
"
If you saw the output above your table is working properly!

For ij help enter: "help;".

4.
You can now close the ij window ONLY but LEAVE THE NetworkServerControl WINDOW RUNNING!

5.
Open your "%JBOSS_HOME%\standalone\configuration\standalone.xml" file and inside the <datasources> tag add the following:
"
<datasource jndi-name="java:/EmployeeDB" pool-name="EmployeeDB" enabled="true" use-java-context="true">
	<connection-url>jdbc:derby://localhost:1527/EmployeeMgmt</connection-url>
	<driver>derbyclient.jar</driver>
	<security>
		<user-name>APP</user-name>
		<password>APP</password>
	</security>
</datasource>
"
Save the standalone.xml file.

NOTE:
 - The default port for the Apache Derby database is port "1527".
 - The default username and password for the Derby database is "APP".

6.
Copy your "derbyclient.jar" file from "%DERBY_HOME%\lib\derbyclient.jar" to your "%JBOSS_HOME%\standalone\deployments\"
folder. So that JBoss/Wildfly will autodeploy it when it starts.

7.
Start your server via the "%JBOSS_HOME%\bin\standalone.bat" file and go to the Mgmt Console via "localhost:9990".

8.
Go to:
Configuration tab --> Subsystems --> Datasources --> Non-XA --> EmployeeDB --> View button.

Then test JBoss connection to Derby via going to:
Connection tab link --> Test Connection button.
Should see: "Successfully created JDBC connection." message.

9.
Next configure how many connection pool/threads should be used for your application via going to:
Pool --> Edit --> then Setting:
a. Min pool size = 8.
b. Initial pool size = 8.
c. Max pool size = 32.
Scroll down the page and hit Save button.

10.
Done!  You should now be able to run this JPA application.

