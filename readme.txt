0. Build the application
1. Setup MySQL server and update the application.properties accordingly, if needed
2. Create a database by name 'users' in the MySQL

3. Start the application
java -jar cmad-harbinger.jar

3. Use a REST client like postman or CURL and make POST requests with body that looks like
curl -d '{"id":"123456", "passwordSha":"Veera Reddy Evuri"}' -H 'Content-Type: application/json'  http://localhost:8082/user


Make sure that the IP Addresses specified are the same that are used in the cmad-harbinger.
