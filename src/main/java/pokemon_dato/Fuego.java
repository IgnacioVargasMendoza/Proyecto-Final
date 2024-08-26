/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon_dato;

/**
 *
 * @author Ignac
 */
public class Fuego extends Pokemon {

    public Fuego(String nombre, int id) {
        super(nombre, id);
        this.setVida(115);
        this.setHPAtaque(70);
        this.setHPDefensa(45);
        this.setHPAtaqueEspecial(80);
        this.setHPDefensaEspecial(60);
        this.setTipo("Fuego");
    }

    @Override
    public void ataqueEspecial(Pokemon enemigo, boolean defensaEspecial) {

        int dano = this.getHPAtaqueEspecial(); // el daño es igual a HPAtaqueEspecial del pokemon atacando

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
            dano -= enemigo.getHPDefensaEspecial();
            enemigo.recibirDaño(dano);
        } else {// si ninguna defensa es activada
            enemigo.recibirDaño(dano);
        }
    }

}
