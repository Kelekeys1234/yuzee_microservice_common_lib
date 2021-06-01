package com.yuzee.common.lib.dto.user;

import java.io.Serializable;
import java.util.List;

public class UserIdList implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4133782439462102821L;

	private List<Long> userIds;
	private String citizenship;
	private List<String> cities;
	private String gender;

	public List<Long> getUserIds() {
		return userIds;
	}

	public void setUserIds(final List<Long> userIds) {
		this.userIds = userIds;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(final String citizenship) {
		this.citizenship = citizenship;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(final List<String> cities) {
		this.cities = cities;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(final String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserIdList [userIds=").append(userIds).append(", citizenship=").append(citizenship).append(", cities=").append(cities)
				.append(", gender=").append(gender).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (cities == null ? 0 : cities.hashCode());
		result = prime * result + (citizenship == null ? 0 : citizenship.hashCode());
		result = prime * result + (gender == null ? 0 : gender.hashCode());
		result = prime * result + (userIds == null ? 0 : userIds.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UserIdList other = (UserIdList) obj;
		if (cities == null) {
			if (other.cities != null) {
				return false;
			}
		} else if (!cities.equals(other.cities)) {
			return false;
		}
		if (citizenship == null) {
			if (other.citizenship != null) {
				return false;
			}
		} else if (!citizenship.equals(other.citizenship)) {
			return false;
		}
		if (gender == null) {
			if (other.gender != null) {
				return false;
			}
		} else if (!gender.equals(other.gender)) {
			return false;
		}
		if (userIds == null) {
			if (other.userIds != null) {
				return false;
			}
		} else if (!userIds.equals(other.userIds)) {
			return false;
		}
		return true;
	}

}
