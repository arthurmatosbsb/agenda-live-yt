package com.github.arthurmatosbsb.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Live {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String liveName;
	private String channelName;
	private LocalDateTime liveDate;
	private String liveLink;
	private LocalDateTime registrationDate;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLiveName() {
		return liveName;
	}

	public void setLiveName(String liveName) {
		this.liveName = liveName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public LocalDateTime getLiveDate() {
		return liveDate;
	}

	public void setLiveDate(LocalDateTime liveDate) {
		this.liveDate = liveDate;
	}

	public String getLiveLink() {
		return liveLink;
	}

	public void setLiveLink(String liveLink) {
		this.liveLink = liveLink;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Live other = (Live) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Live [id=" + id + ", liveName=" + liveName + ", channelName=" + channelName + ", liveDate=" + liveDate
				+ ", liveLink=" + liveLink + ", registrationDate=" + registrationDate + "]";
	}

	

}
