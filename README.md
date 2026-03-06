# Automated Waste Management System ♻️

An object-oriented Java application that simulates **smart waste collection** using the **Chain of Responsibility** design pattern.  
The system automatically routes full or near-full waste containers to the appropriate disposal handler based on waste type.

## 📖 Background

Municipalities and cities face significant challenges in managing waste efficiently. Traditional collection methods often lead to:

- Delays in pickup  
- Inefficient resource usage  
- High operational costs  
- Overflowing bins in public areas  

This project proposes an **automated, type-based waste routing system** to optimize collection, reduce delays, and improve sustainability.

## 🎯 Objective

Develop an automated waste management system that:

- Uses the **Chain of Responsibility** pattern  
- Handles different types of waste containers (organic, recyclable, hazardous, etc.)  
- Triggers appropriate disposal actions based on container **type** and **fill level**

## ✨ Features

- **WasteContainer** class with type, capacity, current fill level  
- Chain of responsibility for routing disposal requests  
- Threshold-based triggering (e.g., dispose when ≥80% full)  
- Clear console logging for simulation  
- Easy to extend with new waste types and handlers  
- Clean separation of concerns (no giant switch/if-else blocks)

## 🏗️ Design Pattern Used

**Chain of Responsibility**  
Each handler is responsible for one waste type.  
If it can handle the container → process it.  
Otherwise → pass to the next handler in the chain.

## 📋 Requirements Implemented

1. **Waste Container**  
   Class representing bins with type and capacity

2. **Waste Collection Chain**  
   Chain of responsibility with specialized handlers per waste type

3. **Waste Collection Process**  
   - Chain initialized in correct order  
   - Disposal triggered when container needs collection  
   - Correct handler processes the container

4. **Validation**  
   Proper type identification and fallback for unknown types

## 🛠️ Tech Stack

- **Language**: Java (JDK 8+)  
- **Design Pattern**: Chain of Responsibility  
- **Build Tool**: None (pure Java – ready to compile/run)


