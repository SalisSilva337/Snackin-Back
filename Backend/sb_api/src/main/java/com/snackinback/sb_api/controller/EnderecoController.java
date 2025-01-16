package com.snackinback.sb_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snackinback.sb_api.service.EnderecoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/enderecos")
@RequiredArgsConstructor
public class EnderecoController {
    private final EnderecoService enderecoService;
}
