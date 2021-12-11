package ga.susite.StablerCharacter.utils;

import java.util.ArrayList;
import java.util.function.Function;

public class Event<EventArgsType> {
	ArrayList<Function<EventArgs<EventArgsType>, Void>> subscribers = new ArrayList<Function<EventArgs<EventArgsType>, Void>>();
	
	public void invoke(EventArgs<EventArgsType> eventArgs) {
		for(Function<EventArgs<EventArgsType>, Void> subscriber : subscribers) {
			subscriber.apply(eventArgs);
		}
	}
	
	public void addEventListener(Function<EventArgs<EventArgsType>, Void> subscriber) {
		subscribers.add(subscriber);
	}
	
	@SuppressWarnings("unchecked")
	public void addEventListeners(Function<EventArgs<EventArgsType>, Void>... subscribers) {
		for(Function<EventArgs<EventArgsType>, Void> subscriber : subscribers) {
			addEventListener(subscriber);
		}
	}
}
