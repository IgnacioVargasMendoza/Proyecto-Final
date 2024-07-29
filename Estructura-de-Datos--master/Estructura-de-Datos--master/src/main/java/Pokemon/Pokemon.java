package Pokemon;

public abstract class Pokemon {

    private static int contadorIds = 1; // Contador estático para asignar ids únicos
    private int id;
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private String tipo;

    public Pokemon(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos de batalla
    public void atacar(Pokemon pokemonEnemigo) {
        System.out.println(this.nombre + " ataca a " + pokemonEnemigo.getNombre());
        int daño = this.ataque - pokemonEnemigo.getDefensa();
        if (daño > 0) {
            pokemonEnemigo.recibirDaño(daño);
        } else {
            System.out.println(pokemonEnemigo.getNombre() + " bloqueó el ataque!");
        }
    }

    public void recibirDaño(int daño) {
        this.vida -= daño;
        System.out.println(this.nombre + " recibió " + daño + " puntos de daño. Vida restante: " + this.vida);
        if (this.vida <= 0) {
            System.out.println(this.nombre + " ha sido derrotado!");
        }
    }

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

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "id=" + id + ", nombre=" + nombre + ", vida=" + vida + ", ataque=" + ataque + ", defensa=" + defensa + ", ataqueEspecial=" + ataqueEspecial + ", defensaEspecial=" + defensaEspecial + ", tipo=" + tipo + '}';
    }


}
