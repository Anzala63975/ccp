Hotel Room Reservation System
Last updated: 12/25/2025

Project Overview
The Hotel Room Reservation System is an object-oriented Java application that allows management of hotels, rooms, guests, and reservations. The system is implemented following UML design specifications, clean code principles, and defensive programming techniques.
Key objectives:
•	Encapsulation & OO Design: Proper use of classes, inheritance, aggregation, and associations.
•	Clean Code: Meaningful names, small focused methods, modularity, and avoidance of duplication.
•	Defensive Programming: Input validation, exception handling, prevention of illegal states.
•	Unit Testing: Comprehensive tests for all domain classes using JUnit 5, including parameterized tests, normal cases, boundary cases, and invalid inputs.

Features / Use Cases
1.	Hotel & HotelChain Management
o	Create multiple hotels within a hotel chain.
o	Add rooms and room types.
2.	Room Management
o	Create rooms with types and costs.
o	Manage room state transitions: FREE → RESERVED → OCCUPIED → FREE.
3.	Guest & Payer Management
o	Register guests and payment details for reservations.
4.	Reservation Handling
o	Book rooms according to type and availability.
o	Reserve multiple rooms via HowMany.
o	Check-in and check-out guests.
o	Cancel reservations.
5.	Simulation / Main Method
o	Demonstrates all core use cases: hotel initialization, room addition, guest registration, reservations, and check-in/check-out.

Technology Stack
•	Language: Java 11+
•	IDE: Visual Studio Code
•	Testing: JUnit 5
•	Version Control: Git & GitHub

Getting Started
Prerequisites
•	Java JDK 11 or above
•	VS Code or any Java IDE
•	Git installed
