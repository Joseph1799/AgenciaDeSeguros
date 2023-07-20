# AgenciaDeSeguros

This project is a Java-based application that serves as an insurance management system for a health insurance entity. It allows for the control and tracking of insured individuals and provides various functionalities using data structures such as queues, stacks, and linked lists.

## Features

The insurance management system includes the following features:

1. **Public Service and Customer Care**
   - Customers are attended by three available employees in a queue-based system.
   - Each customer is assigned to an available employee or placed in a queue if all employees are busy.
   - Employees can be freed to attend the next customer in the queue.

2. **Customer Information**
   - Customers' personal information, such as ID, name, age, province, address, and phone number, is stored.
   - Customers can be added, modified, or deactivated.
   - Customers' information can be displayed and searched.

3. **Insurance Details**
   - Insurance information, including insurance ID, description, status, amount, and additional notes, is recorded.
   - Insurance types and their descriptions are managed.
   - Insurance details can be added, modified, or deactivated.
   - Insurance details can be displayed and searched.

4. **Expedient Management**
   - Customer expedients are stored, including the ID, observations, and status (reviewed, canceled, active, in transit).
   - Doctors' information, including ID, name, specialty, years of experience, and title, is maintained.
   - The system tracks the number of customers attended by each doctor and the assigned insurance type.
   - Expedients can be created, modified, or canceled.
   - Expedients can be displayed and searched.

5. **Employee and Administrator Control**
   - Employee and administrator details, such as ID, name, role, and status, are managed.
   - Employees and administrators can be added, modified, or deactivated in the system.
   - Employees and administrators can log in to the system with different access privileges.

6. **Data Management**
   - Error handling is implemented for data input validation.
   - Sorting methods are applied to display data in an orderly manner.
   - Customers over 60 years old are managed separately using a stack data structure.
   - A separate list is maintained for customers under 60 years old.

7. **Additional Functionalities (To be Implemented)**
   - Assigning a relative and contact number to each customer over 60 years old.
   - Modifying customer expedient details at any time.
   - Doctor management (addition, modification, and deactivation).
   - Insurance management (addition, modification, and deactivation).

## Usage

To run the insurance management system locally, follow these steps:

1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Clone this repository to your local machine.
3. Open the project in your preferred Java IDE.
4. Compile and run the application.
5. Follow the on-screen prompts to navigate through the system's functionalities.

## Contributing

This project was developed as a university project, and contributions are not open at this time.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgements

We would like to express our gratitude to our professor, Ing. Mauricio Rivera Villalobos, Lic., for providing guidance and support throughout the development of this project.

## Contact

For any inquiries or feedback, please contact the project team at [Joseph1799us@gmail.com].
