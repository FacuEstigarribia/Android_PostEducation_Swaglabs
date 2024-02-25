package com.spotify.carina.carina.demo.db.mappers;

import com.spotify.carina.carina.demo.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);
}
