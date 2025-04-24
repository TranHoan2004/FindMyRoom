package com.FindMyRoom.service;

import com.FindMyRoom.dto.response.CartResponseDTO;

public interface CartService {
    CartResponseDTO getCartByUserID(Long id) throws Exception;
}