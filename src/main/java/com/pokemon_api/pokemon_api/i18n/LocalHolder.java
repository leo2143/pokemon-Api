package com.pokemon_api.pokemon_api.i18n;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalHolder {

    private Locale currentLocale;
}
