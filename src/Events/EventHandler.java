package Events;

import java.util.HashMap;
import java.util.Vector;




public class EventHandler 
{
	HashMap<Integer, Vector<EventListener>> event_listeners;
	
	void addListener(EventListener listener, int event)
	{
		if(event_listeners.get(event) == null)
		{
			event_listeners.put(event, new Vector<EventListener>());
		}
		
		if(!event_listeners.get(event).contains(listener))
		{
			event_listeners.get(event).add(listener);
		}
	}
	
	public void removeListener(int event, EventListener listener)
	{
		event_listeners.get(event).remove(listener);
		
		if(event_listeners.get(event).size() == 0)
			event_listeners.remove(event);
	}
	
	public void generateEvent(int event, Object source, Object data)
	{		
		Vector<EventListener> crt_listeners = this.event_listeners.get(event);
		if(crt_listeners == null)
			return;
		
		int n = crt_listeners.size();
		
		for(int i=0; i<n; i++)
		{
			crt_listeners.get(i).eventReceived(event, source, data);
		}
	}
}
