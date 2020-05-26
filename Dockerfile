FROM maven:3.6.1-jdk-8-slim
WORKDIR /app
COPY . .
RUN mvn package && \
	mv target/cmad-harbinger.jar /run/cmad-harbinger.jar && \ 
	rm -rf /app/*
EXPOSE 8082
CMD java -jar /run/cmad-harbinger.jar


