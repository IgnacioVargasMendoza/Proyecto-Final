/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokemon;

/**
 *
 * @author Ignac
 */
public class Normal extends Pokemon {

    public Normal(String nombre) {
        super(nombre);
        this.setVida(150);
        this.setAtaque(50);
        this.setDefensa(35);
        this.setAtaqueEspecial(70);
        this.setDefensaEspecial(60);
        this.setTipo("Normal");
    }

    @Override
    public void ataqueEspecial() {
        System.out.println("ataque especial Normal");
    }

    @Override
    public void defensaEspecial() {
        System.out.println("defensa especial Normal");
    }




}
