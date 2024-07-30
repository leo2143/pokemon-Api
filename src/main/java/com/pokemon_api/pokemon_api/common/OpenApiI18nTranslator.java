package com.pokemon_api.pokemon_api.common;

import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class OpenApiI18nTranslator {

    @Autowired
    private I18nUtil  I18nUtil;

    @Bean
    public OpenApiCustomizer translateOpenApi() {
        return openApi -> {
            openApi.getPaths().entrySet().stream().forEach(entry -> {
                PathItem pathItem = entry.getValue();
                translateOperations(pathItem);
            });
            openApi.getTags().stream().forEach(tag -> {
                tag.setDescription(I18nUtil.getMessage(tag.getDescription(), new Object[]{}));
            });
        };
    }

    private void translateOperations(PathItem pathItem) {
        for (PathItem.HttpMethod method : PathItem.HttpMethod.values()) {
            Operation operation = pathItem.readOperationsMap().get(method);
            if (operation != null) {
                operation.setSummary(I18nUtil.getMessage(operation.getSummary(), new Object[]{}));
                operation.setDescription(I18nUtil.getMessage(operation.getDescription(), new Object[]{}));
                translateParameters(operation.getParameters());
                translateResponses(operation.getResponses());
            }
        }
    }

    private void translateParameters(List<Parameter> parameters) {
        if (parameters != null) {
            parameters.stream().forEach(p -> {
                p.setDescription(I18nUtil.getMessage(p.getDescription(), new Object[]{}));
            });
        }
    }

    private void translateResponses(ApiResponses responses) {
        if (responses != null) {
            for (Map.Entry<String, ApiResponse> responseEntry : responses.entrySet()) {
                ApiResponse apiResponse = responseEntry.getValue();
                String responseDescriptionKey = responseEntry.getKey();
                String responseDescriptionText = apiResponse.getDescription();
                if (responseDescriptionKey != null && !responseDescriptionText.startsWith("#{") && !responseDescriptionText.endsWith("}")) {
                    String i18nKey = "api.response." + responseDescriptionKey;
                    String i18nText = I18nUtil.getMessage(i18nKey, new Object[]{});
                    if (i18nKey.equals(i18nText)) {
                        i18nText = apiResponse.getDescription();
                    }
                    apiResponse.setDescription(i18nText);
                } else {
                    responseDescriptionKey = apiResponse.getDescription();
                    if (responseDescriptionKey != null && !responseDescriptionKey.isEmpty() && responseDescriptionKey.startsWith("#{") && responseDescriptionKey.endsWith("}")) {
                        String i18nKey = responseDescriptionKey.substring(2, responseDescriptionKey.length() - 1);
                        String i18nText = I18nUtil.getMessage(i18nKey, new Object[]{});
                        if (i18nKey.equals(i18nText)) {
                            i18nText = apiResponse.getDescription();
                        }
                        apiResponse.setDescription(i18nText);
                    }

                }
            }
        }
    }
}
