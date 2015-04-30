/**
 * 
 */
package my.notebook;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * @author Derek O Keeffe 
 * @version 1.0
 */
public class TaskTest {

	@Test
	public void test() 
	{
		String taskName = "Derek";
		String taskDescription = "O Keeffe";
		Priority priority = Priority.Low;
		Status status = Status.Closed;
		Task task = new Task(taskName,priority, taskDescription, status);
		
		//Test to see if the values that have been passed in above are returned
		assertEquals(task.getName(),"Derek");
		assertEquals(task.getDescription(),"O Keeffe");
		assertEquals(task.getPriority(),Priority.Low);
		assertEquals(task.getStatus(),Status.Closed);
	}
}