# Azure Employee API

A beginner-friendly **Java 21 + Spring Boot** REST API that you can deploy to **Azure App Service** on a low-cost or free Azure setup.

## What this app does

This app exposes **4 public JSON REST endpoints** for simple employee CRUD operations.

### Employee fields
- `firstName` (String)
- `lastName` (String)
- `department` (String)

### Important note about storage
This project uses **in-memory storage only**.
That means:
- data is stored only while the app is running
- if the app restarts, scales out, or is redeployed, the data is lost
- this is okay for learning and demo purposes

---

## Tech stack
- Java 21
- Spring Boot 4.0.5
- Maven
- Azure App Service

---

## REST endpoints

Base URL locally:
```bash
http://localhost:8080
```

Base URL on Azure:
```bash
https://<your-app-name>.azurewebsites.net
```

### 1. Create employee
**POST** `/api/employees`

Request:
```json
{
  "firstName": "Max",
  "lastName": "Mueller",
  "department": "Engineering"
}
```

Response:
```json
{
  "id": "generated-id",
  "firstName": "Max",
  "lastName": "Vuller",
  "department": "Engineering"
}
```

### 2. Get all employees
**GET** `/api/employees`

Response:
```json
[
  {
    "id": "generated-id",
    "firstName": "Max",
    "lastName": "Muller",
    "department": "Engineering"
  }
]
```

### 3. Update employee
**PUT** `/api/employees/{id}`

Request:
```json
{
  "firstName": "Max",
  "lastName": "Muller",
  "department": "Cloud"
}
```

### 4. Delete employee
**DELETE** `/api/employees/{id}`

Response:
```json
{
  "message": "Employee deleted successfully",
  "id": "generated-id"
}
```

---

## Run locally

### Prerequisites
- Java 21 installed
- Maven installed

### Start the app
```bash
mvn spring-boot:run
```

### Build the jar
```bash
mvn clean package
```

The generated jar will be in:
```bash
target/azure-employee-api-0.0.1-SNAPSHOT.jar
```

---

## Simple deployment to Azure App Service (no CI/CD)

This is the easiest beginner path using the **Azure Web App Maven plugin** and Microsoft Learn guidance.

### Prerequisites
1. Install Java 21
2. Install Maven
3. Install Azure CLI
4. Create an Azure account / free account
5. Login to Azure:
```bash
az login
```

---

## Option A: Deploy using Maven plugin

### 1. Build the app
```bash
mvn clean package
```

### 2. Deploy to Azure App Service
Pick your own globally unique app name.

```bash
mvn azure-webapp:deploy \
  -Dazure.resourceGroup=rg-employee-api \
  -Dazure.appName=employee-api-demo-12345 \
  -Dazure.region=westeurope \
  -Dazure.pricingTier=F1
```

### Notes
- `F1` is the Free tier where available.
- If the region or plan combination is not available, Azure may require another supported region or a different plan.
- Keep your app name unique across Azure.

After deployment, your app should be available at:
```bash
https://employee-api-demo-12345.azurewebsites.net/api/employees
```

---

## Option B: Deploy from the Azure Portal manually

If you prefer the portal:

1. Build the jar:
```bash
mvn clean package
```
## 🚀 Deploy Spring Boot Java App to Azure App Service (Linux)

### ✅ Prerequisites

*   Java **21**
*   Maven
*   Spring Boot application (executable / fat JAR)
*   Azure subscription

***

### 1️⃣ Build the Application

```bash
mvn clean package
```

✅ Ensure the JAR runs locally:

```bash
java -jar target/your-app.jar
```

***

### 2️⃣ Configure the Application Port

Azure provides a dynamic port via the `PORT` environment variable.

Add this to `application.properties`:

```properties
server.port=${PORT:8080}
```

***

### 3️⃣ Create Azure App Service

In **Azure Portal**:

1.  Create **App Service**
2.  Choose:
    *   **OS**: Linux ✅
    *   **Stack**: Java
    *   **Java version**: 21
    *   **Java web server**: Java SE
3.  Create the App Service

***

### 4️⃣ Deploy the JAR (ZIP Deploy)

1.  Create a ZIP file:
        app.zip
        └── your-app.jar
2.  Go to:
    *   **App Service → Deployment Center**
    *   Choose **ZIP Deploy**
    *   Upload `app.zip`

***

### 5️⃣ Configure Startup Command

Go to:
**App Service → Configuration → General settings**

Set **Startup Command**:

```bash
java -jar your-app.jar
```

✅ Save and **Restart** the App Service.

***

### 6️⃣ Verify Application Startup

Go to:
**App Service → Log stream**

✅ Successful startup looks like:

*   Spring Boot banner
*   `Tomcat started on port XXXX`
*   `Started <ApplicationName>`

