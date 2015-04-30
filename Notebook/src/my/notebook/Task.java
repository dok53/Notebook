package my.notebook;

/**This class sets up a single task that can be added to a list 
 * @author Derek O Keeffe 
 * @version 1.0
 */

public class Task 
{
	private String name;
	private String description;
	private Priority priority;
	private Status status;
	
	/* Sets the parameters of the task 
	 * @param name
	 * @param priority
	 * @param description
	 * @param status
	 */
	public Task (String name, Priority priority, String description, Status status)
	{
		if (name.trim().length() > 0)
		{
			this.name = name;
		}
		if (description.length() <= 255 && description.length() > 0)
		{
			this.setDescription(description);
		}
		else
		{
			this.description = "No description added !!!!!";
		}
		this.priority = priority;
		this.status = status;
	}
	
	/**
	 * @return Priority
	 */
	public Priority getPriority()
	{
		return priority;
	}
	
	/**
	 * @param priority Set the priority
	 */
	public void setPriority(Priority priority) 
	{
		this.priority = priority;
	}
	
	/**
	 * @param Name Set the name
	 * @param Priority Set the priority
	 * @param Description Set the description
	 * @param Status Set the status
	 */
	public void addTask(String name, Priority priority, String description, Status status)
	{
		this.name = name;
		this.priority = priority;
		this.description = description;
		this.status = status;
		
	}

	/**
	 * @return Description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description Set the description
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	/**
	 * @return name
	 */
	public String getName()
	{
		return name ;
	}
	
	/**
	 * @param name Set the name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status Set the status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String toString()
	{
		return "Name : " + name + "\n" + "Priority : " + priority + "\n" + "Description : " 
				+ description +  "\n" + "Status : " + status + "\n" + "__________________________" + "\n";
	}
	
}
