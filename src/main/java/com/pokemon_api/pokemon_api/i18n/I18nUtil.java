package com.pokemon_api.pokemon_api.i18n;

import jakarta.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class I18nUtil {

    private MessageSource messageSource;

    @Resource(name = "localHolder")
    LocalHolder localHolder;

    public I18nUtil(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String code, Object... args){
        if (code != null && code.startsWith("#{") && code.endsWith("}")) {
            code = code.substring(2, code.length() - 1);
        }
        return messageSource.getMessage(code!=null?code:"", args, localHolder.getCurrentLocale());
    }

    public String getMessageEntityNotFound(Object id) {
        return getMessage(I18nCodes.ENTITY_NOTFOUND_ID, id.toString());
    }

}
