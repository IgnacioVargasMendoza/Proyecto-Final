package Pokemon;

public abstract class Pokemon implements MovimientoEspecial {

    private static int contadorIds = 1; // Contador estático para asignar ids únicos
    private int id;
    private String nombre;
    private int vida;
    private int HPataque;
    private int HPdefensa;
    private int HPataqueEspecial;
    private int HPdefensaEspecial;
    private String tipo;

    public Pokemon(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos de batalla
    public void atacar(Pokemon pokemonEnemigo) {
        System.out.println(this.nombre + " ataca a " + pokemonEnemigo.getNombre());
        int daño = this.HPataque - pokemonEnemigo.getHPDefensa();
        if (daño > 0) {
            pokemonEnemigo.recibirDaño(daño);
        } else {
            System.out.println(pokemonEnemigo.getNombre() + " bloqueó el ataque!");
        }
    }
    
    public void defender(Pokemon pokemonEnemigo){};
    public void ataqueEspecial(Pokemon pokemonEnemigo){};
    public void defensaEspeical(Pokemon pokemonEnemigo){};
    
    public void recibirDaño(int daño) {
        this.vida -= daño;
        System.out.println(this.nombre + " recibió " + daño + " puntos de daño. Vida restante: " + this.vida);
        if (this.vida <= 0) {
            System.out.println(this.nombre + " ha sido derrotado!");
        }
    }
    
    
    //Pokemon Getter and Setter
    public static int getContadorIds() {
        return contadorIds;
    }

    public static void setContadorIds(int contadorIds) {
        Pokemon.contadorIds = contadorIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getHPAtaque() {
        return HPataque;
    }

    public void setHPAtaque(int ataque) {
        this.HPataque = ataque;
    }

    public int getHPDefensa() {
        return HPdefensa;
    }

    public void setHPDefensa(int defensa) {
        this.HPdefensa = defensa;
    }

    public int getHPAtaqueEspecial() {
        return HPataqueEspecial;
    }

    public void setHPAtaqueEspecial(int ataqueEspecial) {
        this.HPataqueEspecial = ataqueEspecial;
    }

    public int getHPDefensaEspecial() {
        return HPdefensaEspecial;
    }

    public void setHPDefensaEspecial(int defensaEspecial) {
        this.HPdefensaEspecial = defensaEspecial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "id=" + id + ", nombre=" + nombre + ", vida=" + vida + ", HPataque=" + HPataque + ", HPdefensa=" + HPdefensa + ", HPataqueEspecial=" + HPataqueEspecial + ", HPdefensaEspecial=" + HPdefensaEspecial + ", tipo=" + tipo + '}';
    }




}
