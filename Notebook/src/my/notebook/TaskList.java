package my.notebook;
import java.util.List;
import java.util.ArrayList;
/*
 * This class sets up a tasklist which single tasks can be added to.
 * @author Derek O Keeffe
 * @version 1.0
 */

public class TaskList
{
	private ArrayList<Task> tasks;
	private String name;
	
	/**
	 * @param name Sets the name
	 */
	public TaskList(String name)
	{
		this.name = name;
		this.tasks = new ArrayList<Task>();
	}
	
	/**
	 * @param position
	 * @return name Returns the name of a specified task
	 */
	public String getTasksName(int position)
	{
		List <String> tempList = new ArrayList <String>();
		for (int i = 0; i < tasks.size(); i++) 
		{
			tempList.add(tasks.get(i).getName());
		}
		return tempList.get(position);
	}
	
	/**
	 * Takes the toString and removes the commas and square brackets
	 * @return toString Returns the formatted toString
	 */
	public String printableToString()
	{
		String formatedString = tasks.toString().replace(",", "");
		String formatedString1 = formatedString.toString().replace("[", "");
		String formatedString2 = formatedString1.toString().replace("]", "");
		return formatedString2;
	}

	/**
	 * @return tasks Returns the tasks
	 */
	public ArrayList<Task> getTask()
	{
		return tasks;
	}
	
	/**
	 * @param task Adds a task to the list
	 */
	public void addTask(Task task)
	{
		tasks.add(task);
	}
	
	/**
	 * @param tasks Sets the tasks
	 */
	public void setTasks(ArrayList<Task> tasks)
	{
		this.tasks = tasks;
	}
	
	/**
	 * @param p Removes a specified task
	 */
	public void removeTask(int p)
	{
		tasks.remove(p);
	}

	/**
	 * @return name Returns the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @param name Sets the name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String toString()
	{
		return "" + name; 
	}
	
}