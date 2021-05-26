<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

        <title>Usuarios</title>
    </head>
    <body>
        <div class="container">
            <h1>Formulario de Roles</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="roles" />
            </jsp:include>
            
            <form action="RolControlador" method="post" >
                <input type="hidden" name="id" value="${rol.id}">
                <div class="form-group">
                    <label for="" class="form-label">Rol</label>
                    <input type="text" class="form-control" name="descripcion" value="${rol.descripcion}" placeholder="Describa el rol">                    
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    </body>
</html>

