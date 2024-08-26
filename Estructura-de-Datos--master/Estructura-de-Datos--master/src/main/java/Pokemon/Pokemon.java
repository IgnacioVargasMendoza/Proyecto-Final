package Pokemon;
import Pokemon.MovimientoEspecial;
import javax.swing.JOptionPane;

public abstract class Pokemon implements MovimientoEspecial {

    private static int contadorIds = 1; // Contador estático para asignar ids únicos
    private int id;
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private String tipo;
    private boolean recargaDefensaEspecial; // Indica si la defensa especial está en recarga
    private int turnosRecargaEspecial; // Indica el número de turnos restantes de recarga del ataque especial

    public Pokemon(String nombre) {
        this.id = contadorIds++;
        this.nombre = nombre;
        this.vida = 100; // Asume un valor inicial por defecto
        this.ataque = 10; // Asume un valor inicial por defecto
        this.defensa = 5; // Asume un valor inicial por defecto
        this.ataqueEspecial = 20; // Asume un valor inicial por defecto
        this.defensaEspecial = 10; // Asume un valor inicial por defecto
        this.tipo = "Normal"; // Asume un valor inicial por defecto
        this.turnosRecargaEspecial = 0;
    }

    public int atacar(Pokemon pokemonEnemigo) {
        System.out.println("Inicio de atacar: " + this.nombre + " contra " + pokemonEnemigo.getNombre());

        if (turnosRecargaEspecial > 0) {
            JOptionPane.showMessageDialog(null, this.nombre + " está recargando su ataque especial y no puede atacar.");
            return 0;
        }

        String mensajeAtaque = this.nombre + " ataca a " + pokemonEnemigo.getNombre() + "!";
        int daño = this.ataque - (int) (pokemonEnemigo.getDefensa() * 0.8);
        if (daño > 0) {
            JOptionPane.showMessageDialog(null, mensajeAtaque);
            System.out.println("Daño calculado: " + daño);
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

        // Realizar el ataque especial
        String mensajeAtaqueEspecial = this.nombre + " realiza un ataque especial contra " + pokemonEnemigo.getNombre() + "!";
        int daño = this.ataqueEspecial - (int) (pokemonEnemigo.getDefensaEspecial() * 0.7);
        if (daño > 0) {
            JOptionPane.showMessageDialog(null, mensajeAtaqueEspecial);
            pokemonEnemigo.recibirDaño(daño);
        } else {
            JOptionPane.showMessageDialog(null, pokemonEnemigo.getNombre() + " bloqueó parte del ataque especial!");
        }

        // Configura el ataque especial en recarga por 2 turnos
        turnosRecargaEspecial = 2;
    }

    public void terminarTurno() {
        if (turnosRecargaEspecial > 0) {
            turnosRecargaEspecial--; // Reduce el contador de recarga especial
        }
    }

    // Otros métodos y atributos

    // Getters y Setters
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
        // Implementar lógica para reducir el daño recibido en la próxima ronda
        recargaDefensaEspecial = true;
    }

    public void defender(Pokemon pokemonEnemigo) {
        if (recargaDefensaEspecial) {
            JOptionPane.showMessageDialog(null, this.nombre + " está recargando su defensa especial y no puede usar defensa.");
            return;
        }

        // Mensaje de defensa
        JOptionPane.showMessageDialog(null, this.nombre + " usa defensa contra el ataque de " + pokemonEnemigo.getNombre() + "!");

        // Aquí puedes implementar la lógica de defensa
        // Por ejemplo, puedes reducir el daño recibido en el próximo turno
        // Esta lógica depende de cómo quieras que funcione la defensa en tu juego
        // Marcar que la defensa especial está en recarga
        recargaDefensaEspecial = true;
    }

    public void recibirDaño(int daño) {
        System.out.println("Inicio de recibirDaño: " + daño);

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

        System.out.println("Fin de recibirDaño: " + this.vida);
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
        turnosRecargaEspecial = 2; // Coloca el ataque especial en recarga
    }

    public boolean isRecargaEspecial() {
        return turnosRecargaEspecial > 0;
    }

    public void setRecargaEspecial(boolean recargaEspecial) {
        // No es necesario establecer este valor, ya que turnosRecargaEspecial se encarga del estado
    }

    // Getters y Setters
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
