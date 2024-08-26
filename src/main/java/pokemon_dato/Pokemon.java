/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon_dato;

/**
 *
 * @author Ignac
 */
public abstract class Pokemon implements MovimientoEspecial {

    private int id;
    private String nombre;
    private int vida;
    private int HPataque;
    private int HPdefensa;
    private int HPataqueEspecial;
    private int HPdefensaEspecial;
    private String tipo;

    public Pokemon(String nombre, int id) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos de batalla
    public void atacar(Pokemon enemigo, boolean defensa) {
        
        System.out.println(this.nombre + " ataca a " + enemigo.getNombre());
        System.out.println("La vida del pokemon es: " + enemigo.getVida());
        
        int dano = this.HPataque;
        if (defensa == true) {
            dano -= enemigo.getHPDefensa();
            enemigo.recibirDaño(dano);
        }else {
            enemigo.recibirDaño(dano);
        }
    }

    public void ataqueEspecial(Pokemon enemigo, boolean defensaEspecial) {
    }

 
    
    //Activa la defensa
    public boolean defender() {
        return true;
    };
    
    //Activa defensaEspecial
    public boolean defensaEspecial() {
        return true;
    };
    
    
    public void recibirDaño(int dano) {
        this.vida -= dano;
        System.out.println(this.nombre + " recibio " + dano + " puntos de dano. Vida restante: " + this.vida);
        if (this.vida <= 0) {
            System.out.println(this.nombre + " ha sido derrotado!");
        }
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

    protected void setVida(int vida) {
        this.vida = vida;
    }

    public int getHPAtaque() {
        return HPataque;
    }

    protected void setHPAtaque(int HPataque) {
        this.HPataque = HPataque;
    }

    public int getHPDefensa() {
        return HPdefensa;
    }

    protected void setHPDefensa(int HPdefensa) {
        this.HPdefensa = HPdefensa;
    }

    public int getHPAtaqueEspecial() {
        return HPataqueEspecial;
    }

    protected void setHPAtaqueEspecial(int HPataqueEspecial) {
        this.HPataqueEspecial = HPataqueEspecial;
    }

    public int getHPDefensaEspecial() {
        return HPdefensaEspecial;
    }

    protected void setHPDefensaEspecial(int HPdefensaEspecial) {
        this.HPdefensaEspecial = HPdefensaEspecial;
    }

    public String getTipo() {
        return tipo;
    }

    protected void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pokemon:" + "id=" + id +
                "\nNombre=" + nombre + 
                "\nVida=" + vida + 
                "\nHPataque=" + HPataque + 
                "\nHPdefensa=" + HPdefensa + 
                "\nHPataqueEspecial=" + HPataqueEspecial + 
                "\nHPdefensaEspecial=" + HPdefensaEspecial +
                "\nTipo=" + tipo;
    }

}
