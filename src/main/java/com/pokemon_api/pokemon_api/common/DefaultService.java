package com.pokemon_api.pokemon_api.common;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public abstract class DefaultService<D, E, C, U, T> {

    private static final String CREATE_OK = "create.ok";

    private static final String DELETED_OK = "deleted.ok";

    private static final String INTERNAL_ERROR = "internal.error";

    private static final String UPDATE_OK = "update.ok";

    private static final String NOT_FOUND = "not.found";

    private static final String FOUND_OK = "found.ok";

    private static final String ALL_FOUND_OK = "all.found.ok";

    private static final String ALL_NOT_FOUND = "all.not.found";


    @Autowired
    ApplicationContext applicationContext;

    protected abstract JpaRepository<E, T> getRepository();

    protected abstract MapStructMapper getMapper();


    public Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

    public abstract String getI8nMessage(String key, Object[] args);

    @Transactional
    public ResponseEntity<?> create(C create) {
        CustomResponse customResponse = null;
        try {
            E entity = ((CreateMapper<E, C>) getMapper()).fromCreateDtoToEntity(create);
            entity = getRepository().save(entity);
            D dto = ((DtoMapper<E, D>) getMapper()).ToDto(entity);
            customResponse = new CustomResponse(HttpStatus.OK.value(), getI8nMessage(CREATE_OK, null), dto);
            return ResponseEntity.ok(customResponse);

        } catch (Exception e) {
            customResponse = new CustomResponse(HttpStatus.OK.value(), getI8nMessage(INTERNAL_ERROR, null), e.getMessage());
            return ResponseEntity.internalServerError().body(customResponse);
        }
    }

    @Transactional
    public ResponseEntity<?> update(U update, T id) {

        CustomResponse customResponse = null;
        try {
            E entity = getRepository().findById(id).orElse(null);
            if (entity != null) {
                E merge = ((UpdateMapper<E, U>) getMapper()).merge(entity, update);
                entity = getRepository().save(merge);
                D dto = ((DtoMapper<E, D>) getMapper()).ToDto(entity);
                customResponse = new CustomResponse(HttpStatus.OK.value(), getI8nMessage(UPDATE_OK, null), dto);
                return ResponseEntity.ok(customResponse);
            } else {
                customResponse = new CustomResponse(HttpStatus.NOT_FOUND.value(), getI8nMessage(NOT_FOUND, new Object[] {id} ), null);
                return ResponseEntity.ok(customResponse);

            }
        } catch (Exception e) {
            customResponse = new CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), getI8nMessage(INTERNAL_ERROR, null), e.getMessage());
            return ResponseEntity.internalServerError().body(customResponse);

        }
    }

    @Transactional
    public ResponseEntity<?> deleted(T id) {
        CustomResponse customResponse;
        try {
            E entity = getRepository().findById(id).orElse(null);
            if (entity != null) {
                getRepository().deleteById(id);
                customResponse = new CustomResponse(HttpStatus.OK.value(), getI8nMessage(DELETED_OK, null), null);
                return ResponseEntity.ok(customResponse);
            } else {
                customResponse = new CustomResponse(HttpStatus.NOT_FOUND.value(), getI8nMessage(NOT_FOUND,  new Object[] {id} ),null);
                return ResponseEntity.ok(customResponse);
            }
        } catch (Exception e) {
            customResponse = new CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), getI8nMessage(INTERNAL_ERROR, null), e.getMessage());
            return ResponseEntity.internalServerError().body(customResponse);
        }

    }

    public ResponseEntity<?> findById(T id) {
        CustomResponse customResponse;
        try {
            E entity = getRepository().findById(id).orElse(null);
            if (entity != null) {
                D dto = ((DtoMapper<E, D>) getMapper()).ToDto(entity);
                customResponse = new CustomResponse(HttpStatus.OK.value(), getI8nMessage(FOUND_OK, null), dto);
                return ResponseEntity.ok(customResponse);
            } else {
                customResponse = new CustomResponse(HttpStatus.NOT_FOUND.value(), getI8nMessage(NOT_FOUND,  new Object[] {id} ), null);
                return ResponseEntity.ok(customResponse);
            }
        } catch (Exception e) {
            customResponse = new CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), getI8nMessage(INTERNAL_ERROR, null), e.getMessage());
            return ResponseEntity.internalServerError().body(customResponse);
        }
    }

    public ResponseEntity<?> findAll() {

        CustomResponse customResponse;
        try {
            List<E> entity = getRepository().findAll();
            if (entity != null) {
                List<D> dto = ((DtoMapper<E, D>) getMapper()).toListDto(entity);
                customResponse = new CustomResponse(HttpStatus.OK.value(), getI8nMessage(ALL_FOUND_OK, null), dto);
                return ResponseEntity.ok(customResponse);
            } else {
                customResponse = new CustomResponse(HttpStatus.NOT_FOUND.value(), getI8nMessage(ALL_NOT_FOUND, null), entity);
                return ResponseEntity.ok(customResponse);
            }
        } catch (Exception e) {
            customResponse = new CustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), getI8nMessage(
                    INTERNAL_ERROR, null), e.getMessage());
            return ResponseEntity.internalServerError().body(customResponse);
        }
    }

}
