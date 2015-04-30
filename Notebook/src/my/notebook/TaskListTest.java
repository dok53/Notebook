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
 * passed to the TaskLiat class is returned correctly
 */
public class TaskListTest {

	@Test
	public void test() {
		ArrayList <TaskList> tasks = new ArrayList <TaskList> ();
		String name = "Appointments";
		
		TaskList lists = new TaskList(name);
		tasks.add(lists);
		assertEquals(tasks.size(), 1);
		assertEquals(tasks.get(0).getName(),"Appointments");
		String name2 ="Dereks List";
		TaskList list2 = new TaskList(name2);
		tasks.add(list2);
		tasks.get(1).setName(name2);
		assertEquals(tasks.size(),2);
	}
}
