/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon_dato;

/**
 *
 * @author Ignac
 */
public class Normal extends Pokemon {

    public Normal(String nombre, int id) {
        super(nombre, id);
        this.setVida(150);
        this.setHPAtaque(50);
        this.setHPDefensa(35);
        this.setHPAtaqueEspecial(70);
        this.setHPDefensaEspecial(60);
        this.setTipo("Normal");
    }

    public void ataqueEspecial(Pokemon enemigo, boolean defensaEspecial) {

        int dano = this.getHPAtaqueEspecial(); // el daño es igual a HPAtaqueEspecial del pokemon atacando

        if (enemigo.getTipo().equalsIgnoreCase("Agua")) {// si el pokemon enemigo es tipo agua
            dano += 5;
        }
        //muestro el nombre de los pokemones oponentes
        System.out.println(this.getNombre() + " ataca a " + enemigo.getNombre());
        System.out.println("La vida del pokemon es: " + enemigo.getVida());

        /*Actualizo el daño segun la defensa que el jugador enemigo y envio el daño al pokemon enemigo*/
        if (defensaEspecial == true) { // si la defensa especial fue activada
            if (enemigo.getTipo().equalsIgnoreCase("Fuego")) {// si el pokemon enemigo es tipo fuego
                dano -= 10;
            }
            dano -= enemigo.getHPDefensaEspecial();
            enemigo.recibirDaño(dano);
        } else {// si ninguna defensa es activada
            enemigo.recibirDaño(dano);
        }
    }

}
