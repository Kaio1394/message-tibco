package br.com.app.messagetibco.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tibco_configs_sender")
public class TibcoConfigSender extends BaseModel{
    @Column(name = "tag", nullable = false)
    private String tag;

    private String daemon;

    private String service;

    private String network;

    private String subject;
}
