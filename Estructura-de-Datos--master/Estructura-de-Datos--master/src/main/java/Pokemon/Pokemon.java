package Pokemon;

import Pokemon.MovimientoEspecial;
import javax.swing.JOptionPane;

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
    private boolean recargaDefensaEspecial;
    private int turnosRecargaEspecial;

    // Métodos de batalla
    public int atacar(Pokemon enemigo, boolean defensa) {
        int dano = this.HPataque;
        if (defensa == true) {
            dano -= enemigo.getHPdefensa();
            enemigo.recibirDaño(dano);
        } else {
            enemigo.recibirDaño(dano);
        }
        return dano;
    }
    
    public void ataqueEspecial(Pokemon enemigo, boolean defensaEspecial) {
    }

    //Activa la defensa
    public boolean defender() {
        return true;
    }

    ;
    
    //Activa defensaEspecial
    public boolean defensaEspecial() {
        return true;
    }

    ;
    
    
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

    public int getHPataque() {
        return HPataque;
    }

    public void setHPataque(int HPataque) {
        this.HPataque = HPataque;
    }

    public int getHPdefensa() {
        return HPdefensa;
    }

    public void setHPdefensa(int HPdefensa) {
        this.HPdefensa = HPdefensa;
    }

    public int getHPataqueEspecial() {
        return HPataqueEspecial;
    }

    public void setHPataqueEspecial(int HPataqueEspecial) {
        this.HPataqueEspecial = HPataqueEspecial;
    }

    public int getHPdefensaEspecial() {
        return HPdefensaEspecial;
    }

    public void setHPdefensaEspecial(int HPdefensaEspecial) {
        this.HPdefensaEspecial = HPdefensaEspecial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pokemon(String nombre) {
        this.id = contadorIds++;
        this.nombre = nombre;
    }
    
        public boolean isRecargaEspecial() {
        return turnosRecargaEspecial > 0;
    }

        /*
    public void setRecargaEspecial(boolean recargaEspecial) {

    }**/

    public void terminarTurno() {
        if (turnosRecargaEspecial > 0) {
            turnosRecargaEspecial--;
        }
    }

    public int getTurnosRecargaEspecial() {
        return turnosRecargaEspecial;
    }

    public void setTurnosRecargaEspecial(int turnos) {
        this.turnosRecargaEspecial = turnos;
    }

}
