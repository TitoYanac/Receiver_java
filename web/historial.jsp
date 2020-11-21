<jsp:include page="home_header.jsp" /> 

        <div class="center">
            <section id="content">

                <h1 class="subheader">Formulario Historial Médico</h1>

                <form class="mid-form" id="formulario">
                    <div class="form-group">
                        <label for="nombre">Fecha del examen</label>
                        <input type="text" name="fecha-examen" id="campo-fecha-examen"/>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" name="nombre" id="campo-nombre" />
                    </div>
                    <div class="form-group">
                        <label for="apellidos">Apellido</label>
                        <input type="text" name="apellidos"id="campo-apellido" />
                    </div>
                    <div class="form-group">
                        <label for="email">Fecha de Nacimiento</label>
                        <input type="text" name="fecha-nacimiento" id="campo-fecha-nacimiento" />
                    </div>
                    <div class="form-group">
                        <label for="re-pass">Alergias</label>
                        <input type="text" name="alergias" id="campo-alergias"/>
                    </div>
                    <div class="form-group radibuttons">
                        <input type="radio" name="genero" value="hombre" /> Hombre 
                        <input type="radio" name="genero" value="mujer" /> Mujer                             
                    </div>
                    <div class="clearfix"></div>
                    <button type="submit" name="Confirmar" class="btn btn-success">REGISTRAR</button>
                </form>

            </section>

            <aside id="sidebar">
                <div id="nav-blog" class="sidebar-item">
                    <h3>Suscríbete al Blog</h3>
                    <a href="#" class="btn btn-success">Suscribirse</a>
                </div>

                <div id="search" class="sidebar-item">
                    <h3>Buscador</h3>
                    <p>Encuentra el artículo que buscas</p>
                    <form>
                        <input type="text" name="search" />
                        <input type="submit" name="submit" value="Buscar" class="btn" />
                    </form>
                </div>
            </aside>

            <div class="clearfix"></div>
        </div> 

        <jsp:include page="home_footer.jsp" /> 