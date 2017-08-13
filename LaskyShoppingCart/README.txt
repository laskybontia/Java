Answers to the following questions:
1.) Reason why you used speciﬁc frameworks and libraries for the front-end and backend?
      Backend Java:
        - Wildfly Swarm (Microservice)
        - EJB3
        - Spring Framework and Spring MVC
      Front End:
        - Angular JS 1.4.9
    
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

