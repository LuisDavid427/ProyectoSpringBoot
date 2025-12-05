package com.sena.crudbasic.service;

import java.util.List;
import com.sena.crudbasic.dto.request.RegistrationRequestDto;

import com.sena.crudbasic.dto.response.RegistrationResponseDto;

public interface RegistrationService extends GenericService <RegistrationRequestDto, RegistrationResponseDto, Integer>{

    List<RegistrationResponseDto> filterByVisitorId(int idVisitor);
    List<RegistrationResponseDto> filterByCompanyId(int idCompany);
    List<RegistrationResponseDto> filterByFairId(int idFair);
    List<RegistrationResponseDto> filterByStandId(int idStand);
    List<RegistrationResponseDto> filterByLectureId(int idLecture);
    List<RegistrationResponseDto> filterByDemonstrationId(int idDemonstration);
    List<RegistrationResponseDto> filterBySpeakerId(int idSpeaker);
}