/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    private Employee employee;

    public void setup1() {
        employee = new Employee("Alfonso", "Ramos", "22-11", 0, new BSTClientsInCharge());
    }

    public void setup2() {
        employee = new Employee("Carlos", "Quintero", "11-22", 0, new BSTClientsInCharge());
    }

    @Test
	public void testCompareTo() {

		// Example with the Restaurant NIT attribute from an order (descending sort purposes) :

		// Expected comparison result: greater than it:

		setup1();
		String exampleCurrentNit4 = "11-22";
		assertTrue(employee.getId().compareTo(exampleCurrentNit4) > 0, "Lexicographically, the attribute passed as parameter isn't greater than the current one.");
		assertFalse(employee.getId().compareTo(exampleCurrentNit4) < 0, "Lexicographically, the attribute passed as parameter is less than the current one.");
		assertFalse(employee.getId().compareTo(exampleCurrentNit4) == 0, "Lexicographically, the attribute passed as parameter is equal to the current one.");

		/*-----------------------------------------------------------------------------------------------------------*/

		// Expected comparison result: less than it:

		setup2();
		String exampleCurrentNit5 = "22-11";
		assertTrue(employee.getId().compareTo(exampleCurrentNit5) < 0, "Lexicographically, the attribute passed as parameter isn't less than the current one.");
		assertFalse(employee.getId().compareTo(exampleCurrentNit5) > 0, "Lexicographically, the attribute passed as parameter is greater than the current one.");
		assertFalse(employee.getId().compareTo(exampleCurrentNit5) == 0, "Lexicographically, the attribute passed as parameter is equal to the current one.");

		/*-----------------------------------------------------------------------------------------------------------*/

		// Expected comparison result: equal:

		setup2();
		String exampleCurrentNit6 = "11-22";
		assertTrue(employee.getId().compareTo(exampleCurrentNit6) == 0, "Lexicographically, the attribute passed as parameter isn't equal to the current one.");
		assertFalse(employee.getId().compareTo(exampleCurrentNit6) > 0, "Lexicographically, the attribute passed as parameter is greater than the current one.");
		assertFalse(employee.getId().compareTo(exampleCurrentNit6) < 0, "Lexicographically, the attribute passed as parameter is equal to the current one.");
    }

    @Test
    public void testToString() {
        String separator = ";";
        setup1();
        assertEquals("Ramos " + separator + " Alfonso " + separator + " 22-11 " + separator + " " + 0, employee.toString(separator), "The employee information isn't the same one.");
    }
}