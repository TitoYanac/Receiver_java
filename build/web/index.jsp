<jsp:include page="home_header.jsp" /> 
        <div id="slider" class="slider-big">            
            <h1>Bienvenido a Farmacia San Marcos</h1>            
            <!--<a href="#" class="btn-white">Iniciar Sesión</a>-->
        </div>
        <div class="center">
            <section id="content">
                <h2 class="subheader" >Lista de Recetas en Espera</h2>
                <!--Listado articulos-->
                <div class="articles">
                    

                </div>
            </section>

            <aside id="sidebar">

                <div id="search" class="sidebar-item">
                        <h3>Buscador</h3>
                        <p>Ingresa DNI paciente </p>
                        <form>
                            <input type="text" name="search" />
                            <input type="submit" name="submit" value="Buscar" class="btn" />
                        </form>
                </div>
            </aside>

            <div class="clearfix"></div>
        </div>

        <jsp:include page="home_footer.jsp" /> 