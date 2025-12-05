package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.request.ProductRequestDto;

import com.sena.crudbasic.dto.response.ProductResponseDto;

public interface ProductService extends GenericService <ProductRequestDto, ProductResponseDto, Integer>{
    List<ProductResponseDto> filterByStandId(int idStand);
}