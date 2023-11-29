package com.mycompany.empresa.models;

import com.mycompany.empresa.models.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-11-28T15:04:49")
@StaticMetamodel(Estatus.class)
public class Estatus_ { 

    public static volatile ListAttribute<Estatus, Usuario> listaUsuarios;
    public static volatile SingularAttribute<Estatus, String> nombre_estatus;
    public static volatile SingularAttribute<Estatus, Integer> id;

}