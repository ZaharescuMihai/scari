package Events;

public interface EventListener 
{
	public void eventReceived(int event, Object source, Object data);
}
