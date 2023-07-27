FROM openjdk:8u191-jre-alpine3.8

# Workspace
WORKDIR /usr/share/udemy
# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar            selenium-docker.jar
ADD target/selenium-docker-tests.jar      selenium-docker-tests.jar
ADD target/libs                           libs

#If you have any other dependencies like .csv /.json .xls - please add it here
#ADD suite files
ADD testng.xml                           testng.xml
ADD searchtestng.xml                     searchtestng.xml


#RUN wget http://s3.amazonaws.com/selenium-docker/healthcheck/healthccheck.sh                      
#They have to pass three varialbe to execute in the command line.
#BROWSER
#HUB_HOST
#MODULE

ENTRYPOINT sleep 3 && java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* \
-DBROWSER=$BROWSER \
-DHUB_HOST=$HUB_HOST \
org.testng.TestNG $MODULE
#ENTRYPOINT healthcheck.sh