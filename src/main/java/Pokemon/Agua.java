/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokemon;

/**
 *
 * @author Ignac
 */
public class Agua extends Pokemon{

    public Agua(String nombre) {
        super(nombre);
        this.setVida(190);
        this.setHPAtaque(55);
        this.setHPDefensa(45);
        this.setHPAtaqueEspecial(75);
        this.setHPDefensaEspecial(65);
        this.setTipo("Agua");
    }

    @Override
    public void ataqueEspecial() {
        System.out.println("Ataque Especial Agua");
    }

    @Override
    public void defensaEspecial() {
        System.out.println("Defensa Especial Agua");
    }



    
}
