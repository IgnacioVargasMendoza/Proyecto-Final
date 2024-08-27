package Pokemon;

import javax.swing.JOptionPane;

public class Fuego extends Pokemon {

    public Fuego(String nombre) {
        super(nombre);
        this.setVida(115);
        this.setHPataque(70);
        this.setHPdefensa(45);
        this.setHPataqueEspecial(80);
        this.setHPdefensaEspecial(60);
        this.setTipo("Fuego");
    }

    @Override
    public void ataqueEspecial(Pokemon enemigo, boolean defensaEspecial) {

        int dano = this.getHPataqueEspecial(); // el daño es igual a HPAtaqueEspecial del pokemon atacando

        if (enemigo.getTipo().equalsIgnoreCase("Normal")) {// si el pokemon enemigo es tipo normal
            dano += 5;
        }
        //muestro el nombre de los pokemones oponentes
        System.out.println(this.getNombre() + " ataca a " + enemigo.getNombre());
        System.out.println("La vida del pokemon es: " + enemigo.getVida());

        /*Actualizo el daño segun la defensa que el jugador enemigo y envio el daño al pokemon enemigo*/
        if (defensaEspecial == true) { // si la defensa especial fue activada
            if (enemigo.getTipo().equalsIgnoreCase("Agua")) {// si el pokemon enemigo es tipo agua
                dano -= 10;
            }
            dano -= enemigo.getHPdefensaEspecial();
            enemigo.recibirDaño(dano);
        } else {// si ninguna defensa es activada
            enemigo.recibirDaño(dano);
        }
    }
}
