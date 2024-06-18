package com.diego.sqs.domain;


//import javax.persistence.*;
import java.io.Serializable;

//@EntityListeners(BaseEntityListener.class)
//@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable {

//	@Column(updatable = false, name = "tt_creation_date")
//	private LocalDateTime creationDate;
//
//	@Column(name = "tt_last_update_date")
//	private LocalDateTime lastUpdateDate;
//
//	protected BaseEntity() {
//		super();
//	}
//
//	public void creationDate() {
//		this.creationDate = LocalDateTime.now();
//	}
//
//	public void lastUpdateDate() {
//		this.lastUpdateDate = LocalDateTime.now();
//	}
//
//	public LocalDateTime getCreationDate() {
//		return creationDate;
//	}
//
//	public void setCreationDate(LocalDateTime creationDate) {
//		this.creationDate = creationDate;
//	}
//
//	public LocalDateTime getLastUpdateDate() {
//		return lastUpdateDate;
//	}
//
//	public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
//		this.lastUpdateDate = lastUpdateDate;
//	}
//
//	@PrePersist
//	public void prePersist() {
//		creationDate = LocalDateTime.now();
//	}
//
//	@PreUpdate
//	public void preUpdate() {
//		lastUpdateDate = LocalDateTime.now();
//	}
}