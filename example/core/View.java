package core;


/**
 * Responsible for the visual parts of the program.
 */
public interface View 
{	
	/**
	 * Defines what to do when a model notifies it of changes.
	 * 
	 * @param model Model that triggered the update
	 * @param data Data sent by this model
	 */
	public void update(Model model, Object data);
}
