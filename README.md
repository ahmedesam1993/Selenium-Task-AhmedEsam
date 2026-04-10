Qoyod Login Automation Task

Automated testing for the Qoyod Login application using **Selenium + TestNG + Page Object Model + Page Object Manager + DDT**

---
## 🚀 How to Run

### 1. Clone the Repository
```bash
git clone https://github.com/ahmedesam1993/Selenium-Task-AhmedEsam.git
cd QoyodTask
```

### 2. Load Dependencies
```bash
mvn clean install
```

### 3. Run All Tests
```bash
mvn test
```

## 📋 Prerequisites

Before starting, ensure you have:

- **Java 11 or higher** (tested with Java 26)
- **Maven 3.6 or higher**
- **Chrome Browser** (WebDriverManager will download ChromeDriver automatically)

---

## 🔧 Setting Up Environment Variables

### Windows

#### 1. Set JAVA_HOME
Open: System Properties → Advanced → Environment Variables
Click: New → System Variable
Variable name: JAVA_HOME
Variable value: C:\Program Files\Java\jdk-26 (or your Java installation path)
Click OK


#### 2. Set MAVEN_HOME

Open: Environment Variables
Click: New → System Variable
Variable name: MAVEN_HOME
Variable value: C:\apache-maven-3.9.0 (or your Maven installation path)
Click OK


#### 3. Add to PATH

Open: Environment Variables
Find: Path (in System variables)
Click: Edit
Click: New
Add: %JAVA_HOME%\bin
Add: %MAVEN_HOME%\bin
Click OK

#### 4. Verify Installation
bash
# Open a new Command Prompt
```bash
java -version
```
# Output: openjdk 26.0.1 2024-10-29
```bash
mvn -version
```
# Output: Apache Maven 3.9.0
