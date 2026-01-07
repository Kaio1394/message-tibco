package br.com.app.messagetibco.application.service;

import br.com.app.messagetibco.application.dto.ModelMapperConfig;
import br.com.app.messagetibco.application.dto.TibcoConfigSenderDto;
import br.com.app.messagetibco.application.dto.TibcoConfigSenderRegisterDto;
import br.com.app.messagetibco.domain.exception.TagAlreadyExistsException;
import br.com.app.messagetibco.domain.model.TibcoConfigSender;
import br.com.app.messagetibco.domain.repository.TibcoConfigRepository;
import org.modelmapper.ModelMapper;

import java.util.List;

public class TibcoConfigService {
    private final TibcoConfigRepository repository;
    private static final ModelMapper mapper =
            ModelMapperConfig.getInstance();

    public TibcoConfigService(TibcoConfigRepository repository){
        this.repository = repository;
    }

    public void saveConfig(TibcoConfigSenderRegisterDto dto){
        if(this.repository.existsByTag(dto.getTag()))
            throw new TagAlreadyExistsException(dto.getTag());

        TibcoConfigSender model = mapper.map(dto, TibcoConfigSender.class);
        this.repository.save(model);
    }
    public List<TibcoConfigSenderDto> getListTibcoConfig(){
        return this.repository.getListTibcoConfig()
                .stream()
                .map(model -> mapper.map(model, TibcoConfigSenderDto.class)).toList();
    }
}
