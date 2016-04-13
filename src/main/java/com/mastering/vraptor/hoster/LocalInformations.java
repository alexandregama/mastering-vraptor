package com.mastering.vraptor.hoster;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LocalInformations {

	@Column(name = "descrition")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
