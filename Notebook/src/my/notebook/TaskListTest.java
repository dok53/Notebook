/**
 * 
 */
package my.notebook;

import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.Test;

/**
 * @author dok53
 *
 */

/**
 * @author Derek O Keeffe
 * @version 1.0
 * This test is used to check that all the information that is 
 * passed to the TaskList class is returned correctly
 */
public class TaskListTest {

	@Test
	public void test() {
		//Create ArrayList to store lists
		ArrayList <TaskList> tasks = new ArrayList <TaskList> ();
		//Create list name
		String name = "Appointments";
		//Create list with name
		TaskList lists = new TaskList(name);
		//Add to ArrayList
		tasks.add(lists);
		//Run tests on size and find name of first list
		assertEquals(tasks.size(), 1);
		assertEquals(tasks.get(0).getName(),"Appointments");
		
		//Repeat for a second list.. without checking size
		String name2 ="Dereks List";
		TaskList list2 = new TaskList(name2);
		tasks.add(list2);
		tasks.get(1).setName(name2);
		assertEquals(tasks.size(),2);
	}
}
