FROM java:openjdk-8-jdk-alpine

COPY target/NLPostCodes-1.0.jar  /home/NLPostCodes-1.0.jar
RUN chmod 777 /home/NLPostCodes-1.0.jar

EXPOSE 8087

CMD ["java" , "-jar" , "/home/NLPostCodes-1.0.jar"]

