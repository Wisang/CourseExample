package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import production.DateUtil;
import production.TimeSlot;

import com.om.query.domain.ObjectDescription;
import com.om.query.handler.PropertyHandler;
import com.om.reflection.PropertyGetter;

public class TimeSlotPropertyHandler extends PropertyHandler {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
	static SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm");

	@Override
	public void handle(PropertyGetter propertyGetter, Object targetObject,
			ObjectDescription objectDescription) {
		TimeSlot timeSlot = propertyGetter.getValue(targetObject,
				TimeSlot.class);

		Date startDateTime = timeSlot.startDateTime;

		objectDescription.addPropertyDescription("date", DateUtil.instance()
				.formatDate(startDateTime));
		objectDescription.addPropertyDescription("startTime", DateUtil
				.instance().formatTime(startDateTime));
	}
}
