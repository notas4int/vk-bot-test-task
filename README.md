# vk-bot-test-task

## Used technologies
* **Java**
* Spring Boot
* Maven (package manager to manipulate with dependecies)
* Lombok

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/notas4int/vk-bot-test-task.git
```

**2. Change PostgreSQL username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `vk.api.secret-token`, `vk.api.secret` and `vk.api.version` as your bot's configuration

**3. Download and start ngrok (https://ngrok.com/)**

**4. Configure token after register**
```bash
ngrok config add-authtoken <token>
```
**and start**
```bash
ngrok http 8080
```
**_!also change your bot's ip to suggested by ngrok!_**

**5. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

## An example of how the application works
![](src/main/resources/static/vk-bot.png)