package net.nilsghesquiere.entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name ="counters")
public class Counter implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@NotBlank
	String name;
	@Column
	ZonedDateTime timeStart;
	@Column
	ZonedDateTime timeEnd;
	@Column
	Duration duration;
	@Column
	boolean active;
	
	public Counter() {
	}

	public Counter(String name, ZonedDateTime timeStart, Duration duration, boolean active) {
		//this.duration = Duration.ofHours(3L);
		this.name = name;
		this.timeStart = timeStart;
		this.duration = duration;
		if (timeStart != null){
			this.timeEnd = timeStart.plus(duration);
		} else {
			timeEnd= null;
		}
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ZonedDateTime getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(ZonedDateTime timeStart) {
		this.timeStart = timeStart;
		if (timeStart != null){
			setTimeEnd(timeStart.plus(this.duration));
		} else {
			setTimeEnd(null);
		}
	}

	public ZonedDateTime getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(ZonedDateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	//Werking: Klik op knop, start = nu, eind binnen 3u, actief ja.
	//resetknop: actief op nee zetten, gewone knop: opnieuw vullen
}
