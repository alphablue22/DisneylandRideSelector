# 🎢 Disneyland Ride Selector

A modular Java CLI app that helps Disneyland visitors choose their next ride based on thrill level, land, or randomness—complete with ride tracking, filtering, and full test coverage. Built for scalability with future plans for GUI, Android, and API integration.

---

## 🚀 Project Overview

### **Project Name:**  
Disneyland Ride Selector

### **Purpose:**  
This app helps Disneyland visitors decide which attraction to ride next based on preferences. Whether someone is exploring the park for a day, making the most of their passholder benefits, or simply gamifying their experience, the app eliminates indecision and enhances their visit.

### **Features:**  
- Ride selection based on thrill level or land  
- Randomizer option for picking attractions  
- Tracks ridden attractions and excludes them from future suggestions  
- Fully interactive CLI menu with input validation  
- JUnit test suite for core logic

### **Technologies Used:**  
- **Language:** Java  
- **Tools:** IntelliJ IDEA, GitHub  
- **Libraries:** Java Collections, Jackson (for JSON parsing)  
- **Testing:** JUnit 5

---

## 🧑‍💻 User Interaction

- Text-based interface with clear prompts  
- Filter rides by thrill level, land, or type  
- Mark rides as ridden and view ridden history  
- Surprise ride picker with optional thrill filtering  
- Input validation for smooth UX

---

## 🧭 User Stories

- **Passholder:** _"I want to track which rides I’ve been on so I can avoid repeats."_  
- **Thrill Seeker:** _"I want to filter by thrill level to find intense rides."_  
- **Explorer:** _"I want a random ride selection to discover new attractions."_

---

## 🔄 User Flow

1. Launch app and choose a selection method  
2. View recommended ride(s)  
3. Accept or request another option  
4. Mark rides as ridden  
5. Repeat until session ends

---

## 🧪 Testing Strategy

### **Unit Testing**
- `RideSelector`: filters by type, thrill level, land, and ridden status  
- `Ride`: verifies attributes and `toString()` output  

### **Integration Testing**
- CLI ↔ RideSelector: confirms user input flows correctly  
- RideSelector ↔ Ride: ensures filtering logic matches expectations  

### **Functional Testing**
- Input validation  
- Edge cases (e.g., no matching rides)  
- Output correctness

### **Tools**
| Test Type       | Approach Used    | Future Expansion |
|----------------|------------------|------------------|
| Unit Tests      | JUnit 5          | Extended coverage |
| Integration     | Manual CLI tests | Mock API testing |
| Functional      | Manual CLI checks| GUI automation |

> Initial unit tests implemented in `RideSelectorTest.java`

---

## 📦 Deployment Plan

### **Local Deployment**
- Java SE 11+  
- Run via CLI: `javac *.java` → `java ui.RideApp`  
- Ride data stored in local JSON

### **Packaged Deployment**
- Create JAR: `jar cvfm RideSelector.jar Manifest.txt *.class`  
- Run: `java -jar RideSelector.jar`  
- Host on GitHub with install instructions

### **Future Expansion**
- GUI version (JavaFX/Swing)  
- Android app (Java/Kotlin)  
- Spring Boot API with cloud hosting  
- SQL or cloud-based ride data storage

---

## 🛣️ Feature Roadmap

### **Phase 1: Core Functionality**
- CLI ride selector  
- Filtering and tracking logic  
- JSON-based data storage

### **Phase 2: Optimization**
- Enhanced filtering  
- Persistent user preferences  
- Full JUnit test coverage

### **Phase 3: GUI Transition**
- JavaFX/Swing interface  
- Interactive ride cards  
- Scalable architecture

### **Phase 4: Advanced Features**
- SQL database integration  
- Real-time wait time API  
- Android mobile app

---

## 📁 Repository Structure

```
src/
├── main/
│   ├── model/         # Ride.java
│   ├── service/       # RideLoader, RideSelector
│   └── ui/            # RideApp.java
└── test/
    └── service/       # RideSelectorTest.java
```

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## 📌 Notes

- Considering ride rankings and park section-based suggestions  
- Planning history tracking for frequent visitors  
- GUI and Android versions will reuse core logic for scalability

---

_Last updated: 2025-09-28_

---

