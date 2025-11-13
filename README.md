```markdown
# OOP Project - Clinic Management System in Java
```

<p align="center">
<img src="https://img.shields.io/badge/Language-Java-blue.svg?style=for-the-badge&logo=openjdk" alt="Language Java"/>
</p>

> A simple console application written in Java to demonstrate core Object-Oriented Programming (OOP) concepts. This project, built using the NetBeans IDE, implements a basic system for managing a doctor's clinic, including patients, doctors, and appointments.

> 
>
> -----
>
> ## Features
>
> The program was designed to exemplify key OOP principles:
>
>   * **Classes and Objects:** Defines clear classes for `Pessoa` (Person), `Paciente` (Patient), `Medico` (Doctor), `Consulta` (Appointment), `Exame` (Exam), and `Medicacao` (Medication).
>   * **Inheritance:** `Paciente` and `Medico` inherit common attributes (like CPF and name) from the base `Pessoa` class.
>   * **Association/Composition:** Demonstrates relationships between objects. A `Consulta` links a `Medico` and a `Paciente`, and it can also contain a list of `Exame` and `Medicacao` objects.
>   * **Console Demonstration:** The main file (likely `ProjetoPOO.java`) instantiates these classes to simulate creating entities and scheduling appointments, printing the results to the console.

> 
>
> -----
>
> ## How to Compile and Run
>
> This project was developed in Java and requires the Java Development Kit (JDK) to be installed. It is structured as an Apache NetBeans project.
>
> 1.  **Clone the repository:**
>
>     ```bash
>     git clone https://github.com/Quasar-Inc-Dev/ProjetoPOO.git
>     cd ProjetoPOO
>     ```
>
> 2.  **Run using Apache NetBeans (Recommended):**
>
>       * Open the NetBeans IDE.
>       * Go to `File` \> `Open Project...`
>       * Navigate to and select the cloned `ProjetoPOO` folder (the one with the `nbproject` directory).
>       * Press `F6` or click the "Run Project" (▶) button.
>
> 3.  **Run Manually (using Command Line):**
>     If you don't have NetBeans, you can compile and run the files manually.
>
>     ```bash
>     # Navigate to the source files directory
>     cd ProjetoPOO/src
>     ```

> ```
> # Compile all .java files
> javac projetopoo/*.java
> ```

> ````
> # Run the main class
> java projetopoo.ProjetoPOO
> ```
> ````
>
> 4.  **Usage:**
>     The program will run in the console, display its output, and then exit. It's a non-interactive demo.
>
> -----
>
> ## Technologies Used
>
>   * **Java Language**
>   * **Java Development Kit (JDK)**
>   * **Apache NetBeans** (IDE)