***

### 7️⃣ Access the Application

Base URL:

    https://<app-name>.azurewebsites.net

Health check example:

    /actuator/health

API example:

    /api/health

***

## ✅ Common Troubleshooting

| Issue                    | Fix                              |
| ------------------------ | -------------------------------- |
| 503 Service Unavailable  | Check `server.port=${PORT:8080}` |
| App not starting         | Verify Startup Command           |
| No logs                  | Check Log Stream                 |
| Works locally, not Azure | Java version mismatch            |

## 🚀 Deploy Spring Boot Java App to Azure App Service (Linux)

### ✅ Prerequisites

*   Java **21**
*   Maven
*   Spring Boot application (executable / fat JAR)
*   Azure subscription

***

### 1️⃣ Build the Application

```bash
mvn clean package
```

✅ Ensure the JAR runs locally:

```bash
java -jar target/your-app.jar
```

***

### 2️⃣ Configure the Application Port

Azure provides a dynamic port via the `PORT` environment variable.

Add this to `application.properties`:

```properties
server.port=${PORT:8080}
```

***

### 3️⃣ Create Azure App Service

In **Azure Portal**:

1.  Create **App Service**
2.  Choose:
    *   **OS**: Linux ✅
    *   **Stack**: Java
    *   **Java version**: 21
    *   **Java web server**: Java SE
3.  Create the App Service

***

### 4️⃣ Deploy the JAR (ZIP Deploy)

1.  Create a ZIP file:
        app.zip
        └── your-app.jar
2.  Go to:
    *   **App Service → Deployment Center**
    *   Choose **ZIP Deploy**
    *   Upload `app.zip`

***

### 5️⃣ Configure Startup Command

Go to:
**App Service → Configuration → General settings**

Set **Startup Command**:

```bash
java -jar your-app.jar
```

✅ Save and **Restart** the App Service.

***

### 6️⃣ Verify Application Startup

Go to:
**App Service → Log stream**

✅ Successful startup looks like:

*   Spring Boot banner
*   `Tomcat started on port XXXX`
*   `Started <ApplicationName>`

***

### 7️⃣ Access the Application

Base URL:

    https://<app-name>.azurewebsites.net

Health check example:

    /actuator/health

API example:

    /api/health

***

## ✅ Common Troubleshooting

| Issue                    | Fix                              |
| ------------------------ | -------------------------------- |
| 503 Service Unavailable  | Check `server.port=${PORT:8080}` |
| App not starting         | Verify Startup Command           |
| No logs                  | Check Log Stream                 |
| Works locally, not Azure | Java version mismatch            |



The Maven plugin path is usually simpler for beginners.

---

## Recommended Azure settings for this learning app

For a low-cost beginner deployment:
- App Service Plan: **Free F1** if available
- Runtime: **Java 21**
- Web container: **Java SE**
- Region: use a region close to you and supported by your subscription

---

## Security tips for beginners on Azure App Service

Even for a simple learning app, do these:

### 1. Do not hardcode secrets
This sample has no database and no secrets.
Later, if you add passwords or keys, do **not** place them in source code.
Use **App Settings** or **Azure Key Vault**.

### 2. Validate input
This project already validates JSON fields using Spring validation.

### 3. Do not expose management endpoints broadly
This project exposes only `health` and `info` actuator endpoints.
Avoid exposing everything.

### 4. Use HTTPS only
Azure App Service supports HTTPS. In production, always enforce HTTPS redirection in Azure.

### 5. Keep dependencies updated
Use supported Java and Spring Boot versions and update them regularly.

### 6. Remember that in-memory data is not persistent
Anyone can call the public API, and all data is temporary. Do not use this design for real business data.

### 7. Add authentication before real use
This sample intentionally has no authentication so you can learn REST basics.
For a real public API, add authentication and authorization.

---

## Suggested test commands

### Create
```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{
    "firstName":"Max",
    "lastName":"Muller",
    "department":"Engineering"
  }'
```

### Get all
```bash
curl http://localhost:8080/api/employees
```

### Update
```bash
curl -X PUT http://localhost:8080/api/employees/<id> \
  -H "Content-Type: application/json" \
  -d '{
    "firstName":"Max",
    "lastName":"Muller",
    "department":"Cloud"
  }'
```

### Delete
```bash
curl -X DELETE http://localhost:8080/api/employees/<id>
```

---

## Helpful official references
- Azure App Service Java quickstart
- Azure App Service Java deployment and runtime docs
- Azure App Service hosting plans and pricing tiers

---

## Final beginner advice
Start simple:
1. Run locally
2. Build the jar
3. Deploy once with Maven plugin
4. Test the public URL
5. Later, add database, auth, and better security

That path is much easier than learning everything at once.
