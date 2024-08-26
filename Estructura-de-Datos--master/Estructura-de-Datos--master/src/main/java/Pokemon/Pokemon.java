package Pokemon;

import Pokemon.MovimientoEspecial;
import javax.swing.JOptionPane;

public abstract class Pokemon implements MovimientoEspecial {

    private static int contadorIds = 1;
    private int id;
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private String tipo;
    private boolean recargaDefensaEspecial;
    private int turnosRecargaEspecial;

    public Pokemon(String nombre) {
        this.id = contadorIds++;
        this.nombre = nombre;
        this.vida = 100;
        this.ataque = 10;
        this.defensa = 5;
        this.ataqueEspecial = 20;
        this.defensaEspecial = 10;
        this.tipo = "Normal";
        this.turnosRecargaEspecial = 0;
    }

    public int atacar(Pokemon pokemonEnemigo) {

        if (turnosRecargaEspecial > 0) {
            JOptionPane.showMessageDialog(null, this.nombre + " está recargando su ataque especial y no puede atacar.");
            return 0;
        }

        String mensajeAtaque = this.nombre + " ataca a " + pokemonEnemigo.getNombre() + "!";
        int daño = this.ataque - (int) (pokemonEnemigo.getDefensa() * 0.8);
        if (daño > 0) {
            JOptionPane.showMessageDialog(null, mensajeAtaque);

            pokemonEnemigo.recibirDaño(daño);
            return daño;
        } else {
            JOptionPane.showMessageDialog(null, pokemonEnemigo.getNombre() + " bloqueó parte del ataque!");
            return 0;
        }
    }

    public void atacarEspecial(Pokemon pokemonEnemigo) {
        if (turnosRecargaEspecial > 0) {
            JOptionPane.showMessageDialog(null, this.nombre + " está recargando su ataque especial y no puede atacar.");
            return;
        }

        String mensajeAtaqueEspecial = this.nombre + " realiza un ataque especial contra " + pokemonEnemigo.getNombre() + "!";
        int daño = this.ataqueEspecial - (int) (pokemonEnemigo.getDefensaEspecial() * 0.7);
        if (daño > 0) {
            JOptionPane.showMessageDialog(null, mensajeAtaqueEspecial);
            pokemonEnemigo.recibirDaño(daño);
        } else {
            JOptionPane.showMessageDialog(null, pokemonEnemigo.getNombre() + " bloqueó parte del ataque especial!");
        }

        turnosRecargaEspecial = 2;
    }

    public void recibirDaño(int daño) {

        if (daño < 0) {
            daño = 0;
        }

        this.vida -= daño;

        if (this.vida < 0) {
            this.vida = 0;
        }

        String mensajeDaño = this.nombre + " recibió " + daño + " puntos de daño. Vida restante: " + this.vida;
        JOptionPane.showMessageDialog(null, mensajeDaño);

        if (this.vida <= 0) {
            JOptionPane.showMessageDialog(null, this.nombre + " ha sido derrotado!");
        }

    }

    protected int aplicarDaño(Pokemon pokemonEnemigo, int dañoBase) {
        if (dañoBase > 0) {
            JOptionPane.showMessageDialog(null, this.nombre + " inflige " + dañoBase + " puntos de daño a " + pokemonEnemigo.getNombre() + "!");
            pokemonEnemigo.recibirDaño(dañoBase);
        } else {
            JOptionPane.showMessageDialog(null, pokemonEnemigo.getNombre() + " bloqueó el ataque!");
        }
        return dañoBase;
    }

    protected void aplicarDañoEspecial(Pokemon pokemonEnemigo, int dañoBase) {
        if (dañoBase > 0) {
            JOptionPane.showMessageDialog(null, this.nombre + " inflige " + dañoBase + " puntos de daño especial a " + pokemonEnemigo.getNombre() + "!");
            pokemonEnemigo.recibirDaño(dañoBase);
        } else {
            JOptionPane.showMessageDialog(null, pokemonEnemigo.getNombre() + " bloqueó el ataque especial!");
        }
        turnosRecargaEspecial = 2;
    }

    public boolean isRecargaEspecial() {
        return turnosRecargaEspecial > 0;
    }

    public void setRecargaEspecial(boolean recargaEspecial) {

    }

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

    public void defensaEspecial(Pokemon pokemonEnemigo) {
        if (recargaDefensaEspecial) {
            JOptionPane.showMessageDialog(null, this.nombre + " está recargando su defensa especial y no puede utilizarla.");
            return;
        }

        JOptionPane.showMessageDialog(null, this.nombre + " usa una defensa especial contra el ataque de " + pokemonEnemigo.getNombre() + "!");

        recargaDefensaEspecial = true;
    }

    public void defender(Pokemon pokemonEnemigo) {
        if (recargaDefensaEspecial) {
            JOptionPane.showMessageDialog(null, this.nombre + " está recargando su defensa especial y no puede usar defensa.");
            return;
        }

        JOptionPane.showMessageDialog(null, this.nombre + " usa defensa contra el ataque de " + pokemonEnemigo.getNombre() + "!");

        recargaDefensaEspecial = true;
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

    public boolean isRecargaDefensaEspecial() {
        return recargaDefensaEspecial;
    }

    public void setRecargaDefensaEspecial(boolean recargaDefensaEspecial) {
        this.recargaDefensaEspecial = recargaDefensaEspecial;
    }
}
