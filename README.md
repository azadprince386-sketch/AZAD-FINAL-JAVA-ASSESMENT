# 🎓 SmartCampus Management System

**GNC College | BTech 2nd Year – Java Final Assessment**

A console-based Smart Campus Management System built in Java that demonstrates core OOP principles, Collections, Exception Handling, Multithreading, and File Handling.

---

## 📋 Problem Statement

Build a Smart Campus Management System that allows:
- Managing Students and Courses
- Enrolling Students into Courses
- Handling invalid inputs gracefully
- Processing enrollments asynchronously using threads

---

## ✨ Features

| Feature | Description |
|---|---|
| Student Management | Add and view students with ID, name, and email |
| Course Management | Add and view courses with fee validation |
| Enrollment System | Enroll students in multiple courses using `HashMap` |
| Custom Exceptions | `InvalidFeeException`, `StudentNotFoundException`, `CourseNotFoundException` |
| Multithreading | Asynchronous enrollment processing with `synchronized` block |
| File Handling | Auto-save and load data from `campus_data.txt` |
| Interface | `Courseable` interface enforces `calculateFee()` on all course types |

---

## 🏗️ Project Structure

```
src/
└── smartcampus/
    ├── Main.java                          ← Menu-driven entry point
    ├── model/
    │   ├── Courseable.java                ← Interface
    │   ├── Student.java                   ← Student POJO
    │   └── Course.java                    ← Course POJO (implements Courseable)
    ├── exception/
    │   ├── InvalidFeeException.java       ← Custom exception
    │   ├── StudentNotFoundException.java  ← Custom exception
    │   └── CourseNotFoundException.java   ← Custom exception
    ├── service/
    │   └── CampusService.java             ← Business logic + file I/O
    └── thread/
        └── EnrollmentProcessor.java       ← Runnable for async processing
```

---

## 🔧 Technical Concepts Used

- **OOP**: Classes, Constructors, Interfaces, Encapsulation, Polymorphism
- **Collections**: `ArrayList`, `HashMap<Student, ArrayList<Course>>`
- **Exception Handling**: Custom checked exceptions, try-catch-finally
- **Multithreading**: `Thread`, `Runnable`, `synchronized` block
- **File Handling**: `FileWriter`, `BufferedReader`, `PrintWriter`

---

## ▶️ How to Run

### Using Terminal

```bash
# 1. Navigate to project root
cd gnc-java-final-assessment-smartcampus

# 2. Compile all source files
javac -d out src/smartcampus/**/*.java src/smartcampus/*.java

# 3. Run the application
java -cp out smartcampus.Main
```

### Using VS Code / IntelliJ
1. Open the `src` folder as the source root
2. Run `Main.java`

---

## 🖥️ Sample Output

```
╔══════════════════════════════════════╗
║   SmartCampus Management System      ║
║   GNC College | BTech 2nd Year       ║
╚══════════════════════════════════════╝

┌─────────────────────────────────────┐
│           MAIN MENU                 │
├─────────────────────────────────────┤
│  1. Add Student                     │
│  2. Add Course                      │
│  3. Enroll Student in Course        │
│  4. View All Students               │
│  5. View All Enrollments            │
│  6. Process Enrollments (Thread)    │
│  7. Save Data to File               │
│  8. View All Courses                │
│  0. Exit                            │
└─────────────────────────────────────┘

Enter choice: 1
Student ID   : 227
Name         : AZAD KHAN
Email        : azad@gnc.227
  ✓  Student added: AZAD KHAN
```

---

## 🧠 MCQ Answers (Scenario-Based)

| MCQ | Answer | Reason |
|-----|--------|--------|
| 1 | **B** – `HashMap<Student, ArrayList<Course>>` | Fast student lookup + multiple course support |
| 2 | **C** – Throw `InvalidFeeException` | Custom exception for clear, typed error handling |
| 3 | **B** – `synchronized` block | Prevents race conditions on shared enrollment list |
| 4 | **B** – Interface | Interface enforces `calculateFee()` across all course types |

---

## 💡 Unique Feature

**Auto-Save on Exit**: Data is automatically saved to `campus_data.txt` when the user exits, and reloaded the next time the program starts — ensuring no data is lost between sessions.

---

## 📊 Evaluation Coverage

| Criteria | Marks | Covered By |
|---|---|---|
| Code Structure | 15 | Package structure, separation of concerns |
| OOP Implementation | 20 | Interface, encapsulation, constructors |
| Collections | 15 | HashMap + ArrayList for enrollments |
| Exception Handling | 15 | 3 custom exceptions + input validation |
| Multithreading | 10 | EnrollmentProcessor (Runnable + synchronized) |
| Functionality | 15 | All 8 menu options working |
| GitHub | 10 | This repo with README + screenshots |

---

*Built for GNC College BTech 2nd Year Java Final Assessment*






![Image Alt](https://github.com/azadprince386-sketch/AZAD-FINAL-JAVA-ASSESMENT/blob/0289a02f387c7c2c92ca02b50f72fb6f7c31362b/Screenshot%202026-04-16%20143131.png)
![Image Alt](https://github.com/azadprince386-sketch/AZAD-FINAL-JAVA-ASSESMENT/blob/0289a02f387c7c2c92ca02b50f72fb6f7c31362b/Screenshot%202026-04-16%20143354.png)
![Image Alt](https://github.com/azadprince386-sketch/AZAD-FINAL-JAVA-ASSESMENT/blob/0289a02f387c7c2c92ca02b50f72fb6f7c31362b/Screenshot%202026-04-16%20143443.png)
![Image Alt](https://github.com/azadprince386-sketch/AZAD-FINAL-JAVA-ASSESMENT/blob/0289a02f387c7c2c92ca02b50f72fb6f7c31362b/Screenshot%202026-04-16%20143510.png)
![Image Alt](https://github.com/azadprince386-sketch/AZAD-FINAL-JAVA-ASSESMENT/blob/0289a02f387c7c2c92ca02b50f72fb6f7c31362b/Screenshot%202026-04-16%20143535.png)
