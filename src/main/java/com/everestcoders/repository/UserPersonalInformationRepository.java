package com.everestcoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.everestcoders.model.UserPersonalInformation;

public interface UserPersonalInformationRepository extends JpaRepository<UserPersonalInformation, String> {
	@Query("select u from UserPersonalInformation  u where  u.userId=:userId")
    public UserPersonalInformation getUserPersonalInformationByUserId(@Param("userId") String userId);
}
