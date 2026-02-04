# 🌱 Energy Transition Management System

Java console-based application to manage and analyze renewable energy production data, developed as part of a backend learning process.

## 🚀 Project Overview
This project simulates a system that allows users to manage renewable energy records by region, country, energy source, and year.  
It focuses on **Object-Oriented Programming**, **clean architecture**, and **CRUD operations**, serving as a foundation for future integration with databases and REST APIs.

## 🛠️ Technologies Used
- Java (OOP)
- Collections (List, Iterator)
- Console-based UI
- Git & GitHub

## 📌 Features
- Add energy production records
- List all records
- Update records (full edit or production-only)
- Delete records safely using Iterator
- Calculate total energy production by year
- Menu-driven console interaction

## 🧠 Architecture
src/
├── model/ → Domain entities (EnergyRecord, Region, Country, EnergySource)
├── service/ → Business logic and data handling
└── App.java → Application entry point (UI + flow control)

## ▶️ How to Run
1. Clone the repository  
2. Open in your Java IDE (IntelliJ / Eclipse / VS Code)
3. Run `App.java`
4. Use the console menu to interact with the system

## 🔮 Future Improvements
- Database integration (MySQL + JPA)
- Spring Boot REST API
- Frontend integration (Angular)
- Data visualization

---

💡 *This project is part of my journey into backend development and will continue evolving.*