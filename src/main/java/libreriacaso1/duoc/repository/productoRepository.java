package libreriacaso1.duoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import libreriacaso1.duoc.model.producto;

@Repository
public class productoRepository {

    public class LibroRepository {


        private List<producto> listaProductos = new ArrayList<>();

        private LibroRepository(){

            listaProductos.add(new producto(1,"lapiz pasta",300,"lapices"));
            listaProductos.add(new producto(2,"lapiz grafito",150,"lapices"));
            listaProductos.add(new producto(3,"cuaderno universitario",1000,"cuadernos"));
            listaProductos.add(new producto(4,"cuaderno collage",850,"cuadernos"));
        }

        public List<producto> findAll(){
            return listaProductos;
        }

        public producto findById(int id){
            return listaProductos.stream().filter(producto->producto.getId() == id).findAny().orElse(null);

        }

        public producto save (producto prod){
            listaProductos.add(prod);
            return prod;
        }

        public producto update (producto prod){

            producto prodBusc = findById(prod.getId());
            if (prodBusc!=null) {
                listaProductos.remove(prodBusc);
                listaProductos.add(prodBusc);
                return prodBusc;
            }
            return null;
        }
        public boolean delte(int id){
            producto prodDel = findById(id);
            if (prodDel != null ) {
                listaProductos.remove(prodDel);
                return true;

            }
            return false;
        }
    }

}
