# Project Overview  

## Project Name:  
Disneyland Ride Selector  

## Purpose:  
This app helps Disneyland visitors decide which attraction to ride next based on preferences. Whether someone is exploring the park for a day, making the most of their passholder benefits, or simply gamifying their experience, the app eliminates indecision and enhances their visit.  

## Features:  
- Ride selection based on preferences (thrill level or land)  
- Randomizer option for picking attractions  
- Keeps track of ridden attractions and either removes them from the remaining list or maintains a count  

## Technologies Used:  
- **Programming Language:** Java  
- **Tools:** IntelliJ IDEA, GitHub  
- **Potential Libraries:** Java Collections (for ride list management), JSON storage (for saving ride history)  

## User Interaction:  
- Text-based user input to guide ride recommendations  
- Interactive selection options (randomized or filtered)  

## Expansion Plan:  
**Short-Term:**  
- Develop a GUI version for desktop  

**Mid-Term:**  
- Extend to an Android app with an intuitive UI  

**Long-Term:**  
- Integrate real-time wait time data and weather-based recommendations  

## Notes:  
- Considering ways to incorporate ride rankings and park section-based suggestions  
- Potentially adding history tracking for frequent visitors 

# Disneyland Ride Selector - User Stories & Flow

## **1. User Stories**
These scenarios describe how different users interact with the app.

- **Passholder:**  
  _"As a Disneyland passholder, I want to track which rides I’ve been on so I can avoid repeats."_

- **Thrill Seeker:**  
  _"As a visitor looking for high-intensity attractions, I want to filter by thrill level."_

- **Explorer:**  
  _"As someone who enjoys discovering the park, I want a random ride selection option."_

## **2. User Flow**
This outlines the steps users follow while using the app.

1️⃣ **App Start:** User opens the app and chooses a selection method:  
   - Filter by **thrill level**  
   - Filter by **land**  
   - Use **random ride selection**  

2️⃣ **Recommendation:** The app presents an available ride based on user input.  

3️⃣ **User Decision:**  
   - Accept the ride recommendation.  
   - Request another option.  

4️⃣ **Ride Tracking:**  
   - If tracking is enabled, the app records the ridden attraction and updates the list.  

5️⃣ **Repeat Process:** The user continues selecting rides until they finish their session.  

---

_Last updated: 5/17/2025

### **PROJECTS**  
#### **Disneyland Ride Selector App (Java-based) – In Progress**  
- Currently developing **a text-based version** focused on **ride selection logic and user interaction**.  
- Designing **class structures and algorithms** to enhance user experience and scalability.  
- Planning future expansion into **GUI and Android versions**, showcasing **application adaptability**.  
- Writing **technical documentation**, including **requirements, architecture design, and testing strategy** to support structured development.  

# Deployment Plan - Disneyland Ride Selector App  

## Overview  
This document outlines the deployment strategy for the Disneyland Ride Selector App, ensuring smooth installation, execution, and future scalability.  

## Deployment Environment  

### **1. Local Deployment (Current Version)**  
- **Operating System:** Windows/macOS/Linux  
- **Java Version:** Java SE 11+  
- **Required Dependencies:** None (Standard Java Libraries)  
- **Deployment Method:**  
  - Compile and run via CLI using `javac` and `java`.  
  - Store ride data in local JSON or text-based files.  

### **2. Packaged Deployment (Improved Accessibility)**  
- **Create a JAR file:**  
  - Compile all source files: `javac *.java`  
  - Package into JAR: `jar cvfm RideSelector.jar Manifest.txt *.class`  
  - Run: `java -jar RideSelector.jar`  
- **Distribution Options:**  
  - Host JAR file on GitHub for easy sharing.  
  - Include README with installation instructions.  

### **3. Future Expansion (Scalability Considerations)**  
- **GUI Version Deployment:**  
  - Convert the CLI app to **Swing/JavaFX**.  
  - Package as a JAR or executable installer (.exe for Windows, .app for macOS).  
- **Database Integration:**  
  - Transition ride data storage from files to **MySQL or SQLite**.  
  - Deploy alongside database scripts for installation ease.  
- **Cloud Hosting for a Web/App Version:**  
  - Convert to a **Java Spring Boot API** and deploy on AWS/GCP.  
  - Expand to **Android (Java/Kotlin)** for mobile accessibility.  

## Maintenance & Version Control  

- **GitHub Repository** (Recommended for employers to see progress):  
  - **Master Branch:** Stable versions.  
  - **Development Branch:** Work-in-progress features.  
  - Use `git tags` to mark versions (`v1.0`, `v2.0` for milestones).  
- **Bug Tracking:** Maintain an issue log in GitHub for continuous improvement.  

---

_Last updated: 5/17/2025_  

# Feature Roadmap - Disneyland Ride Selector App  

