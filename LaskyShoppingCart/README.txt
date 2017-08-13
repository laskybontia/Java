Answers to the following questions:
1.) Reason why you used speciﬁc frameworks and libraries for the front-end and backend?
      Backend Java:
        - Wildfly Swarm (Microservice)
        - EJB3
        - Spring Framework and Spring MVC
      Front End:
        - Angular JS 1.4.9

      Reasons:
         - Using wildfly swarm will make the project very flexible either to continue scaling it in microservices area.
           As well as wildfly swarm projects are very portable if we move them to wildfly server based projects
           It is actually where my original code was based from.
         - Since wildfly swarm supports EJB3 it is good have it in there because once we port our wildfly swarm project to an Application Server
           like Wildfly EJBs will be needed and this will make the project flexible to microservice or application server approach
         - Spring has a very good frame work for web servers and it also has support for microservice and application service layers
         - Angular JS is quite popular these days and has rich GUI libraries that comes along with it
    
2.) How the persistent layer could be implemented?
      The persistent layer for this project is partially implemented already.
      It is using The Repository Layer of the Application Microservice Server
      The remaining part is just the Database Layer which can be implemented using HikariCP
         and MySQL or Postgres SQL or any supported SQL Server.
         It will be using DB Pooling connection scheme.

3.) How long did it take yo to create the code?
    It took me roughly 13 hours to finish this mini-project



====================================================================
To build and Run:
  1.) CD to this to this directory
  2.) $ ./cleanBuildAndRun.sh


To just Run:
  1.) CD to this to this directory
  2.) Make sure target folder is present or else use cleanBuildAndRun.sh
  3.) $ ./run.sh

Once it is running, you can access the page in the browser using this URL:
   http://localhost:8080/LaskyShoppingCart/laskystore/shop.html

