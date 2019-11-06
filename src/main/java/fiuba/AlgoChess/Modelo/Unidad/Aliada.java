package fiuba.AlgoChess.Modelo.Unidad;

public class Aliada{

    private Hashtable<String, Entidad entidad> aliados = new Hashtable<String, Entidad entidad>();

    public void recibirCura(){

        this.vida += 15;
    }

    public void agregarAliado(Entidad nuevoAliado){

        aliados.put(nuevoAliado.getEstatus, nuevoAliado);

    }
}
