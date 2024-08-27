package Pokemon;

import javax.swing.JOptionPane;

public class Agua extends Pokemon {

    public Agua(String nombre) {
        super(nombre);
        this.setVida(190);
        this.setHPataque(55);
        this.setHPdefensa(45);
        this.setHPataqueEspecial(75);
        this.setHPdefensaEspecial(65);
        this.setTipo("Agua");
    }

    @Override
    public void ataqueEspecial(Pokemon enemigo, boolean defensaEspecial) {

        //muestro el nombre de los pokemones oponentes **estas lineas de codigo deben ser removidas
        System.out.println(this.getNombre() + " ataca a " + enemigo.getNombre());
        System.out.println("La vida del pokemon es: " + enemigo.getVida());

        int dano = this.getHPataqueEspecial(); // el daño es igual a HPAtaqueEspecial del pokemon atacando

        if (enemigo.getTipo().equalsIgnoreCase("Fuego")) {// si el pokemon enemigo es tipo fuego
            dano += 10;
        }

        /*Actualizo el daño segun la defensa que el jugador enemigo y envio el daño al pokemon enemigo*/
        if (defensaEspecial == true) { // si la defensa especial fue activada
            if (enemigo.getTipo().equalsIgnoreCase("Normal")) {// si el pokemon enemigo es tipo normal
                dano -= 5;
            }
            dano -= enemigo.getHPdefensaEspecial();
            enemigo.recibirDaño(dano);
        } else {// si ninguna defensa es activada
            enemigo.recibirDaño(dano);
        }
    }//Fin metodo ataqueEspecial

}
