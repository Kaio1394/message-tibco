package br.com.app.messagetibco.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TibcoConfigSenderDto {
    private String tag;
    private String daemon;
    private String service;
    private String network;

    @Override
    public String toString() {
        return tag;
    }
}
