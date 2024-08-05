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
        this.setHPAtaque(50);
        this.setHPDefensa(35);
        this.setHPAtaqueEspecial(70);
        this.setHPDefensaEspecial(60);
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
