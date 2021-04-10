package com.example.Trade.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TradeInfoDTO {
	private String tradeId;
	private int version;
	private String counterPartyId;
	private String bookId;
	private Date maturityDate;
	private Date createdDate;
	private String expired;
	/**
	 * @return the tradeId
	 */
	public String getTradeId() {
		return tradeId;
	}
	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	/**
	 * @return the counterPartyId
	 */
	public String getCounterPartyId() {
		return counterPartyId;
	}
	/**
	 * @param counterPartyId the counterPartyId to set
	 */
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the maturityDate
	 */
	public Date getMaturityDate() {
		return maturityDate;
	}
	/**
	 * @param maturityDate the maturityDate to set
	 */
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the expired
	 */
	public String getExpired() {
		return expired;
	}
	/**
	 * @param expired the expired to set
	 */
	public void setExpired(String expired) {
		this.expired = expired;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((counterPartyId == null) ? 0 : counterPartyId.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((expired == null) ? 0 : expired.hashCode());
		result = prime * result + ((maturityDate == null) ? 0 : maturityDate.hashCode());
		result = prime * result + ((tradeId == null) ? 0 : tradeId.hashCode());
		result = prime * result + version;
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
		TradeInfoDTO other = (TradeInfoDTO) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (counterPartyId == null) {
			if (other.counterPartyId != null)
				return false;
		} else if (!counterPartyId.equals(other.counterPartyId))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (expired == null) {
			if (other.expired != null)
				return false;
		} else if (!expired.equals(other.expired))
			return false;
		if (maturityDate == null) {
			if (other.maturityDate != null)
				return false;
		} else if (!maturityDate.equals(other.maturityDate))
			return false;
		if (tradeId == null) {
			if (other.tradeId != null)
				return false;
		} else if (!tradeId.equals(other.tradeId))
			return false;
		if (version != other.version)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TradeInfoDTO [tradeId=" + tradeId + ", version=" + version + ", counterPartyId=" + counterPartyId
				+ ", bookId=" + bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate
				+ ", expired=" + expired + "]";
	}
	public TradeInfoDTO(String tradeId, int version, String counterPartyId, String bookId, Date maturityDate,
			Date createdDate, String expired) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}

}