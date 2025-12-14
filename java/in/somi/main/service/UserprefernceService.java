package in.somi.main.service;

import in.somi.main.dto.UpdateUserPreferenceRequestDTO;
import in.somi.main.dto.UserPreferenceDTO;

public interface UserprefernceService {
	
	UserPreferenceDTO getUserPrefernece(Long userId);
	
	UserPreferenceDTO updateUserPreference(Long userId, UpdateUserPreferenceRequestDTO dto);
}
