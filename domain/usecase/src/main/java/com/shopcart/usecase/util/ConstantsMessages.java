package com.shopcart.usecase.util;

import lombok.Data;

@Data
public class ConstantsMessages {
    public static final String CREATE_RECORD_SUCCESS = "El registro se ha creado exitosamente ";
    public static final String CREATE_RECORD_FAILED = "Hubo un fallo al intentar crear el registro. ";
    public static final String RECORD_EMPTY = "Hay uno o más campos vacios. ";
    public static final String LIST_RECORD_SUCCESS = "Se han encontrado registros. ";
    public static final String LIST_RECORD_EMPTY = "No se han encontrado ningún registro. ";
    public static final String NOT_RECORD_EXIST = "No existe ningun registro con ese Id. ";
    public static final String UPDATE_RECORD_SUCCESS = "El registro se ha actualizado exitosamente ";
    public static final String UPDATE_RECORD_FAILED = "Hubo un problema al actualizar el registro ";
    public static final String USER_NOT_EXIST = "No existe ningún usuario registrado con esas credenciales." +
            " Verifique el usuario y la contraseña. ";
}
