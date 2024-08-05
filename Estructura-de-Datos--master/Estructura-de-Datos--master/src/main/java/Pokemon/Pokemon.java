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

    public Pokemon(String nombre) {
        this.id = contadorIds++;
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
    public void defensaEspecial(Pokemon pokemonEnemigo){};
    
    public void recibirDaño(int daño) {
        this.vida -= daño;
        System.out.println(this.nombre + " recibió " + daño + " puntos de daño. Vida restante: " + this.vida);
        if (this.vida <= 0) {
            System.out.println(this.nombre + " ha sido derrotado!");
        }
    }
    
    // Getters y Setters
    public static int getContadorIds() {
        return contadorIds;
    }

    public static void setContadorIds(int contadorIds) {
        Pokemon.contadorIds = contadorIds;
    }

    public int getId() {
        return id;
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

    public void setHPAtaque(int HPataque) {
        this.HPataque = HPataque;
    }

    public int getHPDefensa() {
        return HPdefensa;
    }

    public void setHPDefensa(int HPdefensa) {
        this.HPdefensa = HPdefensa;
    }

    public int getHPAtaqueEspecial() {
        return HPataqueEspecial;
    }

    public void setHPAtaqueEspecial(int HPataqueEspecial) {
        this.HPataqueEspecial = HPataqueEspecial;
    }

    public int getHPDefensaEspecial() {
        return HPdefensaEspecial;
    }

    public void setHPDefensaEspecial(int HPdefensaEspecial) {
        this.HPdefensaEspecial = HPdefensaEspecial;
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
