package br.com.app.messagetibco.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TibcoConfigSenderRegisterDto {
    private String tag;
    private String daemon;
    private String service;
    private String network;
}
