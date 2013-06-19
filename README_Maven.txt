= Instructions for using Maven build system

Compile and build the jars:

TIP: The "mvn install" step will copy the primary project artifact into your
local ~/.m2/repository/ so that it can be referenced as a dependency by related
projects)

$ cd utilities/sedris
$ mvn compile
$ mvn install

$ cd ../Enumerations
$ mvn compile
$ mvn install

$ cd ../../languages/java/trunk
$ mvn compile
$ mvn install

This will have created the following artifacts:

- utilities/sedris/target/srm-4.4.0.jar
- utilities/Enumerations/target/dis-enums-1.1.jar
- languages/java/trunk/target/open-dis-4.0.8.jar
