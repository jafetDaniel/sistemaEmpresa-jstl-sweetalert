package com.mycompany.empresa.models;

import com.mycompany.empresa.models.Acceso;
import com.mycompany.empresa.models.Estatus;
import com.mycompany.empresa.models.PerfilUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-12-12T14:11:51")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, PerfilUsuario> perfilUsuario;
    public static volatile SingularAttribute<Usuario, Estatus> estatus;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, Acceso> acceso;
    public static volatile SingularAttribute<Usuario, String> apellido_paterno;
    public static volatile SingularAttribute<Usuario, String> apellido_materno;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile SingularAttribute<Usuario, String> nombre;

}