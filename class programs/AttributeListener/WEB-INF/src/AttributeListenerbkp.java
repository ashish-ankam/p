import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
 
public class AttributeListener implements ServletRequestAttributeListener {
 
	public void attributeAdded(ServletRequestAttributeEvent event) {
		event.getServletContext().log("Attribute added : " + event.getName() + " = "
				+ event.getValue());
		//System.out.println("Attribute added : " + event.getName() + " = "
		//		+ event.getValue());
	}
 
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("Attribute removed : " + event.getName() + " = "
				+ event.getValue());
	}
 
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.err.println("Attribute replaced : " + event.getName() + " = "
				+ event.getValue());
	}
 
}