## Overview  
This roadmap outlines the **planned features** for the Disneyland Ride Selector App, ensuring incremental growth while keeping the application scalable for future improvements.  

## Phase 1: Core Functionality (Current Development)  
- **Text-Based CLI Version**: Simple command-line interaction for user ride selection.  
- **Ride Recommendation Logic**: Filters rides based on user preferences and height requirements.  
- **Basic Data Storage**: Rides stored in an internal collection (e.g., `ArrayList<Ride>`).  

## Phase 2: Optimization & Enhancements (Short-Term Goals)  
- **Improve Selection Logic**: Enhance recommendation accuracy with refined filtering criteria.  
- **User Preferences Storage**: Implement persistent user preference saving for repeated sessions.  
- **JUnit Testing Framework**: Integrate structured unit tests to validate core functionality.  

## Phase 3: GUI Transition (Mid-Term Goal)  
- **Swing/JavaFX UI Development**: Upgrade the CLI interface to a graphical version for better usability.  
- **Interactive Ride Selection**: Allow dynamic filtering and selection via UI components.  
- **Scalability Improvements**: Optimize class structure for smoother transition to an expanded platform.  

## Phase 4: Advanced Features & Future Expansion (Long-Term Goal)  
- **Database Integration**: Move ride data storage to a **SQL or external file-based system** for scalability.  
- **Real-Time Park Data API**: Integrate an API for live wait times and ride availability.  
- **Mobile App Version**: Expand into an Android app to demonstrate multi-platform capability.  

---

_Last updated: 5/17/2025_  

# Disneyland Ride Selector - Requirements Document

## **1. Functional Requirements**
- Users can filter ride selections by thrill level or land.
- The app provides a random ride picker option.
- Tracks ridden attractions and either removes them or maintains a count.
- Uses a text-based interface for interaction.

## **2. Non-Functional Requirements**
- Efficient data storage for quick ride retrieval.
- Modular code structure for easy expansion to GUI and Android versions.
- Smooth user experience with clear prompts and error handling.

## **3. Future Enhancements**
- GUI interface for improved user interaction.
- Android version for mobile convenience.
- Possible API integration for real-time wait times.

---
_Last updated: 5/17/25

# Testing Strategy - Disneyland Ride Selector App  

## Overview  
This document outlines the **basic testing approach** for the Disneyland Ride Selector App. The goal is to ensure correctness and maintainability while keeping the process straightforward for an early-stage application.  

## Testing Approach  

### **1. Unit Testing**  
- **User Class:** Ensure user preferences and height requirements are correctly stored and retrieved.  
- **RideSelector Class:** Validate that ride filtering works based on user attributes.  
- **Ride Class:** Confirm ride attributes (name, height, intensity) are correctly managed.  

### **2. Integration Testing**  
- **User ↔ RideSelector:** Verify user inputs influence ride recommendations properly.  
- **RideSelector ↔ Ride:** Ensure filtered rides match expected criteria.  
- **Interface ↔ User:** Confirm smooth command-line interactions.  

### **3. Basic Functional Testing**  
- **Input validation:** Ensure negative values or invalid selections are handled.  
- **Edge cases:** Test scenarios where no rides match or multiple recommendations exist.  
- **Output correctness:** Verify ride selections align with user input.  

### **4. Future Enhancements (Showcasing Growth Potential)**  
- **JUnit Integration:** Automate unit testing for structured validation.  
- **Scalability tests:** Simulate large ride databases to test efficiency.  
- **Potential GUI Automation:** Prepare for Swing/JavaFX UI validation in future versions.  

## Testing Tools  

| Test Type       | Approach Used    | Future Expansion |
|---------------|----------------|------------------|
| Unit Tests    | Manual JUnit    | Extended automated testing |
| Integration   | Manual CLI Tests | Mock API testing for future updates |
| Functional    | Manual CLI Checks | UI automation in advanced versions |

---

_Last updated: 5/17/2025_  

+------------------+
|  User           |
+------------------+
| - preferredRides: List<String> |
| - heightRequirement: int |
+------------------+
| + getPreferences(): List<String> |
+------------------+

          |
          | (provides preferences to)
          v

+------------------+
|  RideSelector   |
+------------------+
| - userProfile: User |
| - rides: List<Ride> |
+------------------+
| + filterRides(User) |
| + recommendRide(User) |
+------------------+

          |
          | (accesses ride data from)
          v

+------------------+
|  Ride           |
+------------------+
| - name: String |
| - heightRequirement: int |
| - intensityLevel: String |
| - theme: String |
+------------------+
| + getDetails(): String |
+------------------+

          |
          | (manages interaction)
          v

+------------------+
|  Interface      |
+------------------+
| - input: String |
| - output: String |
+------------------+
| + getUserInput(): String |
| + displayOptions(): void |
+------------------+
