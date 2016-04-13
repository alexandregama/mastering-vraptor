package com.mastering.vraptor.hoster;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
@DiscriminatorValue(value = "hoster")
public class Hoster extends User {

	@Column(name = "nickname")
	private String nickName;
	
	@Embedded
	private LocalInformations informations = new LocalInformations();

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public LocalInformations getInformations() {
		return informations;
	}

	public void setInformations(LocalInformations informations) {
		this.informations = informations;
	}

}
